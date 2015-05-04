;; 4Clojure Question 93
;;
;; Write a function which flattens any nested combination of sequential things (lists, vectors, etc.), but maintains the lowest level sequential items.  The result should be a sequence of sequences with only one level of nesting.
;;
;; Use M-x 4clojure-check-answers when you're done!

(= (__ [["Do"] ["Nothing"]])
   [["Do"] ["Nothing"]])

(= (__ [[[[:a :b]]] [[:c :d]] [:e :f]])
   [[:a :b] [:c :d] [:e :f]])

(= (__ '((1 2)((3 4)((((5 6)))))))
   '((1 2)(3 4)(5 6)))

(defn __ [x]
  (map
   #(loop [foo %]
      (if (coll? (first foo))
        (recur (first foo))
        foo))
   x))

;; (defn __
;;   ([x] (__ x '()))
;;   ([x y]
;;    (if (coll? (first x))
;;      (for [c x]
;;        (__ c y))
;;      (println x))))
(defn __ [x]
  (if (coll? (first x))
    (for [c x]
      (__ c))
    x))

(defn __ [x]
  (if (coll? (first x))
    (loop [c x
           d '()]
      (if (empty? c) d
          (recur (rest c) (concat d (__ (first c))))))
    x))



(defn __ [x]
  (loop [c false
         r x]
    (if (= c true) r
        (let [rr (reduce #(if (coll? (first %2))
                            (loop [z %2 y %]
                              (if (empty? z)
                                y
                                (recur (rest z) (concat y (list (first z))))))
                            (concat % (list %2))) '() r)
              mr (apply = (map #(coll? (first %)) rr))]
          (recur mr rr)))))


(__ '((1 2)((3 4)((((5 6)))))))



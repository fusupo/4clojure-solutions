;; 4Clojure Question 132
;;
;; Write a function that takes a two-argument predicate, a value, and a collection; and returns a new collection where the <code>value</code> is inserted between every two items that satisfy the predicate.
;;
;; Use M-x 4clojure-check-answers when you're done!

(= '(1 :less 6 :less 7 4 3) (__ < :less [1 6 7 4 3]))

(= '(2) (__ > :more [2]))

(= [0 1 :x 2 :x 3 :x 4]  (__ #(and (pos? %) (< % %2)) :x (range 5)))

(empty? (__ > :more ()))

(= [0 1 :same 1 2 3 :same 5 8 13 :same 21]
   (take 12 (->> [0 1]
               (iterate (fn [[a b]] [b (+ a b)]))
               (map first) ; fibonacci numbers
               (__ (fn [a b] ; both even or both odd
                     (= (mod a 2) (mod b 2)))
                   :same))))

;; (defn __ [p v c]
;;   (reverse (loop [r (list (first c))
;;                   x (rest c)]
;;              (if (empty? x)
;;                r
;;                (if (p (first r) (first x))
;;                  (recur (conj r v (first x)) (rest x))
;;                  (recur (conj r (first x)) (rest x)))))))


;; (defn __
;;   ([p v c]
;;    (if (empty? c) c
;;        (__ p v (next c) (list (first c)))))
;;   ([p v c r]
;;    (if (empty? c) (reverse r)
;;        (if (p (first r) (first c))
;;          (lazy-seq (__ p v (next c) (conj r v (first c))))
;;          (lazy-seq (__ p v (next c) (conj r (first c))))))
;;    ))


(defn __
  ([p v c]
   (if (empty? c) c
       (__ p v (next c) (list (first c)))))
  ([p v c r]
   (let [step (fn [x y z a]
                (when (seq z)
                  (__ x y (next z) (if (x (last a) (first z))
                                     (list y (first z))
                                     (list (first z))))))]
     (concat r (lazy-seq (step p v c r))))))



(__ < :less [1 6 7 4 3])

(conj '(4 5 6) :less 7)
(seq '())
(next '(4 5 6 7 8))

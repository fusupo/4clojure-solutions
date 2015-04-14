;; 4Clojure Question 79
;;
;; Write a function which calculates the sum of the minimal path through a triangle.  The triangle is represented as a collection of vectors.  The path should start at the top of the triangle and move to an adjacent number on the next row until the bottom of the triangle is reached.
;;
;; Use M-x 4clojure-check-answers when you're done!

(= 7 (__ '([1]
           [2 4]
           [5 1 4]
           [2 3 4 5])))
;; 1->2->1->3

(= 20 (__ '([3]
            [2 4]
            [1 9 3]
            [9 9 2 4]
            [4 6 6 7 8]
            [5 7 3 5 1 4])))
;; 3->4->3->2->7->1

(clojure.walk/prewalk #(do (println "visiting:" %) %) '([1]
                                                        [2 4]
                                                        [5 1 4]
                                                        [2 3 4 5]))

(defn __
  ([t]
   (-> (__ (rest t) (ffirst t) 0)
      (flatten)
      (sort)
      (first)))
  ([t v i]
   (if (> (count t) 0)
     (let [row (first t)
           ii (inc i)
           rt (rest t)
           va (+ v (nth row i))
           vb (+ v (nth row ii))
           x (list (__ rt va i) (__ rt vb ii))]
       x)
     v)))









;; SHOW YOUR WORK
(println ((fn foo
            ([t]
             (-> (foo (rest t) (ffirst t) 0)
                (flatten)
                (sort)
                (first)))
            ([t v i]
             (if (> (count t) 0)
               (let [row (first t)
                     ii (inc i)
                     rt (rest t)
                     va (+ v (nth row i))
                     vb (+ v (nth row ii))
                     xxx (list (foo rt va i) (foo rt vb ii))]
                 xxx)
               v)))
          '([1]
            [2 4]
            [5 1 4]
            [2 3 4 5])))

(-> '(((10 11) (7 8)) ((9 10) (13 14)))
   (flatten)
   (sort)
   (first))

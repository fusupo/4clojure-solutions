;; 4Clojure Question 143
;;
;; Create a function that computes the <a href="http://en.wikipedia.org/wiki/Dot_product#Definition">dot product</a> of two sequences. You may assume that the vectors will have the same length.
;;
;; Use M-x 4clojure-check-answers when you're done!

(= 0 (__ [0 1 0] [1 0 0]))

(= 3 (__ [1 1 1] [1 1 1]))

(= 32 (__ [1 2 3] [4 5 6]))

(= 256 (__ [2 5 6] [100 10 1]))

(defn __ [v1 v2]
  (reduce + (map-indexed #(* %2 (v2 %)) v1)))
;;(fn [v1 v2]
;;  (reduce + (map-indexed #(* %2 (v2 %)) v1)))

(defn __ [v1 v2] (reduce + (map * v1 v2)))
;;#(reduce + (map * % %2))

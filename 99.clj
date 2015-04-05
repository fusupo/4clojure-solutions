;; 4Clojure Question 99
;;
;; Write a function which multiplies two numbers and returns the result as a sequence of its digits.
;;
;; Use M-x 4clojure-check-answers when you're done!

(= (__ 1 1) [1])

(= (__ 99 9) [8 9 1])

(= (__ 999 99) [9 8 9 0 1])

(defn __ [a b]
  (map #(Integer/parseInt %) (re-seq #"\d" (str (* a b)))))
;;(fn [a b] (map #(Integer/parseInt %) (re-seq #"\d" (str (* a b)))))

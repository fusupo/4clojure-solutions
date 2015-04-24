;; 4Clojure Question 75
;;
;; Two numbers are coprime if their greatest common divisor equals 1.  Euler's totient function f(x) is defined as the number of positive integers less than x which are coprime to x.  The special case f(1) equals 1.  Write a function which calculates Euler's totient function.
;;
;; Use M-x 4clojure-check-answers when you're done!

(= (__ 1) 1)

(= (__ 10) (count '(1 3 7 9)) 4)

(= (__ 40) 16)

(= (__ 99) 60)

(defn __ [x]
  (if (not= x 1)
    (let [div (fn [y] (conj (set (filter #(= 0 (rem y %)) (range 1 y))) y))
          d (div x)]
      (println d)
      (count  (filter #(= #{1} (clojure.set/intersection d (div %))) (range 1 x))))
    x))

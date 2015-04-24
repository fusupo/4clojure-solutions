;; 4Clojure Question 80
;;
;; A number is "perfect" if the sum of its divisors equal the number itself.  6 is a perfect number because 1+2+3=6.  Write a function which returns true for perfect numbers and false otherwise.
;;
;; Use M-x 4clojure-check-answers when you're done!

(= (__ 6) true)

(= (__ 7) false)

(= (__ 496) true)

(= (__ 500) false)

(= (__ 8128) true)


(defn __ [x]
  (= x (apply + (loop [c 1 a []]
                  (if (not= c x)
                    (recur (inc c) (if (= 0 (rem x c)) (conj a c) a))
                    a)))))
;; #(= % (apply + (loop [c 1 a []]
;;                  (if (not= c %)
;;                    (recur (inc c) (if (= 0 (rem % c)) (conj a c) a))
;;                    a))))

(defn __ [x]
  (= x (loop [c 1 a 0]
         (if (not= c x)
           (recur (inc c) (if (= 0 (rem x c)) (+ a c) a))
           a))))
;; #(= % (loop [c 1 a 0]
;;         (if (not= c %)
;;           (recur (inc c) (if (= 0 (rem % c)) (+ a c) a))
;;           a)))

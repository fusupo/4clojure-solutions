;; 4Clojure Question 115
;;
;; A balanced number is one whose component digits have the same sum on the left and right halves of the number.  Write a function which accepts an integer n, and returns true iff n is balanced.
;;
;; Use M-x 4clojure-check-answers when you're done!

(= true (__ 11))

(= true (__ 121))

(= false (__ 123))

(= true (__ 0))

(= false (__ 88099))

(= true (__ 89098))

(= true (__ 89089))

(= (take 20 (filter __ (range)))
   [0 1 2 3 4 5 6 7 8 9 11 22 33 44 55 66 77 88 99 101])


(defn __ [x]
  (let [s (map #(- (int %) 48) (seq (str x)))
        c (int (/ (count s) 2))]
    (if (= c 0)
      true
      (= (apply + (take c s)) (apply + (take-last c s))))))

(defn __ [x]
  (loop [s (map #(- (int %) 48) (seq (str x)))
         a 0
         b 0]
    (if (empty? s)
      (= a b)
      (recur (butlast (drop 1 s)) (+ a (first s)) (+ b (last s))))))

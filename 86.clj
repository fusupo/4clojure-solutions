;; 4Clojure Question 86
;;
;; Happy numbers are positive integers that follow a particular formula: take each individual digit, square it, and then sum the squares to get a new number. Repeat with the new number and eventually, you might get to a number whose squared sum is 1. This is a happy number. An unhappy number (or sad number) is one that loops endlessly. Write a function that determines if a number is happy or not.
;;
;; Use M-x 4clojure-check-answers when you're done!

(= (__ 7) true)

(= (__ 986543210) true)

(= (__ 2) false)

(= (__ 3) false)

(defn __ [x]
  (let [dgts (fn [n] (map #(- (int %) 48) (seq (str n))))]
    (loop [curr x
           acc '()]
      (let [res (apply + (map #(* % %) (dgts curr)))]
        (cond
          (> (.indexOf acc res) -1) false
          (= 1 res) true
          :default (recur res (conj acc res)))))))

(defn __ [x]
  (loop [n x
         a '()]
    (let [r (apply + (map #(* % %) (map #(- (int %) 48) (seq (str n)))))]
      (cond
        (> (.indexOf a r) -1) false
        (= 1 r) true
        :default (recur r (conj a r))))))

(__ 7)
(__ 986543210)
(__ 2)

(map #(- (int %) 48) (seq (str 986543210)))












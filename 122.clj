;; 4Clojure Question 122
;;
;; Convert a binary number, provided in the form of a string, to its numerical value.
;;
;; Use M-x 4clojure-check-answers when you're done!

(= 0     (__ "0"))

(= 7     (__ "111"))

(= 8     (__ "1000"))

(= 9     (__ "1001"))

(= 255   (__ "11111111"))

(= 1365  (__ "10101010101"))

(= 65535 (__ "1111111111111111"))

(defn __ [n]
  (loop [l (reverse (map #(- (int %) 48) n))
         n 1
         r 0]
    (if (empty? l)
      r
      (recur (rest l) (* n 2) (+ r (* n (first l)))))))
;; (fn [n]
;;   (loop [l (reverse (map #(- (int %) 48) n))
;;          n 1
;;          r 0]
;;     (if (empty? l)
;;       r
;;       (recur (rest l) (* n 2) (+ r (* n (first l)))))))

;; 4Clojure Question 97
;;
;; <a href="http://en.wikipedia.org/wiki/Pascal%27s_triangle">Pascal's triangle</a> is a triangle of numbers computed using the following rules:<br/></br>- The first row is 1.</br>- Each successive row is computed by adding together adjacent numbers in the row above, and adding a 1 to the beginning and end of the row.<br/><br/>Write a function which returns the nth row of Pascal's Triangle.
;;
;; 
;;
;; 
;;
;; 
;;
;; Use M-x 4clojure-check-answers when you're done!

(= (__ 1) [1])

(= (map __ (range 1 6))
   [     [1]
         [1 1]
         [1 2 1]
         [1 3 3 1]
         [1 4 6 4 1]])

(= (__ 11)
   [1 10 45 120 210 252 210 120 45 10 1])

(defn __ [x]
  (if (= 1 x) [1]
      (loop [r [1 1]]
        (if (= x (count r))
          r
          (recur (mapv + (conj r 0) (cons 0 r)))))))
;; #(if (= 1 %) [1]
;;     (loop [r [1 1]]
;;       (if (= % (count r))
;;         r
;;         (recur (mapv + (conj r 0) (cons 0 r))))))

(defn __ [x]
  (loop [r [1]]
    (if (= x (count r))
      r
      (recur (mapv + (conj r 0) (cons 0 r))))))
;; #(loop [r [1]]
;;    (if (= % (count r))
;;      r
;;      (recur (mapv + (conj r 0) (cons 0 r)))))

(defn __ [x]
  (nth (iterate (fn [r] (mapv + (conj r 0) (cons 0 r))) [1]) (dec x)))
;;(fn [x] (nth (iterate #(mapv + (conj % 0) (cons 0 %)) [1]) (dec x)))

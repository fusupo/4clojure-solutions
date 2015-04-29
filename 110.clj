;; 4Clojure Question 110
;;
;; <p>Write a function that returns a lazy sequence of "pronunciations" of a sequence of numbers. A pronunciation of each element in the sequence consists of the number of repeating identical numbers and the number itself. For example, <code>[1 1]</code> is pronounced as <code>[2 1]</code> ("two ones"), which in turn is pronounced as <code>[1 2 1 1]</code> ("one two, one one").</p><p>Your function should accept an initial sequence of numbers, and return an infinite lazy sequence of pronunciations, each element being a pronunciation of the previous element.</p>
;;
;; Use M-x 4clojure-check-answers when you're done!

(= [[1 1] [2 1] [1 2 1 1]] (take 3 (__ [1])))

(= [3 1 2 4] (first (__ [1 1 1 4 4])))

(= [1 1 1 3 2 1 3 2 1 1] (nth (__ [1]) 6))

(= 338 (count (nth (__ [3 2]) 15)))



(defn fib [a b]
  (cons a (lazy-seq (fib b (+ b a)))))

(take 5 (fib 1 1))


(defn __ [v]
  (mapcat #(list(count %)(first %)) (partition-by identity v)))

(defn __ [v]
  (mapcat (fn[x][(count x)(first x)]) (partition-by identity v)))

(defn __ [v]
  (lazy-cat v (__ (mapcat #(list (count %) (first %)) (partition-by identity v)))))

(defn __ [v]
  (rest
   (iterate
    (fn [x]
      (mapcat
       #(list (count %) (first %))
       (partition-by identity x)))
    v)))

;; #(rest
;;   (iterate
;;    (fn [x]
;;      (mapcat
;;       (fn [y]
;;         [(count y) (first y)])
;;       (partition-by identity x)))
;;    %))

(take 3 (__ [1]))

(__ [2 1])
(__ [1 2 1 1])
(__ [1 1 1 4 4])


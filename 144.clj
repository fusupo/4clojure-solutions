;; 4Clojure Question 144
;;
;; Write an oscillating iterate: a function that takes an initial value and a variable number of functions. It should return a lazy sequence of the functions applied to the value in order, restarting from the first function after it hits the end.
;;
;; Use M-x 4clojure-check-answers when you're done!

(= (take 3 (__ 3.14 int double)) [3.14 3 3.0])

(= (take 5 (__ 3 #(- % 3) #(+ 5 %))) [3 0 5 2 7])

(= (take 12 (__ 0 inc dec inc dec inc)) [0 1 0 1 0 1 2 1 2 1 2 3])

(defn __ [x & args]
  (println x)
  (println (count args))
  (let [a (if (= 1 (count args))
            (first args)
            args)]
    (println ((first a) x))
    (println "A" a)
    (cons x (lazy-seq (__ ((first a) x) (conj (vec (rest a))(first a)))))))

(defn __ [x & args]
  (map first (iterate (fn [[a b]]
                        [((first b) a) (rest b)] ) [x (cycle args)])))

(defn __ [x & f] (reductions #(%2 %1) x (cycle f)))

;;(fn [x & f] (reductions #(%2 %1) x (cycle f)))

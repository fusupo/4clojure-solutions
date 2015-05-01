;; 4Clojure Question 108
;;
;; <p>Given any number of sequences, each sorted from smallest to largest, find the smallest single number which appears in all of the sequences. The sequences may be infinite, so be careful to search lazily.</p>
;;
;; Use M-x 4clojure-check-answers when you're done!

(= 3 (__ [3 4 5]))

(= 4 (__ [1 2 3 4 5 6 7] [0.5 3/2 4 19]))

(= 7 (__ (range) (range 0 100 7/6) [2 3 5 7 11 13]))

(= 64 (__ (map #(* % % %) (range)) ;; perfect cubes
          (filter #(zero? (bit-and % (dec %))) (range)) ;; powers of 2
          (iterate inc 20))) ;; at least as large as 20

(defn __ [& args]
  (if (= 1 (count args))
    (ffirst args)
    (loop [a args]
      (let [b (map first a)
            m (apply max b)]
        ;; (println rargs)
        ;;(println b)
        ;; (println (.indexOf (vec (map empty? rargs)) true))
        ;;(println (apply = (map first a)))
        (cond
          (apply = (map first a))(ffirst a)
          (or (empty? (first a))) (println "foo")
          :else (recur  (map (fn [x] (if (= m (first x))
                                      x
                                      (rest x))) a)))))))


(defn __ [& args]
  (if (= 1 (count args))
    (ffirst args)
    (loop [a args]
      (let [b (map first a)
            m (apply max b)]
        ;; (println rargs)
        ;;(println b)
        ;; (println (.indexOf (vec (map empty? rargs)) true))
        ;;(println (apply = (map first a)))
        (cond
          (apply = (map first a))(ffirst a)
          (or (empty? (first a))) (println "foo")
          :else (recur  (map (fn [x] (if (= m (first x))
                                      x
                                      (rest x))) a)))))))

(defn __ [& a]
  (let [m (map first a)]
    (if (or (= 1 (count a))(apply = m))
      (first m)
      (apply __ (map #(if (not= (apply max m) (first %))
                        (rest %)
                        %) a)))))



(__ [1 2 3 4 5 6 7] [0.5 3/2 3 19])
(__ [1 2 3 4 5 6 7] [0.5 3/2 4 19])
(__ (range) (range 0 100 7/6) [2 3 5 7 11 13])

(range 0 10 7/6)
(range 10)

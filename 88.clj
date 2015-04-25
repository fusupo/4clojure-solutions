;; 4Clojure Question 88
;;
;; Write a function which returns the symmetric difference of two sets.  The symmetric difference is the set of items belonging to one but not both of the two sets.
;;
;; Use M-x 4clojure-check-answers when you're done!

(= (__ #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7})

(= (__ #{:a :b :c} #{}) #{:a :b :c})

(= (__ #{} #{4 5 6}) #{4 5 6})

(= (__ #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]})

(defn __ [s1 s2]
  (let [int (clojure.set/intersection s1 s2)
        d1 (clojure.set/difference s1 int)
        d2 (clojure.set/difference s2 int)]
    (clojure.set/union d1 d2)))
;; (fn [s1 s2]
;;   (let [int (clojure.set/intersection s1 s2)
;;         d1 (clojure.set/difference s1 int)
;;         d2 (clojure.set/difference s2 int)]
;;     (clojure.set/union d1 d2)))

(defn __ [s1 s2]
  (let [f (fn [sa sb r] (reduce #(if (contains? sb %2) % (conj % %2)) r sa))]
    (f s2 s1 (f s1 s2 #{}))))
;; (fn [s1 s2] 
;;   (let [f (fn [sa sb r] (reduce #(if (contains? sb %2) % (conj % %2)) r sa))]
;;     (f s2 s1 (f s1 s2 #{}))))

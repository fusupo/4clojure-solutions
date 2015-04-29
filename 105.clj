;; 4Clojure Question 105
;;
;; Given an input sequence of keywords and numbers, create a map such that each key in the map is a keyword, and the value is a sequence of all the numbers (if any) between it and the next keyword in the sequence.
;;
;; Use M-x 4clojure-check-answers when you're done!

(= {} (__ []))

(= {:a [1]} (__ [:a 1]))

(= {:a [1], :b [2]} (__ [:a 1, :b 2]))

(= {:a [1 2 3], :b [], :c [4]} (__ [:a 1 2 3 :b :c 4]))


(partition-by keyword? [:a 1 2 3 :b :c 4])


(defn __ [l]
  (reduce #(do
             (cond
               (=  1 (count (first %2))) (assoc % (ffirst %2) (second %2))
               :else (assoc (reduce (fn [x y] (assoc x y [])) % (butlast (first %2))) (last (first %2)) (second %2)))) {} (partition 2 (partition-by keyword? l))))


(defn __ [x]
  (loop [l x
         r {}
         k nil]
    (cond
      (empty? l) r
      (keyword? (first l))(recur (rest l) (assoc r (first l) []) (first l))
      :else (recur (rest l) (assoc r k (conj (r k) (first l))) k))))

(defn __ [x]
  (loop [l x
         r {}
         k nil]
    (cond
      (empty? l) r
      (keyword? (first l))(recur (rest l) (assoc r (first l) []) (first l))
      :else (recur (rest l) (assoc r k (conj (r k) (first l))) k))))

(defn __ [x]
  (loop [l x
         r {}
         k nil]
    (let [fr (first l)
          rst (rest l)]
      (cond
        (empty? l) r
        (keyword? fr)(recur rst (assoc r fr []) fr)
        :else (recur rst (assoc r k (conj (r k) fr)) k)))))

(defn __ [x]
  (loop [[fr & rst] x
         r {}
         k nil]
    (cond
      (nil? fr) r
      (keyword? fr)(recur rst (assoc r fr []) fr)
      :else (recur rst (assoc r k (conj (r k) fr)) k))))

(__ [:a 1 2 3 :b :c 4])

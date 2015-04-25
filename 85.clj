;; 4Clojure Question 85
;;
;; Write a function which generates the <a href="http://en.wikipedia.org/wiki/Power_set">power set</a> of a given set.  The power set of a set x is the set of all subsets of x, including the empty set and x itself.
;;
;; Use M-x 4clojure-check-answers when you're done!

(= (__ #{1 :a}) #{#{1 :a} #{:a} #{} #{1}})

(= (__ #{}) #{#{}})

(= (__ #{1 2 3})
   #{#{} #{1} #{2} #{3} #{1 2} #{1 3} #{2 3} #{1 2 3}})

(= (count (__ (into #{} (range 10)))) 1024)

(println (into #{#{} #{:a} #{:b} #{:c} #{:d} #{:e} #{:a :b :c :d :e}} (for [x #{:a :b :c :d :e}
                                                                            y #{:a :b :c :d :e}
                                                                            :when (not= x y)]
                                                                        #{x y})))

(into #{} (for [foo #{:a :b :c :d :e}
                bar #{#{:c :d} #{:c} #{:e :a} #{:d} #{:b :d} #{:b} #{:e} #{} #{:e :c :b :d :a} #{:b :a} #{:c :a} #{:e :c} #{:e :b} #{:e :d} #{:a} #{:d :a} #{:c :b}}
                :when (not= foo bar)]
            (clojure.set/union #{foo} bar)))

(for [a #{:a :b :c :d :e}
      b #{#{:a} #{:b} #{:c} #{:d} #{:e}}]
  (clojure.set/union #{a} b))

(into #{} (for [a #{:a :b :c :d :e}
                b #{:a :b :c :d :e}
                :when (not= a b)]
            #{a b}))

(for [a #{1 2 3}]
  #{a})

(defn __ [x]
  (let [b (map (fn [y] #{y}) x) 
        f (fn [z] (into #{} (for [a x b z]
                             (clojure.set/union #{a} b))))]
    (loop [r (f b)]
      (cond
        (or (= r #{})(contains? r x)) (conj r #{})
        :else (recur (f r))))))

(defn __
  ([x]
   (__ x (map (fn [y] #{y}) x)))
  ([x y]
   (let [z (into #{} (for [a x b y] (clojure.set/union #{a} b)))]
     (if (or (= z #{})(contains? z x))
       (conj z #{})
       (__ x z)))))

;; though this could all prob be done with clever emoloyment of Reduce
(__ #{:a :b :c :d :e})
(__ #{1 :a})
(__ #{})

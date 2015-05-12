;; 4Clojure Question 103
;;
;; Given a sequence S consisting of n elements generate all <a href="https://secure.wikimedia.org/wikipedia/en/wiki/Combination">k-combinations</a> of S, i. e. generate all possible sets consisting of k distinct elements taken from S.
;;
;; 
;;
;; The number of k-combinations for a sequence is equal to the <a href="https://secure.wikimedia.org/wikipedia/en/wiki/Binomial_coefficient">binomial coefficient</a>.
;;
;; Use M-x 4clojure-check-answers when you're done!

(= (__ 1 #{4 5 6}) #{#{4} #{5} #{6}})

(= (__ 10 #{4 5 6}) #{})

(= (__ 2 #{0 1 2}) #{#{0 1} #{0 2} #{1 2}})

(= (__ 3 #{0 1 2 3 4}) #{#{0 1 2} #{0 1 3} #{0 1 4} #{0 2 3} #{0 2 4}
                         #{0 3 4} #{1 2 3} #{1 2 4} #{1 3 4} #{2 3 4}})

(= (__ 4 #{[1 2 3] :a "abc" "efg"}) #{#{[1 2 3] :a "abc" "efg"}})

(= (__ 2 #{[1 2 3] :a "abc" "efg"}) #{#{[1 2 3] :a} #{[1 2 3] "abc"} #{[1 2 3] "efg"}
                                      #{:a "abc"} #{:a "efg"} #{"abc" "efg"}})



(set (for [x #{4 5 6}
           :while (distinct? x)]
       #{x}))

(set (for [a #{4 5 6}
           b #{4 5 6}
           c #{4 5 6}
           d #{4 5 6}
           e #{4 5 6}
           f #{4 5 6}
           g #{4 5 6}
           h #{4 5 6}
           i #{4 5 6}
           j #{4 5 6}
           :while (distinct? a b c d e f g h i j)]
       #{a b c d e f g h i j}))

(set (for [x #{0 1 2}
           y #{0 1 2}
           :while (distinct? x y)]
       #{x y}))

(set (for [x #{0 1 2 3 4}
           y #{0 1 2 3 4}
           z #{0 1 2 3 4}
           :while (distinct? x y z)]
       #{x y z}))

(set (for [x #{[1 2 3] :a "abc" "efg"}
           y #{[1 2 3] :a "abc" "efg"}
           z #{[1 2 3] :a "abc" "efg"}
           a #{[1 2 3] :a "abc" "efg"}
           :while (distinct? x y z a)]
       #{x y z a}))

(set (for [x #{[1 2 3] :a "abc" "efg"}
           y #{[1 2 3] :a "abc" "efg"}
           :while (distinct? x y)]
       #{x y}))





(defmacro yyy [r]
  (let [sym (gensym 0)]
    `(for [~sym (range ~r)]
       ~sym)))

(print (macroexpand '(yyy 4)))
(yyy 4)

(defmacro xxx [k s]
  (let [v (map #(gensym %) (range k))
        b (conj (reduce (fn [x y] (conj x y (range s))) [] v) :when (conj v distinct?))]
    (list 'for b "foo")))

(print (macroexpand '(xxx 2 4)))
(xxx 2 4)





(let [v (map #(gensym %) (range k))
      b (conj (reduce (fn [x y] (conj x y (range s))) [] v) :when (conj v distinct?))]
  `(for ~b "foo"))

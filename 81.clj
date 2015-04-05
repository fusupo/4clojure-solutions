;; 4Clojure Question 81
;;
;; Write a function which returns the intersection of two sets.  The intersection is the sub-set of items that each set has in common.
;;
;; Restrictions (please don't use these function(s)): intersection
;;
;; Use M-x 4clojure-check-answers when you're done!

(= (__ #{0 1 2 3} #{2 3 4 5}) #{2 3})

(= (__ #{0 1 2} #{3 4 5}) #{})

(= (__ #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d})

(defn __ [a b]
  (reduce #(disj % %2) a (clojure.set/difference a b)))

(defn __ [a b]
  (reduce #(if (not (contains? b %2)) (disj % %2) %) a a))

(defn __ [a b]
  (reduce disj a (reduce disj a b)))

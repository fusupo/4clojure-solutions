;; 4Clojure Question 134
;;
;; Write a function which, given a key and map, returns true <a href="http://en.wikipedia.org/wiki/If_and_only_if">iff</a> the map contains an entry with that key and its value is nil.
;;
;; Use M-x 4clojure-check-answers when you're done!

(true?  (__ :a {:a nil :b 2}))

(false? (__ :b {:a nil :b 2}))

(false? (__ :c {:a nil :b 2}))

(defn __ [k m]
  (if (and (contains? m k) (= nil (m k)))
    true
    false))

(defn __ [k m]
  (= nil (get m k false)))

(defn __[k m]
  (nil? (m k 1)))

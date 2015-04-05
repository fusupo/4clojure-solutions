;; 4Clojure Question 83
;;
;; Write a function which takes a variable number of booleans.  Your function should return true if some of the parameters are true, but not all of the parameters are true.  Otherwise your function should return false.
;;
;; Use M-x 4clojure-check-answers when you're done!

(= false (__ false false))

(= true (__ true false))

(= false (__ true))

(= true (__ false true false))

(= false (__ true true true))

(= true (__ true true true false))

(defn __ [& args]
  (and (not (nil? (some true? args)))(not-every? true? args)))
;;(fn [& args] (and (not (nil? (some true? args))) (not-every? true? args)))

(defn __ [& args]
  (and (not (not-any? true? args))(not-every? true? args)))
;;(fn [& args] (and (not (not-any? true? args)) (not-every? true? args)))

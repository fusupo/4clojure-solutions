;; 4Clojure Question 158
;;
;; Write a function that accepts a curried function of unknown arity <i>n</i>.  Return an equivalent function of <i>n</i> arguments.
;;
;; <br/>
;;
;; You may wish to read <a href="http://en.wikipedia.org/wiki/Currying">this</a>.
;;
;; Use M-x 4clojure-check-answers when you're done!

(= 10 ((__ (fn [a]
             (fn [b]
               (fn [c]
                 (fn [d]
                   (+ a b c d))))))
       1 2 3 4))

(= 24 ((__ (fn [a]
             (fn [b]
               (fn [c]
                 (fn [d]
                   (* a b c d))))))
       1 2 3 4))

(= 25 ((__ (fn [a]
             (fn [b]
               (* a b))))
       5 5))


(defn __ [f]
  (fn [& n]
    (loop [x (f (first n))
           y (rest n)]
      (println (fn? x))
      (if (empty? y)
        x
        (recur (x (first y)) (rest y))))))

(defn __ [f]
  (fn [& n]
    (reduce #(% %2) f n)))

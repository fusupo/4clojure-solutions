;; 4Clojure Question 166
;;
;; For any orderable data type it's possible to derive all of the basic comparison operations (&lt;, &le;, =, &ne;, &ge;, and &gt;) from a single operation (any operator but = or &ne; will work). Write a function that takes three arguments, a <var>less than</var> operator for the data and two items to compare. The function should return a keyword describing the relationship between the two items. The keywords for the relationship between <var>x</var> and <var>y</var> are as follows:
;;
;; 
;;
;; <ul>
;;
;; <li><var>x</var> = <var>y</var> &rarr; :eq</li>
;;
;; <li><var>x</var> &gt; <var>y</var> &rarr; :gt</li>
;;
;; <li><var>x</var> &lt; <var>y</var> &rarr; :lt</li>
;;
;; </ul>
;;
;; Use M-x 4clojure-check-answers when you're done!

(= :gt (__ < 5 1))

(= :eq (__ (fn [x y] (< (count x) (count y))) "pear" "plum"))

(= :lt (__ (fn [x y] (< (mod x 5) (mod y 5))) 21 3))

(= :gt (__ > 0 2))

(defn __ [c a b]
  (let [r1 (c a b)
        r2 (c b a)]
    (if (= r1 false)
      (if (= r2 false)
        :eq
        :gt)
      :lt)))

(defn __ [c a b]
  (if (= (c a b) false)
    (if (= (c b a) false)
      :eq
      :gt)
    :lt))

(defn __ [c a b]
  (if (= (c a b) true)
    :lt
    (if (= (c b a) false)
      :eq
      :gt)))
;;#(if (= (% %2 %3) true) :lt (if (= (% %3 %2) false) :eq :gt))
(defn __ [c a b]
  (if (c a b) :lt
      (if (c b a) :gt :eq)))
;;#(if (% %2 %3) :lt (if (% %3 %2) :gt :eq))

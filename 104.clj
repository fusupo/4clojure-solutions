;; 4Clojure Question 104
;;
;; This is the inverse of <a href='92'>Problem 92</a>, but much easier. Given an integer smaller than 4000, return the corresponding roman numeral in uppercase, adhering to the <a href='http://www.numericana.com/answer/roman.htm#valid'>subtractive principle</a>.
;;
;; Use M-x 4clojure-check-answers when you're done!

(= "I" (__ 1))

(= "XXX" (__ 30))

(= "IV" (__ 4))

(= "CXL" (__ 140))

(= "DCCCXXVII" (__ 827))

(= "MMMCMXCIX" (__ 3999))

(= "XLVIII" (__ 48))

(defn __ [x]
  (let [key ['(:s)
             '(:s :s)
             '(:s :s :s)
             '(:s :m)
             '(:m)
             '(:m :s)
             '(:m :s :s)
             '(:m :s :s :s)
             '(:s :M)]]
    (loop [n x
           m 10
           u ["I" "V" "X" "L" "C" "D" "M"]
           v '()]
      (if (= 0 n)
        (clojure.string/join (flatten v))
        (let [r (mod n m)
              d (/ r (/  m 10))]
          (recur (- n r) (* m 10) (rest (rest u)) (if(> d 0)
                                                    (conj v (map #(cond
                                                                    (= :s %) (first u)
                                                                    (= :m %) (second u)
                                                                    (= :M %) (nth u 2)) (key (dec d)))) v)))))))

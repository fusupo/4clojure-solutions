;; 4Clojure Question 74
;;
;; Given a string of comma separated integers, write a function which returns a new comma separated string that only contains the numbers which are perfect squares.
;;
;; Use M-x 4clojure-check-answers when you're done!

(= (__ "4,5,6,7,8,9") "4,9")

(= (__ "15,16,25,36,37") "16,25,36")

(defn __ [x]
  (subs (reduce
         #(str % "," %2)
         ""
         (filter
          #(let [sq (Math/sqrt %)]
             (zero? (rem sq (int sq))))
          (map
           #(Integer/parseInt %)
           (re-seq #"\d+" x)))) 1))

(defn __ [x]
  (let [y (map #(Integer/parseInt %) (re-seq #"\d+" x))
        z (filter #(let [sq (Math/sqrt %)] (zero? (rem sq (int sq)))) y)
        a (reduce #(str % "," %2) "" z)]
    (subs a 1)))

(defn __ [x]
  (->> (map #(Integer/parseInt %) (re-seq #"\d+" x))
     (filter #(let [sq (Math/sqrt %)] (zero? (rem sq (int sq)))))
     (map str)
     (clojure.string/join ",")))

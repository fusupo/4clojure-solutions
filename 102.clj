;; 4Clojure Question 102
;;
;; When working with java, you often need to create an object with <code>fieldsLikeThis</code>, but you'd rather work with a hashmap that has <code>:keys-like-this</code> until it's time to convert. Write a function which takes lower-case hyphen-separated strings and converts them to camel-case strings.
;;
;; Use M-x 4clojure-check-answers when you're done!

(= (__ "something") "something")

(= (__ "multi-word-key") "multiWordKey")

(= (__ "leaveMeAlone") "leaveMeAlone")

(defn __ [x]
  (let [a (re-seq #"\w+" x)
        as (fn [l] (apply str l))]
    (as (cons (first a)(map #(let[s (seq %)]
                               (as (cons (clojure.string/upper-case (first s))(rest s))))(rest a))))))

(defn as [l] (apply str l))
(clojure.string/replace "hello-world" #"\w+" #(let[s (seq %)]
                                                (println s)
                                                (as (cons (clojure.string/upper-case (first s))(rest s)))))

(map #(clojure.string/replace % #"^[A-Za-z]" (fn [x] (clojure.string/upper-case x)))
     (clojure.string/split "multiWordKey" #"\-"))

(clojure.string/replace "hello" #"^[a-z]" #(.toUpperCase %))

(defn __ [x]
  (clojure.string/replace x #"\-\w{1}" #(str (last (seq (clojure.string/upper-case %))))))

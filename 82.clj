;; 4Clojure Question 82
;;
;; A word chain consists of a set of words ordered so that each word differs by only one letter from the words directly before and after it.  The one letter difference can be either an insertion, a deletion, or a substitution.  Here is an example word chain:<br/><br/>cat -> cot -> coat -> oat -> hat -> hot -> hog -> dog<br/><br/>Write a function which takes a sequence of words, and returns true if they can be arranged into one continous word chain, and false if they cannot.
;;
;; Use M-x 4clojure-check-answers when you're done!

(= true (__ #{"hat" "coat" "dog" "cat" "oat" "cot" "hot" "hog"}))

(= false (__ #{"cot" "hot" "bat" "fat"}))

(= false (__ #{"to" "top" "stop" "tops" "toss"}))

(= true (__ #{"spout" "do" "pot" "pout" "spot" "dot"}))

(= true (__ #{"share" "hares" "shares" "hare" "are"}))

(= false (__ #{"share" "hares" "hare" "are"}))

(defn __ [x]
  (println x)
  (println (vec (sort x))))

(defn __ [x]
  (let [findk (fn [words]
                (loop [idx (- (count words) 2)]
                  (cond
                    (< (compare (words idx) (words (inc idx))) 0) idx
                    (= idx 0) nil
                    :else (recur (dec idx)))))
        findl (fn [words k]
                (loop [idx (dec (count words))]
                  (cond
                    (< (compare (words k) (words idx)) 0) idx
                    (= idx k) nil
                    :else (recur (dec idx)))))]
    (loop [vx (vec (sort x))
           c 0]
      (let [k (findk vx)
            l (findl vx k)]
        (if (and (not (nil? k)) (< c 100))
          (let [nvx (assoc vx l (vx k) k (vx l))]
            (println nvx)
            (recur (vec (concat (subvec nvx 0 k) (reverse (subvec nvx k)))) (inc c)))
          (println "permutations complete"))))))


(clojure.set/subset? (set "at") (set "oat"))
(clojure.set/difference (set "dog") (set "cat"))
(clojure.set/difference (set "dog") (set "log"))

(compare "cat" "dog")

(vec (concat (subvec ["hat" "coat" "dog" "cat" "oat" "cot" "hot" "hog"] 0 4) (reverse (subvec ["hat" "coat" "dog" "cat" "oat" "cot" "hot" "hog"] 4))))

(defn chkchn [a b]
  (loop [idx 0]
    (cond (= idx (count a)) false
          (= (conj a (last b)) b) true
          (= (rest a) b) true
          (= (vec (remove #(= (b idx) %) a)) b) true 
          (= (vec (concat (subvec a 0 idx) (vector (b idx)) (subvec a idx))) b) true
          (= (assoc a idx (b idx)) b) true
          :else (recur (inc idx)))))


(vec "chain")
(vector :e)
(into [] (concat [:a :b :c] :z [:d :e]))
(subvec [12 3 4 5 6 7] 2)
(subvec [12 3 4 5 6 7] 0 0)

(chkchn (vec "hat") (vec "cat"))
(chkchn (vec "cat") (vec "coat"))
(chkchn (vec "first") (vec "second"))
(chkchn (vec "first") (vec "firsts"))

;;"share" "hares" "shares" "hare" "are"
(chkchn (vec "hare") (vec "are"))

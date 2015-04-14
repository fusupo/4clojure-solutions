;; 4Clojure Question 77
;;
;; Write a function which finds all the anagrams in a vector of words.  A word x is an anagram of word y if all the letters in x can be rearranged in a different order to form y.  Your function should return a set of sets, where each sub-set is a group of words which are anagrams of each other.  Each sub-set should have at least two words.  Words without any anagrams should not be included in the result.
;;
;; Use M-x 4clojure-check-answers when you're done!

(= (__ ["meat" "mat" "team" "mate" "eat"])
   #{#{"meat" "team" "mate"}})

(= (__ ["veer" "lake" "item" "kale" "mite" "ever"])
   #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}})

(defn __ [x]
  (reduce #(if (> (count %2) 1) (conj % %2) %)
          #{} (set (for [w1 x]
                     (set (for [w2 x
                                :when (and (= (count w1) (count w2))
                                         (clojure.set/subset? (set w1) (set w2)))]      
                            w2))))))
;; (fn [x]
;;   (reduce #(if (> (count %2) 1) (conj % %2) %)
;;           #{} (set (for [w1 x]
;;                      (set (for [w2 x
;;                                 :when (and (= (count w1) (count w2))
;;                                          (clojure.set/subset? (set w1) (set w2)))]      
;;                             w2))))))

(defn __ [x]
  (set (filter #(> (count %) 1)
               (set (for [w x]
                      (set (for [w2 x
                                 :when (and (= (count w) (count w2))
                                          (clojure.set/subset? (set w) (set w2)))]      
                             w2)))))))

;;

(defn __ [x]
  (set (filter #(> (count %) 1)
               (for [w x]
                 (set (filter #(and (= (count w) (count %))
                                  (clojure.set/subset? (set w) (set %))) x))))))

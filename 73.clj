;; 4Clojure Question 73
;;
;; A <a href="http://en.wikipedia.org/wiki/Tic-tac-toe">tic-tac-toe</a> board is represented by a two dimensional vector. X is represented by :x, O is represented by :o, and empty is represented by :e.  A player wins by placing three Xs or three Os in a horizontal, vertical, or diagonal row.  Write a function which analyzes a tic-tac-toe board and returns :x if X has won, :o if O has won, and nil if neither player has won.
;;
;; Use M-x 4clojure-check-answers when you're done!

(= nil (__ [[:e :e :e]
          [:e :e :e]
          [:e :e :e]]))

(= :x (__ [[:x :e :o]
           [:x :e :e]
           [:x :e :o]]))

(= :o (__ [[:e :x :e]
           [:o :o :o]
           [:x :e :x]]))

(= nil (__ [[:x :e :o]
          [:x :x :e]
          [:o :x :o]]))

(= :x (__ [[:x :e :e]
           [:o :x :e]
           [:o :e :x]]))

(= :o (__ [[:x :e :o]
           [:x :o :e]
           [:o :e :x]]))

(= nil (__ [[:x :o :x]
          [:x :o :x]
          [:o :x :o]]))

(defn __ [b]
  (let [checks [[0 0 inc nil]
                [0 0 inc inc]
                [0 0 nil inc]
                [1 0 nil inc]
                [2 0 dec inc]
                [2 0 nil inc]
                [0 1 inc nil]
                [0 2 inc nil]]
        didwin (fn [cx cy fx fy r]
                 (if (and (<= cx 2) (>= cx 0) (<= cy 2) (>= cy 0))
                   (recur (if (not= nil fx) (fx cx) cx)
                          (if (not= nil fy) (fy cy) cy)
                          fx fy
                          (cons ((b cy) cx) r))
                   r))
        res (map #(didwin (% 0) (% 1) (% 2) (% 3) '()) checks)
        res2 (reduce (fn [x v]
                       (conj x (if (and (apply = v) (not= (first v) :e))
                                 (first v)
                                 nil))) '() res)]
    (if (some #(= :x %) res2) :x
        (if (some #(= :o %) res2) :o nil))))

(apply = [:e :e :e])

wins [[0 0 1 0 2 0]
      [0 0 1 1 2 2]
      [0 0 0 1 0 2]
      [1 0 1 1 1 2]
      [2 0 1 1 0 2]
      [0 1 1 1 2 1]
      [0 2 1 2 2 2]]

(print (reduce (fn [x v]
                 (conj x (if (and (apply = v) (not= (first v :e)))
                           (first v)
                           nil))) '() '((:x :o :x) (:o :o :x) (:o :x :x) (:x :o :o) (:o :o :x) (:o :x :x) (:x :o :x) (:o :x :o))))

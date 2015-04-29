;; 4Clojure Question 137
;;
;; Write a function which returns a sequence of digits of a non-negative number (first argument) in numerical system with an arbitrary base (second argument). Digits should be represented with their integer values, e.g. 15 would be [1 5] in base 10, [1 1 1 1] in base 2 and [15] in base 16. 
;;
;; Use M-x 4clojure-check-answers when you're done!

(= [1 2 3 4 5 0 1] (__ 1234501 10))

(= [0] (__ 0 11))

(= [1 0 0 1] (__ 9 2))

(= [1 0] (let [n (rand-int 100000)](__ n n)))

(= [16 18 5 24 15 1] (__ Integer/MAX_VALUE 42))


(defn __ [n b]
  (if (= n 0)
    [0]
    (reverse (loop [i n
                    d []
                    c 0]
               (if (or (= i 0) (= c 100)) d
                   (let [r (mod i b)
                         ii (/ (- i r) b)]
                     (if (< r 0)
                       (recur (inc ii) (conj d (+ r b)) (inc c))
                       (recur ii (conj d r) (inc c)))))))))

(defn __ [n b]
  (reduce #() [] n))

;; function toArb(i,b){
;;              var digits = [];
;;              // if(!i){
;;                        //     digits = [0];
;;                        // }else{
;;                                 while(i !== 0){  
;;                                              var remainder = i % b;
;;                                              i = (i - remainder)/b;
;;                                              if(remainder<0){
;;                                                              remainder += b;
;;                                                              i += 1;
;;                                                              }
;;                                              digits.push(remainder);
;;                                              }
;;                                 //}
;;              return digits;
             
;;              }

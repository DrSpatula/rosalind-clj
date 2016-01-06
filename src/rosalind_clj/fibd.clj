(ns rosalind-clj.fibd)


(def mortal-rabbits 
  (memoize
    (fn [month lifespan]
      (cond
        (and (<= lifespan 1) (> month 1)) 0
        (<= month 0) 0
        (or (= 1 month) (= 2 month)) 1
        :else (let [mortality-month (inc (- month lifespan))] 
                (- (+ (mortal-rabbits (dec month) lifespan)
                      (mortal-rabbits (- month 2) lifespan))
                   (- (mortal-rabbits mortality-month lifespan)
                      (mortal-rabbits (dec mortality-month) lifespan))))))))

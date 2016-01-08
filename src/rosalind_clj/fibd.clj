(ns rosalind-clj.fibd)


(def newborns
  (memoize 
    (fn [lifespan month]
      (cond
        (= month 1) 1
        (or (< month 1) (= month 2)) 0
        :else (let [start-range (- month lifespan)
                    end-range (dec month)
                    months (filter #(> % 0) (range start-range end-range))]
                (apply +' (map #((partial newborns lifespan) %) months)))))))


(defn mortal-rabbits [month lifespan]
  (let [start-range (- month (dec lifespan))
        end-range (inc month)]
    (apply +' (map #((partial newborns lifespan) %) (range start-range end-range)))))

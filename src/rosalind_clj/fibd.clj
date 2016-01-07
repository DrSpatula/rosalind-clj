(ns rosalind-clj.fibd)


(defn age-pair [lifespan pair]
  (cond
    (= pair 1) 2
    (= pair lifespan) 1
    :else [(inc pair) 1]))


(defn next-generation [lifespan generation]
  (flatten (map #((partial age-pair lifespan) %) generation)))


(defn mortal-rabbits [month lifespan]
  (count (nth (iterate #((partial next-generation lifespan) %) [1]) (dec month))))

(ns rosalind-clj.iev)


(def probabilities
  "Probability of offspring having the dominant phenotype for each posible genotype pairing"
  {:AA-AA 1.0 :AA-Aa 1.0 :AA-aa 1.0 :Aa-Aa 0.75 :Aa-aa 0.5 :aa-aa 0.0})


(defn expected-offspring [offspring population]
  (if (not= 6 (count population))
    (throw (IllegalArgumentException. "Population argument must contain 6 values"))
    (reduce + (map #(* offspring (* %1 %2)) population (vals probabilities)))))

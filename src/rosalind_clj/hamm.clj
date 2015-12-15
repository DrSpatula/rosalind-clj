(ns rosalind-clj.hamm)

(defn hamming-distance [seq-a seq-b] 
  (when (not (= (count seq-a) (count seq-b)))
    (throw (IllegalArgumentException. "Sequence parameters must be of the same length.")))
  (reduce + (map #(if (not (= %1 %2)) 1 0) seq-a seq-b)))

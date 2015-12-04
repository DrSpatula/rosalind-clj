(ns rosalind-clj.rna)

(defn transcribe-base [base]
  (let [valid-bases #{\A \C \G \T}]
    (when (not (contains? valid-bases base))
      (throw (IllegalArgumentException. "Invalid base."))))
  (if (= base \T)
    \U
    base))

(defn dna->rna [dna-seq]
  (reduce str (map transcribe-base dna-seq)))

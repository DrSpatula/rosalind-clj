(ns rosalind-clj.rna)

(defn transcribe-base [base]
  (if (= base \T)
    \U
    base))

(defn dna->rna [dna-seq]
  (reduce str (map transcribe-base dna-seq)))

(ns rosalind-clj.core)

(def dna-bases #{\A \C \G \T})
(def rna-bases #{\A \C \G \U})

(defn valid-dna-base [base]
  (contains? dna-bases base))

(def invalid-dna-base (complement valid-dna-base))

(defn valid-rna-base [base]
  (contains? rna-bases base))

(def invalid-rna-base (complement valid-rna-base))

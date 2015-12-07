(ns rosalind-clj.rna
  (:require [rosalind-clj.core :as core]))

(defn transcribe-base [base]
  (when (core/invalid-dna-base base)
    (throw (IllegalArgumentException. "Invalid base.")))
  (if (= base \T)
    \U
    base))

(defn dna->rna [dna-seq]
  (reduce str (map transcribe-base dna-seq)))

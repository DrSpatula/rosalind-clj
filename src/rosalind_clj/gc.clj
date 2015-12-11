(ns rosalind-clj.gc
  (:require [rosalind-clj.core :as c]))

(defn g-or-c? [base]
  (or (= base \G) (= base \C)))

(defn gc-count [dna-seq]
  (reduce + (map #(if (g-or-c? %) 1 0) dna-seq)))

(defn gc-content [dna-seq]
  (* 100 (double (/ (gc-count dna-seq) (count dna-seq)))))

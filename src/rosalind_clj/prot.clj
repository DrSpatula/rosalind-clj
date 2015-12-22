(ns rosalind-clj.prot
  (:require [rosalind-clj.core :as c]
            [clojure.string :as s]))


(defn mrna->codons [mrna]
  (map #(keyword (s/join %)) (partition 3 mrna)))


(defn mrna->protein [mrna]
  (s/join (drop-last (map #(% c/rna-codon-table) (mrna->codons mrna)))))

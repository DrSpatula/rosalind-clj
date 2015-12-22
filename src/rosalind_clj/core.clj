(ns rosalind-clj.core
  (:require [clojure.string :as str]
            [clojure.java.io :as io]))

(def dna-bases #{\A \C \G \T})
(def rna-bases #{\A \C \G \U})

(defn valid-dna-base [base]
  (contains? dna-bases base))

(def invalid-dna-base (complement valid-dna-base))

(defn valid-rna-base [base]
  (contains? rna-bases base))

(def invalid-rna-base (complement valid-rna-base))

(defn import-fasta [filename]
  (let [file (io/resource filename)
        raw-txt (slurp file)
        raw-entries (rest (str/split raw-txt #">"))
        cleaned-entries (map #(str/split % #"\n") raw-entries)]
    (reduce (fn [new-map entry]
              (assoc new-map (first entry) (reduce str (rest entry))))
            {} cleaned-entries)))

(defn round-to-millionths [number]
  (/ (Math/round (* 1000000 number)) 1000000.0))

(defn within-abs-error? [result expected]
  (let [abs-error 0.001
        difference (Math/floor (- expected result))]
    (< difference abs-error)))

(def rna-codon-table
  {:UUU \F    :UUC \F    :UUA \L    :UUG \L   
   :UCU \S    :UCC \S    :UCA \S    :UCG \S   
   :UAU \Y    :UAC \Y    :UAA :stop :UAG :stop
   :UGU \C    :UGC \C    :UGA :stop :UGG \W
   :CUU \L    :CUC \L    :CUA \L    :CUG \L
   :CCU \P    :CCC \P    :CCA \P    :CCG \P
   :CAU \H    :CAC \H    :CAA \Q    :CAG \Q
   :CGU \R    :CGC \R    :CGA \R    :CGG \R
   :AUU \I    :AUC \I    :AUA \I    :AUG \M
   :ACU \T    :ACC \T    :ACA \T    :ACG \T
   :AAU \N    :AAC \N    :AAA \N    :AAG \N
   :AGU \S    :AGC \S    :AGA \R    :AGG \R
   :GUU \V    :GUC \V    :GUA \V    :GUG \V
   :GCU \A    :GCC \A    :GCA \A    :GCG \A
   :GAU \D    :GAC \D    :GAA \E    :GAG \E
   :GGU \G    :GGC \G    :GGA \G    :GGG \G})

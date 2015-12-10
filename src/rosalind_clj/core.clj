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

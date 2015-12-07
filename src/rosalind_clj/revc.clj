(ns rosalind-clj.revc
  (:require [rosalind-clj.core :as c]))

(def base-complements {:A \T :C \G :G \C :T \A})

(defn complement-base [base]
  (when (c/invalid-dna-base base)
    (throw (IllegalArgumentException. "Invalid base.")))
  ((keyword (str base)) base-complements))

(defn reverse-complement [dna-seq]
  (reduce str (map complement-base (reverse dna-seq))))

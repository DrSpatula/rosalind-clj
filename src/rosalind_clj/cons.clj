(ns rosalind-clj.cons
  (require [rosalind-clj.dna :as dna]))


(defn pivot-matrix [strands]
  (partition (dec (count (first strands))) (apply interleave strands)))


(defn consensus [strands]
  (let [position-counts (map dna/count-bases (pivot-matrix strands))]
    (map #(key (apply max-key val %)) position-counts)))

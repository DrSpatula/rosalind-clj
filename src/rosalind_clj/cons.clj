(ns rosalind-clj.cons
  (require [rosalind-clj.core :as core]
           [rosalind-clj.dna :as dna]
           [clojure.string :as str]))


(defn pivot-matrix [strands]
  (partition (count strands) (apply interleave strands)))


(defn counts-by-position [strands]
  (map dna/count-bases (pivot-matrix strands)))


(defn consensus [strands]
  (let [position-counts (counts-by-position strands) 
        cons-list (map #(key (apply max-key val %)) position-counts)]
    (str/join (map #(second (str %)) cons-list))))


(defn profile [strands]
  (let [counts (counts-by-position strands)
        base-list (map #(keyword (str %)) core/dna-bases)]
    (reduce 
      (fn [profile base]
        (assoc profile base (map #(get % base 0) counts))) 
      {} base-list)))


(defn consensus-and-profile [fasta-filename]
  (let [strands (vals (core/import-fasta fasta-filename))
        con (consensus strands)
        pro (profile strands)]
    (println con)
    (println "A:" (str/join " " (:A pro)))
    (println "C:" (str/join " " (:C pro)))
    (println "G:" (str/join " " (:G pro)))
    (println "T:" (str/join " " (:T pro)))))

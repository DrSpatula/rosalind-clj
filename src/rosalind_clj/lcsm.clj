(ns rosalind-clj.lcsm
  (:require [clojure.string :as s]))

(defn contains-motif? [nt-seq motif]
  (when (> (count motif) (count nt-seq))
    (throw (IllegalArgumentException. "Motif cannot be longer than nucleotide sequence")))
  (let [motif-seq (seq motif)
        motif-len (count motif)]
    (loop [search-seq nt-seq]
      (if (> motif-len (count search-seq)) false
        (let [test-chunk (take motif-len search-seq)]
          (if (= test-chunk motif-seq) true
            (recur (rest search-seq))))))))


(defn found-in-all? [seqs motif]
  (if (empty? seqs) true
    (if (not (contains-motif? (first seqs) motif)) false
      (found-in-all? (rest seqs) motif))))


(defn find-sub-motif [motif sub-size seqs]
  (when (> sub-size (count motif))
    (throw (IllegalArgumentException. "Length of sub-sequence cannot be longer than motif")))
  (loop [sub-motif motif]
    (if (> sub-size (count sub-motif)) nil
      (let [test-motif (take sub-size sub-motif)]
        (if (found-in-all? seqs test-motif) (s/join test-motif) 
          (recur (rest sub-motif)))))))


(defn longest-common-shared-motif [fasta-data]
  (when (>= 1 (count fasta-data))
    (throw (IllegalArgumentException. "Data must contain more than one nucleotide sequence")))
  (let [seqs (vals fasta-data)
        motif-source (first (sort-by count seqs))]
    (loop [lcsm-len (count motif-source)]
      (let [lcsm (find-sub-motif motif-source lcsm-len seqs)]
        (if (nil? lcsm)
          (recur (dec lcsm-len))
          lcsm)))))

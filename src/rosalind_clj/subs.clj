(ns rosalind-clj.subs)

(defn find-repeats [nt-seq motif]
  (when (> (count motif) (count nt-seq))
    (throw (IllegalArgumentException. "Motif to locate cannot be longer than nucleotide sequence")))
  (loop [position 0
         indicies []]
    (if (> (+ position (count motif)) (count nt-seq))
      indicies
    (let [test-seq (take (count motif) (drop position nt-seq))]
      (if (= test-seq (seq motif))
        (recur (inc position) (conj indicies (inc position)))
        (recur (inc position) indicies))))))

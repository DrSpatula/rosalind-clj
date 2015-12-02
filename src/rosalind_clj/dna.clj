(ns rosalind-clj.dna)

(defn count-bases [dna-seq]
  (let [grouped-bases (group-by identity dna-seq)]
    (reduce (fn [base-count-map [key val]]
              (assoc base-count-map (keyword (str key)) (count val)))
            {} grouped-bases)))

(defn print-base-counts [base-counts]
  (str (:A base-counts) " " (:C base-counts) " " (:G base-counts) " " (:T base-counts)))

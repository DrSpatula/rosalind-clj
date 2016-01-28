(ns rosalind-clj.grph)

(defn overlaps [order label data]
  (let [suffix (take-last order (get data label))]
    (remove #(= label %)
            (map first 
                 (filter #(= suffix (take order (second %))) data)))))


(defn overlap-graph [order data]
  (let [labels (keys data)]
    (reduce (fn [graph label]
              (let [links (overlaps order label data)]
                (if (not (empty? links))
                  (assoc graph label links)
                  graph)))
            {} labels)))


(defn print-o3-overlap-graph [data]
  (let [graph (overlap-graph 3 data)]
    (map (fn [[label links]]
           (map #(println label %) links)) graph)))

(ns rosalind-clj.fib)

(defn rabbit-pairs [month offspring]
  (if (or (= month 1) (= month 2))
    1
    (+ (rabbit-pairs (- month 1) offspring) (* (rabbit-pairs (- month 2) offspring) offspring))))

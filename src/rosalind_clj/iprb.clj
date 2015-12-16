(ns rosalind-clj.iprb
  (:require [rosalind-clj.core :as c]))

;; Calculate the probablity of an offspring having the dominant phenotype
;; given counts for all possible allele combinations within the population

;; hod: homozygous dominant
;; het: heterozygous
;; hor: homozygous recessive


;; Probablility is the sum of the following:

;; P(both parents being ho-d)
(defn- both-parents-hod [hod-pop het-pop hor-pop]
  (let [total-pop (+ hod-pop het-pop hor-pop)]
    (* (/ hod-pop total-pop)
       (/ (dec hod-pop) (dec total-pop)))))

;; P(exacly one parent being hod)
;; Multiplies by two to represent the probability of both hod/* and */hod
(defn- one-parent-hod [hod-pop het-pop hor-pop]
  (let [total-pop (+ hod-pop het-pop hor-pop)]
    (* 2 (/ hod-pop total-pop) (/ (+ het-pop hor-pop) (dec total-pop)))))

;; P(both parents being het) * P(offspring of a het/het pairing having the dominant allele)
(defn- both-parents-het [hod-pop het-pop hor-pop]
  (let [total-pop (+ hod-pop het-pop hor-pop)
        probability-of-dominant-phenotype 3/4]
    (* (/ het-pop total-pop) (/ (dec het-pop) (dec total-pop)) probability-of-dominant-phenotype)))

;; P(one parent het and the other hor) * P(offspring of a het/hor pairing having the dominant allele)
;; Multiplies by two to represent the probability of both het/hor and hor/het
(defn- het-hor [hod-pop het-pop hor-pop]
  (let [total-pop (+ hod-pop het-pop hor-pop)
        probability-of-dominant-phenotype 1/2]
    (* 2 (/ het-pop total-pop) (/ hor-pop (dec total-pop)) probability-of-dominant-phenotype)))


;; Total Probability
(defn probability-of-dominant-phenotype [hod-pop het-pop hor-pop]
  (let [population [hod-pop het-pop hor-pop]]
    (when (< (reduce + population) 2)
      (throw (IllegalArgumentException. "Total population must be at least two.")))
    (c/round-to-millionths 
      (double (+ (apply both-parents-hod population)
                 (apply one-parent-hod population)
                 (apply both-parents-het population)
                 (apply het-hor population))))))

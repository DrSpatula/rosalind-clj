(ns rosalind-clj.iprb)

;; Calculate the probablity of an offspring having the dominant phenotype
;; given counts for all possible allele combinations within the population

;; ho-d: homozygous dominant
;; het:  heterozygous
;; ho-r: homozygous recessive

;; Probablility is the sum of the following:
;; P(both parents being ho-d)
;; P(exacly one parent being ho-d)
;; P(both parents being het) * P(offspring of a het/het pairing having the dominant allele)
;; P(one parent het and the other ho-r) * P(offspring of a het/ho-r pairing having the dominant allele)

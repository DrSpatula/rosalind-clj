(ns rosalind-clj.prot-test
  (:require [clojure.test :refer :all]
            [rosalind-clj.prot :refer :all]))

(def sample-dataset "AUGGCCAUGGCGCCCAGAACUGAGAUCAAUAGUACCCGUAUUAACGGGUGA")

(deftest test-mrna->codons
  (let [codons (mrna->codons sample-dataset)]
    (testing "All codons represented as keywords"
      (is (every? keyword? codons)))
    (testing "Correct codons returned for sample dataset"
      (is (= (mrna->codons sample-dataset) '(:AUG :GCC :AUG :GCG :CCC :AGA :ACU :GAG :AUC :AAU :AGU :ACC :CGU :AUU :AAC :GGG :UGA))))))

(deftest test-mrna->protein
  (testing "Correct protein sequence returned for sample dataset"
    (let [prot-seq "MAMAPRTEINSTRING"]
      (is (= (mrna->protein sample-dataset) prot-seq)))))

(ns rosalind-clj.grph-test
  (:require [clojure.test :refer :all]
            [rosalind-clj.grph :refer :all]
            [rosalind-clj.core :as c]))


(def data (c/import-fasta "grph_sample_data.txt"))


(deftest overlaps-test
  (testing "Test on sample data returns correct result"
    (is (= '("Rosalind_2391"  "Rosalind_0442") (overlaps 3 (first (first data)) data)))))


(deftest overlap-graph-test
  (testing "Sample data returns correct result"
    (is (= {"Rosalind_0498"  '("Rosalind_2391"  "Rosalind_0442"),  "Rosalind_2391"  '("Rosalind_2323")}
           (overlap-graph 3 data)))))

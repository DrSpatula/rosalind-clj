(ns rosalind-clj.dna-test
  (:require [clojure.test :refer :all]
            [rosalind-clj.dna :refer :all]))

(def sample-dna-dataset "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC")
(def correct-base-count-map {:A 20 :G 17 :C 12 :T 21})
(def correct-base-count-str "20 12 17 21")

(deftest test-count-bases
  (testing "Test of count-bases"
    (is (= correct-base-count-map (count-bases sample-dna-dataset)))))

(deftest test-base-counts->str
  (testing "Test of base-counts->str"
    (is (= correct-base-count-str (base-counts->str correct-base-count-map)))))

(deftest test-base-count-str
  (testing "Test of base-count-str"
    (is (= correct-base-count-str (base-count-str sample-dna-dataset)))))

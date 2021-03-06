(ns rosalind-clj.core-test
  (:require [clojure.test :refer :all]
            [clojure.set :as s]
            [rosalind-clj.core :refer :all]))

(def all-chars (set (map char (concat (range 65 91) (range 97 123)))))
(def valid-dna-bases #{\A \C \G \T})
(def invalid-dna-bases (s/difference all-chars valid-dna-bases))
(def valid-rna-bases #{\A \C \G \U})
(def invalid-rna-bases (s/difference all-chars valid-rna-bases))

(deftest test-valid-dna-base 
  (testing "Valid bases return true"
      (is (every? valid-dna-base valid-dna-bases)))
  (testing "Invalid bases return false"
      (is (nil? (some valid-dna-base invalid-dna-bases)))))

(deftest test-invalid-dna-base
  (testing "Invalid bases return true"
    (is (every? invalid-dna-base invalid-dna-bases)))
  (testing "Valid bases return false"
    (is (nil? (some invalid-dna-base valid-dna-bases)))))

(deftest test-valid-rna-base 
  (testing "Valid bases return true"
      (is (every? valid-rna-base valid-rna-bases)))
  (testing "Invalid bases return false"
      (is (nil? (some valid-rna-base invalid-rna-bases)))))

(deftest test-invalid-rna-base
  (testing "Invalid bases return true"
    (is (every? invalid-rna-base invalid-rna-bases)))
  (testing "Valid bases return false"
    (is (nil? (some invalid-rna-base valid-rna-bases)))))


(deftest test-import-fasta
  (testing "Test FASTA data file returns correct data"
    (let [test-filename "fasta_test_file.txt"
          correct-data {"Label 1"  "Data line 1 Data line 2"  "Label 2"  "Data line 3 Data line 4"}]
      (is (= correct-data (import-fasta test-filename))))))


(deftest test-within-abs-error?
  (testing "Difference higher than absolute error returns false"
    (is (not (within-abs-error? 10 20))))
  (testing "Difference lower than absolute error returns true"
    (is (within-abs-error? 10 10.0009))))

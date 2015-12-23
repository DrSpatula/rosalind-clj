(ns rosalind-clj.subs-test
  (:require [clojure.test :refer :all]
            [rosalind-clj.subs :refer :all]))

(def sample-sequence "GATATATGCATATACTT")
(def sample-motif "ATAT")

(deftest test-find-repeats
  (testing "Empty vector returned when motif doesn't exist in sequence"
    (is (empty? (find-repeats "ATGCCGCAT" "NO"))))
  (testing "Motif found at beginning of sequence"
    (is (= (find-repeats sample-sequence "GATATA") [1])))
  (testing "Motif found at end of sequence"
    (is (= (find-repeats sample-sequence "ATACTT") [12])))
  (testing "Sample data returns correct result"
    (is (= (find-repeats sample-sequence sample-motif) [2 4 10])))
  (testing "Motif longer than sequence throws exception"
    (is (thrown? IllegalArgumentException (find-repeats sample-motif sample-sequence)))))

(ns rosalind-clj.hamm-test
  (:require [clojure.test :refer :all]
            [rosalind-clj.hamm :refer :all]))

(deftest test-hamming-distance
  (testing "No differences returns 0"
    (let [test-1-seq "GAGCCTACTAACGGGAT"]
      (is (= 0 (hamming-distance test-1-seq test-1-seq)))))
  (testing "One difference returns 1"
    (let [test-2-seq-a "GAGCCTACTAACGGGAT"
          test-2-seq-b "GAGCCTACTAACGGGAG"]
      (is (= 1 (hamming-distance test-2-seq-a test-2-seq-b)))))
  (testing "Complete difference returns length of string"
    (let [test-3-seq-a "GAGCCTACTAACGGGAT"
          test-3-seq-b "CTCGGATGATTGCCCTA"]
      (is (= (count test-3-seq-a) (hamming-distance test-3-seq-a test-3-seq-b)))))
  (testing "Sample data returns correct answer"
    (let [test-4-seq-a "GAGCCTACTAACGGGAT"
          test-4-seq-b "CATCGTAATGACGGCCT"
          correct-result 7]
      (is (= correct-result (hamming-distance test-4-seq-a test-4-seq-b)))))
  (testing "Calling with different length arguments throws an exception"
    (let [test-5-seq-a "CGATTGCGATT"
          test-5-seq-b "GGCAT"]
      (is (thrown? IllegalArgumentException (hamming-distance test-5-seq-a test-5-seq-b))))))

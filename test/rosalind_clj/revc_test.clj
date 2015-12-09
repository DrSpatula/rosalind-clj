(ns rosalind-clj.revc-test
  (:require [clojure.test :refer :all]
            [rosalind-clj.revc :refer :all]))

(deftest test-complement-base
  (testing "Complement of adenine is thymine"
    (is (= \T (complement-base \A))))
  (testing "Complement of cytosine is guanine"
    (is (= \G (complement-base \C))))
  (testing "Complement of guanine is cytosine"
    (is (= \C (complement-base \G))))
  (testing "Complement of thymine is adenine"
    (is (= \A (complement-base \T))))
  (testing "Invalid base throws exception"
    (is (thrown? IllegalArgumentException (complement-base \U)))))

(deftest test-reverse-complement
  (testing "Correct reverse complement is returned"
    (let [sample-data "AAAACCCGGT"
          correct-output "ACCGGGTTTT"]
      (is (= correct-output (reverse-complement sample-data))))))

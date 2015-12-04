(ns rosalind-clj.rna-test
  (:require [clojure.test :refer :all]
            [rosalind-clj.rna :refer :all]))

(deftest test-transcribe-base
  (testing "Invalid base throws an exception"
    (is (thrown? IllegalArgumentException (transcribe-base \F))))
  (testing "Adenine, cytosine, and guanine pass unchanged"
    (is (= \A (transcribe-base \A)))
    (is (= \C (transcribe-base \C)))
    (is (= \G (transcribe-base \G))))
  (testing "Thyamine is correctly translated to uracil"
    (is (= \U (transcribe-base \T)))))

(deftest test-dna->rna
  (let [sample-dataset "GATGGAACTTGACTACGTAAATT"
        correct-rna "GAUGGAACUUGACUACGUAAAUU"]
    (testing "DNA transcribes to correct RNA"
      (is (= correct-rna (dna->rna sample-dataset))))))

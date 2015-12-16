(ns rosalind-clj.iprb-test
  (:require [clojure.test :refer :all]
            [rosalind-clj.iprb :refer :all]
            [rosalind-clj.core :as c]))

(deftest test-probability-of-dominant-phenotype
  (testing "All homozygous dominant population returns 1.0"
    (is (= 1.0 (probability-of-dominant-phenotype 2 0 0))))
  (testing "All heterozygous population returns 0.75"
    (is (= 0.75 (probability-of-dominant-phenotype 0 2 0))))
  (testing "All homozygous recessive population returs 0.0"
    (is (= 0.0 (probability-of-dominant-phenotype 0 0 2))))
  (testing "Sample data returns correct answer"
    (is (c/within-abs-error? 0.78333 (probability-of-dominant-phenotype 2 2 2))))
  (testing "Population of one throws exception"
    (is (thrown? IllegalArgumentException (probability-of-dominant-phenotype 1 0 0)))))

(ns rosalind-clj.iev-test
  (:require [clojure.test :refer :all]
            [rosalind-clj.iev :refer :all]))


(deftest expected-offspring-test
  (testing "Zero population expects zero offspring"
    (is (= 0.0 (expected-offspring 1 (take 6 (repeat 0))))))
  (testing "Population of six ones and single offspring returns sum of probability values"
    (is (= (reduce + (vals probabilities)) (expected-offspring 1 (take 6 (repeat 1))))))
  (testing "Sample data returns correct result"
    (let [sample-data [1 0 0 1 0 1]]
      (is (= 3.5 (expected-offspring 2 sample-data)))))
  (testing "Exception is thrown if population contains incorrect number of values"
    (is (thrown? IllegalArgumentException (expected-offspring 1 [1 0])))))

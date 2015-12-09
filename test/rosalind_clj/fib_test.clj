(ns rosalind-clj.fib-test
  (:require [clojure.test :refer :all]
            [rosalind-clj.fib :refer :all]))

(deftest test-rabbit-pairs
  (testing "Sample case returns correct answer"
    (let [months 5
          new-pairs 3
          correct-answer 19]
      (is (= correct-answer (rabbit-pairs months new-pairs)))))
  (testing "Base cases both return one"
    (is (= 1 (rabbit-pairs 1 (+ 1 (rand-int 500)))))
    (is (= 1 (rabbit-pairs 2 (+ 1 (rand-int 500))))))
  (testing "Sequence of successive answers is correct"
    (let [fib-seq-for-3 '(1 1 4 7 19 40 97 217 508 1159)]
      (is (= fib-seq-for-3 (map #(rabbit-pairs % 3) (range 1 11)))))))

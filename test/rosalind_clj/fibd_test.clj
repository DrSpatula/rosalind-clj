(ns rosalind-clj.fibd-test
  (:require [clojure.test :refer :all]
            [rosalind-clj.fibd :refer :all]))

(deftest newborns-test
  (testing "base cases return correct values"
    (is (= 1 (newborns 3 1)))
    (is (= 0 (newborns 3 2)))
    (is (= 0 (newborns 3 -1))))
  (testing "correct value returned for various inputs"
    (is (= 2 (newborns 3 6)))
    (is (= 4 (newborns 4 7)))
    (is (= 7 (newborns 5 8)))))


(deftest mortal-rabbits-test
  (testing "sample data returns correct input"
    (is (= 4 (mortal-rabbits 6 3))))
  (testing "correct value returned for various inputs"
    (is (= 9 (mortal-rabbits 7 4)))
    (is (= 17 (mortal-rabbits 8 5)))))

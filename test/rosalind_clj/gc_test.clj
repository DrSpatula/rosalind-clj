(ns rosalind-clj.gc-test
  (:require [clojure.test :refer :all]
            [clojure.set :as s]
            [rosalind-clj.gc :refer :all]))

(def not-g-or-c (s/difference (set (map char (concat (range 65 91) (range 97 123)))) #{\G \C}))

(deftest test-g-or-c
  (testing "G returns true"
    (is (g-or-c? \G)))
  (testing "C returns true"
    (is (g-or-c? \C)))
  (testing "Anything else returns false"
    (is (nil? (some g-or-c? not-g-or-c)))))

(deftest test-gc-count
  (testing "String of all G and C returns string length"
    (let [test-str "GGGGCCCC"]
      (is (= (gc-count test-str) (count test-str)))))
  (testing "String with no G or C returns 0"
    (is (= (gc-count "AAAATTTT") 0)))
  (testing "Mixed sequence returns correct count"
    (let [test-seq "AAAACCCCGGGGTTTT"]
      (is (= (gc-count test-seq) 8)))))

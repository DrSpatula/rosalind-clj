(ns rosalind-clj.gc-test
  (:require [clojure.test :refer :all]
            [clojure.set :as s]
            [rosalind-clj.gc :refer :all]
            [rosalind-clj.core :as c]))

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

(deftest test-gc-content
  (testing "String of all G and C returns 100.0"
    (is (c/within-abs-error? (gc-content "GC") 100.0)))
  (testing "String with no G or C returns 0.0"
    (is (c/within-abs-error? (gc-content "AT") 0.0)))
  (testing "Mixed sequence returns expected result"
    (let [test-seq "CCACCCTCGTGGTATGGCTAGGCATTCAGGAACCGGAGAACGCTTCAGACCAGCCCGGACTGGGAACCTGCGGGCAGTAGGTGGAAT"
          expected-result 60.919540]
      (is (c/within-abs-error? (gc-content test-seq) expected-result)))))

(deftest test-max-gc-content
  (is (= (-> "gc_sample_data.txt" c/import-fasta max-gc-content) ["Rosalind_0808" 60.919540])))

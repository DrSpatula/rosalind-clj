(ns rosalind-clj.cons-test
  (require [rosalind-clj.cons :refer :all]
           [clojure.test :refer :all]
           [rosalind-clj.core :as core]))


(def sample-strands (vals (core/import-fasta "cons_sample_data.txt")))


(deftest consensus-test
  (testing "Consensus of single strand is that strand itself"
    (let [data '("AAAAAAAAAAA")]
      (is (= (consensus data) (first data)))))
  (testing "Consensus is same length as input strands"
    (let [sample-consensus (consensus sample-strands)]
      (is (= (count sample-consensus) (count (first sample-strands))))))
  (testing "Sample data gives correct consensus strand"
    (let [sample-consensus (consensus sample-strands)
          correct-consensus "ATGCAACT"]
      (is (= sample-consensus correct-consensus)))))


(deftest profile-test
  (let [sample-profile (profile sample-strands)
        correct-profile {:A '(5 1 0 0 5 5 0 0) :C '(0 0 1 4 2 0 6 1) :G '(1 1 6 3 0 1 0 0) :T '(1 5 0 0 0 1 1 6)}]
    (testing "All base profiles have the same number of elements"
      (let [counts (map count (vals sample-profile))]
        (is (every? #(= (first counts) %) counts))))
    (testing "Each base profile has the same number of elements as the input strands"
      (let [counts (map count (vals sample-profile))]
        (is (every? #(= (count (first sample-strands)) %) counts))))
    (testing "Sample data gives correct profile"
      (is (= sample-profile correct-profile)))))

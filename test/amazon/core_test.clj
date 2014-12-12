(ns amazon.core-test
  (:require [clojure.test :refer :all]
            [clojure-csv.core :refer :all]
            [clojure.java.io :as io]
            [amazon.core :refer :all]))


(def sample-data-file
  (io/file (io/resource
            "yellow-small.data" )))


(def sample-data
  (map #(list (zipmap [:color :size :act :age] %)
              (last %))
       (parse-csv (slurp sample-data-file))))

(deftest entropy-test
  (is (= 0 (entropy [])) "zero for an empty dataset")
  (is (= 0.9709505944546686 (entropy sample-data)) "entropy for a sample dataset"))


(deftest info-gain-test
  (is (= 0.4199730940219749 (info-gain :color sample-data)) "color attribute info-gain")
  (is (= 0.4199730940219749 (info-gain :size sample-data)) "size attribute info-gain")
  (is (= 0.0 (info-gain :act sample-data)) "act attribute info-gain")
  (is (= 0.0 (info-gain :age sample-data)) "age attribute info-gain"))



(deftest max-info-gain-key-test
  (is (= :color (max-info-gain-key sample-data))))

(ns amazon.core-test
  (:require [clojure.test :refer :all]
            [amazon.core :refer :all]))

(def sample-dataset
  [
   [:foo,  :t]
   [:foo,  :t]
   [:foo,  :t]
   [:foo,  :f]
   [:foo,  :t]
   [:foo,  :f]
   [:foo,  :t]
   [:foo,  :f]
   [:foo,  :f]
   [:foo,  :f]])

(deftest entropy-test
  (is (= 0 (entropy [])) "zero for an empty dataset")
  (is (= 1.0 (entropy sample-dataset)) "entropy for a sample dataset"))

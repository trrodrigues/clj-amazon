(ns amazon.core
  (:gen-class))

(defn log2 [x]
  (/ (Math/log x) (Math/log 2)))

(defn entropy [alist]
  (let
    [n (count alist)
     counts (vals (frequencies (map #(nth % 1) alist)))]

    (reduce + (map #(* (- %) (log2 %)) (map #(/ % n) counts)))))

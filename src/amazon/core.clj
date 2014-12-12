(ns amazon.core
  (:gen-class))

(defn log2 [x]
  (/ (Math/log x) (Math/log 2)))

(defn entropy [alist]
  (let
    [n (count alist)
     list-freqs (vals (frequencies (map #(nth % 1) alist)))]

    (reduce +
            (map #(* (- %) (log2 %))
                 (map #(/ % n) list-freqs)))))

(defn info-gain
  ([k alist]
   (info-gain (entropy alist) k alist))

  ([current-entropy k alist]
   (let [grouped-keys (group-by #(k (nth % 0)) alist)
         lcount (count alist)]

     (- current-entropy
        (reduce +
                (map
                 #(* (/ (count (nth % 1)) lcount)
                     (entropy (nth % 1)))
                 grouped-keys))))))


(defn max-info-gain-key [alist]
  (let [data-keys (keys (nth (first alist) 0))]
    (apply max-key #(info-gain % alist) data-keys)))

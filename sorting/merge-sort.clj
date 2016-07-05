;; to run this code use - http://app.klipse.tech

;; merge sort using clojure

(defn merge-sort
  [vec]
  "sorts the given vector `vec` using merge sort"
  (if (<= (count vec) 1) vec
      ;; do the merge of sorted divided vectors
      (merge
       (merge-sort (get-first-half vec))
       (merge-sort (get-second-half vec)))))

(defn get-first-half
  [vec]
  (let [vec-size (count vec)
        start 0
        end (Math/floor (/ vec-size 2))]
    (subvec vec start end)))

(defn get-second-half
  [vec]
  (let [vec-size (count vec)
        start (Math/floor (/ vec-size 2))]
    (subvec vec start)))

(defn merge
  [vec1 vec2]
  "merge vectors `vec1` and `vec2` so that results are sorted"
  (loop [v1 vec1
         v2 vec2
         result []]
    (cond
      (empty? v1) (into [] (concat result v2))
      (empty? v2) (into [] (concat result v1))
      (> (first v1) (first v2)) (recur v1 (rest v2) (conj result (first v2)))
      :else (recur (rest v1) v2 (conj result (first v1))))))


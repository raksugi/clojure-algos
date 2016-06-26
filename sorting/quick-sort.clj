;; to run this code use - http://app.klipse.tech

;; this is a non-tail recursive version of quicksort
(defn quick-sort
  [vec]
  "sort the given vector `vec` using quick sort"
  (cond 
    (empty? vec) vec
    (= (count vec) 1) vec
    :else (let [
                pivot (first vec)
                sm (filterv (fn [el] (< el pivot)) (rest vec))
                lg (filterv (fn [el] (> el pivot)) (rest vec))
                ]
            (into [] (concat (conj (quick-sort sm) pivot) (quick-sort lg))))))

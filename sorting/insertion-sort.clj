;; to run this code use - http://app.klipse.tech

;; insertion sort using clojure
;; notice that this is tail-recursive sort
(defn insertion-sort
  [vec]
  "sorts the given `vec` using insertion sort algorithm"
  (loop [sorted-vec []
         item (first vec)
         pending-inserts (rest vec)]
    (if (nil? item)
      sorted-vec
      (recur (insert sorted-vec item) (first pending-inserts) (rest pending-inserts)))))

;; the tail recursive insert function
(defn insert
  [vec item]
  "inserts the `item` into the sorted vector `vec` in its right position"
  (loop [in-vec vec
         el item
         out-vec []]
    (cond
      (empty? in-vec) (conj out-vec el)
      (> (first in-vec) el) (into [] (concat (conj out-vec el) in-vec))
      :else (recur (rest in-vec) el (conj out-vec (first in-vec))))))

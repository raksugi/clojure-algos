;; to run this code use - http://app.klipse.tech

;; insertion sort using clojure
;; notice that this is tail-recursive sort
(defn insertion-sort
  [vec]
  "sorts the given `vec` using insertion sort algorithm"
  (loop [sortedVec []
         item (first vec)
         pendingInserts (rest vec)]
    (if (nil? item)
      sortedVec
      (recur (insert sortedVec item) (first pendingInserts) (rest pendingInserts)))))

;; the tail recursive insert function
(defn insert
  [vec item]
  "inserts the `item` into the sorted vector `vec` in its right position"
  (loop [inVec vec
         el item
         outVec []]
    (cond
      (empty? inVec) (conj outVec el)
      (> (first inVec) el) (into [] (concat (conj outVec el) inVec))
      :else (recur (rest inVec) el (conj outVec (first inVec))))))

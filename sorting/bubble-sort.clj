;; to run this code use - http://app.klipse.tech

;; bubble sort using clojure
;; feels like doing pointer based sorting :(

(defn bubble-sort
  [vec]
  "use bubble sort algorithm to sort vector `vec`"
  (loop [v vec
         counter (count vec)]
    (if (= 0 counter) v
        (recur (bubble v) (dec counter)))))

(defn bubble
  [vec]
  "bubbles up the largest value in `vec`"
  (loop [v vec
         p1 0
         p2 1]
    (cond (= (count v) p2) v
          :else (recur
                 (if (> (get v p1) (get v p2))
                   (swap v p1 p2)
                   v)
                 (inc p1) (inc p2)))))
(defn swap
  [vec p1 p2]
  "swaps the elements in positions p1 and p2 in vector `vec`"
  (assoc vec
         p1 (get vec p2)
         p2 (get vec p1)))

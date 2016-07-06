;; to run this code use - http://app.klipse.tech

;; selection sort using clojure

(defn selection-sort
  [vec]
  "sorts the given vector `vec` using selection sort"
  (if (<= (count vec) 1) vec
      (loop [i 0
             v vec]
        (if (= (count v) i)
          v
          (recur (inc i)
                 (swap v i (index-of-min v i)))))))

(defn index-of-min
  [vec start-idx]
  "finds the index of a minimum value in given vector `vec`"
  (if (empty? vec) -1
      (loop [min-idx start-idx
             i (+ start-idx 1)]
        (if (nil? (get vec i)) min-idx
            (recur (if (> (get vec min-idx) (get vec i)) i min-idx)
                   (inc i))))))


(defn swap
  [vec p1 p2]
  "swaps the elements in positions p1 and p2 in vector `vec`"
  (assoc vec
         p1 (get vec p2)
         p2 (get vec p1)))

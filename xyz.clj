(ns clojure-practice-new.xyz)

(defn is_even1[]

  (filter even? [12 3 4 56  7 8 8 ])
  )



(defn filter_example[nos]
  (filter even? (range nos))
  )

(defn is_even2[x]
  (filter #(even? %)x)
  )

(defn is_even3[x]
  (filter (fn[x2](even? x2))x)
  )
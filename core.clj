(ns clojure-practice-new.core)

(defn myfn [name]
  (println (str "Hello " name)))

(defn add [a b]
  (println (+ a b)))

(defn add2 [a b]
  (+ a b))

(defn function2 []
  (+ 10 (add2 1 2)))

(defn function3 [num]
  (if (even? num)
    (println "It is an even number")
    (println "It is not an even number"))
  )

(defn function4 [number]
  (if (even? number)
    (do (println "It is an even number")
        1)
    (do (println "It is not an even number")
        2)))

(defn function-let []
  (let [a 10
        b 12]

    (prn a b)
    )
  )

;;higher order functions
(defn myfn2 [asdf]
  (asdf "Cerner")
  )

(def a 11)
(def myfn3 (fn [x] (prn x "IBM")))


;;anonymous fns
;(fn [] :adfs)
;(myfn2 ())
;;clojure doesnt have return
;;nil is same as null in java
;if, switch case, when, how is let used in clojure

;;examples of while



(defn example_of_while [numbr]
  (while (> numbr 100)
    (do
      (println "given no is greater than 100")
      (println "given no is not greater than 100")
      (swap! - numbr 2)
      )))

;(loop)
;loop recur, for , map



;loop recur examples

(defn loop_recur_example [no]
  (loop [x no]
    (when (> x 0)
      (println no)
      (recur (- x 2)))))



;;filter example


(defn filter_example[nos]
  (filter even? (range nos))
  )

;example of maps
(defn map_example_new[]
  (map (fn[x] (+ x 1)) (range 10)))

;apply map reduce areduce some? some loop recur

(def fruits '("apple", "pineapple"));;wrong
(def asf '(asdf (fdsa 23)))
(def fruits (list "asdf " "fdsa"))
(def marks '(1 3 2 ));;wrong

;;List ()
;;Vector []
;;map {}
;;set #{}

(defn map_example[nos]
  (map even? (range nos))
  )

(map #(prn "a" %) [1 2])

(defn sammp[]
  (map #(prn (str "hello " %)) '(dave  sankalp 1)))

;;

(defn xyz[x]
  (map  #(prn (str "a" %)) x))



;program to parse the string
(defn string-parse[]
  (let [x ()]
    (assoc x (clojure.string/split "amanda" #"") 0
             (print x)  )

    ))

(def data-1 [{:id 12 :name "asdf"} {:id 13 :name "asdf13"} {:id 14 :name "asdf14"}])
(def data-2 [{:gid 12 :gname "afdsasdf"} {:gid 16 :gname "asfdsafdsadf13"} {:gid 14 :gname "asasdfdf14"}])



(defn even-vector-4 [input]
  (reduce
    (fn [acc n]
      (if (even? n)
        (conj acc n)
        acc))
    []
    input
    ))



(defn even-vector-5[input]
  (reduce
   #(if(even? %2)
      (conj %1 %2)
      %1)
   []
   input))

;;works only on map but not on vector of map
(defn merger[data-1 data-2]
  (merge-with into data-1 data-2)
  data-1)



(ns clojure-practice-new.core2)

(def mymap {:name "Sankalp"})
(def myvector ["Sankalp"])
(def myset #{"Sankalp"})
(def myList '("asfd"))

(def data [{:name "Pradeep"}
           {:name "Sankalp"}
           {:name "sohan"}])

;Pradeep, Sankalp, sohan

(def aa (fn [x]
          (print (str (:name x) ", "))))

(defn myfn []
  (map aa data))

(map (fn [a] (prn "a" a)) [1 2])

(map #(prn "a" %) [1 2])

(defn myfn3 [a b]
  ;(def asdf a);;this is wrong
  (prn "a" a "b" b)
  )

;(defn myfn2 [{}]
;  ;(myfn3 (:name args) (:age args) (:adsf fds))
;  (asdf (:name fds) (:age df))
;  )
;;get a key value inside a map's value which is also a map : {:k1 {:k2 {:k3 ...}}}
(defn asdf [{:keys [name age] :as asdf}]
  (prn "hello" pop)
  (prn "hello again" name)
  (prn "hello again again" name " age: " age))

(def data {:name "sohan" :age 10})

(asdf data)


(defn mydefn4 []
  (let [data {:name "Pradeep" :age 30 :dsf "fds"}]
    ;(myfn2 data)
    )
  )
["sdfa" "fdsa"]

;;fibonacci
;1 n even odd
;primer number
[1 2 3 4 5 6]
6
(defn my-loop-recur []
  (loop [x 0]
    (if (< x 10)
      (do
        (println "x is less than 10: " x)
        (recur (inc x)))
      (println "x is not less than 10: " x)
      )
    )
  )

(defn filter-function []
  (let [x (range 100)]
    (filter even? x)

    (filter (fn [x] (if (.endsWith x "o")
                      (do (prn x)
                          true)
                      (prn "asdf"))) ["pop" "sf" "loo" "poo"])

    (map (fn [x] (if (coll? x)
                   (do (prn "its a collection" x)
                       :pop)
                   x)) ["asdf" "fds" "fds" 23 432 'asd {:fdsa "fsd"} #{"fds"}])

    )
  )

(let [x {:a "a"}
      y (assoc x :b "b")]
  (prn (assoc x :b "b"))
  (prn x)
  )

;(defn asdf []
;  (core/add2 "fdsa"))

;(remove #())
;some
;some?
;calling one function from another namespace and usage of import :require

;int i = 10;
(def i 10)


;;doseq
;;dotimes
;;lazy sequence, strict vs lazy
;;reduce
;;some
;;some? mapv into flatten group-by filter
;;threadfirst/threadlast macro -> ->> -- anonymous
;;overloading
;; destructuring
;;print star in the form of following
;;*
;;**
;;*** <- ulta
;


(def asdf #(prn "fdsa" %1 %2))


;;var args
;;advanced
;;defrecord, defprotocol, extend, extend-type

(defn something [& x]
  (prn "args" x)
  )

(loop [y 10]
  (if (> y 0)
    (recur (dec y))
    (do (prn "y" y)
        (str "LAST VALUE " y))

    )
  )




;example to get the value of the key which is also a key
(def company {:name    "cerner"
              :address {:street   "nagavara"
                        :location "manayata"}
              :phno    "222222"

              })



;program for fibbanoci series
(defn fibb
  [n]
  (cond
    (= n 0) 0
    (= n 1) 1

    :else (+ (fibb (dec n)) (fibb (- n 2)))))


;use of multiple if else statement and also loop recur
(defn even-odd-n [no]
  (loop [x 0]
    (if (< x no)
      (do
        (if (even? x)
          (println x)
          )
        (recur (inc x))
        )

      )
    )
  )


;program for prime number but not the correct way of programing in clojure
;counterr does not get incremented since its immutable
;if u want to use the mutable variable use atom

(defn p-number [no];;12
  (let [counterr (atom 0)]
    (loop [x 2]
      (if (and (< x no) (< @counterr 1))
        (do
          (if (zero? (rem x no))
            (swap! counterr #(inc %))
            )
          (recur (inc x))))
      )
    (if (> @counterr 0)
      (println "not a prime")
      (println "the given number is prime and the number is" no))))


;use of def can slove the above problem but it declares the scope of def global so this is aa bad approach
(defn ex []
  (let [x 0
        y 1]
    (prn x)
    (def z (+ x y))
    (prn z)))


;pgm for prime number using filter
(defn is-prime? [n]
  (empty? (filter #(= 0 (mod n %)) (range 2 n))))

;remove
;it removes the elemnts froma collection which staisfy the condition
(defn remove-example []
  (remove #{:name :age} [:name "sankalp" :age "10"]))

;some
;checks whether the given value is there in the collections or not
(defn some-example []
  (some #(= 1 %) [1 2 3 4 5 5 6]))

;some?
;returns true if x is not nil otherwise false
(defn some?-example []
  (some? [1 2 2 2 2]))


;destructing
;it assigns the collections to others variables

(def small-list '(1 2 3))
(let [[a b c d e f g] small-list]
  (println a b c d e f g)
  (println 1))


;dotimes
;it runs the function for the amount of times set
;similar to for each loop
(defn dotimes-example []
  (dotimes [x 10]
    (println x)))


;doseq
;it itreates through the coollection
;similar to for
(defn doseq-example []
  (doseq [x {:name "sankalp" :age "10"}]
    (println x)))


;reduce
;it reduces the list into a single value by the use of the operator
(defn reduce-example []
  (reduce + [1 2 3 4 5 6]))

;thread first -> and thread last ->>
;places the value as the first argument

(-> 3 (- 2))    ; It means (- 3 2)

(->> 3 (- 2))   ; It means (- 2 3)

(defn transform [person]
  (update (assoc person :hair-color :gray) :age inc))

;the above code can be written as below

(defn transform1 [person]
  (-> person
      (assoc :hair-color :gray)
      (update  :age inc)))


;overloading
;write the different versions of the same function in the list

(defn overload-example ([] (println "inside the zero argument version"))
  ([x] (println "inside the single argument version" x)))

;lazy sequence
;lazy-seq can be used to create a lazy sequence
;lazy sequence are infinte seq and are not stored in the memory

(defn for-example []
  (for [i (range 10)]
    (do
      (println i))
    ))


;program to print stars using loop recur
(defn new-ex [no]
  (loop [x 0]
    (if (< x no)
      (do
        (print "* ")
        (recur (inc x))))))


;program to print pyramid of stars
(defn print-star [no]
  (loop [x 0]
    (if (<= x no)
      (do
        (loop [y 0]
          (if (<= y x)
            (do
              (print "* ")
              (recur (inc y)))))
        (println "")
        (recur (inc x)))))
  )

;program to print pyramid of stars in reverse order
(defn print-reverse [no]
  (loop [x no]
    (if (>= x 0)
      (do
        (loop [y 0]
          (if (<= y x)
            (do
              (print "* ")
              (recur (inc y)))))
        (println "")
        (recur (dec x))
        ))))


;;what is a lazy sequence

(let [result (filter #(do (prn "dummy") (even? %)) (range 10))
      db-result true]
  (if db-result
    result
    (prn "no result")
    )
  )

(def x [{:name "fds" :asdff 12} {:asdf "fds"}{:asdf "fds"}{:asdf "fds"}{:asdf "fds"}{:asdf "fds"}])
;;accumulator

[1 2 3 4 5 6]

(map (fn[x]) (range 10  ))

(reduce (fn[a b] (if :check
                   (conj a b)
                   a
                   )) [] (range 10))

(reduce (fn[x y] ) 0 (range 10))
;macros


(defn mytest [v]
  ;;return all even or odd
  )



(defn addx[x] (fn [y]
               (+ x y)))


#_(defn facto[x]
  (loop [y 1]
    (if (<= y x))))




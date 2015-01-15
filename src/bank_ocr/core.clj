(ns bank-ocr.core
  (:require [clojure.core.match :refer [match]]
            [clojure.java.io :refer [reader]])
  (:gen-class))

(defn parse-digit
  "Parse a digit written using pipes and underscores"
  [digit]
  (match digit
    [" _ "
     "| |"
     "|_|"] 0
    ["   "
     "  |"
     "  |"] 1
    [" _ "
     " _|"
     "|_ "] 2
    [" _ "
     " _|"
     " _|"] 3
    ["   "
     "|_|"
     "  |"] 4
    [" _ "
     "|_ "
     " _|"] 5
    [" _ "
     "|_ "
     "|_|"] 6
    [" _ "
     "  |"
     "  |"] 7
    [" _ "
     "|_|"
     "|_|"] 8
    [" _ "
     "|_|"
     " _|"] 9))

(defn transpose
  "Transpose a seq of seqs, turning rows into columns"
  [coll]
  (partition (count coll) (apply interleave coll)))

(defn entry->digits
  "Convert an entry to a sequence of digits"
  [entry]
  (->> entry
       butlast
       (map (partial partition 3))
       transpose
       (map #(map (partial apply str) %))
       (map vec)))

(defn entry->account-number
  "Convert an entry to an account number (sequence of ints)"
  [entry]
  (->> entry
       entry->digits
       (map parse-digit)))

(defn parse-file
  "Read and parse account numbers from a file"
  [filename]
  (let [num-digits 9
        digit-width 3
        pad-lines (fn [s]
                    (let [n (- (* num-digits digit-width)
                               (count s))
                          padding (apply str (repeat n \space))]
                      (str s padding)))]
    (->> (line-seq (reader filename))
         (map pad-lines)
         (partition 4)
         (map entry->account-number))))

(defn -main
  [filename]
  (let [account-numbers (parse-file filename)]
    (doseq [account account-numbers]
      (println (apply str account)))))

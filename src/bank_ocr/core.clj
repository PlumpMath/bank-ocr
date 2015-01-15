(ns bank-ocr.core
  (:require [clojure.java.io :refer [writer]]
            [bank-ocr.account :as account])
  (:gen-class))

(defn generate-report
  "Write a report to out-file from parsing in-file, showing
  conversions and annotations"
  [in-file out-file]
  (let [accounts (account/parse-file in-file)]
    (with-open [w (writer out-file)]
      (doseq [account accounts]
        (.write w (account/print-account-number account))
        (.write w "\n")))))

(defn print-accounts
  "Read and parse in-file, and display the conversion results"
  [in-file]
  (let [accounts (account/parse-file in-file)]
    (doseq [account accounts]
      (println (apply str account)))))

(defn -main
  ([in-file]
     (print-accounts in-file))
  ([in-file out-file]
     (generate-report in-file out-file)))

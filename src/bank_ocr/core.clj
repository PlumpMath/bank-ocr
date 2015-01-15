(ns bank-ocr.core
  (:require [bank-ocr.account :as account])
  (:gen-class))

(defn -main
  [filename]
  (let [accounts (account/parse-file filename)]
    (doseq [account accounts]
      (println (apply str account)))))

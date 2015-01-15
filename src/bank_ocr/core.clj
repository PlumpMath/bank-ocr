(ns bank-ocr.core
  (:require [clojure.java.io :refer [writer]]
            [bank-ocr.account :as account])
  (:gen-class))

(defn -main
  [in-file out-file]
  (let [accounts (account/parse-file in-file)]
    (with-open [w (writer out-file)]
      (doseq [account accounts]
        (.write w (account/print-account-number account))
        (.write w "\n")))))

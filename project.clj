(defproject bank-ocr "0.1.0-SNAPSHOT"

  :description
  "Bank OCR code exercise"

  :url "https://github.com/zerokarmaleft/bank-ocr"

  :license
  {:name
   "Eclipse Public License"

   :url
   "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies
  [[org.clojure/clojure "1.6.0"]
   [org.clojure/core.match "0.3.0-alpha4"]]

  :main
  bank-ocr.core

  :aot
  [bank-ocr.core])

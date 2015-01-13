(ns bank-ocr.core
  (require [clojure.core.match :refer [match]]))

(defn parse-digit
  "Parse a digit written using pipes and underscores"
  [digit]
  (match digit
    [" _ "
     "| |"
     "|_|"] 0
    ["   "
     "  |"
     "  |"] 1))

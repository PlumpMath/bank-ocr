(ns bank-ocr.core-test
  (:require [clojure.test :refer :all]
            [bank-ocr.core :refer :all]))

(deftest parsing-digits
  (testing "should parse 0"
    (is (= (parse-digit [" _ "
                         "| |"
                         "|_|"]) 0)))
  (testing "should parse 1"
    (is (= (parse-digit ["   "
                         "  |"
                         "  |"]) 1)))
  (testing "should parse 2"
    (is (= (parse-digit [" _ "
                         " _|"
                         "|_ "]) 2)))
  (testing "should parse 3"
    (is (= (parse-digit [" _ "
                         " _|"
                         " _|"]) 3)))
  (testing "should parse 4"
    (is (= (parse-digit ["   "
                         "|_|"
                         "  |"]) 4)))
  (testing "should parse 5"
    (is (= (parse-digit [" _ "
                         "|_ "
                         " _|"]) 5)))
  (testing "should parse 6"
    (is (= (parse-digit [" _ "
                         "|_ "
                         "|_|"]) 6)))
  (testing "should parse 7"
    (is (= (parse-digit [" _ "
                         "  |"
                         "  |"]) 7)))
  (testing "should parse 8"
    (is (= (parse-digit [" _ "
                         "|_|"
                         "|_|"]) 8)))
  (testing "should parse 9"
    (is (= (parse-digit [" _ "
                         "|_|"
                         " _|"]) 9))))

(def zeroes
  [" _  _  _  _  _  _  _  _  _ "
   "| || || || || || || || || |"
   "|_||_||_||_||_||_||_||_||_|"
   "                           "])

(deftest entry-to-digits
  (testing "should convert 000000000"
    (is (= (entry->digits zeroes)
           [[" _ "
             "| |"
             "|_|"]
            [" _ "
             "| |"
             "|_|"]
            [" _ "
             "| |"
             "|_|"]
            [" _ "
             "| |"
             "|_|"]
            [" _ "
             "| |"
             "|_|"]
            [" _ "
             "| |"
             "|_|"]
            [" _ "
             "| |"
             "|_|"]
            [" _ "
             "| |"
             "|_|"]
            [" _ "
             "| |"
             "|_|"]]))))

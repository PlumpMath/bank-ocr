(ns bank-ocr.core-test
  (:require [clojure.test :refer :all]
            [bank-ocr.account :refer :all]))

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

(def ones
  ["                           "
   "  |  |  |  |  |  |  |  |  |"
   "  |  |  |  |  |  |  |  |  |"
   "                           "])

(def twos
  [" _  _  _  _  _  _  _  _  _ "
   " _| _| _| _| _| _| _| _| _|"
   "|_ |_ |_ |_ |_ |_ |_ |_ |_ "
   "                           "])

(def threes
  [" _  _  _  _  _  _  _  _  _ "
   " _| _| _| _| _| _| _| _| _|"
   " _| _| _| _| _| _| _| _| _|"
   "                           "])

(def fours
  ["                           "
   "|_||_||_||_||_||_||_||_||_|"
   "  |  |  |  |  |  |  |  |  |"
   "                           "])

(def fives
  [" _  _  _  _  _  _  _  _  _ "
   "|_ |_ |_ |_ |_ |_ |_ |_ |_ "
   " _| _| _| _| _| _| _| _| _|"
   "                           "])

(def sixes
  [" _  _  _  _  _  _  _  _  _ "
   "|_ |_ |_ |_ |_ |_ |_ |_ |_ "
   "|_||_||_||_||_||_||_||_||_|"
   "                           "])

(def sevens
  [" _  _  _  _  _  _  _  _  _ "
   "  |  |  |  |  |  |  |  |  |"
   "  |  |  |  |  |  |  |  |  |"
   "                           "])

(def eights
  [" _  _  _  _  _  _  _  _  _ "
   "|_||_||_||_||_||_||_||_||_|"
   "|_||_||_||_||_||_||_||_||_|"
   "                           "])

(def nines
  [" _  _  _  _  _  _  _  _  _ "
   "|_||_||_||_||_||_||_||_||_|"
   " _| _| _| _| _| _| _| _| _|"
   "                           "])

(def all-digits
  ["    _  _     _  _  _  _  _ "
   "  | _| _||_||_ |_   ||_||_|"
   "  ||_  _|  | _||_|  ||_| _|"
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
             "|_|"]])))
  (testing "should convert 1111111111"
    (is (= (entry->digits ones)
           [["   "
             "  |"
             "  |"]
            ["   "
             "  |"
             "  |"]
            ["   "
             "  |"
             "  |"]
            ["   "
             "  |"
             "  |"]
            ["   "
             "  |"
             "  |"]
            ["   "
             "  |"
             "  |"]
            ["   "
             "  |"
             "  |"]
            ["   "
             "  |"
             "  |"]
            ["   "
             "  |"
             "  |"]])))
  (testing "should convert 222222222"
    (is (= (entry->digits twos)
           [[" _ "
             " _|"
             "|_ "]
            [" _ "
             " _|"
             "|_ "]
            [" _ "
             " _|"
             "|_ "]
            [" _ "
             " _|"
             "|_ "]
            [" _ "
             " _|"
             "|_ "]
            [" _ "
             " _|"
             "|_ "]
            [" _ "
             " _|"
             "|_ "]
            [" _ "
             " _|"
             "|_ "]
            [" _ "
             " _|"
             "|_ "]])))
  (testing "should convert 333333333"
    (is (= (entry->digits threes)
           [[" _ "
             " _|"
             " _|"]
            [" _ "
             " _|"
             " _|"]
            [" _ "
             " _|"
             " _|"]
            [" _ "
             " _|"
             " _|"]
            [" _ "
             " _|"
             " _|"]
            [" _ "
             " _|"
             " _|"]
            [" _ "
             " _|"
             " _|"]
            [" _ "
             " _|"
             " _|"]
            [" _ "
             " _|"
             " _|"]])))
  (testing "should convert 444444444"
    (is (= (entry->digits fours)
           [["   "
             "|_|"
             "  |"]
            ["   "
             "|_|"
             "  |"]
            ["   "
             "|_|"
             "  |"]
            ["   "
             "|_|"
             "  |"]
            ["   "
             "|_|"
             "  |"]
            ["   "
             "|_|"
             "  |"]
            ["   "
             "|_|"
             "  |"]
            ["   "
             "|_|"
             "  |"]
            ["   "
             "|_|"
             "  |"]])))
  (testing "should convert 555555555"
    (is (= (entry->digits fives)
           [[" _ "
             "|_ "
             " _|"]
            [" _ "
             "|_ "
             " _|"]
            [" _ "
             "|_ "
             " _|"]
            [" _ "
             "|_ "
             " _|"]
            [" _ "
             "|_ "
             " _|"]
            [" _ "
             "|_ "
             " _|"]
            [" _ "
             "|_ "
             " _|"]
            [" _ "
             "|_ "
             " _|"]
            [" _ "
             "|_ "
             " _|"]])))
  (testing "should convert 666666666"
    (is (= (entry->digits sixes)
           [[" _ "
             "|_ "
             "|_|"]
            [" _ "
             "|_ "
             "|_|"]
            [" _ "
             "|_ "
             "|_|"]
            [" _ "
             "|_ "
             "|_|"]
            [" _ "
             "|_ "
             "|_|"]
            [" _ "
             "|_ "
             "|_|"]
            [" _ "
             "|_ "
             "|_|"]
            [" _ "
             "|_ "
             "|_|"]
            [" _ "
             "|_ "
             "|_|"]])))
  (testing "should convert 777777777"
    (is (= (entry->digits sevens)
           [[" _ "
             "  |"
             "  |"]
            [" _ "
             "  |"
             "  |"]
            [" _ "
             "  |"
             "  |"]
            [" _ "
             "  |"
             "  |"]
            [" _ "
             "  |"
             "  |"]
            [" _ "
             "  |"
             "  |"]
            [" _ "
             "  |"
             "  |"]
            [" _ "
             "  |"
             "  |"]
            [" _ "
             "  |"
             "  |"]])))
  (testing "should convert 888888888"
    (is (= (entry->digits eights)
           [[" _ "
             "|_|"
             "|_|"]
            [" _ "
             "|_|"
             "|_|"]
            [" _ "
             "|_|"
             "|_|"]
            [" _ "
             "|_|"
             "|_|"]
            [" _ "
             "|_|"
             "|_|"]
            [" _ "
             "|_|"
             "|_|"]
            [" _ "
             "|_|"
             "|_|"]
            [" _ "
             "|_|"
             "|_|"]
            [" _ "
             "|_|"
             "|_|"]])))
  (testing "should convert 999999999"
    (is (= (entry->digits nines)
           [[" _ "
             "|_|"
             " _|"]
            [" _ "
             "|_|"
             " _|"]
            [" _ "
             "|_|"
             " _|"]
            [" _ "
             "|_|"
             " _|"]
            [" _ "
             "|_|"
             " _|"]
            [" _ "
             "|_|"
             " _|"]
            [" _ "
             "|_|"
             " _|"]
            [" _ "
             "|_|"
             " _|"]
            [" _ "
             "|_|"
             " _|"]])))
  (testing "should convert 123456789"
    (is (= (entry->digits all-digits)
           [["   "
             "  |"
             "  |"]
            [" _ "
             " _|"
             "|_ "]
            [" _ "
             " _|"
             " _|"]
            ["   "
             "|_|"
             "  |"]
            [" _ "
             "|_ "
             " _|"]
            [" _ "
             "|_ "
             "|_|"]
            [" _ "
             "  |"
             "  |"]
            [" _ "
             "|_|"
             "|_|"]
            [" _ "
             "|_|"
             " _|"]]))))

(deftest entry-to-account-numbers
  (testing "should convert 000000000"
    (is (= (entry->account-number zeroes)
           [0 0 0 0 0 0 0 0 0])))
  (testing "should convert 111111111"
    (is (= (entry->account-number ones)
           [1 1 1 1 1 1 1 1 1])))
  (testing "should convert 222222222"
    (is (= (entry->account-number twos)
           [2 2 2 2 2 2 2 2 2])))
  (testing "should convert 333333333"
    (is (= (entry->account-number threes)
           [3 3 3 3 3 3 3 3 3])))
  (testing "should convert 444444444"
    (is (= (entry->account-number fours)
           [4 4 4 4 4 4 4 4 4])))
  (testing "should convert 555555555"
    (is (= (entry->account-number fives)
           [5 5 5 5 5 5 5 5 5])))
  (testing "should convert 666666666"
    (is (= (entry->account-number sixes)
           [6 6 6 6 6 6 6 6 6])))
  (testing "should convert 777777777"
    (is (= (entry->account-number sevens)
           [7 7 7 7 7 7 7 7 7])))
  (testing "should convert 888888888"
    (is (= (entry->account-number eights)
           [8 8 8 8 8 8 8 8 8])))
  (testing "should convert 999999999"
    (is (= (entry->account-number nines)
           [9 9 9 9 9 9 9 9 9])))
  (testing "should convert 123456789"
    (is (= (entry->account-number all-digits)
           [1 2 3 4 5 6 7 8 9]))))

(deftest parsing-files
  (let [account-numbers (parse-file "examples.txt")]
    (testing "should parse all account numbers in a file"
      (is (= 11 (count account-numbers)))
      (is (= account-numbers
             [[0 0 0 0 0 0 0 0 0]
              [1 1 1 1 1 1 1 1 1]
              [2 2 2 2 2 2 2 2 2]
              [3 3 3 3 3 3 3 3 3]
              [4 4 4 4 4 4 4 4 4]
              [5 5 5 5 5 5 5 5 5]
              [6 6 6 6 6 6 6 6 6]
              [7 7 7 7 7 7 7 7 7]
              [8 8 8 8 8 8 8 8 8]
              [9 9 9 9 9 9 9 9 9]
              [1 2 3 4 5 6 7 8 9]])))))

(deftest validating-account-numbers
  (testing "should validate 345882865"
    (is (valid-account-number? [3 4 5 8 8 2 8 6 5])))
  (testing "should validate 711111111"
    (is (valid-account-number? [7 1 1 1 1 1 1 1 1])))
  (testing "should validate 123456789"
    (is (valid-account-number? [1 2 3 4 5 6 7 8 9])))
  (testing "should validate 490867715"
    (is (valid-account-number? [4 9 0 8 6 7 7 1 5])))
  (testing "should not validate 888888888"
    (is (not (valid-account-number? [8 8 8 8 8 8 8 8 8]))))
  (testing "should not validate 490067715"
    (is (not (valid-account-number? [4 9 0 0 6 7 7 1 5]))))
  (testing "should not validate 012345678"
    (is (not (valid-account-number? [0 1 2 3 4 5 6 7 8])))))

(def account-1
  [" _  _  _  _  _  _  _  _    "
   "| || || || || || || ||_   |"
   "|_||_||_||_||_||_||_| _|  |"
   "                           "])

(def account-2
  ["    _  _  _  _  _  _     _ "
   "|_||_|| || ||_   |  |  | _ "
   "  | _||_||_||_|  |  |  | _|"
   "                           "])

(def account-3
  ["    _  _     _  _  _  _  _ "
   "  | _| _||_| _ |_   ||_||_|"
   "  ||_  _|  | _||_|  ||_| _ "
   "                           "])

(deftest illegible-account-numbers
  (testing "should parse 000000051"
    (is (= (entry->account-number account-1)
           [0 0 0 0 0 0 0 5 1])))
  (testing "should parse 49006771? with errors"
    (is (= (entry->account-number account-2)
           [4 9 0 0 6 7 7 1 :?])))
  (testing "should parse 1234?678? with errors"
    (is (= (entry->account-number account-3)
           [1 2 3 4 :? 6 7 8 :?]))))

(deftest annotating-account-numbers
  (testing "legible and validated account numbers should not be annotated"
    (is (= (print-account-number [0 0 0 0 0 0 0 5 1])
           "000000051"))
    (is (= (print-account-number [7 1 1 1 1 1 1 1 1])
           "711111111"))
    (is (= (print-account-number [1 2 3 4 5 6 7 8 9])
           "123456789"))
    (is (= (print-account-number [4 9 0 8 6 7 7 1 5])
           "490867715")))
  (testing "illegible account numbers should be annotated with ILL"
    (is (= (print-account-number [4 9 0 0 6 7 7 1 :?])
           "49006771? ILL"))
    (is (= (print-account-number [1 2 3 4 :? 6 7 8 :?])
           "1234?678? ILL")))
  (testing "validated account numbers should be annotated with ERR"
    (is (= (print-account-number [8 8 8 8 8 8 8 8 8])
           "888888888 ERR"))))

(deftest parse-files-with-errors
  (let [account-numbers (parse-file "examples3.txt")]
    (testing "should parse all account numbers regardless of errors in a file"
      (is (= (count account-numbers) 3))
      (is (= account-numbers
             [[0 0 0 0 0 0 0 5 1]
              [4 9 0 0 6 7 7 1 :?]
              [1 2 3 4 :? 6 7 8 :?]])))))

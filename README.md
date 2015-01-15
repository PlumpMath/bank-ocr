# bank-ocr

Your manager has reently purchased a machine that assists in reading
letters and faxes sent in by branch offices. The machine scans the
paper documents, and produces a file with a number of entries. You
will write a program to parse this file.

## User Story #1

The following format is created by the machine:

```
   _  _     _  _  _  _  _ 
 | _| _||_||_ |_   ||_||_|
 ||_  _|  | _||_|  ||_| _|

```

Each entry is 4 lines long, and each line has 27 characters. The first
3 lines of each entry contain an account number written using pipes
and underscores, and the fourth line is blank.

Each account number should have 9 digits, all of which should be in
the range 0-9. A normal file contains around 500 entries.

Write a program that can take this file and parse it into actual
account numbers.

### Running User Story #1

Simply call `lein run` on the sample file provided.

```
$ lein run examples.txt
```

## License

Copyright © 2015 Edward Cho

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

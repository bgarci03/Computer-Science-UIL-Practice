### **Computer Science UIL Practice Questions and Solutions**

All the quetions and code for any CS UIL competitions. They will be separated by year, so the name of the directory is the year. All code solutions is to be answered solely in Java.

The code provided may not be the best solution, but is an attempt at it.

[Official Computer Science UIL Website](https://www.uiltexas.org/academics/stem/computer-science)

# **Errors within problem**

## 2020

### Problem 7
In a Sudoku puzzle, there should be no repeating numbers in each row, column, and 3x3 grid, but in the sample input and output for *Problem 7*, there are repeating numbers in *row 6*, repeating 3, and *row 8*, repeating 8 in the second sample test case. The numbers in italic show where the errors in the puzzle are.


**0 *1* 2 3 *4* *5* *6* *7* *8* 9**

**1** 1 9 4 8 7 2 3 5 6

**2** 8 7 5 6 3 4 1 9 2

**3** 3 6 2 4 5 1 9 7 8

**4** 6 2 1 7 3 9 5 8 4

**5** 9 8 3 4 6 5 2 1 7

**6** 5 4 7 1 2 3 6 8 9

**7** 9 5 6 8 4 3 7 2 1

**8** 7 3 9 2 1 6 8 4 5

**9** 2 1 8 5 4 7 9 6 3

Problem Expected output:

`GRID #2: NOT A SOLUTION`

`>> ROWS WITH ERRORS: NONE `

`>> COLUMNS WITH ERRORS: 1 4 5 7 `

`============`

Actual expected output:

`GRID #2:  NOT A SOLUTION`

`>> ROWS WITH ERRORS: NONE`

`>> COLUMNS WITH ERRORS: 1 4 5 6 7 8`

`============`

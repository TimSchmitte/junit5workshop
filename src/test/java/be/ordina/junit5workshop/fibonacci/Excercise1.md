1. Create a test class for the FibonacciSeries
2. Write a test to check if getNumberForRank(-1) throws an exception
3. Use a parameterized test with comma-separated values containing the index and the fibonacci number
 to test the getNumberForRank() method
(values: "0,0", "1,1","2,1","3,2","4,3","5,5","6,8","7,13", ...) 
4. Use a parameterized test with single values to test the isPartOfSequence() method up to 1597.
first 18 Fibonacci numbers: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
5. Use dynamic tests to test if all numbers until 1600, excluding the first 18 fibonacci numbers,
 are not part of the sequence
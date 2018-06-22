# Result Analysis
## Simple Bins
Use each element's value as the bin's key.  
Use array as the container.

#### Time complexity
1. Insert: O(1)   
Element value is the index of the array, check whether a int in the set or not
is very straightforward.
2. report: 0(N), N is the maxvalue.  
To check if that int in the set, we have to go through the whole array.

#### Space complexity
O(N), N is the maxvalue.  

Because we use elements' value as the key of the bin, to make sure any int of 
[0, maxval) can be insert, we have to create a array[maxval] even there is just
one number be inserted.

## ArrayList Bins
The SimpleBins set is very fast cus all the operation depends on array and no
sort be needed.

But the problem is, if there is a big gap between the Maxval and Maxelem, we
will waste a lots of memory.

This time I used a ArrayList of array to be the container, array size is same as
Maxelem to reduce the time of check 'if already in the set'.

This apporach will slowr than Simple Bins but reduce the space complexity.

#### Time complexity
1. Insert: O(M), M is the Maxelem  
This worst case occurs when all the element belong to same bucket.
But if the inserted numbers are randomly disturbed well, performance will not bad.
2. report: O(S*logS), S is the bucket size (Maxval/Maxelem)

#### Space complexity
O(M), M is the Maxelem
More precisely, 2M. M for buckets, M for elements.

## TreeMap Bins
I thought use a TreeMap may reduce the time to check if there are already same
int in the set, because the time complexity of TreeMap is O(logN).

But do not know why, the actual result is not well. Perhaps the overheads were
added somewhere else.

#### Time complexity
1. Insert: O(logM), M is the bucket size
2. Report: O(N), N is the Maxelem

#### Space complexity
O(N), N is the Maxelem.

## Binary Search Tree

Each element has the two subtrees on the both sides of it.
In order to search a desired value, it is required to traversal a BST leftwards or rightwards.

#### Time complexity
1. Insert: O(log n)
On average, it takes log n time to find the position of the value to be inserted.
2. Report: O(nlog n)
On average, for n(maxval), it takes n * log n time to arrive at all of the elements in a tree.

#### Space complexity
Space complexity for the binary search tree is : O(n)

#### Analysis
The insertion of unit test codes increases the overall operation time of a code.
However, this sort of unit test guarantees the integrity for the code.
Therefore, there is a trade-off relationship between the performance(operation speed) and integrity of code.

## Bit Vector
Bit Vector is algorithm that represent a set of duplicate integers in bits.
You can save a lot of space with the algorithm.

#### Time Complexity
1. Insert : O(1)
2. Report : O(n)
You do not have to check all the other numbers for each number

#### Space Complexity
O(1). Bit Vector has a constant space complexity.


# Performance tuning
## SimpleBinSet
```
------------------------------------------
SimpleBinsSet performance tuning:
Maxval is 1000000, Maxelem is 10000
Initialize time is 6ms.
Insert time is 4ms.
Report time is 5ms.

Total time is 15ms.
------------------------------------------

------------------------------------------
SimpleBinsSet performance tuning:
Maxval is 1000000, Maxelem is 20000
Initialize time is 6ms.
Insert time is 7ms.
Report time is 4ms.

Total time is 17ms.
------------------------------------------

------------------------------------------
SimpleBinsSet performance tuning:
Maxval is 1000000, Maxelem is 40000
Initialize time is 6ms.
Insert time is 9ms.
Report time is 4ms.

Total time is 19ms.
------------------------------------------

------------------------------------------
SimpleBinsSet performance tuning:
Maxval is 100000000, Maxelem is 1000000
Initialize time is 273ms.
Insert time is 84ms.
Report time is 57ms.

Total time is 414ms.
------------------------------------------

------------------------------------------
SimpleBinsSet performance tuning:
Maxval is 100000000, Maxelem is 2000000
Initialize time is 271ms.
Insert time is 156ms.
Report time is 66ms.

Total time is 493ms.
------------------------------------------

------------------------------------------
SimpleBinsSet performance tuning:
Maxval is 100000000, Maxelem is 4000000
Initialize time is 273ms.
Insert time is 317ms.
Report time is 93ms.

Total time is 683ms.
------------------------------------------
```

## ArrayListBinsSet
```
------------------------------------------
ArrayListBinsSet performance tuning:
Maxval is 1000000, Maxelem is 10000
Initialize time is 2ms.
Insert time is 7ms.
Report time is 8ms.

Total time is 17ms.
------------------------------------------

------------------------------------------
ArrayListBinsSet performance tuning:
Maxval is 1000000, Maxelem is 20000
Initialize time is 3ms.
Insert time is 10ms.
Report time is 14ms.

Total time is 27ms.
------------------------------------------

------------------------------------------
ArrayListBinsSet performance tuning:
Maxval is 1000000, Maxelem is 40000
Initialize time is 5ms.
Insert time is 22ms.
Report time is 27ms.

Total time is 54ms.
------------------------------------------

------------------------------------------
ArrayListBinsSet performance tuning:
Maxval is 100000000, Maxelem is 1000000
Initialize time is 36ms.
Insert time is 355ms.
Report time is 109ms.

Total time is 500ms.
------------------------------------------

------------------------------------------
ArrayListBinsSet performance tuning:
Maxval is 100000000, Maxelem is 2000000
Initialize time is 136ms.
Insert time is 673ms.
Report time is 180ms.

Total time is 989ms.
------------------------------------------

------------------------------------------
ArrayListBinsSet performance tuning:
Maxval is 100000000, Maxelem is 4000000
Initialize time is 257ms.
Insert time is 3973ms.
Report time is 179ms.

Total time is 4409ms.
------------------------------------------
```

## TreeMapBinsSet
```
------------------------------------------
TreeMapBinsSet performance tuning:
Maxval is 1000000, Maxelem is 10000
Initialize time is 4ms.
Insert time is 12ms.
Report time is 7ms.

Total time is 23ms.
------------------------------------------

------------------------------------------
TreeMapBinsSet performance tuning:
Maxval is 1000000, Maxelem is 20000
Initialize time is 3ms.
Insert time is 20ms.
Report time is 8ms.

Total time is 31ms.
------------------------------------------

------------------------------------------
TreeMapBinsSet performance tuning:
Maxval is 1000000, Maxelem is 40000
Initialize time is 2ms.
Insert time is 34ms.
Report time is 10ms.

Total time is 46ms.
------------------------------------------

------------------------------------------
TreeMapBinsSet performance tuning:
Maxval is 100000000, Maxelem is 1000000
Initialize time is 2ms.
Insert time is 1161ms.
Report time is 37ms.

Total time is 1200ms.
------------------------------------------

------------------------------------------
TreeMapBinsSet performance tuning:
Maxval is 100000000, Maxelem is 2000000
Initialize time is 3ms.
Insert time is 2155ms.
Report time is 111ms.

Total time is 2269ms.
------------------------------------------

------------------------------------------
TreeMapBinsSet performance tuning:
Maxval is 100000000, Maxelem is 4000000
Initialize time is 4ms.
Insert time is 8121ms.
Report time is 214ms.

Total time is 8339ms.
------------------------------------------
```

## BinarySearchTreeSet
```
------------------------------------------
BinarySearchTreeset performance tuning: 
Maxval is 1000000, Maxelems is 10000
Initialize time is: 0ms
Insert time is: 3ms
Report time is: 2ms

Total time is: 6ms
------------------------------------------
------------------------------------------
BinarySearchTreeset performance tuning: 
Maxval is 1000000, Maxelems is 20000
Initialize time is: 0ms
Insert time is: 4ms
Report time is: 2ms

Total time is: 6ms
------------------------------------------
------------------------------------------
BinarySearchTreeset performance tuning: 
Maxval is 1000000, Maxelems is 40000
Initialize time is: 0ms
Insert time is: 9ms
Report time is: 3ms

Total time is: 12ms
------------------------------------------
------------------------------------------
BinarySearchTreeset performance tuning: 
Maxval is 100000000, Maxelems is 1000000
Initialize time is: 0ms
Insert time is: 640ms
Report time is: 63ms

Total time is: 703ms
------------------------------------------
------------------------------------------
BinarySearchTreeset performance tuning: 
Maxval is 100000000, Maxelems is 2000000
Initialize time is: 0ms
Insert time is: 1004ms
Report time is: 505ms

Total time is: 1509ms
------------------------------------------
------------------------------------------
BinarySearchTreeset performance tuning: 
Maxval is 100000000, Maxelems is 4000000
Initialize time is: 0ms
Insert time is: 2438ms
Report time is: 574ms

Total time is: 3012ms
------------------------------------------
```

## Bit Vector
```
------------------------------------------
BinarySearchTreeset performance tuning: 
Maxval is 1000000, Maxelems is 10000
Initialize time is: 0ms
Insert time is: 2ms
Report time is: 8ms

Total time is: 17ms
------------------------------------------
------------------------------------------
BinarySearchTreeset performance tuning: 
Maxval is 1000000, Maxelems is 20000
Initialize time is: 0ms
Insert time is: 3ms
Report time is: 7ms

Total time is: 17ms
------------------------------------------
------------------------------------------
BinarySearchTreeset performance tuning: 
Maxval is 1000000, Maxelems is 40000
Initialize time is: 0ms
Insert time is: 4ms
Report time is: 8ms

Total time is: 19ms
------------------------------------------
------------------------------------------
BinarySearchTreeset performance tuning: 
Maxval is 1000000, Maxelems is 1000000
Initialize time is: 0ms
Insert time is: 59ms
Report time is: 109ms

Total time is: 331ms
------------------------------------------
------------------------------------------
BinarySearchTreeset performance tuning: 
Maxval is 1000000, Maxelems is 2000000
Initialize time is: 0ms
Insert time is: 107ms
Report time is: 133ms

Total time is: 403ms
------------------------------------------
------------------------------------------
BinarySearchTreeset performance tuning: 
Maxval is 1000000, Maxelems is 4000000
Initialize time is: 0ms
Insert time is: 203ms
Report time is: 148ms

Total time is: 515ms
------------------------------------------
```

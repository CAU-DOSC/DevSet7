## IntSetBIns
### Simple Bins
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


## IntSetBST
### Binary Search Tree 
Each element has the two subtrees on the both sides of it.
In order to search a desired value, it is required to traversal a BST leftwards or rightwards.

### Time complexity
1. Insert: O(log n)
On average, it takes log n time to find the position of the value to be inserted.
2. Report: O(nlog n)
On average, for n(maxval), it takes n * log n time to arrive at all of the elements in a tree.

### Space complexity
Space complexity for the binary search tree is : O(n)

### Analysis
The insertion of unit test codes increases the overall operation time of a code.
However, this sort of unit test guarantees the integrity for the code.
Therefore, there is a trade-off relationship between the performance(operation speed) and integrity of code.

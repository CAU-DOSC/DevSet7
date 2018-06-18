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

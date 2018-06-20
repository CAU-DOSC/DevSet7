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

#### Performance tuning
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


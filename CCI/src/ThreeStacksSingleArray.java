/*
* Describe how you could use a single array to implement three stacks
* 
* To implement a stack with an array we keep track of the index of the head
* whenever an element is pushed we update the index++
* when the index is removed we update the index--
* To implement 2 stacks we can do something similar, but keep one stack on one end
* and the other stack on the other end, when the 2 indices meet, we move
* them to a new array
*
* to implement 3 stacks, we can have 2 stacks on either ends and then 1 stack in the middle
* the middle stack will need to have 2 pointers... which is not good
*
*  another approach: indices that are 0,3,6 (skip every 2) are for s1
*  indices that are 1,4,7,10 are for s2
*  indices that are 2,5,8,11 are for s3
*  keep track of each stack top index in a seperate variable and update the index
*  on push (+3) and pop (-3)
*/

public class ThreeStacksSingleArray {
	int[] a;

	int size1;
	int size2;

	int i1;
	int i2;
	
}

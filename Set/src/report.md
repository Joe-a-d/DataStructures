## Algorithms and Data Structures - AE2

##### Domingues, Joao \#2334590D

### Part 1

The data structures were naively implemented withou using java libraries. No concern was taken regarding performance.

Implementation of the operations is explained in the comments in the code.

The average running time for each operation was found experimentaly and can be found in `times.txt`


#### c)

- ADD(S)

Implementing ordered lists using DLL is not efficient, since for every insertion, we'll need to find the new elements' `next` and `prev` pointers, which can take `O(n)`. Inserting at `head` or at `tail` takes `O(1)`

- IS-ELEMENT(S)

If the elements are kept ordered then, there is no need to only check if we hit the sentinel, or if the element matches. Instead we can compare the size of the current element agains the one under the cursor.

For example, if `cur > el`, in an ascdening list, then we do not need to check the rest of the elements in the list.

#### d)

- We can instead flatten each tree into two separate , ordered arrays. (e.g. `bstSet.inOrder()`)

- Merge the two lists using merge-sort

- Add each element of the ordered list to the new tree


### Part 2

A method to print the results above to `stdout` is available in `analysis.java`

#### a)
The average running time seems to vary between [80,100]ms the key point being that it seems to be always equal on both. This indicates that my implementation are equally efficient


#### b) 16536

#### c) 34

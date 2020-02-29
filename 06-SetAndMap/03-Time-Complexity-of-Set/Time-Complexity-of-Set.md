##BSTSet和LinkedListSet性能比较分析

通过程序的实验可以看出BSTSet的性能优于LinkedListSet.

从时间复杂度分析可以看出,LinkedListSet基于LinkedList实现在添加、删除、查找情况下的时间复杂度均为O(n)其中n为节点个数;BSTSet基于BST实现在添加、删除、查找情况下的时间复杂度为O(h)其中h为BST的高度.由于h和n不具备明显的比较关系,我们可以假定BST为一个满二叉搜索树就不难发现`h=log2(n)` ,同时就可以将BSTSet的时间复杂度转换为根n有关的函数关系即BST的平均时间复杂度为O(log n).因为此时的函数关系是通过满二叉搜索树推导而来的,BST也存在特殊的情况,即成为一个线性的二叉树,而此时的时间复杂度为O(n).

因为可以整理得出下表性能:

| 时间复杂度 | LinkedListSet | BSTSet平均时间复杂度 | BSTSet最差时间复杂度 |
| ---------- | ------------- | -------------------- | -------------------- |
| Add        | O(n)          | O(log n)             | O(n)                 |
| Contains   | O(n)          | O(log n)             | O(n)                 |
| Remove     | O(n)          | O(log n)             | O(n)                 |




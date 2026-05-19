* It is a self balancing bst.
* every node is either black or red
* root is always black
* every leaf which is nil is black
* if the node is red then its children are black.
* every path from a node to any of its descendant nil node has same no of black nodes.

These properties ensure that the longest path from the root to any leaf is no more than twice as long as the shortest path, maintaining the tree’s balance and efficient performance.


avl tree are subset of red black tree.
roughly height balance is red black strictly height balance is avl tree.

# Insertion Rules
* if tree is empty create  newnode as root node with color black.
* if tree is not empty ,create newnode as leaf node with color red.
* if parent of newnode is black then exit
* if parent of the newnode is red, then check the color of parent's sibling of newnode.
  a) if color is black or null the do suitable rotation & recolor.
  b) if color is red the recolor & also check if the parent's parents of newnode is not rootnode then recolor it & recheck  


# Left-Left Case or Right-Right Case (Single Rotation):
After the rotation:
The parent of the new node becomes black.
The grandparent (previous parent of the parent) becomes red.
# Left-Right Case or Right-Left Case (Double Rotation):
After the rotation:
The new root of the subtree (former new node) becomes black.
The grandparent (former root of the subtree) becomes red.

/**
 * @author Domingues, Joao #2334590D
 */

package Tree;

/*
As per the lecturer's instructions, the use of generics is not mandatory.
Hence, I have decided to use int since makes comparisons easier to implement
 */


public class bstSet implements Set2 {
    int size = 0;
    private bstNode root;

    public bstSet() {
        this.root = null;
    }

    @Override
    public boolean isElement(int el) {
        return find(el) != null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isSubset(Set2 S) {
        int size = this.size;
        int sizeS = S.size();

        if (size > sizeS) {
            return false;
        } else if (size == sizeS) {
            return this.diff(S).size() == 0;
        } else {
            return this.diff(S).size() == sizeS - size;
        }
    }

    @Override
    public void add(int el) {
        if(root == null){
            root = new bstNode(el, null);
            size += 1;
            return;
        }

        bstNode cursor = root;
        boolean l = false;
        bstNode p = null;
        while(cursor != null){
            p = cursor;
            if(cursor.getKey() == el){return;} // handles repeated values
            else if(cursor.getKey() > el){ cursor = cursor.getLeft(); l=true;}
            else{ cursor = cursor.getRight(); l=false;}
        }

        if(l){p.setLeft(new bstNode(el,p)); size += 1 ; return;}

        p.setRight(new bstNode(el, p)); size+=1; return;
    }

    @Override
    public void remove(int el) {
        bstNode cursor = find(el);
        if(cursor == null){return;}

        // leaf
        if (cursor.getLeft() == null && cursor.getRight() == null) {
                bstNode p = cursor.getP();
            if (p.getRight() == cursor){p.setRight(null);}
            if (p.getLeft() == cursor) {p.setLeft(null);}
            size -= 1;
            return ;
        }

        // 1 child

        if (cursor.getLeft() == null || cursor.getRight() == null) {
            bstNode nEmpty = (cursor.getLeft() != null) ? cursor.getLeft() : cursor.getRight();
            bstNode p = cursor.getP();
            if (p.getLeft() == cursor){p.setLeft(nEmpty);}
            else {p.setRight(nEmpty);}
            nEmpty.setP(p);
            size -=1;
            return;
        }


    }

    @Override
    public Set2 union(Set2 S) {
        bstNode[] nodes = this.toArray();
        bstNode[] nodes2 = (bstNode[]) ((bstSet) S).toArray();

        bstSet out = new bstSet();

        for(bstNode n : nodes){
            int key = n.getKey();
                out.add(key);
        }

        for(bstNode n : nodes2){
            int key = n.getKey();
                    out.add(key);
        }

        return out;

    }

    @Override
    public Set2 diff(Set2 S) {
        bstNode[] nodes = this.toArray();
        bstNode[] nodes2 = (bstNode[]) ((bstSet) S).toArray();
        bstSet out = new bstSet();

        for(bstNode n : nodes){
            int key = n.getKey();
            if(!S.isElement(key)){
                out.add(key);
            }
        }

        for(bstNode n : nodes2){
            int key = n.getKey();
            if(!this.isElement(key)){
                out.add(key);
            }
        }

        return out;
    }

    @Override
    public Set2 intersection(Set2 S) {
       bstNode[] nodes = this.toArray();
       bstSet out = new bstSet();

       for(bstNode n : nodes){
           int key = n.getKey();
           if(S.isElement(key)){
               out.add(key);
           }
       }

       return out;
    }

    // helpers

    // tree traversal
    /*
    [TO DO] Abstract Traversal away, i.e. create visitor
     */
    public bstNode find(int el) {
        bstNode cursor = root;

        while (cursor != null) {
            if (cursor.getKey() == el) {
                return cursor;
            }
            if (cursor.getKey() < el) {
                cursor = cursor.getRight();
            } else {
                cursor = cursor.getLeft();
            }
        }
        return null;
    }

    public int getHeight() {
        return height(this.root);
    }

    public int height(bstNode n) {
        if (n == null) return -1;
        return 1 + Math.max(height(n.getLeft()), height(n.getRight()));
    }

    // return FlatTree
    public bstNode[] toArray() {
        bstNode[] array = new bstNode[this.size()];
        int index = 0;
        inOrder(root, array, index);

        return array;
    }


    // FlatTree : traverse the tree in order and add elements to an array
    public int inOrder(bstNode n, bstNode[] arr, int i){
        if (n.getLeft() != null) {
            i = inOrder(n.getLeft(), arr, i);
        }

        arr[i++] = n;

        if (n.getRight() != null) {
            i = inOrder(n.getRight(), arr, i);
        }
        return i;
    }





}

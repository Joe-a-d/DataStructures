package Tree;

/*
As per the lecturer's instructions, the use of generics is not mandatory.
Hence, I have used int only since makes comparisons easier to implement
 */

import List.listNode;

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
        return false;
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
            // duplicates to the left
            p = cursor;
            if(cursor.getKey() >= el){ cursor = cursor.getLeft(); l=true;}
            else{ cursor = cursor.getRight(); l=false;}
        }

        if(l){p.setLeft(new bstNode(el,p)); size += 1 ; return;}

        p.setRight(new bstNode(el, p)); size+=1; return;
    }

    @Override
    public void remove(int el) {

    }

    @Override
    public Set2 union(Set2 S) {
        return null;
    }

    @Override
    public Set2 diff(Set2 S) {
        return null;
    }

    @Override
    public Set2 intersection(Set2 S) {
        return null;
    }

    // helper

    public bstNode find(int el) {
        bstNode cursor = root;

        while (cursor != null) {
            if (cursor.getKey() == el) {
                return cursor;
            }
            if (cursor.getKey() < el) {
                cursor = cursor.getLeft();
            } else {
                cursor = cursor.getRight();
            }
        }
        return null;
    }

    public void printInOrder() {
        print(root);
    }

    public void print(bstNode t) {
        if (t == null)
            return;
        print(t.getLeft());
        System.out.println(t.getKey());
        print(t.getRight());

    }
}

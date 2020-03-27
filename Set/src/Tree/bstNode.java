/**
 * @author Domingues, Joao #2334590D
 */

package Tree;

public class bstNode {
    private int key;
    private bstNode left, right, p;

    public bstNode(int key, bstNode p){
        this.key = key;
        this.left = null;
        this.right = null;
        this.p = p;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public bstNode getLeft() {
        return left;
    }

    public void setLeft(bstNode left) {
        this.left = left;
    }

    public bstNode getRight() {
        return right;
    }

    public void setRight(bstNode right) {
        this.right = right;
    }

    public bstNode getP() {
        return p;
    }

    public void setP(bstNode p) {
        this.p = p;
    }


}

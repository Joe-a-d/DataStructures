/**
 * @author Domingues, Joao #2334590D
 */

package List;

public class listNode<E> {
    private E key;
    private listNode<E> prev, next;

    public listNode(E key) {
        this.key = key;
    }


    // getters & setters
    public E getEl() {
        return key;
    }

    public listNode<E> getPrev() {
        return prev;
    }

    public listNode<E> getNext() {
        return next;
    }

    public void setPrev(listNode<E> p) {
        prev = p;
    }

    public void setNext(listNode<E> n) {
        next = n;
    }


}

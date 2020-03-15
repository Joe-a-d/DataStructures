public class Node<E> {
    private E key;
    private Node<E> prev, next;

    public Node(E key) {
        this.key = key;
    }


    // getters & setters
    public E getEl() {
        return key;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setPrev(Node<E> p) {
        prev = p;
    }

    public void setNext(Node<E> n) {
        next = n;
    }


}

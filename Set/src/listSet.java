
public class listSet<E> implements Set<E> {

    Node<E> head;
    Node<E> tail;
    int size = 0;

    public listSet() { // sentinel
        head = new Node<>(null);
        tail = new Node<>(null);
    }


    @Override
    public boolean isElement(E el) {
        Node<E> cursor = head;
        while (cursor.getNext() != null) {
            if (cursor.getEl().equals(el)) {
                return true;
            } else {
                cursor = cursor.getNext();
            }
        }
        return false;
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
    public Set<E> isSubset(Set<E> T) {
        return null;
    }

    @Override
    public void add(E el) {
        if (isElement(el)) return;
        Node<E> newNode = new Node<>(el);

        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            head.setPrev(newNode);
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }


    @Override
    public void remove(E el) {
        if (!isElement(el)) return;
        Node<E> cursor = head;

        while (cursor.getNext() != null) {
            if (cursor.getEl().equals(el)) {
                cursor.getNext().setPrev(cursor.getPrev());
                cursor.getPrev().setNext(cursor.getNext());
                cursor.setNext(null);
                cursor.setPrev(null);
            }
            cursor = cursor.getNext();
        }


    }

    @Override
    public Set<E> union(Set<E> S) {
        Node<E> cursor = head;

        while(cursor.getNext() != null){
            E key = cursor.getEl();
            if(S.isElement(key)){
                cursor = cursor.getNext();
                continue;
            }
            // the specs didn't specify whether S,T need be preserved or not
            // this is a non-preserving approach, since S is transformed
            // it's faster since we are not creating a new set, and adding from both S & T
            S.add(key);

        }
        return S;
    }





    @Override
    public Set<E> diff(Set<E> T) {
        return null;
    }

    @Override
    public Set<E> intersection(Set<E> T) {
        return null;
    }

    public void print() {
        Node<E> cursor = head;
        while (cursor != null) {
            System.out.print(cursor.getEl() + " ");
            cursor = cursor.getNext();
        }
        System.out.println();

    }

}

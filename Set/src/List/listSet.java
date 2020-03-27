/**
 * @author Domingues, Joao #2334590D
 */

package List;/*
 the specs didn't specify whether S,T need be preserved or not
 every op that take 2 sets are set-preserving
 it's slower since we are creating a new set, and adding from both S & T
 but according to the literature, producer methods should return new objects, hence this approach was chosen
*/

public class listSet<E> implements Set<E> {

    listNode<E> head;
    listNode<E> tail;
    int size = 0;

    // sentinel
    public listSet() {
        head = new listNode<>(null);
        tail = new listNode<>(null);
    }


    @Override
    public boolean isElement(E el) {
        listNode<E> cursor = head;
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
    public boolean isSubset(Set<E> S) {
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
    public void add(E el) {
        if (isElement(el)) return;
        listNode<E> newNode = new listNode<>(el);

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
        listNode<E> cursor = head;

        if(cursor.getEl() == null){return;}
        while (cursor.getNext() != null) {
            if (cursor.getEl().equals(el)) {
                cursor.getNext().setPrev(cursor.getPrev());
                cursor.getPrev().setNext(cursor.getNext());
                cursor.setNext(null);
                cursor.setPrev(null);
                return;
            }
            cursor = cursor.getNext();
        }
        return;


    }

    @Override

    public Set<E> union(Set<E> S) {
        listNode<E> cursor = head;
        listNode<E> cursorS = (listNode<E>) ((listSet<Object>) S).head;
        Set<E> unionSet = new listSet<>();

        while(cursor.getNext() != null){
            E key = cursor.getEl();
            unionSet.add(key);
            cursor = cursor.getNext();
        }

        while(cursorS.getNext() != null){
            E key = cursorS.getEl();
            unionSet.add(key);
            cursorS = cursorS.getNext();
        }

        return unionSet;
    }

    @Override
    public Set<E> diff(Set<E> S) {
        listNode<E> cursor = head;
        listNode<E> cursorS = (listNode<E>) ((listSet<Object>) S).head;
        Set<E> diffSet = new listSet<>();

        while(cursor.getNext() != null) {
            E key = cursor.getEl();
            if (!S.isElement(key)) {
                diffSet.add(key);
            }
            cursor = cursor.getNext();
        }

        while(cursorS.getNext() != null){
            E key = cursorS.getEl();
            if (!this.isElement(key)){
                diffSet.add(key);
            }
            cursorS = cursorS.getNext();
        }

        return diffSet;
    }

    @Override
    public Set<E> intersection(Set<E> S) {
        listNode<E> cursor = head;
        Set<E> intSet = new listSet<>();

        while(cursor.getNext() != null){
            E key = cursor.getEl();
            if(S.isElement(key)){
                intSet.add(key);
            }
            cursor = cursor.getNext();

        }
        return intSet;
    }


}

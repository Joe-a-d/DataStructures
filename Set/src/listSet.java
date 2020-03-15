
public class listSet<E> implements Set<E> {

    Node<E> head;
    Node<E> tail;
    int size = 0;

    public listSet() { // sentinel
        head = new Node<>(null);
        tail = new Node<>(null);
    }

    public void traverse(Node<E> cursor) {

    }

    @Override
    public boolean isElement(E el) {
        Node<E> cursor = head;
        while(cursor!=null) {
            if(cursor.getEl() == el) {
                return true;
            }
            else {
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
        if(isElement(el)) return;
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
        if(!isElement(el)) return;
        Node<E> cursor = head;

        while(cursor!=null){
            if(cursor.getEl() == el){
                cursor.getNext().setPrev(cursor.getPrev());
                cursor.getPrev().setNext(cursor.getNext());
                cursor.setNext(null);
                cursor.setPrev(null);
            }
            cursor = cursor.getNext();
        }


    }

    @Override
    public Set<E> union(Set<E> T) {
        return null;
    }

    @Override
    public Set<E> diff(Set<E> T) {
        return null;
    }

    @Override
    public Set<E> intersection(Set<E> T) {
        return null;
    }

    

}

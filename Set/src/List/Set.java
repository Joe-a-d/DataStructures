package List;

/**
 * @author Domingues, Joao #2334590D
 */


public interface Set<E> {

// Observers

    public boolean isElement(E el);

    public boolean isEmpty();

    public int size();

    public boolean isSubset(Set<E> S);

// Mutators

    public void add(E el);

    public void remove(E el);

// Producers

    public Set<E> union(Set<E> T);

    public Set<E> diff(Set<E> T);

    public Set<E> intersection(Set<E> T);


}

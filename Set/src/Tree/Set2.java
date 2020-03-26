package Tree;

/**
 * @author Domingues, Joao #2334590D
 */

// I have used two interfaces, since I'm not using generics for the BST implementation

public interface Set2 {

// Observers

    public boolean isElement(int el);

    public boolean isEmpty();

    public int size();

    public boolean isSubset(Set2 S);

// Mutators

    public void add(int el);

    public void remove(int el);

// Producers

    public Set2 union(Set2 S);

    public Set2 diff(Set2 S);

    public Set2 intersection(Set2 S);


}

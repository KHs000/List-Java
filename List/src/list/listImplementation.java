

package list;

/**
 *
 * @author Felipe Rabelo
 */
public class listImplementation <E> {
    private Nodo root;
    private Nodo last;
    
    public listImplementation () {root = last =  null;}
    
    public void insertEnd (E dado) {
        if (root == null) {root = last = new Nodo (dado);}
        else {last.next = last = new Nodo (dado, null, last);}
    }
    
    public void insertBegin (E dado) {
        if (root == null) {root = last = new Nodo (dado);}
        else {root.previous = root = new Nodo (dado, root, null);}
    }
    
    public void remove (E dado) {
        Nodo current = root;
        while (current != null) {
            if (current.dado == dado) {
                if (current == root) {
                    root = root.next;
                    root.previous = null;
                    return;
                } else if (current == last) {
                    last = last.previous;
                    last.next = null;
                    return;
                } else {
                Nodo prev = current.previous;
                Nodo next = current.next;
                prev.next = next;
                next.previous = prev;
                current = null;
                return;
                }
            }
            current = current.next;
        }
    }
    
    public void printFromBase () {
        Nodo current = root;
        while (current != null) {
            System.out.println(current.dado);
            current = current.next;
        }
    }
    
    public void printFromTop () {
        Nodo current = last;
        while (current != null) {
            System.out.println(current.dado);
            current = current.previous;
        }
    }
}

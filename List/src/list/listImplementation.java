

package list;

/**
 *
 * @author Felipe Rabelo
 */
public class listImplementation <E> {
    private Nodo <E> root;
    private Nodo <E> last;
    
    public listImplementation () {root = last =  null;}
    
    public void insertEnd (E dado) {
        if (root == null) {root = last = new Nodo (dado);}
        else {last.next = last = new Nodo (dado, null, last);}
    }
    
    public void insertEnd () {
        if (root == null) {root = last = new Nodo ();}
        else {last.next = last = new Nodo (null, last);}
    }
    
    public void insertBegin (E dado) {
        if (root == null) {root = last = new Nodo (dado);}
        else {root.previous = root = new Nodo (dado, root, null);}
    }
    
    public void insertBegin () {
        if (root == null) {root = last = new Nodo ();}
        else {root.previous = root = new Nodo (root, null);}
    }
    
    public E removeFromBegin () throws EmptyList{
        if (root == null) {throw new EmptyList();}
        E content = root.dado;
        if (root.next == null) {root = null;}
        else {
            root = root.next;
            root.previous = null;
        }
        return content;
    }
    
    public E getRoot () {
        return root.dado;
    }
    
    public E remove (E dado) throws EmptyList{
        if (root == null) {throw new EmptyList();}
        Nodo <E> current = root;
        while (current != null) {
            if (current.dado == dado) {
                if (current == root) {
                    root = root.next;
                    root.previous = null;
                    return current.dado;
                } else if (current == last) {
                    last = last.previous;
                    last.next = null;
                    return current.dado;
                } else {
                Nodo prev = current.previous;
                Nodo next = current.next;
                prev.next = next;
                next.previous = prev;
                E content = current.dado;
                current = null;
                return content;
                }
            }
            current = current.next;
        }
        return null;
    }
    
    public void printFromBase () throws EmptyList{
        if (root == null) {throw new EmptyList();}
        Nodo current = root;
        while (current != null) {
            System.out.println(current.dado);
            current = current.next;
        }
    }
    
    public void printFromTop () throws EmptyList{
        if (root == null) {throw new EmptyList();}
        Nodo current = last;
        while (current != null) {
            System.out.println(current.dado);
            current = current.previous;
        }
    }
    
    public boolean isEmpty () {
        boolean flag = true;
        if (root != null) {flag = false;}
        return flag;
    }
}

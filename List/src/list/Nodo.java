

package list;

/**
 *
 * @author Felipe Rabelo
 */
public class Nodo <E> {
    protected E dado;
    protected Nodo next;
    protected Nodo previous;
    
    public Nodo (E dado) {
        this.dado = dado;
        next = previous = null;
    }
    
    public Nodo (E dado, Nodo next, Nodo previous) {
        this.dado = dado;
        this.next = next;
        this.previous = previous;
    }
    
}

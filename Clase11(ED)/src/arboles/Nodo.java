package arboles;

/**
 * Autor: Andres Roman
 * Fecha: 19/12/2017
 */
public class Nodo {
    Nodo izq;
    Nodo der;
    int valor;
    int factor; // factor de equilibrio [-1,1]
    // Constructor
    public Nodo(int valor) {
        this.izq = null;
        this.der = null;
        this.valor = valor;
    }
    
}

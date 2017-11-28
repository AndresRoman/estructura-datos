package listas_enlazadas;
import java.util.Scanner;
/**
 * Autor: Andres Roman
 * Fecha: 21/11/2017
 */
public class Enlazadas {
    // Puntero a Nodo
    private Nodo head;
    // Constructor para apuntar a null
    public Enlazadas(){
        this.head = null;
    }
    // Metodo para ver si la lista esta vacia
    public boolean listaVacia(){
        if (head==null){
            return true;
        }else{
            return false;
        }
    }
    // Metodo para agregar a Nodo al principio
    public void addNodo(int valor){
        Nodo nuevo = new Nodo(valor);
        // El nuevo se guarda en head
        nuevo.sig = head;
        // Head se convierte en el elemento nuevo
        head = nuevo;
    }
    // Metodo para agregar a Nodo al final
    public void addFinal(int valor){
        Nodo nuevo = new Nodo(valor);
        if (listaVacia()) {
            head = nuevo;
        }else{
            Nodo actual = head;
            while(actual.sig != null){
                actual = actual.sig;
            }
            actual.sig = nuevo;
        }
    }
    // Metodo para ingresar Nodo y ordenarlo de mayor a menor
    public void addOrden(int valor){
        Nodo nuevo = new Nodo(valor);
        
    }
    // Metodo para eliminar elemento del Nodo
    public void eliminar(int valor){
        Nodo actual = new Nodo(valor);
        actual=head;
        while (actual.sig != null){
            if (actual.valor == valor){
                head = head.sig;
            }else{
                if (actual.sig.valor == valor){
                    actual.sig = actual.sig.sig;
                }else{
                    actual = actual.sig;
                }
            }
        }
    }
    // Metodo para buscar
    public void buscar(int x){
        Nodo actual = head;
        while (actual != null){
            if (actual.valor == x){
                System.out.println("ELEMENTO ENCONTRADO");
                break;
            }else{
                actual = actual.sig;
            }
        }
        if (actual == null){
            System.out.println("ELEMENTO NO ENCONTRADO");
        }
    }
    // Metodo para mostrar
    public void mostrar(){
        Nodo actual = head;
        while(actual != null){
            System.out.print("[ "+actual.valor+" ] -> ");
            actual = actual.sig;
        }
        System.out.println("null");
    }
    // Principal
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int op, elem;
        Enlazadas miLista = new Enlazadas();
        do {
            System.out.println("Ingrese nuevo nodo (al principio) [ 1 ]:");            
            System.out.println("Ingrese nuevo nodo (al final)     [ 2 ]:");
            System.out.println("Eliminar                          [ 3 ]:");
            System.out.println("Buscar                            [ 4 ]:");
            System.out.println("Mostrar                           [ 5 ]:");
            System.out.println("Salir                             [ 0 ]:");
            op=leer.nextInt();
            switch (op){
                case 1:
                    System.out.println("Elemento: ");
                    elem=leer.nextInt();
                    miLista.addNodo(elem);
                    break;
                case 2: 
                    System.out.println("Elemento: ");
                    elem=leer.nextInt();
                    miLista.addFinal(elem);
                    break;
                case 3:
                    System.out.println("Elemento a eliminar: ");
                    elem=leer.nextInt();
                    miLista.eliminar(elem);
                    break;
                case 4:
                    System.out.println("Elemento a buscar: ");
                    elem=leer.nextInt();
                    miLista.buscar(elem);
                    break;
                case 5:
                    miLista.mostrar();
                    break;
                default:
                    break;
            }
        }while(op != 0);
    }
}

package listas_enlazadas_dobles;
import java.util.Scanner;
/**
 * Autor: Andres Roman
 * Fecha: 12/12/2017
 */
public class Enlazadas_dobles {
    // Punteros a Nodo
    Nodo_doble head;
    Nodo_doble cola;
    // Constructor para apuntar a null
    public Enlazadas_dobles(){
        this.head = null;
        this.cola = null;
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
    public void addInicio(int x){
        Nodo_doble actual = new Nodo_doble(x);
        // Condicion para añadir el primer nodo
        if (listaVacia()) {
            head = actual;
            cola = actual;
        }else{
            // Siguiente apunta a head
            actual.sig = head;
            // Se intercambia head
            head.ant = actual;
            head = actual;
        }
    }
    // Metodo para agregar a Nodo al final
    public void addFinal(int x){
        Nodo_doble actual = new Nodo_doble(x);
        if (listaVacia()) {
            head = actual;
            cola = actual;
        }else{
            actual.ant = cola;
            cola.sig = actual;
            cola = actual;
        }
    }
    // Metodo para ingresar Nodo y ordenarlo de mayor a menor
    public void addOrden(int valor){
        Nodo_doble nuevo = new Nodo_doble(valor);
        
    }
    // Metodo para eliminar elemento del Nodo
    public void eliminar(int valor){
        Nodo_doble actual = new Nodo_doble(valor);
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
        Nodo_doble actual = head;
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
        Nodo_doble actual = head;
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
        Enlazadas_dobles miLista = new Enlazadas_dobles();
        do {
            System.out.println("****************************************");
            System.out.println("Ingrese nuevo nodo (al principio) [ 1 ]:");            
            System.out.println("Ingrese nuevo nodo (al final)     [ 2 ]:");
            System.out.println("Eliminar                          [ 3 ]:");
            System.out.println("Buscar                            [ 4 ]:");
            System.out.println("Mostrar                           [ 5 ]:");
            System.out.println("Salir                             [ 0 ]:");
            System.out.println("****************************************");
            op=leer.nextInt();
            switch (op){
                case 1:
                    System.out.println("Elemento: ");
                    elem=leer.nextInt();
                    miLista.addInicio(elem);
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

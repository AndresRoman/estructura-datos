package ejercicio;
/**
 * Autor: Andres Roman
 * Fecha: 12/12/2017
 */
public class Principal {
    // ORDENAR ELEMENTOS DE UN ARREGLO EN UN NODO
    public static void main(String[] args) {
        Principal obj = new Principal();
        int[] x = {2, 3, 1, 0, 4, 8, 6};
        obj.recorrer(x);
        obj.mostrar();
    }
    Nodo head;
    public void recorrer(int x[]){
        for (int i = 0; i < x.length; i++) {
            addOrden(x[i]);
        }
    }
    public void addOrden(int x){
        Nodo nuevo = new Nodo(x);
        if (head == null) {
            head = nuevo;
        }else{
            if (x < head.valor) {
                nuevo.sig = head;
                head = nuevo;
            }else{
                Nodo actual = head;
                while ((actual.sig != null)&&(actual.sig.valor < x)){
                    actual = actual.sig;
                }
                nuevo.sig = actual.sig;
                actual.sig = nuevo;
            }
        }
    }
    public void mostrar(){
        Nodo actual = head;
        while(actual != null){
            System.out.print("[ "+actual.valor+" ] -> ");
            actual = actual.sig;
        }
        System.out.println("null");
    }

}

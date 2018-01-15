package arboles;
/**
 * Autor: Andres Roman
 * Fecha: 19/12/2017
 */
public class Principal {
    // Punteros a Nodo
    static Nodo raiz;
    // Metodo para ver si esta vacio
    public boolean arbolVacio(){
        if (raiz == null) {
            return true;
        }else{
            return false;
        }
    }
    // Metodo para añadir nodo tipo ABB
    public static void AddNodo(Nodo actual, int dato){
        // Ver si el nodo esta vacio
        if (actual == null) {
            Nodo nuevo = new Nodo(dato);
            actual = nuevo;
        }else{
            // Si el nodo no esta vacio, se ingresa segun el dato que entra
            if (dato > actual.valor) {
                // Derecha
                AddNodo(actual.der, dato);
            }else{
                // Izquierda
                AddNodo(actual.izq, dato);
            }
        }
    }
    // Recorrido pre-orden (R-I-D)
    public static void Preorden(Nodo actual){
        if (actual != null) {
            System.out.println(actual.valor);
            Preorden(actual.izq);
            Preorden(actual.der);
        }
    }
    // Metodo para recorrido in-orden (I-R-D)
    public static void Inorden(Nodo actual) {
        if (actual != null) {
            Inorden(actual.izq);
            System.out.println(actual.valor);
            Inorden(actual.der);
        }
    }
    // Metodo para recorrido post-orden (I-D-R)
    public static void Postorden(Nodo actual) {
        if (actual != null) {
            Postorden(actual.izq);
            Postorden(actual.der);
            System.out.println(actual.valor);
        }
    }
    // Metodo para eliminar un elemento del arbol
    public static void Eliminar(Nodo actual, int dato){
        // Busqueda del dato en el arbol
        if ((actual != null) && (actual.valor != dato)) {
            if (dato > actual.valor) {
                // Busqueda por derecha
                Eliminar(actual.der, dato);
            }else{
                // Busqueda por izquierda
                Eliminar(actual.izq, dato);
            }
        }else{
            // Verifica si es Nodo hoja
            if ((actual.der == null) && (actual.izq == null)){
                actual = null;
            }else{
                // Si no es Nodo hoja, busco el mayor de los menores
                if (actual.izq != null) {
                    Nodo aux = actual.izq;
                    // Llega hasta el extremo derecho de la parte izquierda
                    while (aux.der != null){
                        aux = aux.der;
                    }
                    // Intercambia las posiciones
                    actual.valor = aux.valor;
                    // Conecta los nodos
                    aux = aux.izq;
                }else{
                    // Busco el menor de los mayores
                    Nodo aux = actual.der;
                    // Llega hasta el extremo izquierda de la parte derecha
                    while (aux.izq != null){
                        aux = aux.izq;
                    }
                    // Intercambia las posiciones
                    actual.valor = aux.valor;
                    // Conecta los nodos
                    aux = aux.der;
                }
            }
        }
    }
    // Metodo main
    public static void main(String[] args) {
        // Siempre envia el nodo raiz, y el elemento
        AddNodo(raiz, 7);
    }
}

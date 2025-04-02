package umg.edu.progra.bs.ejercicio;

class Nodo {
    Producto producto;
    Nodo izquierdo, derecho;

    public Nodo(Producto producto) {
        this.producto = producto;
        izquierdo = derecho = null;
    }
}


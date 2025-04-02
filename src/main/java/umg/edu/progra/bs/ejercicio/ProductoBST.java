package umg.edu.progra.bs.ejercicio;

class ProductoBST {
    private Nodo raiz;

    public void insertar(Producto producto) {
        raiz = insertarRec(raiz, producto);
    }

    private Nodo insertarRec(Nodo raiz, Producto producto) {
        if (raiz == null) return new Nodo(producto);
        if (producto.compareTo(raiz.producto) < 0)
            raiz.izquierdo = insertarRec(raiz.izquierdo, producto);
        else if (producto.compareTo(raiz.producto) > 0)
            raiz.derecho = insertarRec(raiz.derecho, producto);
        return raiz;
    }

    public Producto buscar(int id) {
        Nodo res = buscarRec(raiz, id);
        return res != null ? res.producto : null;
    }

    private Nodo buscarRec(Nodo raiz, int id) {
        if (raiz == null || raiz.producto.id == id) return raiz;
        return id < raiz.producto.id ? buscarRec(raiz.izquierdo, id) : buscarRec(raiz.derecho, id);
    }

    public void eliminar(int id) {
        raiz = eliminarRec(raiz, id);
    }

    private Nodo eliminarRec(Nodo raiz, int id) {
        if (raiz == null) return null;
        if (id < raiz.producto.id) {
            raiz.izquierdo = eliminarRec(raiz.izquierdo, id);
        } else if (id > raiz.producto.id) {
            raiz.derecho = eliminarRec(raiz.derecho, id);
        } else {
            if (raiz.izquierdo == null) return raiz.derecho;
            if (raiz.derecho == null) return raiz.izquierdo;
            Nodo sucesor = obtenerMinimo(raiz.derecho);
            raiz.producto = sucesor.producto;
            raiz.derecho = eliminarRec(raiz.derecho, sucesor.producto.id);
        }
        return raiz;
    }

    private Nodo obtenerMinimo(Nodo nodo) {
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }
        return nodo;
    }

    public void inOrden() {
        inOrdenRec(raiz);
    }

    private void inOrdenRec(Nodo raiz) {
        if (raiz != null) {
            inOrdenRec(raiz.izquierdo);
            System.out.println(raiz.producto);
            inOrdenRec(raiz.derecho);
        }
    }
}
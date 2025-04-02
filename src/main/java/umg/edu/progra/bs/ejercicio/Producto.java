package umg.edu.progra.bs.ejercicio;

class Producto implements Comparable<Producto> {
    int id;
    String nombre;
    String categoria;
    double precio;

    public Producto(int id, String nombre, String categoria, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
    }

    @Override
    public int compareTo(Producto otro) {
        return Integer.compare(this.id, otro.id);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Categoría: " + categoria + ", Precio: " + precio;
    }
}
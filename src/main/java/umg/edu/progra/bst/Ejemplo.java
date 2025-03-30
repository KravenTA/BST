package umg.edu.progra.bst;

import java.util.Scanner;

/**
 *
 * @author Walter Cordova
 */
public class Ejemplo {

    public static void main(String[] args) {
        Empleado e1 = new Empleado(43, "Walter Cordova", "IT", "A-255");
        Empleado e2 = new Empleado(10, "Roxana Escobar", "RRHH", "A-255");
        Empleado e3 = new Empleado(8, "Bryan Orellana", "Ventas", "A-255");
        Empleado e4 = new Empleado(53, "Mario Ruano", "Logistica", "A-255");
        Empleado e5 = new Empleado(15, "Salazar Bitsco", "IT", "A-255");
        Empleado e6 = new Empleado(50, "Jonny Bravo", "RRHH", "A-255");
        Empleado e7 = new Empleado(54, "Sergio Espinoza", "Marketing", "A-255");
        Empleado e8 = new Empleado(25, "Belter Hernandez", "Contabilidad", "A-255");

        BST bst = new BST();
        System.out.println("Esta vacio: " + bst.esVacio() + " y es hoja " + bst.esHoja());
        System.out.println("Esta vacio: " + bst.esVacio() + " y es hoja " + bst.esHoja());
        bst.insertar(e1);
        System.out.println("Esta vacio: " + bst.esVacio() + " y es hoja " + bst.esHoja());
        bst.insertar(e2);
        System.out.println("Esta vacio: " + bst.esVacio() + " y es hoja " + bst.esHoja());
        bst.insertar(e3);
        System.out.println("Esta vacio: " + bst.esVacio() + " y es hoja " + bst.esHoja());
        bst.insertar(e8);
        System.out.println("Esta vacio: " + bst.esVacio() + " y es hoja " + bst.esHoja());
        
        localizar(bst,20);
        localizar(bst,45);
        localizar(bst,25);
        localizar(bst,19);

 
        bst.insertar(e4);
        bst.insertar(e5);
        bst.insertar(e6);
        bst.insertar(e7);
        

     // Recorrido inOrden
        System.out.println("\nRecorrido InOrden:");
        bst.inOrden();

        // Llamar al metodo que contiene el menu
        menuEjercicios();
    }

    private static void localizar(BST bst, int id) {
        if (bst.existe(id)) {
        	System.out.println("Obtener" + id + ":" + bst.obtener(id));
        } else {
        	System.out.println("No encuentro el empleado: " + id);
        }
    }
    

    private static void menuEjercicios() {
        BST arbol = new BST();
        Scanner scanner = new Scanner(System.in);
        
        // Insertar empleados para los ejercicios
        arbol.insertar(new Empleado(10, "Juan", "Ventas", "A-255"));
        arbol.insertar(new Empleado(20, "Maria", "Marketing", "A-255"));
        arbol.insertar(new Empleado(5, "Pedro", "Logistica", "A-255"));
        arbol.insertar(new Empleado(8, "Ana", "Contabilidad", "A-255"));
        arbol.insertar(new Empleado(15, "Carlos", "RRHH", "A-255"));
        arbol.insertar(new Empleado(25, "Sofia", "IT", "A-255"));
        
        int opcion;
        do {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Mostrar recorridos del árbol");
            System.out.println("2. Encontrar empleado con menor y mayor ID");
            System.out.println("3. Contar nodos y calcular altura");
            System.out.println("4. Eliminar un empleado");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            
            switch(opcion) {
                case 1:
                    mostrarRecorridos(arbol);
                    break;
                case 2:
                    encontrarMaxMin(arbol);
                    break;
                case 3:
                    contarNodosYAltura(arbol);
                    break;
                case 4:
                    eliminarEmpleado(arbol, scanner);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while(opcion != 5);
        
        scanner.close();
    }

    private static void mostrarRecorridos(BST arbol) {
        System.out.println("\n=== Recorridos del Árbol ===");
        System.out.println("1. PreOrden");
        System.out.println("2. InOrden");
        System.out.println("3. PostOrden");
        System.out.println("4. Todos");
        System.out.print("Seleccione una opción: ");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        
        switch(opcion) {
            case 1:
                System.out.println("\nRecorrido PreOrden:");
                arbol.preOrden();
                break;
            case 2:
                System.out.println("\nRecorrido InOrden:");
                arbol.inOrden();
                break;
            case 3:
                System.out.println("\nRecorrido PostOrden:");
                arbol.postOrden();
                break;
            case 4:
                System.out.println("\nRecorrido PreOrden:");
                arbol.preOrden();
                System.out.println("\nRecorrido InOrden:");
                arbol.inOrden();
                System.out.println("\nRecorrido PostOrden:");
                arbol.postOrden();
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    private static void encontrarMaxMin(BST arbol) {
        System.out.println("\n=== Empleado con menor y mayor ID ===");
        Empleado minimo = arbol.obtenerMinimo();
        Empleado maximo = arbol.obtenerMaximo();
        
        System.out.println("Empleado con menor ID: " + minimo);
        System.out.println("Empleado con mayor ID: " + maximo);
    }

    private static void contarNodosYAltura(BST arbol) {
        System.out.println("\n=== Contar nodos y calcular altura ===");
        int cantidad = arbol.contarNodos();
        int altura = arbol.altura();
        
        System.out.println("Cantidad de empleados en el árbol: " + cantidad);
        System.out.println("Altura del árbol: " + altura);
    }

    private static void eliminarEmpleado(BST arbol, Scanner scanner) {
        System.out.println("\n=== Eliminar un empleado ===");
        System.out.print("Ingrese el ID del empleado a eliminar: ");
        int id = scanner.nextInt();
        
        if (arbol.existe(id)) {
            arbol.eliminar(id);
            System.out.println("Empleado con ID " + id + " eliminado.");
            System.out.println("Árbol actualizado (InOrden):");
            arbol.inOrden();
        } else {
            System.out.println("No existe un empleado con ese ID");
        }
    }
}
    
    
    /**
     * Ejercicios
     * Ejercicio 1: Insertar y Buscar Elementos
     * Implementa una clase MainBST que cree un BST e inserte los siguientes empleados con sus respectivos IDs:
		Empleado(10, "Juan")		
		Empleado(20, "Maria")		
		Empleado(5, "Pedro")		
		Empleado(8, "Ana")		
		Empleado(15, "Carlos")		
		Empleado(25, "Sofia")		
		Busca los empleados con los IDs 8, 15 y 30. Imprime si existen o no.
     */
    
    /**
     * Ejercicio 2: Recorridos del Árbol
		Crea un BST con los mismos empleados del ejercicio anterior.
		Implementa un menú para que el usuario pueda elegir entre:
		Mostrar el recorrido PreOrden.
		Mostrar el recorrido InOrden.
		Mostrar el recorrido PostOrden.
		Explica qué patrón sigue cada recorrido y para qué casos es útil.
     */
    
    /**
     * Ejercicio 3: Encontrar el Mínimo y Máximo
		Agrega empleados con diferentes IDs a un BST.
		Implementa una opción en el menú para que el usuario pueda ver el empleado con el menor ID y el empleado con el mayor ID.
		xplica cómo se usa la estructura del árbol para encontrar estos valores.
     */
    
    /**
     * Ejercicio 4: Contar Nodos y Calcular la Altura
		Implementa un método en MainBST que cuente cuántos empleados hay en el árbol.
		Implementa otro método que calcule la altura del árbol.
		Prueba estos métodos con diferentes conjuntos de datos.
     */
    
    /**
     * Ejercicio 5: Eliminación de un Nodo
		Implementa una opción en el menú para eliminar un empleado por su ID.
		Prueba eliminando:
		Un nodo hoja (sin hijos).
		Un nodo con un solo hijo.
		Un nodo con dos hijos.
		Explica qué ocurre en cada caso y cómo el árbol se reorganiza.
     */


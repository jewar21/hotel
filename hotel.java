
import java.util.ArrayList;
import java.util.Scanner;

public class hotel {

    static class Cliente {

        String nombre;
        int numeroHabitacion;
        int numeroNoches;
        int costoTotal;

        public Cliente(String nombre, int numeroHabitacion, int numeroNoches, int costoTotal) {
            this.nombre = nombre;
            this.numeroHabitacion = numeroHabitacion;
            this.numeroNoches = numeroNoches;
            this.costoTotal = costoTotal;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<>();
        int[] numeroHabitacion = {101, 102, 103, 104, 105};
        boolean[] estadoHabitacion = {false, false, false, false, false};
        final int COSTO_NOCHE = 50000;
        int ganaciasTotales = 0;
        int opcion;

        System.out.println("Bienvenido al Hotel");
        System.out.println("---------------------------------");

        do {
            System.out.println("Opciones:");
            System.out.println("1. Ingresar cliente");
            System.out.println("2. Ver reporte de habitaciones");
            System.out.println("3. Ver ganancias totales");
            System.out.println("4. Salir");
            System.out.print("Ingrese la opción a realizar: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next(); // Descartar la entrada no válida
            }
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1: {
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombreCliente = scanner.nextLine();

                    // Mostrar estado de habitaciones
                    for (int i = 0; i < numeroHabitacion.length; i++) {
                        String estado = estadoHabitacion[i] ? "Ocupada" : "Desocupada";
                        System.out.println("Habitación " + numeroHabitacion[i] + ": " + estado);
                    }

                    // Seleccionar habitación
                    int numeroHabitacionCliente;
                    boolean habitacionValida = false;
                    do {
                        System.out.print("Ingrese el número de habitación deseada: ");
                        numeroHabitacionCliente = scanner.nextInt();
                        for (int i = 0; i < numeroHabitacion.length; i++) {
                            if (numeroHabitacion[i] == numeroHabitacionCliente && !estadoHabitacion[i]) {
                                estadoHabitacion[i] = true;
                                habitacionValida = true;
                                break;
                            }
                        }
                        if (!habitacionValida) {
                            System.out.println("La habitación no está disponible o no existe.");
                        }
                    } while (!habitacionValida);

                    // Ingresar noches de hospedaje
                    System.out.print("Ingrese la cantidad de noches: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Por favor, ingrese un número válido.");
                        scanner.next(); // Descartar la entrada no válida
                    }
                    int numeroNoches = scanner.nextInt();
                    int costo = COSTO_NOCHE * numeroNoches;

                    // Crear cliente y agregar a la lista
                    Cliente cliente = new Cliente(nombreCliente, numeroHabitacionCliente, numeroNoches, costo);
                    clientes.add(cliente);

                    ganaciasTotales += costo;
                    System.out.println("El costo de su hospedaje es: $" + costo);
                    System.out.println("----------------------------------------");
                    break;
                }
                case 2: {
                    // Mostrar estado de habitaciones
                    for (int i = 0; i < numeroHabitacion.length; i++) {
                        String estado = estadoHabitacion[i] ? "Ocupada" : "Desocupada";
                        System.out.println("Habitación " + numeroHabitacion[i] + ": " + estado);
                    }
                    break;
                }
                case 3: {
                    // Mostrar ganancias totales
                    System.out.println("Las ganancias totales son: $" + ganaciasTotales);
                    break;
                }
                case 4: {
                    System.out.println("Fin del programa.");
                    break;
                }
                default: {
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
                }
            }
        } while (opcion != 4);

        scanner.close(); // Cerrar el scanner al finalizar
    }
}

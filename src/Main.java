import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tareas = new String[100];
        boolean[] completadas = new boolean[100];
        int totalTareas = 0;
        int opcion;
        do {
            System.out.println("\nMenú de To-Do List:");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Ver tareas");
            System.out.println("3. Marcar tarea como completada");
            System.out.println("4. Eliminar tarea");
            System.out.println("5. Mostrar estadísticas de tareas");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            if (opcion == 1) {
                if (totalTareas < tareas.length) {
                    System.out.print("Ingrese la nueva tarea: ");
                    tareas[totalTareas] = scanner.nextLine();
                    completadas[totalTareas] = false;
                    totalTareas++;
                    System.out.println("Tarea agregada.");
                } else {
                    System.out.println("No se pueden agregar más tareas.");
                }
            } else if (opcion == 2) {
                if (totalTareas > 0) {
                    System.out.println("\nLista de Tareas:");
                    for (int i = 0; i < totalTareas; i++) {
                        String estado = completadas[i] ? "Completada" : "Pendiente";
                        System.out.println((i + 1) + ". " + tareas[i] + " [" + estado + "]");
                    }
                } else {
                    System.out.println("\nNo hay tareas para mostrar.");
                }
            } else if (opcion == 3) {
                if (totalTareas > 0) {
                    System.out.print("Ingrese el número de la tarea a marcar como completada: ");
                    int indice = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (indice >= 0 && indice < totalTareas) {
                        completadas[indice] = true;
                        System.out.println("Tarea marcada como completada.");
                    } else {
                        System.out.println("Número de tarea no válido.");
                    }
                } else {
                    System.out.println("\nNo hay tareas para marcar como completadas.");
                }
            } else if (opcion == 4) {
                if (totalTareas > 0) {
                    System.out.print("Ingrese el número de la tarea a eliminar: ");
                    int indice = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (indice >= 0 && indice < totalTareas) {
                        for (int i = indice; i < totalTareas - 1; i++) {
                            tareas[i] = tareas[i + 1];
                            completadas[i] = completadas[i + 1];
                        }
                        totalTareas--;
                        System.out.println("Tarea eliminada.");
                    } else {
                        System.out.println("Número de tarea no válido.");
                    }
                } else {
                    System.out.println("\nNo hay tareas para eliminar.");
                }
            } else if (opcion == 5) {
                System.out.println("\nEstadísticas de Tareas:");
                System.out.println("Total de tareas: " + totalTareas);
            } else if (opcion == 6) {
                System.out.println("Saliendo del programa...");
            } else {
                System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);
        scanner.close();
    }
}
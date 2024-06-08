import java.util.Scanner;

public class Main {
    private static SistemaCitas sistema = new SistemaCitas();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarSistema();

        if (autenticarAdministrador()) {
            mostrarMenu();
        } else {
            System.out.println("Acceso denegado.");
        }
    }

    private static void inicializarSistema() {
        // Agregar un administrador inicial
        sistema.agregarAdministrador(new Administrador("admin", "password"));
    }

    private static boolean autenticarAdministrador() {
        System.out.print("Ingrese ID de administrador: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese contraseña: ");
        String password = scanner.nextLine();

        return sistema.verificarAdministrador(id, password);
    }

    private static void mostrarMenu() {
        while (true) {
            System.out.println("\nMenú del Sistema de Administración de Citas");
            System.out.println("1. Dar de alta doctor");
            System.out.println("2. Dar de alta paciente");
            System.out.println("3. Crear cita");
            System.out.println("4. Mostrar doctores");
            System.out.println("5. Mostrar pacientes");
            System.out.println("6. Mostrar citas");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    darDeAltaDoctor();
                    break;
                case 2:
                    darDeAltaPaciente();
                    break;
                case 3:
                    crearCita();
                    break;
                case 4:
                    mostrarDoctores();
                    break;
                case 5:
                    mostrarPacientes();
                    break;
                case 6:
                    mostrarCitas();
                    break;
                case 7:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void darDeAltaDoctor() {
        System.out.print("Ingrese ID del doctor: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingrese nombre completo del doctor: ");
        String nombreCompleto = scanner.nextLine();
        System.out.print("Ingrese especialidad del doctor: ");
        String especialidad = scanner.nextLine();

        Doctor doctor = new Doctor(id, nombreCompleto, especialidad);
        sistema.agregarDoctor(doctor);
        System.out.println("Doctor agregado exitosamente.");
    }

    private static void darDeAltaPaciente() {
        System.out.print("Ingrese ID del paciente: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingrese nombre completo del paciente: ");
        String nombreCompleto = scanner.nextLine();

        Paciente paciente = new Paciente(id, nombreCompleto);
        sistema.agregarPaciente(paciente);
        System.out.println("Paciente agregado exitosamente.");
    }

    private static void crearCita() {
        System.out.print("Ingrese ID de la cita: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingrese fecha y hora de la cita (YYYY-MM-DD HH:MM): ");
        String fechaHora = scanner.nextLine();
        System.out.print("Ingrese motivo de la cita: ");
        String motivo = scanner.nextLine();

        System.out.print("Ingrese ID del doctor: ");
        int idDoctor = Integer.parseInt(scanner.nextLine());
        Doctor doctor = buscarDoctorPorId(idDoctor);
        if (doctor == null) {
            System.out.println("Doctor no encontrado.");
            return;
        }

        System.out.print("Ingrese ID del paciente: ");
        int idPaciente = Integer.parseInt(scanner.nextLine());
        Paciente paciente = buscarPacientePorId(idPaciente);
        if (paciente == null) {
            System.out.println("Paciente no encontrado.");
            return;
        }

        Cita cita = new Cita(id, fechaHora, motivo, doctor, paciente);
        sistema.agregarCita(cita);
        System.out.println("Cita creada exitosamente.");
    }

    private static Doctor buscarDoctorPorId(int id) {
        for (Doctor doctor : sistema.getDoctores()) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null;
    }

    private static Paciente buscarPacientePorId(int id) {
        for (Paciente paciente : sistema.getPacientes()) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        return null;
    }

    private static void mostrarDoctores() {
        System.out.println("Listado de Doctores:");
        for (Doctor doctor : sistema.getDoctores()) {
            System.out.println(doctor);
        }
    }

    private static void mostrarPacientes() {
        System.out.println("Listado de Pacientes:");
        for (Paciente paciente : sistema.getPacientes()) {
            System.out.println(paciente);
        }
    }

    private static void mostrarCitas() {
        System.out.println("Listado de Citas:");
        for (Cita cita : sistema.getCitas()) {
            System.out.println(cita);
        }
    }
}

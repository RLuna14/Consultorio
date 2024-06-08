import java.util.ArrayList;
import java.util.List;

public class SistemaCitas {
    private List<Doctor> doctores = new ArrayList<>();
    private List<Paciente> pacientes = new ArrayList<>();
    private List<Cita> citas = new ArrayList<>();
    private List<Administrador> administradores = new ArrayList<>();

    public void agregarDoctor(Doctor doctor) {
        doctores.add(doctor);
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void agregarCita(Cita cita) {
        citas.add(cita);
    }

    public boolean verificarAdministrador(String id, String password) {
        for (Administrador admin : administradores) {
            if (admin.getId().equals(id) && admin.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void agregarAdministrador(Administrador administrador) {
        administradores.add(administrador);
    }

    public List<Doctor> getDoctores() {
        return doctores;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public List<Cita> getCitas() {
        return citas;
    }
}

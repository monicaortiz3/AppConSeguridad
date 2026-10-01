package dto;

public class Empleados {

    private Long idEmpleado;

    private String nombre;

    private String apellido;

    private String puesto;


    public Empleados(){}

    public Empleados(Long idEmpleado, String nombre, String apellido, String puesto) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.puesto = puesto;
    }

    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }


    @Override
    public String toString() {
        return "Empleados{" +
                "idEmpleado=" + idEmpleado +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", puesto='" + puesto + '\'' +
                '}';
    }
}

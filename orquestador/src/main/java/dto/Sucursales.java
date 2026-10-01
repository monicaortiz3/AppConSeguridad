package dto;


import java.time.LocalDate;

public class Sucursales {

    private Long idSucursal;

    private String nombre;

    private String ciudad;

    private String estado;

    private LocalDate fechaApertura;

    public Sucursales(){}

    public Sucursales(Long idSucursal, String nombre, String ciudad, String estado, LocalDate fechaApertura) {
        this.idSucursal = idSucursal;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estado = estado;
        this.fechaApertura = fechaApertura;
    }

    public Long getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Long idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    @Override
    public String toString() {
        return "Sucursales{" +
                "idSucursal=" + idSucursal +
                ", nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", estado='" + estado + '\'' +
                ", fechaApertura=" + fechaApertura +
                '}';
    }
}

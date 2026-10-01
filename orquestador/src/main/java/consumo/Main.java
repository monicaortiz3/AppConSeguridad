package consumo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dto.Clientes;
import dto.Empleados;
import dto.Productos;
import dto.Sucursales;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    List<String> erroresCliente = new ArrayList<>();

    public static void main(String[] args) {
        String urlClientesObtenerTodos = "http://localhost:8080/api/clientes";
        String urlEmpleadosObtenerTodos = "http://localhost:8080/api/empleados";
        String urlProductosObtenerTodos = "http://localhost:8080/api/productos";
        String urlSucursalesObtenerTodos = "http://localhost:8080/api/sucursales";

        ConsumoApi consumoApi = new ConsumoApi();
//        List<Clientes> clientesList = consumoApi.obtenerClientes(urlClientesObtenerTodos);
//        List<Empleados> empleadosList = consumoApi.obtenerEmpleados(urlEmpleadosObtenerTodos);
//        List<Productos> productosList = consumoApi.obtenerProductos(urlProductosObtenerTodos);
//        List<Sucursales> sucursalesList = consumoApi.obtenerSucursales(urlSucursalesObtenerTodos);

//        for (int i = 0; i < clientesList.size(); i++) {
//            validaCliente(clientesList.get(i), i+1);
//        }
//        clientesList.stream().forEach(System.out::println);

    }

    /* Validaciones Cliente */

    public static void validaCliente(Clientes cliente, int idLista) {
        if(!esNumeroLongValido(cliente.getIdClientes())){
            logger.info("Cliente [{}] : Error en el id - No puede ser null ni menor o igual a 0.", idLista);
        }

        if(!esCadenaValida(cliente.getNombre())){ // pedro
            logger.info("Cliente [{}] : Error en el nombre - No puede ser null o vacío.", idLista);
        }else{ // revisar
            String nombreLimpio = cliente.getNombre().trim().replace("  ", "");
            nombreLimpio = nombreLimpio.substring(0,1).toUpperCase() + nombreLimpio.substring(1); // Pedro
            cliente.setNombre(nombreLimpio);
        }

        if(!esCadenaValida(cliente.getApellido())){
            logger.info("Cliente [{}] : Error en el nombre - No puede ser null o vacío.", idLista);
        }else{ // revisar
            String apellidoLimpio = cliente.getApellido().trim().replace("  ", "");
            apellidoLimpio = apellidoLimpio.substring(0,1).toUpperCase() + apellidoLimpio.substring(1); // Pedro
            cliente.setApellido(apellidoLimpio);
        }

        if(!esCorreoValido(cliente.getCorreo())){
            logger.info("Cliente [{}] : Error en el email - Validar formato de correo", idLista);
        }else{
            String nuevoCorreo = cliente.getCorreo();
            nuevoCorreo = nuevoCorreo.trim().toLowerCase();
            cliente.setCorreo(nuevoCorreo);
        }

        if(!esCadenaValida(cliente.getTelefono())){ // null, ""
            cliente.setTelefono(null);
        }else{
            cliente.setTelefono(cliente.getTelefono().replaceAll("[ ()\\-]", ""));
        }

        if(!fechaValida(cliente.getFechaRegistro())){
            logger.info("Cliente [{}] : Error en la fecha - No puede ser null ni una fecha futura.", idLista);
        }

    }

    public static void validaEmpleado(Empleados empleado, int idLista){
        if(!esNumeroLongValido(empleado.getIdEmpleado())){
            logger.info("Empleado [{}] : Error en el id - No puede ser null ni menor o igual a 0.", idLista);
        }
        if (!esCadenaValida(empleado.getNombre())){
            logger.info("Empleado [{}] : Error en el nombre - No puede ser null o vacío.", idLista);
        }else{
            String nombreLimpio = empleado.getNombre().trim().replace("  ", "");
            nombreLimpio = nombreLimpio.substring(0,1).toUpperCase() + nombreLimpio.substring(1); // normalizar mayusculas y minusculas
            empleado.setNombre(nombreLimpio);
        }
        if (!esCadenaValida(empleado.getApellido())){
            logger.info("Empleado [{}] : Error en el apellido - No puede ser null o vacío.", idLista);
        }else {
            String apellidoLimpio = empleado.getApellido().trim().replace("  ", "");
            apellidoLimpio = apellidoLimpio.substring(0, 1).toUpperCase() + apellidoLimpio.substring(1); // normalizar mayusculas y minusculas
            empleado.setApellido(apellidoLimpio);
        }
        if (!esCadenaValida(empleado.getPuesto())){
            logger.info("Empleado [{}] : Error en el puesto -No puede ser null o vacío", idLista);
        }else{
            String puestoLimpio = empleado.getPuesto().trim().replace("  ", "");
        }
        //id_sucursal		No puede ser null ni menor o igual a 0.



    }

    public static void validaProducto(Productos producto, int idLista){
        if(!esNumeroLongValido(producto.getIdProducto())){
            logger.info("Producto [{}] : Error en el id - No puede ser null ni menor o igual a 0.", idLista);
        }

        if(!esCadenaValida(producto.getNombre())){ // pedro
            logger.info("Producto [{}] : Error en el nombre - No puede ser null o vacío.", idLista);
        }else{
           String nombreLimpio = producto.getNombre().trim().replaceAll("\\s+", " ");
        }

        if(!esCadenaValida(producto.getDescripcion())){
            producto.setDescripcion(null);
        }else{
            producto.setDescripcion(producto.getDescripcion().trim());
        }

        if (!esNumeroDecimalValido(producto.getPrecio()) || producto.getPrecio() <= 0){
            logger.info("Producto [{}] : Error en el precio - No puede ser null y debe ser mayor que 0", idLista);
        }

        if (!esNumeroIntegerValido(producto.getStock()) || producto.getStock() < 0){
            logger.info("Producto [{}] : Error en el stock - No puede ser null y debe ser mayor que 0", idLista);
        }

    }


    public static void validaSucursal(Sucursales sucursales, int idLista){
        if(!esNumeroLongValido(sucursales.getIdSucursal())){
            logger.info("Sucursal [{}] : Error en el id - No puede ser null ni menor o igual a 0.", idLista);
        }
        if (!esCadenaValida(sucursales.getNombre())){
            logger.info("Sucursal [{}] : Error en el nombre - No puede ser null o vacío.", idLista);
        }else{
            String nombreLimpio = sucursales.getNombre().trim().replace("  ", "");
            nombreLimpio = nombreLimpio.substring(0,1).toUpperCase() + nombreLimpio.substring(1); // normalizar mayusculas y minusculas
            sucursales.setNombre(nombreLimpio);
        }
        if (!esCadenaValida(sucursales.getCiudad())) {
            logger.info("Sucursal [{}] : Error en la ciudad -No puede ser null o vacío", idLista);
        }else{
            String ciudadLimpia = sucursales.getCiudad().trim().replaceAll("\\s+", " ").toLowerCase();
        }
        if (!esCadenaValida(sucursales.getEstado())) {
            logger.info("Sucursal [{}] : Error en el estado -No puede ser null o vacío", idLista);
        }else {
            String ciudadLimpia = sucursales.getCiudad().trim().replaceAll("\\s+", " ").toLowerCase();
        }
        if (!fechaValida(sucursales.getFechaApertura())||
                sucursales.getFechaApertura().isAfter(LocalDate.now())){
            logger.info("Sucursal [{}] : Error en la fecha de apertura - No puede ser null ni una fecha futura", idLista);

        }

    }

    public static boolean esNumeroLongValido(Long numero){
        if(numero != null && numero > 0){
            return true;
        }
        return false;
    }

    public  static boolean esNumeroIntegerValido(Integer numero){
        if(numero != null && numero > 0){
            return true;
        }
        return false;
    }

    public static boolean esNumeroDecimalValido(Float numero){
        if(numero != null && numero > 0){
            return true;
        }
        return false;
    }

    public  static boolean esCadenaValida(String cad){
        if(cad != null && !cad.isEmpty() ){
            return true;
        }
        return false;
    }

    public static boolean fechaValida(LocalDate fecha){
        if(fecha != null && !fecha.isAfter(fecha)){
            return true;
        }else{
            return false;
        }
    }

    public static boolean esCorreoValido(String email) {
       Pattern EMAIL_PATTERN = Pattern.compile(
                "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"
        );
        if (email == null || email.isEmpty()) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public static String capitalizarCadena(String cad){
        return "";
    }

    public static String eliminarEspaciosInnecesarios(String cad){
        return "";
    }


}

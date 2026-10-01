package consumo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dto.Clientes;
import dto.Empleados;
import dto.Productos;
import dto.Sucursales;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ConsumoApi {


    public List<Clientes> obtenerClientes(String url){
        List<Clientes> lista = List.of();
        try{
            HttpClient cliente = HttpClient.newHttpClient();

            HttpRequest peticion = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Accept", "application/json")
                    .GET()
                    .build();
            // contatros / layouts
            HttpResponse<String> respuesta = cliente.send(peticion, HttpResponse.BodyHandlers.ofString());

            if(respuesta.statusCode() == 200){
                String jsonBody = respuesta.body();
                ObjectMapper mapper = new ObjectMapper();
                mapper.registerModule(new JavaTimeModule());

                lista = mapper.readValue(jsonBody, new TypeReference<List<Clientes>>(){});
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return lista;
    }

    public List<Empleados> obtenerEmpleados(String url){
        List<Empleados> lista = List.of();
        try{
            HttpClient cliente = HttpClient.newHttpClient();

            HttpRequest peticion = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Accept", "application/json")
                    .GET()
                    .build();
            // contatros / layouts
            HttpResponse<String> respuesta = cliente.send(peticion, HttpResponse.BodyHandlers.ofString());

            if(respuesta.statusCode() == 200){
                String jsonBody = respuesta.body();
                ObjectMapper mapper = new ObjectMapper();
                mapper.registerModule(new JavaTimeModule());

                lista = mapper.readValue(jsonBody, new TypeReference<List<Empleados>>(){});
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return lista;
    }

    public List<Productos> obtenerProductos(String url){
        List<Productos> lista = List.of();
        try{
            HttpClient cliente = HttpClient.newHttpClient();

            HttpRequest peticion = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Accept", "application/json")
                    .GET()
                    .build();
            // contatros / layouts
            HttpResponse<String> respuesta = cliente.send(peticion, HttpResponse.BodyHandlers.ofString());

            if(respuesta.statusCode() == 200){
                String jsonBody = respuesta.body();
                ObjectMapper mapper = new ObjectMapper();
                mapper.registerModule(new JavaTimeModule());

                lista = mapper.readValue(jsonBody, new TypeReference<List<Productos>>(){});
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return lista;
    }

    public List<Sucursales> obtenerSucursales(String url){
        List<Sucursales> lista = List.of();
        try{
            HttpClient cliente = HttpClient.newHttpClient();

            HttpRequest peticion = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Accept", "application/json")
                    .GET()
                    .build();
            // contatros / layouts
            HttpResponse<String> respuesta = cliente.send(peticion, HttpResponse.BodyHandlers.ofString());

            if(respuesta.statusCode() == 200){
                String jsonBody = respuesta.body();
                ObjectMapper mapper = new ObjectMapper();
                mapper.registerModule(new JavaTimeModule());

                lista = mapper.readValue(jsonBody, new TypeReference<List<Sucursales>>(){});
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return lista;
    }

}

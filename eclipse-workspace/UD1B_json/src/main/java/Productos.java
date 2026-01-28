import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mongodb.client.model.Projections;

public class Productos {

    public static void main(String[] args) {
        JSONParser parse = new JSONParser();

        try {
            // Parsear directamente como JSONArray
            JSONArray jArray = (JSONArray) parse.parse(new FileReader("ficheros\\productos.json"));

            // 1. Obten el  nombre de todos los productos
            for (Object obj : jArray) {
                JSONObject jObject = (JSONObject) obj;
                System.out.println(jObject.get("nombre_producto"));
            }
            
            // 2.- Obtener el nombre y el precio de los productos de la tipo «Ropa»
            for (Object obj : jArray) {
                JSONObject jObject = (JSONObject) obj;
                
                System.out.println(jObject.get("nombre_producto"));
            }
            
            for (Object obj : jArray) {
                JSONObject jObject = (JSONObject) obj;

                // Filtrar por tipo_producto = "Ropa"
                String tipo = (String) jObject.get("tipo_producto");
                if ("Ropa".equals(tipo)) {
                    System.out.println("Filtrado por ropa: " + jObject.get("nombre_producto"));
                }
            }
            
            // 3.- Mostrar toda la información del «Pantalones Levi's 501»
            
            

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        } catch (ParseException e) {
            System.out.println("Error al parsear JSON: " + e.getMessage());
        }
    }
}

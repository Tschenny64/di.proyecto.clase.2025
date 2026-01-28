import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Text2 {

    public static void main(String[] args) {
        JSONParser parse = new JSONParser();
        JSONArray jArray, jArray2 = null;
        JSONObject jObject, jObject2 = null;
        String sid = null;

        try {
            Object docobj = parse.parse(new FileReader("ficheros\\test2.json"));
            JSONObject jObj = (JSONObject) docobj;
            
            //Obtener id
            sid=(String) jObj.get("id");
            System.out.println("id " + sid);
           
            //sacar las page url
            jArray=(JSONArray)jObj.get("pages");
            for (Object obj:jArray) {
            	jObject=(JSONObject)obj;
            	System.out.println(jObject.get("pageUrl"));
       
            }
            
            
                // sacar results
            jArray=(JSONArray)jObj.get("pages");
            	for (Object obj1:jArray) {
            		jObject=(JSONObject)obj1;
            		jArray = (JSONArray) jObject.get("results");
            		for (Object object : jArray) {
            			jObject=(JSONObject)object;
            			System.out.println(jObject.get("number"));
            		}
            	}
           


        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        } catch (ParseException e) {
            System.out.println("Error al parsear JSON: " + e.getMessage());
        }
    }
}

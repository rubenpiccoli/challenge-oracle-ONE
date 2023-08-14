package apiExterna;


import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Scanner;

import org.json.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.JSONArray;

import javax.management.modelmbean.InvalidTargetObjectTypeException;
import javax.swing.JOptionPane;





public class ApiExterna{
	
	public static void main(String[] args) {
		// solicitar una petición
		//http://data.fixer.io/api/latest?access_key=d13211c12d468a93585d7382fef05c51
		try {
		URL url = new URL("http://data.fixer.io/api/latest?access_key=d13211c12d468a93585d7382fef05c51");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.connect();
		
		// ¿Peticón correcta
		int Respuesta = con.getResponseCode();
		
		System.out.println(Respuesta);
		
			if(Respuesta != 200) {
				 JOptionPane.showMessageDialog(
		                    null,
		                    "Debe estar conectado.",
		                    "No es posible conectarse actualmente "
		                    + "con la API FIXER.",
		                    JOptionPane.ERROR_MESSAGE);
				throw new RuntimeException("Ocurrio un error: "+Respuesta);
			}else {
				//Abrir scanner que lea el flujo de datos por consola
				
				StringBuilder InformacionRecibida = new StringBuilder();
				
				Scanner scanner = new Scanner(url.openStream());
				
			
				while(scanner.hasNext()) {
					InformacionRecibida.append(scanner.nextLine());
					
				}	
				scanner.close();
				
				JSONObject jsonObject =  (JSONObject) JSONValue.parse(InformacionRecibida.toString());;
				String rates = (String) jsonObject.get("rates").toString();
			    String ratesEncontrado="";
				/*for(int i = 0; i < rates.length(); i++) {
					
					 
						
						System.out.println("encontrado");
					}
					
					
				}*/
			    System.out.println(rates);
				
				
					
			}
				
				
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
	}

}

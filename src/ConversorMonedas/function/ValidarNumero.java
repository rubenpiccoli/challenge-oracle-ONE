package ConversorMonedas.function;



public class ValidarNumero{
	
	
	public static boolean ValidarNumero(String input) {
	        
		try {
	            double x = Double.parseDouble(input);
	           
	            if(x >= 0) {
	             //System.out.println(x);
	                return true;
	            }
	            
	            
	            
	           return false;
	            
	            
	            } catch (NumberFormatException e) {
	            	
	            	e.getStackTrace();
	                return false;
	            }catch (NullPointerException e) {
	            	
	            	e.getStackTrace();
	            	return false;
	            }
	            }
	        
	    }


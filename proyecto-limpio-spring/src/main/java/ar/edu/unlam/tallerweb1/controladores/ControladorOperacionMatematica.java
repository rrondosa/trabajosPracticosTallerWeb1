package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorOperacionMatematica {
	private static final String SUM="SUMAR";
	private static final String DIV="DIVIDIR";
	private static final String MUL="MULTIPLICAR";
	private static final String RES="RESTAR";
	
	@RequestMapping(path = "/operacionMatematica/{operador}/{primerNro}/{segundoNro}")
	public ModelAndView saludar(@PathVariable("primerNro") String primerNro, @PathVariable("operador") String operador, @PathVariable("segundoNro") String segundoNro){
		
		ModelMap modelo = new ModelMap();
		
		//se envia parametros variables porURL
		modelo.put("nro1", primerNro);
		modelo.put("nro2", segundoNro);
		modelo.put("operador", operador);
		
		double resultado = 0 ;
		double a = Double.parseDouble(primerNro);
		double b = Double.parseDouble(segundoNro);
		String simbolo = operador.toUpperCase();
		
		if(isInteger(primerNro) && isInteger(segundoNro) && isOperador(simbolo)){
			
			if( simbolo.equals(DIV) && b != 0){
				resultado = a / b;
			} else {
				System.out.println("b es = 0" );
				modelo.put("error", "Error no se puede realizar la operacion el segundo operador debe ser distinto 0.");
			}
			
			switch (simbolo) {
				case SUM:
					resultado = a + b;
					break;
				case RES:
					resultado = a - b;
					break;
				case MUL:
					resultado = a * b;
					break;
			}
			
			modelo.put("resultado", resultado);
			
		}else {
			modelo.put("error", "Error no se puede realizar la operacion.");
		}

		modelo.put("resultado", resultado);
		
		
		return new ModelAndView("operacionMatematica", modelo);
	}
	
	public boolean isInteger(String numero){
	    try{
	        Integer.parseInt(numero);
	        return true;
	    }catch(NumberFormatException e){
	        return false;
	    }
	}
	public boolean isOperador(String simbolo){
	    if(simbolo != SUM || simbolo != RES || simbolo != MUL || simbolo !=  DIV){
	    	System.out.println("simbolo:"+simbolo);
	    	return  true;
	    }
	    return false;
	}
	
}

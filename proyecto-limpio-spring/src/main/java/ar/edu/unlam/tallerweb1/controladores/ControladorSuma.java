package ar.edu.unlam.tallerweb1.controladores;

import javax.management.modelmbean.ModelMBeanOperationInfo;
import javax.servlet.http.HttpServletRequest;

import org.springframework.expression.spel.ast.CompoundExpression;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorSuma {
	
	@RequestMapping(path = "/sumaNumeros/{primerNro}/{segundoNro}")
	public ModelAndView saludar(@PathVariable("primerNro") String primerNro, @PathVariable("segundoNro") String segundoNro){
		
		ModelMap modelo = new ModelMap();
		
		//se envia parametros variables porURL
		modelo.put("nro1", primerNro);
		modelo.put("nro2", segundoNro);
		
		int resultado = 0 ;
		
		if(isInteger(primerNro) && isInteger(segundoNro)){
			resultado= Integer.parseInt(primerNro) + Integer.parseInt(segundoNro);
			modelo.put("resultado", resultado);
		}else {
			modelo.put("error", "Error no se puede realizar la suma");
		}

		modelo.put("resultado", resultado);
		
		
		return new ModelAndView("suma", modelo);
	}
	
	public boolean isInteger(String numero){
	    try{
	        Integer.parseInt(numero);
	        return true;
	    }catch(NumberFormatException e){
	        return false;
	    }
	}
	
	// Este metodo escucha la URL validar-login siempre y cuando se invoque con metodo http POST
	// El método recibe un objeto Usuario el que tiene los datos ingresados en el form correspondiente y se corresponde con el modelAttribute definido en el
	// tag form:form
	@RequestMapping(path = "/realiza-suma", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("primerNro") int a, @ModelAttribute("segundoNro") int b, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		System.out.println(a);
		System.out.println(b);
		if (a != 0 && b != 0) {
			int resultado =  a + b;
			model.put("resultado", resultado);
			model.put("a", a);
			model.put("b",b);
			return new ModelAndView("redirect:/suma");
		} else {
			// si el usuario no existe agrega un mensaje de error en el modelo.
			model.put("error", "no se puede realizar la suma");
		}
		return new ModelAndView("suma", model);
	}

	
}

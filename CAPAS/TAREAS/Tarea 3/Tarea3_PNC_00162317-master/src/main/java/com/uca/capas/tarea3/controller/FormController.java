package com.uca.capas.tarea3.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
	
	@RequestMapping("/resultado")
	public ModelAndView parametros1(HttpServletRequest request) throws ParseException{
		ModelAndView mav = new ModelAndView();
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String fecha = request.getParameter("fecha");
		
		
		java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
		java.util.Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2003-01-01");
		
		
		String lugar = request.getParameter("lugar");
		String colegio = request.getParameter("colegio");
		String fijo = request.getParameter("fijo");
		String celular = request.getParameter("celular");
		
		List<String> lista = new ArrayList<>();

		/*
		if((nombre.length()<1||nombre.length()>25)
				||(apellido.length()<1||apellido.length()>25)
				||(date.compareTo(date1)<0)
				||(lugar.length()<1||lugar.length()>25)
				||(colegio.length()<1||colegio.length()>100)
				||(fijo.length()!=8)
				||(celular.length()!=8)){
			
			lista.add("Por favor introduzca bien los datos, gracias");
			
		}
		*/
		if(nombre.length()<1||nombre.length()>25) {
			lista.add("Ingrese bien el nombre. Mínimo 1 carácter y máximo 25 caracteres");
		}
		
		if(apellido.length()<1||apellido.length()>25) {
			lista.add("Ingrese bien el apellido. Mínimo 1 carácter y máximo 25 caracteres");
		}
		
		if(date.compareTo(date1)<0) {
			lista.add("Ingrese bien la fecha. No puede ser menor al 1 de enero de 2003");
		}
		
		if(lugar.length()<1||lugar.length()>25) {
			lista.add("Ingrese bien el lugar de nacimiento. Mínimo 1 carácter y máximo 25 caracteres");
		}
		
		if(colegio.length()<1||colegio.length()>100) {
			lista.add("Ingrese bien el colegio. Mínimo 1 carácter y máximo 100 caracteres");
		}
		
		if(fijo.length()!=8) {
			lista.add("Ingrese bien el numero fijo. 8 números exactamente");
		}
		
		if(celular.length()!=8) {
			lista.add("Ingrese bien el nuermo de telefono. 8 números exactamente");
		}
		
		if(!lista.isEmpty()) {
			mav.addObject("lista",lista);
			mav.setViewName("formulario/error");
			return mav;
		}
		
		mav.setViewName("formulario/final");
		return mav;
	}

}

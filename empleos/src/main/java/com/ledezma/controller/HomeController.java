package com.ledezma.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ledezma.model.Vacante;

@Controller
public class HomeController {
	
	@GetMapping("/tabla")

	public String mostrarTabla(Model model) {
		
		List<Vacante> lista = getVacantes();
		model.addAttribute("vacantes", lista);
		return "tabla";
	}
	
	@GetMapping("/detalle")
	public String MostrarDetalle(Model model){
		Vacante vacante = new Vacante();
		vacante.setNombre("Ingeniero de Telecomunicaciones");
		vacante.setDescripcion("Se solicita ingeniero para dar soporte a intranet");
		vacante.setFecha(new Date());
		vacante.setSalario(9700.0);
		model.addAttribute("vacante", vacante);
		
		return "detalle"; //vista
	}
	
	
	@GetMapping("/listado")
	public String MostrarListado(Model model) {
		List<String> lista = new LinkedList<String>();
		lista.add("ingeniero de sistemas");
		lista.add("Auxiliar de contabilidad");
		lista.add("Vendedor");
		lista.add("Arqutecto");
		
		model.addAttribute("empleos", lista);
	
			return "Listado";
	}
	@GetMapping("/")
	public String MostrarHome(Model model) {
		/*model.addAttribute("mensaje", "Bienvenidos a empleos App");
		model.addAttribute("fecha", new Date());
		return "home";*/
	
		
		String nombre ="Auxiliar de Contabilidad";
		Date fechaPub = new Date();
		double salario =9000.0;
		boolean vigente = true;
		
		model.addAttribute("nombre", nombre);
		model.addAttribute("fecha", fechaPub);
		model.addAttribute("salario", salario);
		model.addAttribute("vigente", vigente);

		return "Home";
	}
	
	private List<Vacante> getVacantes(){
		
		SimpleDateFormat sdf =new SimpleDateFormat("dd-MM-yyyy");
		List<Vacante> lista = new LinkedList<Vacante>();
		try {
			//creamos la oferta de trabajo
			Vacante vacante1 =new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingenierio civil");
			vacante1.setDescripcion("Solicitamos ing. civil para diseñar puente Peatonal");
			vacante1.setFecha(sdf.parse("02-08-2019"));
			vacante1.setSalario(8500.0);
			vacante1.setDestacado(1);
			vacante1.setImagen("empresa1.png");
			
			//creamos la oferta de trabajo
			Vacante vacante2 =new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Contador publico");
			vacante2.setDescripcion("Importante empresa solicita contador con 5 años de experiencia titulado");
			vacante2.setFecha(sdf.parse("09-02-2019"));
			vacante2.setSalario(12000.0);
			vacante2.setDestacado(0);
			vacante2.setImagen("empresa2.png");
			
			//creamos la oferta de trabajo
			Vacante vacante3 =new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Ingenierio electrico");
			vacante3.setDescripcion("Empresa internacional necesita ing. electrico para mantecnion de la instalacion  electrica");
			vacante3.setFecha(sdf.parse("10-02-2019"));
			vacante3.setSalario(10500.0);
			vacante3.setDestacado(0);
			
			
			//creamos la oferta de trabajo
			Vacante vacante4 =new Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Diseñador Grafico");
			vacante4.setDescripcion("Necesitamos diseñador grafico para diseñar la publicidad de la empresa");
			vacante4.setFecha(sdf.parse("11-02-2019"));
			vacante4.setSalario(7500.0);
			vacante4.setDestacado(1);
			vacante4.setImagen("empresa3.png");
			
		//agregamos los 4 objetos de tipo vacante a la lista
		
			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
			lista.add(vacante4);
		} catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return lista; 
		
	}
	
}

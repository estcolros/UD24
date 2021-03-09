package com.crud.h2.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crud.h2.dto.Empleado;
import com.crud.h2.service.EmpleadoServiceImpl;

@RestController
@RequestMapping("/api")
public class EmpleadoController {
	
	@Autowired
	EmpleadoServiceImpl EmpleadoServideImpl;
	
	@GetMapping("/empleados")
	public List<Empleado> listarEmpleados(){
		return EmpleadoServideImpl.listarEmpleados();
	}
	
	//listar Empleados por campo nombre
	@GetMapping("/empleados/trabajo/{trabajo}")
	public List<Empleado> listarEmpleadoNombre(@PathVariable(name="trabajo") String trabajo) {
	    return EmpleadoServideImpl.listarEmpleadoTrabajo(trabajo);
	}
	
	
	@PostMapping("/empleados")
	public Empleado salvarEmpleado(@RequestBody Empleado Empleado) {
		
		return EmpleadoServideImpl.guardarEmpleado(Empleado);
	}
	
	
	@GetMapping("/empleados/{id}")
	public Empleado EmpleadoXID(@PathVariable(name="id") Long id) {
		
		Empleado Empleado_xid= new Empleado();
		
		Empleado_xid=EmpleadoServideImpl.EmpleadoXID(id);
		
		System.out.println("Empleado XID: "+Empleado_xid);
		
		return Empleado_xid;
	}
	
	@PutMapping("/empleados/{id}")
	public Empleado actualizarEmpleado(@PathVariable(name="id")Long id,@RequestBody Empleado Empleado) {
		
		Empleado Empleado_seleccionado= new Empleado();
		Empleado Empleado_actualizado= new Empleado();
		
		Empleado_seleccionado= EmpleadoServideImpl.EmpleadoXID(id);
		
		Empleado_seleccionado.setNombre(Empleado.getNombre());
		Empleado_seleccionado.setTrabajo(Empleado.getTrabajo());
		Empleado_seleccionado.setSalario(Empleado.getSalario());

		
		Empleado_actualizado = EmpleadoServideImpl.actualizarEmpleado(Empleado_seleccionado);
		
		System.out.println("El Empleado actualizado es: "+ Empleado_actualizado);
		
		return Empleado_actualizado;
	}
	
	@DeleteMapping("/empleados/{id}")
	public void eleiminarEmpleado(@PathVariable(name="id")Long id) {
		EmpleadoServideImpl.eliminarEmpleado(id);
	}
	
	
}

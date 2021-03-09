package com.crud.h2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.h2.dto.Empleado;

/**
 * @author Jose
 *
 */
public interface IEmpleadoDAO extends JpaRepository<Empleado, Long> {

	// Listar clientes or campo nombre
	public List<Empleado> findByNombre(String nombre);

	public List<Empleado> findByTrabajo(String trabajo);

}

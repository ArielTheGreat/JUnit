package tests;

import static org.junit.Assert.*;


import org.junit.Test;

import syspagos.Empleado;
import syspagos.Prima;
import excepciones.*;

public class TestEmpleado 
{
	@Test
	public void calcularPrima()
	{
		Empleado a = new Empleado();
		Prima resultado = Prima.P1;
		try {
			resultado = a.calcularPrima("001","Gabriel","012","-");
		} catch (NumeroEmpleadoException | NombreEmpleadoException | MesesTrabajoException | CargoException e) {
			fail();
		}
		Prima esperado = Prima.P2;
		assertEquals(esperado,resultado);
	}
	@Test 
	public void establecerNumeroDeEmpleadoCorrecto() 
	{
		Empleado e = new Empleado();
        try 
        {
            e.establecerNumeroEmpleado("4");
        } catch (NumeroEmpleadoException ex) 
        {
        	fail();
        }
        assertEquals(4,e.getNumeroEmpleado());
	}
	@Test
	public void establecerNombreDeEmpleadoCorrecto()  
	{
		Empleado c = new Empleado();
		try {
			c.estableceNombreEmpleado("Juan**23");
		} catch (NombreEmpleadoException e) {
			fail();
		}
		String nombre = c.getNombreEmpleado();
		assertEquals(nombre, "Juan**23");
	}
	@Test
	public void establecerMesesDeTrabajo()
	{
		Empleado d = new Empleado();
		try {
			d.estableceMesesTrabajo("7");
		} catch (MesesTrabajoException e) {
			fail();
		}
		Integer resultado = d.getNumeroEmpleado();
		Integer esperado = Integer.parseInt("7");
		assertEquals(esperado, resultado);
	}
	@Test
	public void establecerSerDirectivo()
	{
		Empleado e = new Empleado();
		try {
			e.establecerSerDirectivo("Directivo");
		} catch (CargoException e1) {
			fail();
		}
		assertEquals(false, e.getDirectivo() );
	}
}

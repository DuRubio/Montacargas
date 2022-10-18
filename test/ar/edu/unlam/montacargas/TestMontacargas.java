package ar.edu.unlam.montacargas;

import org.junit.Assert;
import org.junit.Test;

public class TestMontacargas {

	@Test
	public void queSeInicieElMontacargasEn0() {
		Montacargas hyster = new Montacargas(1000.0);
		Assert.assertEquals(0.0, hyster.getCarga(), 0.01);
	}

	@Test
	public void queSePuedaCargarElMontacargas() {
		Carga paquete = new Carga(20.0);
		Montacargas hyster = new Montacargas(1000.0);
		hyster.cargar(paquete);
		Integer valorEsperado = 1;
		Assert.assertEquals(valorEsperado, hyster.getCantidadElementos());
	}

	@Test
	public void queSeCargueElMaximo() {
		Carga paquete = new Carga(1000.0);
		Montacargas hyster = new Montacargas(1000.0);
		hyster.cargar(paquete);
		Double valorEsperado = 1000.0;
		Assert.assertEquals(valorEsperado, hyster.getCarga());
	}

	@Test
	public void queNoSupereElMaximo() {
		Carga paquete = new Carga(2.0);
		Carga paquete2 = new Carga(1000.0);
		Montacargas hyster = new Montacargas(1000.0);
		hyster.cargar(paquete);
		hyster.cargar(paquete2);
		Double valorEsperado = 2.0;
		Assert.assertEquals(valorEsperado, hyster.getCarga());
	}

	@Test
	public void queNoSeCargueNegativo() {
		Carga paquete = new Carga(-2.0);
		Montacargas hyster = new Montacargas(1000.0);
		hyster.cargar(paquete);
		Double valorEsperado = 0.0;
		Assert.assertEquals(valorEsperado, hyster.getCarga());
	}

	@Test
	public void queElMontacargasSeCargueBien() {
		Carga paquete = new Carga(100.0);
		Carga paquete2 = new Carga(20.0);
		Montacargas hyster = new Montacargas(1000.0);
		hyster.cargar(paquete);
		hyster.cargar(paquete2);
		Double valorEsperado = 120.0;
		Assert.assertEquals(valorEsperado, hyster.getCarga());
	}
	
	@Test
	public void queSePuedaEliminarUnaCarga() {
		Carga paquete = new Carga(100.0);
		Carga paquete2 = new Carga(20.0);
		Montacargas hyster = new Montacargas(1000.0);
		hyster.cargar(paquete);
		hyster.cargar(paquete2);
		hyster.descargarUnaCarga(paquete2);
		Integer valorEsperado = 1;
		Assert.assertEquals(valorEsperado, hyster.getCantidadElementos());
		
	}

	@Test
	public void queElMontacargasSeVacie() {
		Carga paquete = new Carga(100.0);
		Carga paquete2 = new Carga(20.0);
		Montacargas hyster = new Montacargas(1000.0);
		hyster.cargar(paquete);
		hyster.cargar(paquete2);
		hyster.descargar();
		Double valorEsperado = 0.0;
		Assert.assertEquals(valorEsperado, hyster.getCarga());
	}

	@Test
	public void queElPromedioDe5cargasDe20gk() {
		Carga paquete = new Carga(10.0);
		Carga paquete2 = new Carga(20.0);
		Carga paquete3 = new Carga(10.0);
		Carga paquete4 = new Carga(20.0);
		Carga paquete5 = new Carga(40.0);
		Montacargas hyster = new Montacargas(1000.0);
		hyster.cargar(paquete);
		hyster.cargar(paquete2);
		hyster.cargar(paquete3);
		hyster.cargar(paquete4);
		hyster.cargar(paquete5);
		Double valorEsperado = 20.0;
		Assert.assertEquals(valorEsperado, hyster.getCargaPromedio());
	}

	@Test
	public void obtenerCargaPromedioHabiendoDescargadoYVueltoACargar() {
		Montacargas hyster = new Montacargas(1000.0);
		Carga paquete = new Carga(100.0);
		Carga paquete2 = new Carga(200.0);
		hyster.cargar(paquete);
		hyster.cargar(paquete2);
		hyster.descargar();
		Carga paquete3 = new Carga(100.0);
		Carga paquete4 = new Carga(200.0);
		Carga paquete5 = new Carga(300.0);
		hyster.cargar(paquete3);
		hyster.cargar(paquete4);
		hyster.cargar(paquete5);
		hyster.descargar();
		Double valorEsperado = 450.0;
		Assert.assertEquals(valorEsperado, hyster.getCargaPromedioTotal());
	}
}

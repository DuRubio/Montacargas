package ar.edu.unlam.montacargas;
import java.util.ArrayList;

public class Montacargas {

	private Double pesoMaximo;
	private ArrayList<Carga> montacargas; // el tipificador del lado izquierdo SIEMPRE va
	private Integer cantidadDescargadas;
	private Double pesoDescargado;

	public Montacargas(Double pesoMaximo) {
		this.montacargas = new ArrayList<Carga>();  //el tipificador del lado derecho no es necesario
		this.pesoMaximo = pesoMaximo;
		this.cantidadDescargadas=0;
		this.pesoDescargado=0.0;
	}

	public Double getCarga() {
		Double pesoActual = 0.0;
//		for (int i = 0; i < montacargas.size(); i++) {
//			pesoActual += montacargas.get(i).getPesoKg();
//		}
		
		for (Carga carga : montacargas) { //por cada carga de la clase Carga que está en la lista montacargas....
			pesoActual += carga.getPesoKg();
		}

		return pesoActual;
	}

	public Boolean cargar(Carga carga) {
		if (getCarga() <= pesoMaximo - carga.getPesoKg() && carga.getPesoKg()>0.0) {
			this.montacargas.add(carga);
			return true;
		}
		return false;
	}
	
	public void descargar () {		
		this.cantidadDescargadas++;
		this.pesoDescargado += this.getCarga(); //la suma de las cargas da la descarga total
		montacargas.clear();
	}
	
	public boolean descargarUnaCarga(Carga carga) {
		return montacargas.remove(carga);
	}
	
	
	public Integer getCantidadDescargadas() {
		return cantidadDescargadas;
	}
	
	public Double getCargaPromedio() {
		return getCarga()/montacargas.size();
	}
	
	public Integer getCantidadElementos() {
		return montacargas.size();
	}
	
	public Double getCargaPromedioTotal () {
		return this.pesoDescargado/this.cantidadDescargadas;
	}
}

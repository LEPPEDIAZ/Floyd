import static org.junit.Assert.*;

import org.junit.Test;

//Christopher Sandoval
//Maria Fernanda Estrada
//Analucia Diaz

public class PruebasUnitarias {

	@Test
	public void AgregarCiudades() {
		Graph graph = new Graph();
		graph.addEdge("guatemala tikal 500");
		assertEquals("Prueba de ingreso",graph.distBetweenNodes("guatemala", "tikal"),500.0,0.001);
	}
	
	@Test
	public void PruebaDeDistancia() {
		Graph graph = new Graph();
		graph.addEdge("panajachel escuintla 200");
		assertEquals("Prueba de distancias",graph.distBetweenNodes("panajachel", "escuintla"),200.0,0.001);
	}
	
	@Test
	public void PruebaDeCentro() {
		Graph graph = new Graph();
		graph.addEdge("guatemala tikal 500");
		assertEquals("Prueba de centro",graph.getCenter(),"Tikal");
	}

}

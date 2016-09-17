package generics;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestsCollector {
	
	Collector<Carrot> carrotCollector =new Collector<Carrot>("carrotCollector");
	Carrot carrot1 = new Carrot(1);
	Carrot carrot2 = new Carrot(2);
	
	@Test
	public void testGetCarriedObject() {
		assertEquals(null, carrotCollector.getCarriedObject());
		carrotCollector.take(carrot1);
		System.out.println(carrotCollector.getCarriedObject());
		assertEquals(carrot1, carrotCollector.getCarriedObject());
		assertEquals("Carrot-1", carrotCollector.getCarriedObject().toString());
	}

	@Test(expected=AlreadyCarryingException.class)
	public void testTake() {
		carrotCollector.take(carrot1);
		assertEquals(carrot1, carrotCollector.getCarriedObject());
		carrotCollector.take(carrot2);
		
	}
	
	
}

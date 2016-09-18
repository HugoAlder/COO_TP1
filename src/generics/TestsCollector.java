package generics;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestsCollector {
	
	Collector<Carrot> carrotCollector_1 =new Collector<Carrot>("carrotCollector_1");
	Collector<Carrot> carrotCollector_2 =new Collector<Carrot>("carrotCollector_2");
	Collector<Vegetable> vegetableCollector =new Collector<Vegetable>("vegetableCollector");
	Carrot carrot1 = new Carrot(1);
	Carrot carrot2 = new Carrot(2);
	
	@Test
	public void testGetCarriedObject() {
		assertEquals(null, carrotCollector_1.getCarriedObject());
		carrotCollector_1.take(carrot1);
		assertEquals(carrot1, carrotCollector_1.getCarriedObject());
		assertEquals("Carrot-1", carrotCollector_1.getCarriedObject().toString());
	}
	
	@Test(expected = AlreadyCarryingException.class)
	public void testTake() {
		carrotCollector_1.take(carrot1);
		assertEquals(carrot1, carrotCollector_1.getCarriedObject());
		//carrotCollector_1.take(carrot2);
	}
	
	@Test(expected = AlreadyCarryingException.class)
	public void testGiveTo() {
		carrotCollector_1.take(carrot1);
		carrotCollector_1.giveTo(carrotCollector_2);
		assertEquals(null, carrotCollector_1.getCarriedObject());
		assertEquals(carrot1, carrotCollector_2.getCarriedObject());
		carrotCollector_2.giveTo(vegetableCollector);
		assertEquals(carrot1, vegetableCollector.getCarriedObject());
		//carrotCollector_2.giveTo(vegetableCollector);
	}
	
	@Test
	public void testDrop() {
		carrotCollector_1.take(carrot1);
		carrotCollector_1.drop();
		assertEquals(null, carrotCollector_1.getCarriedObject());
	}
	
}

package javaCar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarMapTest {

    private CarMap<CarOwner, Car> carMap;

    @Before
    public void setUp() throws Exception {
        //init
        carMap = new CarHashMap<>();
        for (int i = 0; i < 100; i++) {
            carMap.put(new CarOwner(i, "Name" + i, "LastName" + i),
                    new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAdded100ElementsThenSizeIs100() {
        assertEquals(100, carMap.size());
    }

    @Test
    public void countOfKeysMustBeEqualsToCountOfValues() {
        assertEquals(100, carMap.size());
        assertEquals(100, carMap.keySet().size());
        assertEquals(100, carMap.values().size());
    }

    @Test
    public void whenPutOneElementThenSizeIs101() {
        carMap.put(new CarOwner(101, "Anton", "Bondy"),
                new Car("Land Rover", 101));
        assertEquals(101, carMap.size());
    }

    @Test
    public void whenGetCar() {
        Car car = new Car("Brand0", 0);
        CarOwner carOwner = new CarOwner(0, "Name0", "LastName0");
        assertEquals(car, carMap.get(carOwner));
    }

    @Test
    public void whenRemoveOneCarThenSizeDecreaseBy1() {
        CarOwner carOwner = new CarOwner(0, "Name0", "LastName0");
        assertTrue(carMap.remove(carOwner));
        assertEquals(99, carMap.size());
    }
}
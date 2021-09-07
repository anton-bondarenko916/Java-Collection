package javaTest;

import javaCar.Car;
import javaCar.CarHashSet;
import javaCar.CarSet;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarSetTest {

    private CarSet<Car> carSet;

    @Before
    public void setUp() throws Exception {
        carSet = new CarHashSet<>();
        for (int i = 0; i < 100; i++) {
            carSet.add((new Car("Brand" + i, i))); //Добавление 100 машин в список
        }
    }

    @Test
    public void findElementInSet() {
        assertTrue(carSet.contains(new Car("Brand20", 20)));
        assertFalse(carSet.contains(new Car("FMF", 56)));
    }

    @Test
    public void checkSize() {
        assertEquals(100, carSet.size());
    }

    @Test
    public void whenAddedSomeSameElementsThenAddedOnlyOne() {
        Car car1 = new Car("BMW", 1);
        Car car2 = new Car("BMW", 1);
        assertTrue(carSet.add(car1));
        assertFalse(carSet.add(car2));
        assertEquals(101, carSet.size());
    }

    @Test
    public void whenRemoveOneElement() {
        Car car = new Car("Mers", 12);
        carSet.add(car);
        assertTrue(carSet.remove(car));
    }

    @Test
    public void whenRemoveDoesNotExistingElement() {
        Car car = new Car("does not exist", 4545);
        assertFalse(carSet.remove(car));
    }

    @Test
    public void checkClear() {
        carSet.clear();
        assertEquals(0, carSet.size());
    }
}
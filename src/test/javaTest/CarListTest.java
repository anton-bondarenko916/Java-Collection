package javaTest;
import javaCar.CarArrayList;
import org.junit.Before;
import org.junit.Test;

import javaCar.Car;
import javaCar.CarLinkedList;
import javaCar.CarList;

import static org.junit.Assert.*;

public class CarListTest {

    CarList<Car> carList;
    @Before
    public void setUp() throws Exception {
        carList =  new CarArrayList();
        for (int i = 0; i < 100; i++) {
            carList.add((new Car("Brand" + 0, i))); //Добавление 100 машин в список
        }
    }

    @Test
    public void findElementInList() {
        assertTrue(carList.contains(new Car("Brand0", 0)));
    }

    @Test
    public void whenAdded100ElementsThenSizeMustBe100() {
        assertEquals(100, carList.size()); //Проверка на добавление 100 машин
    }

    @Test
    public void whenElementRemovedByIndexThenSizeMustBeDecreased() { // Удаление по индексу -> уменьшение размера
        assertTrue(carList.removeAt(5));
        assertEquals(99, carList.size());
    }

    @Test
    public void whenElementRemovedThenSizeMustBeDecreased() {
        Car car = new Car("Toyota", 15);
        carList.add(car);
        assertEquals(101, carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size()); // Уменьшение размера при удалении
    }

    @Test
    public void whenNonExistentElementRemovedThenReturnFalse() {
        Car car = new Car("Toyota", 15);
        assertFalse(carList.remove(car)); // Удаление элемента, которого нет в списке
        assertEquals(100, carList.size());
    }

    @Test
    public void whenListClearedThenSizeMustBe0() {
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsThenThrownException() {
        carList.get(100);
    }

    @Test
    public void methodGetReturnedRightValue() {
        Car car = carList.get(0);
        assertEquals("Brand0", car.getBrand());
    }
    @Test
    public void insertInMiddle() {
        Car car = new Car("BMW", 1);
        carList.add(car, 50);
        assertEquals("BMW", carList.get(50).getBrand());
    }

    @Test
    public void insertIntoFirstPosition() {
        Car car = new Car("BMW", 1);
        carList.add(car, 1);
        assertEquals("BMW", carList.get(1).getBrand());
    }

    @Test
    public void insertIntoLastPosition() {
        Car car = new Car("BMW", 1);
        carList.add(car, 100);
        assertEquals("BMW", carList.get(100).getBrand());
    }
}
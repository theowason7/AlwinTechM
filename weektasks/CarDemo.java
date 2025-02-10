package weektasks;

public class CarDemo {
	 public static void main(String[] args) {
	        Car[] cars = new Car[2];
	        cars[0] = new Car("Toyota", "Camry", 2020);
	        cars[1] = new ElectricCar("Tesla", "Model S", 2023, 400);

	        for (Car car : cars) {
	            car.startEngine();
	        }
	    }

}

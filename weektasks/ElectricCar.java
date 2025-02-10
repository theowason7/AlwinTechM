package weektasks;

public class ElectricCar extends Car {
	private int batteryRange;

    public ElectricCar(String make, String model, int year, int batteryRange) {
        super(make, model, year);
        this.batteryRange = batteryRange;
    }

    public int getBatteryRange() {
        return batteryRange;
    }

    public void setBatteryRange(int batteryRange) {
        this.batteryRange = batteryRange;
    }

    public void chargeBattery() {
        System.out.println("The battery is being charged.");
    }

    @Override
    public void startEngine() {
        System.out.println("Electric engine started.");
    }
}

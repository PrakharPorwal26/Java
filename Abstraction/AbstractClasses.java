package Abstraction;

public class AbstractClasses {
    public static void main(String[] args) {
        // Car car = new Car(); can't create object of abstract class because it is incomplete, it has abstract methods which are not defined and hence we won't be able to call those methods. So we can't create object of abstract class.
        
        Car electricCar = new ElectricCar(); // we can create object of child class and assign it to parent class reference variable
        electricCar.start();
        electricCar.accelerate();
        electricCar.brake();

        Car fuelCar = new FuelCar();
        fuelCar.start();    
        fuelCar.accelerate();
        fuelCar.brake();
    }
}

abstract class Car{
    void start(){
        System.out.println("Car is starting");
    }

    abstract void accelerate(); //declaration, definition is in the child class
    abstract void brake(); //declaration, definition is in the child class
}
class ElectricCar extends Car{
    @Override //annotation to indicate that we are overriding the method from the parent class
    void accelerate() {
        System.out.println("Electric car is accelerating");
    }
    void brake() {
        System.out.println("Electric car is braking");
    }
}
class FuelCar extends Car{
    @Override
    void accelerate() {
        System.out.println("Fuel car is accelerating");
    }
    void brake() {
        System.out.println("Fuel car is braking");
    }
}
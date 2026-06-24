package Abstraction;
public class Interfaces {
    public static void main(String[] args) {
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

interface Car{
    void start();
    void accelerate();
    void brake();
}
class ElectricCar implements Car{ //using implements keyword to implement the interface instead of extends keyword which is used for abstract class
    @Override
    public void start() { //need to use public access modifier because interface methods are public by default and we can't reduce the visibility of the inherited method
        System.out.println("Electric car is starting");
    }

    @Override
    public void accelerate() {
        System.out.println("Electric car is accelerating");
    }

    @Override
    public void brake() {
        System.out.println("Electric car is braking");
    }
}
class FuelCar implements Car{
    @Override
    public void start(){
        System.out.println("Fuel car is starting");
    }
    @Override
    public void accelerate() {
        System.out.println("Fuel car is accelerating");
    }
    @Override
    public void brake() {
        System.out.println("Fuel car is braking");
    }
}
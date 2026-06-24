package Polymorphism;

public class RunTimePolymorphism {
    public static void main(String[] args) {
        //run method is called based on the object type, which is determined at runtime because object creation is done at runtime. Hence, this is called runtime polymorphism. This is achieved using method overriding.
        Run human = new Human(); 
        human.run(); // human run method is called

        Run dog = new Dog();
        dog.run(); // dog run method is called

        Run cat = new Cat();
        cat.run(); // cat run method is called
    }
}

class Run{
    void run(){
        System.out.println("Running");
    }
}

class Human extends Run{
    @Override
    void run(){
        System.out.println("Human is running");
    }
}

class Dog extends Run{
    @Override
    void run(){
        System.out.println("Dog is running");
    }
}

class Cat extends Run{
    @Override
    void run(){
        System.out.println("Cat is running");
    }
}

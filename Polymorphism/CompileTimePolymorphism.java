package Polymorphism;

public class CompileTimePolymorphism {
    public static void main(String[] args) {
        Run run = new Run();
        //compile time polymorphism is achieved by method overloading, which is done by changing the number of parameters or changing the data type of parameters. In this case, we are changing the number of parameters.

        run.run(); //normal run method is called
        run.run(true); //run method with Boolean parameter is called

        //same object behaves differently based on the method signature, which is determined at compile time. Hence, this is called compile time polymorphism.
    }
}

class Run{
    void run(){
        System.out.println("Running");
    }
    void run(Boolean isDogBehind){
        if(isDogBehind){
            System.out.println("Running faster because dog is behind");
        }
    }
}

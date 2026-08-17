package Functional_Interfaces;
import java.util.function.*;
public class TyepsOfFunctionalInterfaces {
    public static void main(String[] args) {
        // There are 4 types of Functional Interfaces:

        // 1.Function Interface<T,R> T-> I/P, R->O/P
        Function<Integer,Integer> sqaure = x -> (x * x);
        System.out.println(sqaure.apply(5));

        //2.Consumer Interface<T> T->I/P, Returns no O/P
        Consumer<Integer> printValue = x -> System.out.println(x);
        printValue.accept(10);

        //3. Supplier Interface<T> No I/P, Returns O/P
        Supplier<Double> randomValue = () -> Math.random();
        randomValue.get();

        //4. Predicate Interface<T> T->I/P, O/P:Boolean
        Predicate<Integer> checkEven = x -> (x%2==0);
        System.out.println(checkEven.test(20));
    }

}

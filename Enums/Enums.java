package Enums;

public class Enums{
    public static void main(String[] args) {
        Direction d = Direction.NORTH;
        System.out.println(d); //prints NORTH
        System.out.println(d.getDegrees()); //prints 0
        d.move();

        //values()
        Direction[] directions = Direction.values();
        for(Direction dir: directions){
            System.out.println(dir.name());
        }

        //valueOf()
        Direction d2 = Direction.valueOf("SOUTH");
        System.out.println(d2); //prints SOUTH

        //name()
        System.out.println(d.name()); //prints NORTH

        //ordinal()
        System.out.println(d.ordinal()); //prints 0

        /*---Important methods of enum class---

        --> values() - returns an array of all enum constants in the order they are declared. Very useful for iterating over all enum constants. Compiler generated method, not present in Enum class.
        
        --> valueOf() - converts a string to the corresponding enum constant. Throws IllegalArgumentException if the string does not match any enum constant. Compiler generated method, not present in Enum class.

        --> name() - returns the name of the enum constant as a string. This method is present in Enum class. This method can't be overridden, this is the difference between name() and toString() method. toString() can be overridden, but name() can't be overridden.

        --> ordinal() - returns the position of the enum constant starting from 0. This method is present in Enum class.    
        */
    }
}

/*               NORTH(0, y+1)
                     |
                     |
WEST(270, x-1)<------|------->EAST(90, x+1)
                     |
                     |
                SOUTH(180, y-1)
*/


//Syntax of enum along with assigning values to enum constants along with a method which shows different behaviours for different enum constants --> abstract method can be used to achieve this. 
enum Direction{

    //to implement abstract method, we need to override it in each enum constant, just like anonymous class.
    NORTH(0){
        @Override
        public void move() {
            System.out.println("Moving North, y+1");
        }
    },
    SOUTH(180){
        @Override
        public void move() {
            System.out.println("Moving South, y-1");
        }
    },
    WEST(270){
        @Override
        public void move() {
            System.out.println("Moving West, x-1");
        }
    },
    EAST(90){
        @Override
        public void move() {
            System.out.println("Moving East, x+1");
        }
    };

    private int degrees;

    Direction(int degrees){
        this.degrees = degrees;
    }

    public int getDegrees(){
        return degrees;
    }
    
    //abstract method
    public abstract void move();
}

/*
Internally compiler generates this:

class Direction extends Enum<Direction>{
    public static final DIrection NORTH = new Direction(0);
    public static final DIrection SOUTH = new Direction(180);
    public static final DIrection WEST = new Direction(270);
    public static final DIrection EAST = new Direction(90);

    private int degrees;
    private Direction(int degrees){
        this.degrees = degrees;
    }
    public int getDegrees(){
        return degrees;
    }
}
*/
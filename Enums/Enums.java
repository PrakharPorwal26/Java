package Enums;

public class Enums{
    public static void main(String[] args) {
        Direction d = Direction.NORTH;
        System.out.println(d); //prints NORTH
        System.out.println(d.getDegrees()); //prints 0
    }
}

/*          NORTH(0)
                |
                |
WEST(270)<------|------->EAST(90)
                |
                |
            SOUTH(180)
*/


//Syntax of enum along with assigning values to enum constants
enum Direction{
    NORTH(0),
    SOUTH(180),
    WEST(270),
    EAST(90);

    private int degrees;

    Direction(int degrees){
        this.degrees = degrees;
    }

    public int getDegrees(){
        return degrees;
    }
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
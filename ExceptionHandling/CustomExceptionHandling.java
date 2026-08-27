package ExceptionHandling;

/*
 * Custom Exception
 *
 * We create a custom exception when the predefined exceptions
 * provided by Java do not accurately represent our business rule.
 *
 * Example:
 * Age less than 18 is not a Java error, but it may be
 * invalid according to our application's requirements.
 */

/*
 * To create a custom checked exception:
 *      Extend Exception class
 *
 * To create a custom unchecked exception:
 *      Extend RuntimeException class
 */
class InvalidAgeException extends Exception {

    /*
     * Constructor of the custom exception.
     *
     * super(message)
     * ----------------
     * Calls the constructor of the parent Exception class.
     *
     * The Exception class stores the error message internally.
     * Because of this, methods like getMessage() can later
     * retrieve and display that message.
     *
     * If we do not pass the message to the parent class,
     * getMessage() will return null.
     */
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomExceptionHandling {

    /*
     * Method that validates age.
     *
     * throws InvalidAgeException
     * --------------------------
     * Indicates that this method may throw
     * InvalidAgeException and the caller must
     * handle it or further propagate it.
     */
    public static void validateAge(int age)
            throws InvalidAgeException {

        if (age < 18) {

            /*
             * throw keyword
             * -------------
             * Used to explicitly create and throw
             * an exception object.
             */

            throw new InvalidAgeException(
                    "Age must be 18 or above to vote."
            );
        }

        System.out.println("Eligible to vote.");
    }

    public static void main(String[] args) {

        try {

            validateAge(15);

        } catch (InvalidAgeException e) {

            /*
             * getMessage()
             * ------------
             * Returns the message passed through
             * super(message) in the exception constructor.
             */

            System.out.println(
                    "Custom Exception Caught: "
                            + e.getMessage()
            );
        }

        System.out.println("Program continues...");
    }
}

/*
 * =====================================================
 * QUICK NOTES
 * =====================================================
 *
 * throw vs throws
 *
 * throw
 * -----
 * Used inside a method to explicitly throw
 * an exception object.
 *
 * Example:
 * throw new InvalidAgeException("Invalid Age");
 *
 *
 * throws
 * ------
 * Used in method signature to indicate that
 * the method may throw an exception.
 *
 * Example:
 * validateAge() throws InvalidAgeException
 *
 *
 * Why use super(message)?
 * -----------------------
 * To pass the custom error message to the
 * parent Exception class.
 *
 * This allows us to retrieve the message later
 * using getMessage().
 *
 *
 * Custom Checked Exception
 * ------------------------
 * class MyException extends Exception
 *
 * Compiler forces handling using
 * try-catch or throws.
 *
 *
 * Custom Unchecked Exception
 * --------------------------
 * class MyException extends RuntimeException
 *
 * Handling is optional.
 */
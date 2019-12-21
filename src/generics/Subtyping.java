package generics;

import common.Director;
import common.Employee;
import common.Manager;

public class Subtyping {
    public void play() {
        Manager manager = new Manager(4, "Pankaj Munjer", 48);
        Director director = new Director(5, "Anil Pathak", 55);


        Manager[] managers = new Manager[2];
        Employee[] employees = managers;

        employees[0] = manager;
        employees[1] = director;
        // This compiles fine, but will throw ArrayStoreException. This compiles because of concept of covariance in java.
        // Covariance with arrays means, an array T[] of type T can hold value of type 'T' or one of it' subtype. Also, an array S[] is subtype of T[], if and only if 'S' is subtype of 'T'
        // In above assignment, we are assigning director to Employee[] array, but that array is array of Manager[], therefore runtime exception

        for (Employee e :
                employees) {
            System.out.println(e);
        }
    }
}

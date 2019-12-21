package generics;

import common.Director;
import common.Employee;
import common.Manager;

import java.util.Comparator;
import java.util.List;

public class Playground {

    class ReverseComparator<T> implements Comparator<T> {
        private final Comparator<T> delegateComparator;

        ReverseComparator(Comparator<T> delegateComparator) {
            this.delegateComparator = delegateComparator;
        }

        @Override
        public int compare(T o1, T o2) {
            return -1 * delegateComparator.compare(o1, o2);
        }
    }

    public void play() {
        Employee e1 = new Employee(1, "Ashif", 25);
        Employee e2 = new Employee(2, "Nikita", 24);
        Employee e3 = new Employee(3, "Subho", 25);

//        List<Employee> employees = new ArrayList<>();
//        employees.add(e1);
//        employees.add(e2);
//        employees.add(e3);
//
//        Comparator<Employee> ageComparator = (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge());
//        Collections.sort(employees, new ReverseComparator<>(ageComparator));
//
//        Employee employee = min(employees, ageComparator);
//        System.out.println(employee);

        Manager manager = new Manager(4, "Pankaj", 48);
        Director director = new Director(5, "Anil Pathak", 55);


        Manager[] managers = new Manager[1];
        Employee[] employees = managers;

        employees[0] = director; // This compiles fine, but will throw ArrayStoreException. This compiles because of concept of covariance in java.
        // Covariance with arrays means, an array T[] of type T can hold value of type 'T' or one of it' subtype. Also, an array S[] is subtype of T[], if and only if 'S' is subtype of 'T'
        // In above assignment, we are assigning director to Employee[] array, but that array is array of Manager[], therefore runtime exception

        for (Employee e :
                employees) {
            System.out.println(e);
        }


    }


    /**
     * Generics on method
     *
     * @param list
     * @param comparator
     * @return
     */
    public <T> T min(List<T> list, Comparator<T> comparator) {
        return list.stream().min(comparator).get();
    }
}

package generics;

import common.Employee;

import java.util.ArrayList;
import java.util.Collections;
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
        Employee e2 = new Employee(2, "Nikita", 26);
        Employee e3 = new Employee(3, "Subho", 25);

        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

        Comparator<Employee> ageComparator = (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge());
        Collections.sort(employees, new ReverseComparator<>(ageComparator));

        System.out.println(employees);
    }
}

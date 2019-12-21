package generics;

import common.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MethodGenerics {
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

    public void play() {
        Employee e1 = new Employee(1, "Ashif", 25);
        Employee e2 = new Employee(2, "Nikita", 24);
        Employee e3 = new Employee(3, "Subho", 25);

        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

        Comparator<Employee> ageComparator = (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge());

        Employee employee = min(employees, ageComparator);
        System.out.println(employee);
    }
}

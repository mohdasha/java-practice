package generics;

import common.Director;
import common.Employee;
import common.Manager;

import java.util.ArrayList;
import java.util.List;

/**
 * Type of bounds using wildcard
 * 1. Upper Bound <? extends clazz>
 * 2. Lower Bound <? super clazz>
 * 3. Unbounded <?>
 */
public class WildcardExample {
    public void play() {
        List<Employee> employees = new ArrayList<>();

        Manager manager = new Manager(4, "Pankaj Munjer", 48);
        Director director = new Director(5, "Anil Pathak", 55);

        employees.add(manager);
        employees.add(director);

        saveAll(employees);

    }

    public void saveAll(List<? extends Employee> list) {
        for(Employee e: list) {
            System.out.println(e);
        }
    }
}

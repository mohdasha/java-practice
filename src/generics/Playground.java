package generics;

import common.Employee;

import java.util.*;

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
        Employee e3 = new Employee(3, "Subhojeet", 25);

        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

        Comparator<Employee> ageComparator = (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge());
        Collections.sort(employees, new ReverseComparator<>(ageComparator));

        Map<String, Employee> employeeMap = new HashMap<>();
        employeeMap.put("1", e1);
        employeeMap.put("2", e2);

        System.out.println(createListFromMap(employeeMap));
    }

    public <T, G> List<G> createListFromMap(Map<T, G> map) {
        List<G> list = new ArrayList<>();
        for (Map.Entry<T, G> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }

    public void playStack() {
        Stack<String> stringStack = new Stack<>();

        stringStack.push("Hello");
        stringStack.push("World");

        System.out.println(stringStack.pop());
    }
}

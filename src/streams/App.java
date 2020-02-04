package streams;

import common.Employee;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Streams consists of following:
 * 1. Stream
 * 2. Intermediary Operations
 * 3. Terminal Operation
 * <p>
 * - Stream without terminal operation is no-op. It'll not perform any operation and also it do not hold any stream data.
 * - Stream API is fluent. That means, multiple operation calls can be chained into a single expression. Also multiple pipelines can also be chained in single expression.
 * - By Default Stream runs sequentially. Running stream parallely requires invoking "parallel" method on stream, but it is seldom appropriate to do so.
 */
public class App {

    private static Logger LOGGER = Logger.getLogger("App Logger");

    @FunctionalInterface
    interface A<T> {
        public T apply(T a);
    }

    public void printAnagramGroupWithSize(int size) throws IOException {
        File file = new File("C:\\Users\\alima\\words.txt");

        try (Stream<String> words = Files.lines(file.toPath())) {
            words.collect(Collectors.groupingBy(word -> alphabetize(word))).values().stream()
                    .filter(group -> group.size() >= size)
                    .forEach(g -> System.out.println(g.size() + ": " + g));
        }
    }

    public static <T> void playWithStream(List<T> list) {
        List<T> toList = list.stream().collect(Collectors.toList());
        LOGGER.info(toList.getClass() + ": " + toList);

        Set<T> toSet = list.stream().collect(Collectors.toSet());
        LOGGER.info(toSet.getClass() + ": " + toSet);

        Collection<T> toCollection = list.stream().collect(Collectors.toCollection(LinkedHashSet::new));
        LOGGER.info(toCollection.getClass() + ": " + toCollection);

        Map<T, Integer> map = list.stream()
                .collect(Collectors.toMap((a) -> a, b -> b.toString().length()));
        LOGGER.info(map.getClass() + ": " + map);
    }

    private static String alphabetize(String word) {
        char[] a = word.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }

    public static void playWithGroups() throws IOException, ParseException {
        File file = new File("resources\\employee-data.csv");

        try (Stream<String> employee = Files.lines(file.toPath())) {
            employee.map(App::transform)
                    .collect(Collectors.groupingBy(employee1 -> employee1.getAge()))
                    .values().stream()
//                    .forEach(group -> System.out.println("Age: "+group.get(0).getAge()+", Total Members: "+group.size()));
                    .filter(group -> group.size() >= 25)
                    .forEach(g -> LOGGER.info(g.toString()));
        }
    }

    public static Employee transform(String data) {
        Employee employee = new Employee();
        try {
            String[] d = data.split(",");
            //id,gender,bdate,educ,jobcat,salary,salbegin,jobtime,prevexp,minority
            //1,m,3-Feb-1952,15,3,"$57,000","$27,000",98,144,0
            employee.setEmpId(Integer.valueOf(d[0]));

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
            LocalDate date = LocalDate.parse(d[2], formatter);
            LocalDate now = LocalDate.now();

            employee.setAge(Period.between(date, now).getYears());
            employee.setSalary(Double.valueOf(d[5]));

        } catch (Exception e) {
            LOGGER.info("Exception: " + e.getMessage());
        }
        return employee;
    }

    public static void main(String[] args) throws Exception {
//        new App().printAnagramGroupWithSize(10);
        List<String> list = Arrays.asList("a", "ab", "cd", "dce", "efg");

        System.out.println(list.hashCode());

//        playWithStream(list);

        playWithGroups();
    }
}

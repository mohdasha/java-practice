package lambdas;

public class App {
    public static void main(String[] args) {


        EldestEntryRemovalFunction<String, String> eldestEntryRemovalFunction = (map, entry) -> map.size() > 100;


    }
}

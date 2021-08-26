import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Locations locations = new Locations();
    private static Map<String, String> vocabulary = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("EAST", "E");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");

        Location currentLocation = locations.getLocation(1);
        while (true) {
            System.out.println(currentLocation.getDescription());
            if (currentLocation.getLocationID() == 0) {
                break;
            }

            Map<String, Integer> exists = currentLocation.getExits();
            System.out.print("Available exits are ");
            for (String exit : exists.keySet()) {
                System.out.print(exit + ", ");
            }

            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            if (direction.length() > 1) {
                String[] words = direction.split(" ");
                for (String word : words) {
                    if (vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }

            if (exists.containsKey(direction)) {
                currentLocation = locations.getLocation(exists.get(direction));
            } else {
                System.out.println("You cannot go in that direction");
            }
        }

        locations.close();
    }
}

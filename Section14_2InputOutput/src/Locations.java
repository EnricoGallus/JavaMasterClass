import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {

    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        try (BufferedWriter locationWriter = new BufferedWriter(new FileWriter("Section14_2InputOutput/locations.txt"));
             BufferedWriter directionWriter = new BufferedWriter(new FileWriter("Section14_2InputOutput/directions.txt"))) {
            for (Location location: locations.values()) {
                locationWriter.write(location.getLocationID() + "," + location.getDescription() + "\n");
                for (String direction: location.getExits().keySet()) {
                    if (!direction.equalsIgnoreCase("Q")) {
                        directionWriter.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                    }
                }
            }
        }
    }

    static {
        try(Scanner locationReader = new Scanner(new BufferedReader(new FileReader("Section14_2InputOutput/locations_big.txt"))).useDelimiter(",");
            Scanner directionReader = new Scanner(new BufferedReader(new FileReader("Section14_2InputOutput/directions_big.txt"))).useDelimiter(",")) {
            while (locationReader.hasNextLine()) {
                int location = locationReader.nextInt();
                locationReader.skip(locationReader.delimiter());
                String description = locationReader.nextLine();
                System.out.println("Imported loc:" + location + ": " + description);
                locations.put(location, new Location(location, description));
            }

            while (directionReader.hasNextLine()) {
                String[] data = directionReader.nextLine().split(",");
                int location = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);
                System.out.println("Imported exit for location: " + location + ": " + direction + ": " + destination);
                Location targetLocation = locations.get(location);
                targetLocation.addExit(direction, destination);
            }
        } catch (IOException e) {
            throw new RuntimeException("reading location/direction files failed");
        }
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {
        locations.putAll(m);
    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}

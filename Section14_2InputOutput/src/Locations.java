import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Locations implements Map<Integer, Location> {

    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) throws IOException {
        try (FileWriter locationFile = new FileWriter("Section14_2InputOutput/locations.txt");
             FileWriter directionFile = new FileWriter("Section14_2InputOutput/directions.txt")) {
            for (Location location: locations.values()) {
                locationFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
                for (String direction: location.getExits().keySet()) {
                    directionFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                }
            }
        }
        /*FileWriter locationFile = null;
        try {
            locationFile = new FileWriter("Section14_2InputOutput/location.txt");
            for (Location location : locations.values()) {
                locationFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
            }
        } finally {
            System.out.println("In finally block");
            if (locationFile != null) {
                System.out.println("Attempting to close locationFile");
                locationFile.close();
            }
        }*/
    }

    static {
        try(Scanner locationScanner = new Scanner(new BufferedReader(new FileReader("Section14_2InputOutput/locations_big.txt"))).useDelimiter(",");
            Scanner directionScanner = new Scanner(new BufferedReader(new FileReader("Section14_2InputOutput/directions_big.txt"))).useDelimiter(",")) {
            while (locationScanner.hasNextLine()) {
                int location = locationScanner.nextInt();
                locationScanner.skip(locationScanner.delimiter());
                String description = locationScanner.nextLine();
                System.out.println("Imported loc:" + location + ": " + description);
                locations.put(location, new Location(location, description));
            }

            while (directionScanner.hasNextLine()) {
                String input = directionScanner.nextLine();
                String[] data = input.split(",");
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

        /*Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader("Section14_2InputOutput/locations_big.txt"));
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                int location = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                System.out.println("Imported loc:" + location + ": " + description);
                locations.put(location, new Location(location, description));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        try {
            scanner = new Scanner(new BufferedReader(new FileReader("Section14_2InputOutput/directions_big.txt")));
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                *//*int location = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String direction = scanner.next();
                scanner.skip(scanner.delimiter());
                String dest = scanner.nextLine();
                int destination = Integer.parseInt(dest);*//*
                String input = scanner.nextLine();
                String[] data = input.split(",");
                int location = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);
                System.out.println("Imported exit for location: " + location + ": " + direction + ": " + destination);
                Location targetLocation = locations.get(location);
                targetLocation.addExit(direction, destination);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }*/

        /*locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));

        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);

        locations.get(2).addExit("N", 5);

        locations.get(3).addExit("W", 1);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);*/
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

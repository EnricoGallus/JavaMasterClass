import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Locations implements Map<Integer, Location> {

    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        Path locPath = FileSystems.getDefault().getPath("Section14_4NIO/locations.dat");
        try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(locPath)))) {
            for (Location location : locations.values()) {
                locFile.writeObject(location);
            }
        }

        /*Path locPath = FileSystems.getDefault().getPath("Section14_4NIO/locations_big.txt");
        Path dirPath = FileSystems.getDefault().getPath("Section14_4NIO/directions_big.txt");
        try (BufferedWriter locFile = Files.newBufferedWriter(locPath);
             BufferedWriter dirFile = Files.newBufferedWriter(dirPath)) {
            for (Location location : locations.values()) {
                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
                for (String direction : location.getExits().keySet()) {
                    if (!direction.equalsIgnoreCase("Q")) {
                        dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        }*/
    }

    static {
        Path locPath = FileSystems.getDefault().getPath("Section14_4NIO/locations.dat");
        try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(locPath)))) {
            boolean eof = false;
            while (!eof) {
                try {
                    Location location = (Location)locFile.readObject();
                    locations.put(location.getLocationID(), location);
                } catch (EOFException e) {
                    eof = true;
                }
            }
        } catch (InvalidClassException ex) {
            System.out.println("InvalidCastException: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException: " + ex.getMessage());
        }

        /*Path locPath = FileSystems.getDefault().getPath("Section14_4NIO/locations_big.txt");
        Path dirPath = FileSystems.getDefault().getPath("Section14_4NIO/directions_big.txt");
        try (Scanner scanner = new Scanner(Files.newBufferedReader(locPath))) {
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                int locationId = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                System.out.println("Imported loc: " + locationId + ": " + description);
                locations.put(locationId, new Location(locationId, description, null));
            }

        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        }

        try (BufferedReader dirFile = Files.newBufferedReader(dirPath)) {
            String input;
            while ((input = dirFile.readLine()) != null) {
                String[] data = input.split(",");
                int locationId = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);
                locations.get(locationId).getExits().put(direction, destination);
                System.out.println(locationId + ": " + direction + ": " + destination);
            }
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        }*/
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

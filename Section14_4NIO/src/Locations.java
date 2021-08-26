import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Locations implements Map<Integer, Location> {

    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        Path locPath = FileSystems.getDefault().getPath("Section14_4NIO/locations_big.txt");
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
        }
    }

    static {
        try (ObjectInputStream locationFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("Section14_2InputOutput/locations.dat")))) {
            boolean eof = false;
            while (!eof) {
                try {
                    Location location = (Location) locationFile.readObject();
                    System.out.println("Read location" + location.getLocationID() + ": " + location.getDescription());
                    System.out.println("Found " + (location.getExits().size() - 1) + " exits");

                    locations.put(location.getLocationID(), location);
                } catch (EOFException e) {
                    eof = true;
                }
            }
        } catch (InvalidClassException e) {
            System.out.println("Invalid Class Exception " + e);
        } catch (IOException e) {
            System.out.println("IO Exception" + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found exception" + e);
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

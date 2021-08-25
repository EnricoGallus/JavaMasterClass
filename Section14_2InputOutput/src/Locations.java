import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {

    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        try (ObjectOutputStream locationFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Section14_2InputOutput/locations.dat")))) {
            for (Location location : locations.values()) {
                locationFile.writeObject(location);
            }
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

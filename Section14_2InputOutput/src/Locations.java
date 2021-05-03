import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {

    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        try (DataOutputStream locationFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Section14_2InputOutput/locations.dat")))) {
            for (Location location: locations.values()) {
                locationFile.writeInt(location.getLocationID());
                locationFile.writeUTF(location.getDescription());
                System.out.println("Writing location " + location.getLocationID() + " : " + location.getDescription());
                System.out.println("Writing " + (location.getExits().size() - 1) + " exits");
                locationFile.writeInt(location.getExits().size() - 1);
                for (String direction : location.getExits().keySet()) {
                    if (!direction.equalsIgnoreCase("Q")) {
                        System.out.println("\t\t" + direction + "," + location.getExits().get(direction));
                        locationFile.writeUTF(direction);
                        locationFile.writeInt(location.getExits().get(direction));
                    }
                }
            }
        }
    }

    static {
        try (DataInputStream locationFile = new DataInputStream(new BufferedInputStream(new FileInputStream("Section14_2InputOutput/locations.dat")))) {
            boolean eof = false;
            while (!eof) {
                try {
                    Map<String, Integer> exits = new LinkedHashMap<>();
                    int locationId = locationFile.readInt();
                    String description = locationFile.readUTF();
                    int numExits = locationFile.readInt();
                    System.out.println("Read location " + locationId + " : " + description);
                    System.out.println("Found " + numExits + " exits");
                    for (int i=0; i < numExits; i++) {
                        String direction = locationFile.readUTF();
                        int destination = locationFile.readInt();
                        exits.put(direction, destination);
                        System.out.println("\t\t" + direction + "," + destination);
                    }
                    locations.put(locationId, new Location(locationId, description, exits));
                } catch (EOFException e) {
                    eof = true;
                }
            }
        } catch (IOException ioException) {
            System.out.println("IO Exception " + ioException);
        }
        /*try(Scanner locationReader = new Scanner(new BufferedReader(new FileReader("Section14_2InputOutput/locations_big.txt"))).useDelimiter(",");
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

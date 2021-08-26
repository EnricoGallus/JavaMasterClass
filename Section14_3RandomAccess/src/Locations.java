import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {

    private static Map<Integer, Location> locations = new LinkedHashMap<>();
    private static Map<Integer, IndexRecord> index = new HashMap<>();
    private static RandomAccessFile ra;

    public static void main(String[] args) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile("Section14_3RandomAccess/locations_random.dat", "rwd")) {
            raf.writeInt(locations.size());
            int indexSize = locations.size() * 3 * Integer.BYTES;
            int locationStart = (int) (indexSize + raf.getFilePointer() + Integer.BYTES);
            raf.writeInt(locationStart);

            long indexStart = raf.getFilePointer();

            int startPointer = locationStart;
            raf.seek(startPointer);

            for (Location location : locations.values()) {
                raf.writeInt(location.getLocationID());
                raf.writeUTF(location.getDescription());
                StringBuilder builder = new StringBuilder();
                for (String direction: location.getExits().keySet()) {
                    if (!direction.equalsIgnoreCase("Q")){
                        builder.append(direction);
                        builder.append(",");
                        builder.append(location.getExits().get(direction));
                        builder.append(",");
                    }
                }

                raf.writeUTF(builder.toString());

                IndexRecord record = new IndexRecord(startPointer, (int)(raf.getFilePointer() - startPointer));
                index.put(location.getLocationID(), record);
                startPointer = (int) raf.getFilePointer();
            }

            raf.seek(indexStart);
            for (Entry<Integer, IndexRecord> locationRecord : index.entrySet()) {
                raf.writeInt(locationRecord.getKey());
                raf.writeInt(locationRecord.getValue().getStartByte());
                raf.writeInt(locationRecord.getValue().getLength());
            }
        }
    }

    static {
        try {
            ra = new RandomAccessFile("Section14_3RandomAccess/locations_random.dat", "rwd");
            int numLocations = ra.readInt();
            long locationsStartPoint = ra.readInt();
            while (ra.getFilePointer() < locationsStartPoint) {
                int locationId = ra.readInt();
                int locationStart = ra.readInt();
                int locationLength = ra.readInt();

                IndexRecord record = new IndexRecord(locationStart, locationLength);
                index.put(locationId, record);
            }

        } catch (IOException ex) {
            System.out.println("IOException in static initializer " + ex.getMessage());
        }
    }

    public Location getLocation(int locationId) throws IOException {
        IndexRecord record = index.get(locationId);
        ra.seek(record.getStartByte());
        int id = ra.readInt();
        String description = ra.readUTF();
        String exits = ra.readUTF();
        String[] exitPart = exits.split(",");

        Location location = new Location(locationId, description);
        if (locationId != 0) {
            for (int i=0; i<exitPart.length; i++) {
                String direction = exitPart[i];
                int destination = Integer.parseInt(exitPart[++i]);
                location.addExit(direction, destination);
            }
        }

        return location;
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

    public void close() throws IOException {
        ra.close();
    }
}

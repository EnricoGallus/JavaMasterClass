package challenge;

import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody {
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final Key key;

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.key = new Key(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Key getKey() {
        return key;
    }

    public boolean addSatellite(HeavenlyBody satellite) {
        return this.satellites.add(satellite);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    public static Key makeKey(String name, BodyTypes bodyType) {
        return new Key(name, bodyType);
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof HeavenlyBody)) {
            return false;
        }

        return this.key.equals(((HeavenlyBody) obj).getKey());
    }

    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        return this.key.toString() + ", " + orbitalPeriod;
    }

    public enum BodyTypes {
        PLANET,
        DWARF_PLANET,
        MOON
    }

    public static final class Key {
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }

            return other instanceof Key && this.name.equals(((Key) other).getName())
                    && this.bodyType == ((Key) other).getBodyType();
        }

        @Override
        public int hashCode() {
            return name.hashCode() + bodyType.hashCode() + 82;
        }

        @Override
        public String toString() {
            return name + ": " + bodyType.name();
        }
    }
}

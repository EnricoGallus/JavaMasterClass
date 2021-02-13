package game;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable {
    private String name;
    private int hitPoints;
    private int strength;

    public Monster(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public String toString() {
        return "Monster{name='" + name + "', hitPoints=" + hitPoints + ", strength = " + strength + "}";
    }

    @Override
    public List<String> write() {
        List<String> properties = new ArrayList<>();
        properties.add(name);
        properties.add(String.valueOf(hitPoints));
        properties.add(String.valueOf(strength));
        return properties;
    }

    @Override
    public void read(List<String> objects) {
        if (objects != null && objects.size() > 0) {
            this.name = objects.get(0);
            this.hitPoints = Integer.parseInt(objects.get(1));
            this.strength = Integer.parseInt(objects.get(2));
        }
    }
}

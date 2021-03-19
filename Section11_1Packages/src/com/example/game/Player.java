package com.example.game;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable {
    private String name;
    private String weapon;
    private int hitPoints;
    private int strength;

    public Player(String name, int hitPoints, int health) {
        this.name = name;
        this.weapon = "Sword";
        this.hitPoints = hitPoints;
        this.strength = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "Player{name='" + name + "', hitPoints=" + hitPoints + ", strength=" + strength + ", weapon='" + weapon + "'}";
    }

    @Override
    public List<String> write() {
        List<String> properties = new ArrayList<>();
        properties.add(name);
        properties.add(String.valueOf(hitPoints));
        properties.add(String.valueOf(strength));
        properties.add(weapon);
        return properties;
    }

    @Override
    public void read(List<String> objects) {
        if (objects != null && objects.size() > 0) {
            this.name = objects.get(0);
            this.hitPoints = Integer.parseInt(objects.get(1));
            this.strength = Integer.parseInt(objects.get(2));
            this.weapon = objects.get(3);
        }
    }
}

public class EnhancedPlayer {
    private String name;
    private int hitPoints = 100;
    private String weapon;

    public EnhancedPlayer(String name, int hitPoints, String weapon) {
        this.name = name;
        this.weapon = weapon;
        if (hitPoints > 0 && hitPoints <= 100) {
            this.hitPoints = hitPoints;
        }
    }

    public void loseHealth(int damage) {
        this.hitPoints -= damage;
        if (this.hitPoints <= 0) {
            System.out.println("Player knocked out");
            // reduce number of lives remaining for the player
        }
    }

    public int getHealth() {
        return hitPoints;
    }
}

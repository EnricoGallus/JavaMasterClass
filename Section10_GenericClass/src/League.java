import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League<T extends Player> {
    private List<Team<T>> teams = new ArrayList<>();
    private String name;

    public League(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addTeam(Team<T> team) {
        if (teams.contains(team)) {
            return false;
        } else {
            teams.add(team);
            return true;
        }
    }

    public void printLeague() {
        Collections.sort(teams);
        System.out.println("Ranking for League " + this.name);
        for (int i = 1; i <= teams.size(); i++) {
            Team<T> team = teams.get(i - 1);
            System.out.println(i + ". " + team.getName() + " points: " + team.ranking());
        }
    }
}

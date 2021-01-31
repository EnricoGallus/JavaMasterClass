public class Challenge {
    public static void main(String[] args) {
        int position = calculateHighScorePosition(1500);
        displayHighScorePosition("Carol", position);

        position = calculateHighScorePosition(1000);
        displayHighScorePosition("Alex", position);

        position = calculateHighScorePosition(900);
        displayHighScorePosition("Tom", position);

        position = calculateHighScorePosition(500);
        displayHighScorePosition("Gilbert", position);

        position = calculateHighScorePosition(400);
        displayHighScorePosition("Matthias", position);

        position = calculateHighScorePosition(100);
        displayHighScorePosition("Julia", position);

        position = calculateHighScorePosition(50);
        displayHighScorePosition("Looser", position);

    }

    private static void displayHighScorePosition(String name, int position) {
        System.out.println(name + " managed to get into position " + position + " on the high score table");
    }

    private static int calculateHighScorePosition(int score) {
        /*if (score >= 1000) {
            return 1;
        } else if (score >= 500) {
            return 2;
        } else if (score >= 100) {
            return 3;
        } else {
            return 4;
        }*/

        int position = 4;
        if (score >= 1000) {
            position = 1;
        } else if (score >= 500) {
            position = 2;
        } else if (score >= 100) {
            position = 3;
        }

        return position;
    }
}

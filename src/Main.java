import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Team team1 = new Team(1, "Cortinas");
        Team team2 = new Team(2, "Parmera");
        Team team3 = new Team(3, "Flamingo");
        Team team4 = new Team(4, "Tirafogo");
        Team [] teams = new Team [] {team1, team2, team3, team4};
        season(teams);
    }

    public static void season (Team[] teams) {
        for (int i = 0; i < teams.length; i++) {
            for (int j = i + 1; j < teams.length; j++) {
                game(teams[i], teams[j]);
            }
        }
        System.out.println("A temporada acabou!");
        System.out.println("O ranking dos times é:");
        for (int i = 0; i < teams.length; i++) {
            for (int j = i + 1; j < teams.length; j++) {
                if (teams[i].getWins() < teams[j].getWins()) {
                    Team aux = teams[i];
                    teams[i] = teams[j];
                    teams[j] = aux;
                } else if (teams[i].getWins() == teams[j].getWins()) {
                    if (teams[i].getGoals() < teams[j].getGoals()) {
                        Team aux = teams[i];
                        teams[i] = teams[j];
                        teams[j] = aux;
                    }
                }
            }
        }

        for (int i = 0; i < teams.length; i++) {
            System.out.println((i + 1) + "º " + teams[i].getNome() + " com " + teams[i].getWins() + " vitórias e " + teams[i].getGoals() + " gols.");
        }

    }
    public static void game (Team team1, Team team2)    {
        Random random = new Random();
        boolean isCold = random.nextBoolean();
        int goals1 = 0;
        int goals2 = 0;
        for (int i = 0; i < 3; i++) {
            if (isCold) {
                goals1 += random.nextInt(2);
                goals2 += random.nextInt(2);
            } else {
                goals1 += random.nextInt(4);
                goals2 += random.nextInt(4);
            }
        }
        if (goals1 > goals2) {
            team1.addWin();
            team2.addLoss();
        } else if (goals2 > goals1) {
            team2.addWin();
            team1.addLoss();
        } else {
            team1.addWithdraw();
            team2.addWithdraw();
        }
        team1.addGoals(goals1);
        team2.addGoals(goals2);
        team1.addGoalsTaken(goals2);
        team2.addGoalsTaken(goals1);
        System.out.println("O time " + team1.getNome() + " fez " + goals1 + " gols e o time " + team2.getNome() + " fez " + goals2 + " gols.");

    }
}
import java.util.*;
public class Team {
    String name;
    Double fieldGoalPercentage;
    Double threePointPercentage;
    Double freeThrowPercentage;

    ArrayList<Player> playersOnTeam = new ArrayList<>();

    Double totalPointsDuringMatch;
    boolean didWin;

    public Team(String teamName) {
        this.name = teamName;
        this.totalPointsDuringMatch = 0.0;
        this.didWin = false;
    }

    public void addPlayers(Player player1, Player player2, Player player3, Player player4, Player player5) {
        this.playersOnTeam.add(player1);
        this.playersOnTeam.add(player2);
        this.playersOnTeam.add(player3);
        this.playersOnTeam.add(player4);
        this.playersOnTeam.add(player5);

        Double FGP = 0.0;
        Double TPP = 0.0;
        Double FTP = 0.0;

        for (int i = 0; i < this.playersOnTeam.size(); i++) {
            FGP += this.playersOnTeam.get(i).fieldGoalPercentage * .2;
            TPP += this.playersOnTeam.get(i).threePointPercentage * .2;
            FTP += this.playersOnTeam.get(i).freeThrowPercentage * .2;
        }

        this.fieldGoalPercentage = FGP;
        this.threePointPercentage = TPP;
        this.freeThrowPercentage = FTP;

    }

    public void addPlayers(ArrayList<Player> players) {

        this.playersOnTeam.addAll(players);

        Double FGP = 0.0;
        Double TPP = 0.0;
        Double FTP = 0.0;

        for (int i = 0; i < this.playersOnTeam.size(); i++) {
            FGP += this.playersOnTeam.get(i).fieldGoalPercentage * .2;
            TPP += this.playersOnTeam.get(i).threePointPercentage * .2;
            FTP += this.playersOnTeam.get(i).freeThrowPercentage * .2;
        }

        this.fieldGoalPercentage = FGP;
        this.threePointPercentage = TPP;
        this.freeThrowPercentage = FTP;
    }

    public void teamScore() {
        for (int iTPP = 0; iTPP < 4; iTPP++){
            if (randomInt() <= (this.threePointPercentage * 100)) {
                this.totalPointsDuringMatch += 3;
            }
        }

        for (int iFGP = 0; iFGP < 4; iFGP++) {
            if (randomInt() <= (this.fieldGoalPercentage * 100)) {
                this.totalPointsDuringMatch += 2;
            }
        }

        for (int iFTP = 0; iFTP < 4; iFTP++) {
            if (randomInt() <= (this.freeThrowPercentage * 100)) {
                this.totalPointsDuringMatch += 1;
            }
        }
    }

    public int randomInt() {
        int result = (int)(Math.random() * (100 - 1 + 1)) + 1;
        return result;
    }

    public void resetTeamScore() {
        this.totalPointsDuringMatch = 0.0;
    }


}

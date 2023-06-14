import java.util.*;

public class Bracket {
    HashMap<Integer, Team> bracketPositions = new HashMap<>();
    HashMap<Integer, Team> finalsBracketPositions = new HashMap<>();

    public Bracket(ArrayList<Team> teams) {
        for (int i = 0; i < teams.size(); i++) {
            this.bracketPositions.put(i+1, teams.get(i));
        }
    }

    public Team firstRoundOfSemiFinals() {
        this.bracketPositions.get(1).teamScore();
        this.bracketPositions.get(2).teamScore();
        System.out.println("The " + this.bracketPositions.get(1).name + " scored " + this.bracketPositions.get(1).totalPointsDuringMatch);
        System.out.println("The " + this.bracketPositions.get(2).name + " scored " + this.bracketPositions.get(2).totalPointsDuringMatch);
        System.out.println("======================");
        if (this.bracketPositions.get(1).totalPointsDuringMatch > this.bracketPositions.get(2).totalPointsDuringMatch) {
            this.bracketPositions.get(1).didWin = true;
            System.out.println("The " + bracketPositions.get(1).name + " emerged victorious over " + bracketPositions.get(2).name + "!");
            return this.bracketPositions.get(1);
        } else {
            this.bracketPositions.get(2).didWin = true;
            System.out.println("The " + bracketPositions.get(2).name + " emerged victorious over " + bracketPositions.get(1).name + "!");
            return this.bracketPositions.get(2);
        }

    }

    public Team secondRoundOfSemiFinals() {
        this.bracketPositions.get(3).teamScore();
        this.bracketPositions.get(4).teamScore();
        System.out.println("The " + this.bracketPositions.get(3).name + " scored " + this.bracketPositions.get(3).totalPointsDuringMatch);
        System.out.println("The " + this.bracketPositions.get(4).name + " scored " + this.bracketPositions.get(4).totalPointsDuringMatch);
        System.out.println("======================");
        if (this.bracketPositions.get(3).totalPointsDuringMatch > this.bracketPositions.get(4).totalPointsDuringMatch) {
            this.bracketPositions.get(3).didWin = true;
            System.out.println("The " + bracketPositions.get(3).name + " emerged victorious over " + bracketPositions.get(4).name + "!");
            return this.bracketPositions.get(3);
        } else {
            this.bracketPositions.get(4).didWin = true;
            System.out.println("The " + bracketPositions.get(4).name + " emerged victorious over " + bracketPositions.get(3).name + "!");
            return this.bracketPositions.get(4);
        }
    }

    public void printSemiFinalResults(Team team1, Team team2) {
        System.out.println("The final match is " + team1.name + " vs. " + team2.name);
    }


    public void setUpFinals() {
        int index = 1;
        for (int i = 1; i < 5; i++) {
            if (this.bracketPositions.get(i).didWin) {
                this.bracketPositions.get(i).didWin = false;
                this.bracketPositions.get(i).resetTeamScore();
                this.finalsBracketPositions.put(index, this.bracketPositions.get(i));
                index ++;
            }
        }
    }

    public Team finals() {
        this.finalsBracketPositions.get(1).teamScore();
        this.finalsBracketPositions.get(2).teamScore();
        System.out.println("The " + this.finalsBracketPositions.get(1).name + " scored " + this.finalsBracketPositions.get(1).totalPointsDuringMatch);
        System.out.println("The " + this.finalsBracketPositions.get(2).name + " scored " + this.finalsBracketPositions.get(2).totalPointsDuringMatch);
        System.out.println("======================");

        if (this.finalsBracketPositions.get(1).totalPointsDuringMatch > this.finalsBracketPositions.get(2).totalPointsDuringMatch) {
            System.out.println("The winner of this tournament is " + this.finalsBracketPositions.get(1).name + "!");
            return this.finalsBracketPositions.get(1);
        } else {
            System.out.println("The winner of this tournament is " + this.finalsBracketPositions.get(2).name + "!");
            return this.finalsBracketPositions.get(2);
        }

    }

    public void printOriginalBracket() {
        System.out.println("The semi finals match ups are: ");
        System.out.println(this.bracketPositions.get(1).name + " vs " + this.bracketPositions.get(2).name);
        System.out.println("And");
        System.out.println(this.bracketPositions.get(3).name + " vs " + this.bracketPositions.get(4).name);
    }

    public void resetBracket() {
        this.bracketPositions.forEach((key, value) -> value.resetTeamScore());
    }



}


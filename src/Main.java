import java.util.*;

public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args){
        boolean playAgain = true;
        Team userPickedTeam;
        ArrayList<Player> players = createPlayers();
        Bracket bracket = createTeams(players);

        System.out.println("Let's play some bball.");
        System.out.println("When prompted pick which team you think is going to win from each match. ");
        System.out.println("Today's matchups are: ");
        System.out.println("");

        while (playAgain) {
            bracket.resetBracket();
            bracket.printOriginalBracket();

            System.out.println("=======================");
            userPickedTeam = userPickTeamRound1(scan, bracket);

            Team firstRoundWinner = bracket.firstRoundOfSemiFinals();

            if (userPickedTeam == firstRoundWinner) {
                System.out.println("You did it!");
            } else {
                System.out.println("You suck.");
            }

            System.out.println("=======================");
            userPickedTeam = userPickTeamRound2(scan, bracket);

            Team secondRoundWinner = bracket.secondRoundOfSemiFinals();

            if (userPickedTeam == secondRoundWinner) {
                System.out.println("You did it!");
            } else {
                System.out.println("You suck.");
            }


            bracket.printSemiFinalResults(firstRoundWinner, secondRoundWinner);

            bracket.setUpFinals();

            System.out.println("=======================");
            userPickedTeam = userPickTeamFinals(scan, bracket);

            Team finalsWinner = bracket.finals();

            if (userPickedTeam == finalsWinner) {
                System.out.println("You did it!");
            } else {
                System.out.println("You suck.");
            }

            System.out.println("=================");
            playAgain = userPlayAgain(scan);


        }



    }

    public static ArrayList<Player> createPlayers(){
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Kawhi", "Leonard", 0.545, 0.6, 0.882));
        players.add(new Player("Devin", "Booker", 0.585, 0.508, 0.866));
        players.add(new Player("Anthony", "Edwards", 0.482, 0.349, 0.846));
        players.add(new Player("Stephen", "Curry", 0.466, 0.363, 0.845));
        players.add(new Player("Nikola", "Jovic", 0.54, 0.466, 0.806));

        players.add(new Player("Trae", "Young", 0.403, 0.333, 0.86));
        players.add(new Player("Kevin", "Durant", 47.8, 0.333, 0.917));
        players.add(new Player("Jalen", "Brunson",0.474, 0.325, 0.912 ));
        players.add(new Player("De'Aaron", "Fox", 0.424, 0.333, 0.756));
        players.add(new Player("Jimmy", "Butler", 0.476, 0.356, 0.806));

        players.add(new Player("Jayson", "Tatum", 0.458, 0.323, 0.876));
        players.add(new Player("Jamal", "Murray", 0.476, 0.401, 0.926));
        players.add(new Player("Ja", "Morant", 0.425, 0.419, 0.769));
        players.add(new Player("Lebron", "James", 0.498, 0.264, 0.761));
        players.add(new Player("Khris", "Middleton", 0.465, 0.406, 0.867));

        players.add(new Player("Joel", "Embid", 0.431, 0.179, 0.905));
        players.add(new Player("Russell", "Westbrook", 0.41, 0.357, 0.88));
        players.add(new Player("Desmond", "Bane", 0.422, 0.32, 0.931));
        players.add(new Player("Mikal", "Bridges", 0.429, 0.4, 0.783));
        players.add(new Player("Giannis", "Antetokounmpo", 0.528, 0.0, 0.452));

        return players;

    }

    public static Bracket createTeams(ArrayList<Player> players) {
        Team team1 = new Team("Nuggets");
        Team team2 = new Team("Warriors");
        Team team3 = new Team("Celtics");
        Team team4 = new Team("Bulls");

        team1.addPlayers(players.get(1), players.get(2), players.get(3), players.get(4), players.get(5));
        team2.addPlayers(players.get(6), players.get(7), players.get(8), players.get(9), players.get(10));
        team3.addPlayers(players.get(11), players.get(12), players.get(13), players.get(14), players.get(15));
        team4.addPlayers(players.get(16), players.get(17), players.get(18), players.get(19), players.get(0));

        ArrayList<Team> teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

        return new Bracket(teams);

    }

    public static Team userPickTeamRound1(Scanner scan, Bracket bracket) {
        System.out.println("Who do you think will win the second battle? [1] " + bracket.bracketPositions.get(1).name + " OR [2] " + bracket.bracketPositions.get(2).name );
        String userResponse = scan.nextLine();
        while (!userResponse.equalsIgnoreCase("1") && !userResponse.equalsIgnoreCase(("2"))) {
            System.out.println("WRONG RESPONSE BRO");
            System.out.println("Who do you think will win the second battle? [1] " + bracket.bracketPositions.get(1).name + " OR [2] " + bracket.bracketPositions.get(2).name );
            userResponse = scan.nextLine();
        }

        if (userResponse.equalsIgnoreCase("1")) {
            return bracket.bracketPositions.get(1);
        } else {
            return bracket.bracketPositions.get(2);
        }
    }

    public static Team userPickTeamRound2(Scanner scan, Bracket bracket) {
        System.out.println("Who do you think will win the second battle? [1] " + bracket.bracketPositions.get(3).name + " OR [2] " + bracket.bracketPositions.get(4).name );
        String userResponse = scan.nextLine();
        while (!userResponse.equalsIgnoreCase("1") && !userResponse.equalsIgnoreCase(("2"))) {
            System.out.println("WRONG RESPONSE BRO");
            System.out.println("Who do you think will win the second battle? [1] " + bracket.bracketPositions.get(3).name + " OR [2] " + bracket.bracketPositions.get(4).name );
            userResponse = scan.nextLine();
        }

        if (userResponse.equalsIgnoreCase("1")) {
            return bracket.bracketPositions.get(3);
        } else {
            return bracket.bracketPositions.get(4);
        }
    }

    public static Team userPickTeamFinals(Scanner scan, Bracket bracket) {
        System.out.println("Who do you think will win the finals? [1] " + bracket.finalsBracketPositions.get(1).name + " OR [2] " + bracket.finalsBracketPositions.get(2).name);
        String userResponse = scan.nextLine();
        while (!userResponse.equalsIgnoreCase("1") && !userResponse.equalsIgnoreCase("2")) {
            System.out.println("WRONG RESPONSE BRO");
            System.out.println("Who do you think will win the finals? [1] " + bracket.finalsBracketPositions.get(1).name + " OR [2] " + bracket.finalsBracketPositions.get(2).name);
            userResponse = scan.nextLine();
        }

        if (userResponse.equalsIgnoreCase("1")) {
            return bracket.finalsBracketPositions.get(1);
        } else {
            return bracket.finalsBracketPositions.get(2);
        }
    }

    public static boolean userPlayAgain(Scanner scan) {
        System.out.println("Do you want to play again? [Y] or [N] > ");
        String userResponse = scan.nextLine();
        while (!userResponse.equalsIgnoreCase("Y") && !userResponse.equalsIgnoreCase("N")) {
            System.out.println("WRONG RESPONSE BRO");
            System.out.println("Do you want to play again? [Y] or [N] > ");
            userResponse = scan.nextLine();
        }

        if (userResponse.equalsIgnoreCase("Y")) {
            return true;
        } else {
            return false;
        }
    }




}

public class Player {
    String firstName;
    String lastName;
    Double fieldGoalPercentage;
    Double threePointPercentage;
    Double freeThrowPercentage;

    public Player(String firstName, String lastName, Double FGP, Double TPP, Double FTP) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fieldGoalPercentage = FGP;
        this.freeThrowPercentage = FTP;
        this.threePointPercentage = TPP;
    }
}


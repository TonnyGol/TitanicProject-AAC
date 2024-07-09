public class Passenger {
    private int passengerId;
    private boolean survived;
    private int pclass;
    private String name;
    private String sex;
    private double age;
    private int sibSp;
    private int parch;
    private String ticket;
    private double fare;
    private String cabin;
    private char embarked;

    public Passenger(int passengerId, boolean survived, int pclass,
                     String name, String sex, double age, int sibSp,
                     int parch, String ticket, double fare, String cabin, char embarked) {
        this.passengerId = passengerId;
        this.survived = survived;
        this.pclass = pclass;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.sibSp = sibSp;
        this.parch = parch;
        this.ticket = ticket;
        this.fare = fare;
        this.cabin = cabin;
        this.embarked = embarked;
    }


    public String getFormattedName(){
        String[] formattedNameParts = name.split("\\.");
        String[] lastNameParts = formattedNameParts[0].split(" ");

        return formattedNameParts[1] + " " + lastNameParts[0];
    }
}

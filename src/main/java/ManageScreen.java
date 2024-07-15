import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class ManageScreen extends JPanel {
    private JComboBox<String> classComboBox;
    private JComboBox<String> genderComboBox;
    private JComboBox<String> pierEmbarkComboBox;
    private JComboBox<String> sortedStatisticsBox;

    private JTextField rangeMinTextField;
    private JTextField rangeMaxTextField;
    private JTextField nameTextField;
    private JTextField sibSpTextField;
    private JTextField parchTextField;
    private JTextField ticketNumberTextField;
    private JTextField ticketMinCostTextField;
    private JTextField ticketMaxCostTextField;
    private JTextField cabinNumberTextField;
    private JTextArea groupStatistics;

    private JLabel filterResultLabel;

    private JButton statisticResultButton;
    private JButton filterButton;

    private Map<String, Float> classStatistics;
    private Map<String, Float> genderStatistics;
    private Map<String, Float> ageStatistics;
    private Map<String, Float> hasFamilyStatistics;
    private Map<String, Float> ticketCostStatistics;
    private Map<String, Float> pierEmbarkStatistics;

    private List<Passenger> passengers;

    private int fileCount = 1;


    public ManageScreen(int x, int y, int width, int height) {
        File file = new File(Constants.PATH_TO_DATA_FILE); //this is the path to the data file
        if (file.exists()) {
            this.setLayout(null);
            this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);
            JLabel classLabel = new JLabel("Passenger Class: ");
            classLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(classLabel);
            this.classComboBox = new JComboBox<>(Constants.PASSENGER_CLASS_OPTIONS);
            this.classComboBox.setBounds(classLabel.getX() + classLabel.getWidth() + 1, classLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(this.classComboBox);

            JLabel rangeLabel = new JLabel("NumRange-Min/Max: ");
            rangeLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y + Constants.LABEL_HEIGHT, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(rangeLabel);
            this.rangeMinTextField = new JTextField();
            this.rangeMinTextField = new JTextField();
            this.rangeMinTextField.setBounds(rangeLabel.getX() + rangeLabel.getWidth() + 1, rangeLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.rangeMinTextField.setEditable(true);
            this.rangeMinTextField.setVisible(true);
            this.rangeMinTextField.setFocusable(true);
            this.add(this.rangeMinTextField);
            this.rangeMaxTextField = new JTextField();
            this.rangeMaxTextField = new JTextField();
            this.rangeMaxTextField.setBounds(rangeLabel.getX() + rangeLabel.getWidth() * 2, rangeLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.rangeMaxTextField.setEditable(true);
            this.rangeMaxTextField.setVisible(true);
            this.rangeMaxTextField.setFocusable(true);
            this.add(this.rangeMaxTextField);

            JLabel nameLabel = new JLabel("Name: ");
            nameLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y + Constants.LABEL_HEIGHT * 2, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(nameLabel);
            this.nameTextField = new JTextField();
            this.nameTextField.setBounds(nameLabel.getX() + nameLabel.getWidth() + 1, nameLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.nameTextField.setEditable(true);
            this.nameTextField.setVisible(true);
            this.nameTextField.setFocusable(true);
            this.add(this.nameTextField);

            JLabel sexLabel = new JLabel("Gender: ");
            sexLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y + Constants.LABEL_HEIGHT * 3, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(sexLabel);
            this.genderComboBox = new JComboBox<>(Constants.PASSENGER_GENDER_OPTIONS);
            this.genderComboBox.setBounds(sexLabel.getX() + sexLabel.getWidth() + 1, sexLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(this.genderComboBox);

            JLabel sibSpLabel = new JLabel("Sibling Amount: ");
            sibSpLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y + Constants.LABEL_HEIGHT * 4, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(sibSpLabel);
            this.sibSpTextField = new JTextField();
            this.sibSpTextField.setBounds(sibSpLabel.getX() + sibSpLabel.getWidth() + 1, sibSpLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.sibSpTextField.setEditable(true);
            this.sibSpTextField.setVisible(true);
            this.sibSpTextField.setFocusable(true);
            this.add(this.sibSpTextField);

            JLabel parchLabel = new JLabel("Parch: ");
            parchLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y + Constants.LABEL_HEIGHT * 5, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(parchLabel);
            this.parchTextField = new JTextField();
            this.parchTextField.setBounds(parchLabel.getX() + parchLabel.getWidth() + 1, parchLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.parchTextField.setEditable(true);
            this.parchTextField.setVisible(true);
            this.parchTextField.setFocusable(true);
            this.add(this.parchTextField);

            JLabel ticketNumberLabel = new JLabel("Ticket Number: ");
            ticketNumberLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y + Constants.LABEL_HEIGHT * 6, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(ticketNumberLabel);
            this.ticketNumberTextField = new JTextField();
            this.ticketNumberTextField.setBounds(ticketNumberLabel.getX() + ticketNumberLabel.getWidth() + 1, ticketNumberLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.ticketNumberTextField.setEditable(true);
            this.ticketNumberTextField.setVisible(true);
            this.ticketNumberTextField.setFocusable(true);
            this.add(this.ticketNumberTextField);

            JLabel ticketCostLabel = new JLabel("Ticket Cost-Min/Max ");
            ticketCostLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y + Constants.LABEL_HEIGHT * 7, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(ticketCostLabel);
            this.ticketMinCostTextField = new JTextField();
            this.ticketMinCostTextField.setBounds(ticketCostLabel.getX() + ticketCostLabel.getWidth() + 1, ticketCostLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.ticketMinCostTextField.setEditable(true);
            this.ticketMinCostTextField.setVisible(true);
            this.ticketMinCostTextField.setFocusable(true);
            this.add(this.ticketMinCostTextField);

            this.ticketMaxCostTextField = new JTextField();
            this.ticketMaxCostTextField.setBounds(ticketCostLabel.getX() + ticketCostLabel.getWidth() * 2, ticketCostLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.ticketMaxCostTextField.setEditable(true);
            this.ticketMaxCostTextField.setVisible(true);
            this.ticketMaxCostTextField.setFocusable(true);
            this.add(this.ticketMaxCostTextField);

            JLabel cabinNumberLabel = new JLabel("Cabin Number: ");
            cabinNumberLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y + Constants.LABEL_HEIGHT * 8, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(cabinNumberLabel);
            this.cabinNumberTextField = new JTextField();
            this.cabinNumberTextField.setBounds(cabinNumberLabel.getX() + cabinNumberLabel.getWidth() + 1, cabinNumberLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.cabinNumberTextField.setEditable(true);
            this.cabinNumberTextField.setVisible(true);
            this.cabinNumberTextField.setFocusable(true);
            this.add(this.cabinNumberTextField);

            JLabel embarkedLabel = new JLabel("Pier Embarked: ");
            embarkedLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y + Constants.LABEL_HEIGHT * 9, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(embarkedLabel);
            this.pierEmbarkComboBox = new JComboBox<>(Constants.PASSENGER_PIER_EMBARK_OPTIONS);
            this.pierEmbarkComboBox.setBounds(embarkedLabel.getX() + embarkedLabel.getWidth() + 1, embarkedLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(this.pierEmbarkComboBox);

            this.filterButton = new JButton("Filter");
            this.filterButton.setBounds(x + Constants.MARGIN_FROM_LEFT + 100, y + Constants.LABEL_HEIGHT * 11, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(this.filterButton);

            this.filterResultLabel = new JLabel("");
            this.filterResultLabel.setBounds(x + Constants.MARGIN_FROM_LEFT + 25, y + Constants.LABEL_HEIGHT * 12, Constants.LABEL_WIDTH * 5, Constants.LABEL_HEIGHT);
            this.filterResultLabel.setFont(new Font("", Font.ITALIC, 16));
            this.filterResultLabel.setVisible(true);
            this.add(this.filterResultLabel);


            this.statisticResultButton = new JButton("Create Statistics File");
            this.statisticResultButton.setBounds(x + Constants.MARGIN_FROM_LEFT + 90, y + Constants.LABEL_HEIGHT * 13, Constants.LABEL_WIDTH * 2, Constants.LABEL_HEIGHT);
            this.statisticResultButton.setFont(new Font("Create Statistics File", Font.ITALIC, 15));
            this.statisticResultButton.setVisible(true);
            this.add(this.statisticResultButton);

            JLabel groupStatisticsBy = new JLabel("Group Statistics by ");
            groupStatisticsBy.setBounds(x + Constants.MARGIN_FROM_LEFT + 400, y + Constants.LABEL_HEIGHT * 12, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(groupStatisticsBy);
            this.sortedStatisticsBox = new JComboBox<>(Constants.SORTED_STATISTICS_OPTIONS);
            this.sortedStatisticsBox.setBounds(x + Constants.MARGIN_FROM_LEFT + 400, y + Constants.LABEL_HEIGHT * 13, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(this.sortedStatisticsBox);


            this.groupStatistics = new JTextArea();
            this.groupStatistics.setBounds(x + Constants.MARGIN_FROM_LEFT + 350, y + Constants.LABEL_HEIGHT * 15, Constants.COMBO_BOX_WIDTH * 5, Constants.COMBO_BOX_HEIGHT * 6);
            this.groupStatistics.setBackground(this.getBackground());
            this.groupStatistics.setFont(new Font("", Font.ITALIC, 17));
            this.groupStatistics.setVisible(true);
            this.add(this.groupStatistics);


            this.classStatistics = new HashMap<>();
            this.ageStatistics = new HashMap<>();
            this.hasFamilyStatistics = new HashMap<>();
            this.genderStatistics = new HashMap<>();
            this.ticketCostStatistics = new HashMap<>();
            this.pierEmbarkStatistics = new HashMap<>();

            readTitanicPassengerData(file);
            initialGroupStatistics();

            this.filterButton.addActionListener((e) -> filterPassengers());

            this.statisticResultButton.addActionListener((e) -> createStatisticsFile());
            this.sortedStatisticsBox.addActionListener((e) -> dataGrouping());
        }
    }

    public void readTitanicPassengerData(File file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            List<List<String>> records = new ArrayList<>(br.lines()
                    .map(line -> Arrays.asList(line.split(",")))
                    .toList());

            records.remove(0); // Line with no data for passenger Object.
            this.passengers = records
                    .stream()
                    .map(line -> {
                        int passengerId = Integer.parseInt(line.get(0));
                        boolean survived = line.get(1).equals("1");
                        int pclass = Integer.parseInt(line.get(2));
                        String passengerName = line.get(3) + " " + line.get(4);
                        passengerName = passengerName.substring(1, passengerName.length() - 1);
                        String sex = line.get(5);
                        double age = line.get(6).isEmpty() ? 0 : Double.parseDouble(line.get(6));
                        int sibSp = Integer.parseInt(line.get(7));
                        int parch = Integer.parseInt(line.get(8));
                        String ticket = line.get(9);
                        double fare = Double.parseDouble(line.get(10));
                        String cabin = line.get(11);
                        char embarked = line.get(12).charAt(0);

                        return new Passenger(passengerId, survived, pclass, passengerName, sex,
                                age, sibSp, parch, ticket, fare, cabin, embarked);
                    })
                    .toList();
        } catch (IOException ignored) {

        }
    }

    public void filterPassengers() {
        int minIdRange = this.rangeMinTextField.getText().isEmpty() ? -1 : Integer.parseInt(this.rangeMinTextField.getText());
        int maxIdRange = this.rangeMaxTextField.getText().isEmpty() ? -1 : Integer.parseInt(this.rangeMaxTextField.getText());
        String name = this.nameTextField.getText();
        String gender = Objects.requireNonNull(this.genderComboBox.getSelectedItem()).toString();
        int sibSp = this.sibSpTextField.getText().isEmpty() ? -1 : Integer.parseInt(this.sibSpTextField.getText());
        int parch = this.parchTextField.getText().isEmpty() ? -1 : Integer.parseInt(this.parchTextField.getText());
        String ticketString = this.ticketNumberTextField.getText();
        int minFare = this.ticketMinCostTextField.getText().isEmpty() ? -1 : Integer.parseInt(this.ticketMinCostTextField.getText());
        int maxFare = this.ticketMaxCostTextField.getText().isEmpty() ? -1 : Integer.parseInt(this.ticketMaxCostTextField.getText());
        String cabin = this.cabinNumberTextField.getText();
        char pier = Objects.requireNonNull(this.pierEmbarkComboBox.getSelectedItem()).toString().charAt(0);

        int survivedPassengers;

        List<Passenger> filteredPassenger =
                this.passengers
                        .stream()
                        .filter(passenger -> {
                            boolean toFilter = true;
                            if (minIdRange != -1) {
                                toFilter = passenger.getPassengerId() >= minIdRange;
                            }
                            if (maxIdRange != -1 && toFilter) {
                                toFilter = passenger.getPassengerId() <= maxIdRange;
                            }
                            if (!name.isEmpty() && toFilter) {
                                toFilter = passenger.getFormattedName().contains(name);
                            }
                            if (!gender.equals("All") && toFilter) {
                                toFilter = passenger.getSex().equals(gender);
                            }
                            if (sibSp != -1 && toFilter) {
                                toFilter = passenger.getSibSp() == (sibSp);
                            }
                            if (parch != -1 && toFilter) {
                                toFilter = passenger.getParch() == (parch);
                            }
                            if (!ticketString.isEmpty() && toFilter) {
                                toFilter = passenger.getTicket().contains(ticketString);
                            }
                            if (minFare != -1) {
                                toFilter = passenger.getFare() >= minFare;
                            }
                            if (maxFare != -1 && toFilter) {
                                toFilter = passenger.getFare() <= maxFare;
                            }
                            if (!cabin.isEmpty() && toFilter) {
                                toFilter = passenger.getCabin().contains(cabin);
                            }
                            if (pier != 'A' && toFilter) {
                                toFilter = passenger.getEmbarked() == pier;
                            }
                            return toFilter;
                        })
                        .sorted()
                        .toList();

        survivedPassengers = calculateSurvivedPassengers(filteredPassenger);

        writeLogFile(filteredPassenger);

        if (!filteredPassenger.isEmpty()) {
            String result = "Total Rows: " + filteredPassenger.size() + " (" + survivedPassengers + " survived, " + (filteredPassenger.size() - survivedPassengers) + " did not)";
            this.filterResultLabel.setText(result);
        } else {
            this.filterResultLabel.setText("No passengers found.");
        }
    }

    public int calculateSurvivedPassengers(List<Passenger> filteredPassenger) {
        return (int) filteredPassenger
                .stream()
                .filter(Passenger::isSurvived)
                .count();
    }

    public int getSurvivedCountInAgeRange(int min, int max, List<Passenger> allSurvivedPassengers){
        return (int) allSurvivedPassengers
                .stream()
                .filter(passenger -> passenger.getAge() >= min && passenger.getAge() <= max)
                .count();
    }

    public int getSurvivedInTicketRange(int min, int max, List<Passenger> allSurvivedPassengers){
        return (int) allSurvivedPassengers
                .stream()
                .filter(passenger -> passenger.getFare() >= min && passenger.getFare() <= max)
                .count();
    }

    public int getSurvivedByPier(char pier, List<Passenger> allSurvivedPassengers){
        return (int) allSurvivedPassengers
                .stream()
                .filter(passenger -> passenger.getEmbarked() == pier)
                .count();
    }

    public List<Passenger> getPassengersByAgeRange(int min, int max){
        return this.passengers
                .stream()
                .filter(passenger -> passenger.getAge() >= min && passenger.getAge() <= max)
                .toList();
    }

    public List<Passenger> getPassengersByFareRange(int min, int max){
        return this.passengers
                .stream()
                .filter(passenger -> passenger.getFare() >= min && passenger.getFare() <= max)
                .toList();
    }

    public List<Passenger> getPassengersByEmbarked(char embark){
        return this.passengers
                .stream()
                .filter(passenger -> passenger.getEmbarked() == embark)
                .toList();
    }

    public void writeLogFile(List<Passenger> filteredPassenger){
        try {
            //Data convert back to lines
            List<List<String>> filteredPassengersData = filteredPassenger
                    .stream()
                    .map(passenger -> {
                        List<String> line = new ArrayList<>();
                        line.add(String.valueOf(passenger.getPassengerId()));
                        line.add(passenger.isSurvived() ? "1" : "0");
                        line.add(String.valueOf(passenger.getPclass()));
                        line.add(passenger.getName());
                        line.add(passenger.getSex());
                        line.add(String.valueOf(passenger.getAge()));
                        line.add(String.valueOf(passenger.getSibSp()));
                        line.add(String.valueOf(passenger.getParch()));
                        line.add(String.valueOf(passenger.getTicket()));
                        line.add(String.valueOf(passenger.getFare()));
                        line.add(String.valueOf((passenger.getCabin())));
                        line.add(String.valueOf(passenger.getEmbarked()));
                        return line;
                    })
                    .toList();

            //Log file creation
            File savedSearch = new File(Constants.SAVED_SEARCH_FILE_PATH + this.fileCount + ".csv");
            fileCount++;
            System.out.println("created log file");
            FileWriter fileWriter = new FileWriter(savedSearch);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (List<String> line : filteredPassengersData) {
                try {
                    bufferedWriter.write(String.join(",", line));
                    bufferedWriter.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {

        }
    }

    public void createStatisticsFile() {

        try {
            //Stats calculation
            List<String> statisticsData = new ArrayList<>();

            statisticsData.add("Percentage survived by class");
            List<Passenger> firstClass = this.passengers
                    .stream()
                    .filter(passenger -> passenger.getPclass() == 1)
                    .toList();
            int firstClassSurvived = calculateSurvivedPassengers(firstClass);
            double firstClassSurvivedAvg = (double) firstClassSurvived /firstClass.size() ;
            statisticsData.add("1st class Avg: " + String.format("%.2f", firstClassSurvivedAvg*100) +"%");

            List<Passenger> secondClass = this.passengers
                    .stream()
                    .filter(passenger -> passenger.getPclass() == 2)
                    .toList();
            int secondClassSurvived = calculateSurvivedPassengers(secondClass);
            double secondClassSurvivedAvg = (double) secondClassSurvived/secondClass.size();
            statisticsData.add("2nd class Avg: " + String.format("%.2f", secondClassSurvivedAvg*100) +"%");

            List<Passenger> thirdClass = this.passengers
                    .stream()
                    .filter(passenger -> passenger.getPclass() == 3)
                    .toList();
            int thirdClassSurvived = calculateSurvivedPassengers(thirdClass);
            double thirdClassSurvivedAvg = (double) thirdClassSurvived/thirdClass.size();
            statisticsData.add("3rd class Avg: " + String.format("%.2f", thirdClassSurvivedAvg*100) +"%");

            statisticsData.add("--------------------------------");
            statisticsData.add("Percentage survived by gender");
            List<Passenger> malePassengers = this.passengers
                    .stream()
                    .filter(passenger -> passenger.getSex().equals("male"))
                    .toList();
            int malePassengersSurvived = calculateSurvivedPassengers(malePassengers);
            double malePassengersSurvivedAvg = (double) malePassengersSurvived/malePassengers.size();
            statisticsData.add("male Avg: " + String.format("%.2f", malePassengersSurvivedAvg*100) +"%");

            List<Passenger> femalePassengers = this.passengers
                    .stream()
                    .filter(passenger -> passenger.getSex().equals("female"))
                    .toList();
            int femalePassengersSurvived = calculateSurvivedPassengers(femalePassengers);
            double femalePassengersSurvivedAvg = (double) femalePassengersSurvived/femalePassengers.size();
            statisticsData.add("female Avg: " + String.format("%.2f", femalePassengersSurvivedAvg*100) +"%");

            statisticsData.add("--------------------------------");
            statisticsData.add("Percentage survived by age");
            List<Passenger> allSurvivedPassengers = this.passengers
                    .stream()
                    .filter(Passenger::isSurvived)
                    .toList();
            int ageOto10Survived = getSurvivedCountInAgeRange(0, 10, allSurvivedPassengers);
            List<Passenger> age0to10Passengers = getPassengersByAgeRange(0, 10);
            double ageOto10SurvivedAvg = (double) ageOto10Survived / age0to10Passengers.size();
            statisticsData.add("Age (0-10) Avg: " + String.format("%.2f", ageOto10SurvivedAvg*100) +"%");

            int age11to20Survived = getSurvivedCountInAgeRange(11, 20, allSurvivedPassengers);
            List<Passenger> age11to20Passengers = getPassengersByAgeRange(11, 20);
            double age11to20SurvivedAvg = (double) age11to20Survived / age11to20Passengers.size();
            statisticsData.add("Age (11-20) Avg: " + String.format("%.2f", age11to20SurvivedAvg*100) +"%");

            int age21to30Survived = getSurvivedCountInAgeRange(21, 30, allSurvivedPassengers);
            List<Passenger> age21to30Passengers = getPassengersByAgeRange(21, 30);
            double age21to30SurvivedAvg = (double) age21to30Survived / age21to30Passengers.size();
            statisticsData.add("Age (21-30) Avg: " + String.format("%.2f", age21to30SurvivedAvg*100) +"%");

            int age31to40Survived = getSurvivedCountInAgeRange(31, 40, allSurvivedPassengers);
            List<Passenger> age31to40Passengers = getPassengersByAgeRange(31, 40);
            double age31to40SurvivedAvg = (double) age31to40Survived / age31to40Passengers.size();
            statisticsData.add("Age (31-40) Avg: " + String.format("%.2f", age31to40SurvivedAvg*100) +"%");

            int age41to50Survived = getSurvivedCountInAgeRange(41, 50, allSurvivedPassengers);
            List<Passenger> age41to50Passengers = getPassengersByAgeRange(41, 50);
            double age41to50SurvivedAvg = (double) age41to50Survived / age41to50Passengers.size();
            statisticsData.add("Age (41-50) Avg: " + String.format("%.2f", age41to50SurvivedAvg*100) +"%");

            int age50PlusSurvived = getSurvivedCountInAgeRange(51, 120, allSurvivedPassengers);
            List<Passenger> age51to120Passengers = getPassengersByAgeRange(51, 120);
            double age50PlusSurvivedAvg = (double) age50PlusSurvived / age51to120Passengers.size();
            statisticsData.add("Age 50+ Avg: " + String.format("%.2f", age50PlusSurvivedAvg*100) +"%");

            statisticsData.add("--------------------------------");
            statisticsData.add("Percentage survived with family or without");
            List<Passenger> hasFamilyPassengers = this.passengers
                    .stream()
                    .filter(passenger -> passenger.getSibSp() + passenger.getParch() >= 1)
                    .toList();
            int hasFamilyPassengersSurvived = calculateSurvivedPassengers(hasFamilyPassengers);
            double hasFamilyPassengersSurvivedAvg = (double) hasFamilyPassengersSurvived / hasFamilyPassengers.size();
            statisticsData.add("Has family Avg: " + String.format("%.2f", hasFamilyPassengersSurvivedAvg*100) +"%");

            List<Passenger> hasNoFamilyPassengers = this.passengers
                    .stream()
                    .filter(passenger -> passenger.getSibSp() + passenger.getParch() == 0)
                    .toList();
            int hasNoFamilyPassengersSurvived = calculateSurvivedPassengers(hasNoFamilyPassengers);
            double hasNoFamilyPassengersSurvivedAvg = (double) hasNoFamilyPassengersSurvived / hasNoFamilyPassengers.size();
            statisticsData.add("Has no family Avg: " + String.format("%.2f", hasNoFamilyPassengersSurvivedAvg*100) +"%");

            statisticsData.add("--------------------------------");
            statisticsData.add("Percentage survived by ticket cost");
            int fare0to10Survived = getSurvivedInTicketRange(0, 10, allSurvivedPassengers);
            List<Passenger> fare0to10Passengers = getPassengersByFareRange(0, 10);
            double fare0to10SurvivedAvg = (double) fare0to10Survived / fare0to10Passengers.size();
            statisticsData.add("Fare (0-10) Avg: " + String.format("%.2f", fare0to10SurvivedAvg*100) +"%");

            int fare11to30Survived = getSurvivedInTicketRange(11, 30, allSurvivedPassengers);
            List<Passenger> fare11to30Passengers = getPassengersByFareRange(11, 30);
            double fare11to30SurvivedAvg = (double) fare11to30Survived / fare11to30Passengers.size();
            statisticsData.add("Fare (11-30) Avg: " + String.format("%.2f", fare11to30SurvivedAvg*100) +"%");

            int fare30PlusSurvived = getSurvivedInTicketRange(31, 1000000, allSurvivedPassengers);
            List<Passenger> fare30AndAbovePassengers = getPassengersByFareRange(30, 1000000);
            double fare30PlusSurvivedAvg = (double) fare30PlusSurvived / fare30AndAbovePassengers.size();
            statisticsData.add("Fare 30+ Avg: " + String.format("%.2f", fare30PlusSurvivedAvg*100) +"%");

            statisticsData.add("--------------------------------");
            statisticsData.add("Percentage survived by embarked pier");
            int embarkedCherbourgSurvived = getSurvivedByPier('C', allSurvivedPassengers);
            List<Passenger> embarkedFromCherbourgPassengers = getPassengersByEmbarked('C');
            double embarkedCherbourgSurvivedAvg = (double) embarkedCherbourgSurvived / embarkedFromCherbourgPassengers.size();
            statisticsData.add("Embarked Cherbourg Avg: " + String.format("%.2f", embarkedCherbourgSurvivedAvg*100) +"%");

            int embarkedQueenstownSurvived = getSurvivedByPier('Q', allSurvivedPassengers);
            List<Passenger> embarkedFromQueenstownPassengers = getPassengersByEmbarked('Q');
            double embarkedQueenstownSurvivedAvg = (double) embarkedQueenstownSurvived / embarkedFromQueenstownPassengers.size();
            statisticsData.add("Embarked Queenstown Avg: " + String.format("%.2f", embarkedQueenstownSurvivedAvg*100) +"%");

            int embarkedSouthamptonSurvived = getSurvivedByPier('S', allSurvivedPassengers);
            List<Passenger> embarkedFromSouthamptonPassengers = getPassengersByEmbarked('S');
            double embarkedSouthamptonSurvivedAvg = (double) embarkedSouthamptonSurvived / embarkedFromSouthamptonPassengers.size();
            statisticsData.add("Embarked Southampton Avg: " + String.format("%.2f", embarkedSouthamptonSurvivedAvg*100) +"%");


            //Statistics file creation
            File savedStatistics = new File(Constants.SAVED_STATISTICS_FILE_PATH);
            System.out.println("created statistics file");
            FileWriter fileWriter = new FileWriter(savedStatistics);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            // write to file
            for (String line : statisticsData) {
                try {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {

        }
    }

    public void initialGroupStatistics(){
        List<Passenger> firstClass = this.passengers
                .stream()
                .filter(passenger -> passenger.getPclass() == 1)
                .toList();
        this.classStatistics.put("1st Class", ((float) firstClass.size()/this.passengers.size())*100);
        List<Passenger> secondClass = this.passengers
                .stream()
                .filter(passenger -> passenger.getPclass() == 2)
                .toList();
        this.classStatistics.put("2nd Class", ((float)secondClass.size()/this.passengers.size())*100);
        List<Passenger> thirdClass = this.passengers
                .stream()
                .filter(passenger -> passenger.getPclass() == 3)
                .toList();
        this.classStatistics.put("3rd Class", ((float) thirdClass.size() / this.passengers.size())*100);
        this.classStatistics = sortMapByValue(this.classStatistics);


        List<Passenger> malePassengers = this.passengers
                .stream()
                .filter(passenger -> passenger.getSex().equals("male"))
                .toList();
        this.genderStatistics.put("Male" , ((float) malePassengers.size()/this.passengers.size())*100);
        List<Passenger> femalePassengers = this.passengers
                .stream()
                .filter(passenger -> passenger.getSex().equals("female"))
                .toList();
        this.genderStatistics.put("Female" , ((float) femalePassengers.size()/this.passengers.size())*100);
        this.genderStatistics = sortMapByValue(this.genderStatistics);


        List<Passenger> age0to10Passengers = getPassengersByAgeRange(0, 10);
        this.ageStatistics.put("0-10", ((float) age0to10Passengers.size()/this.passengers.size())*100);
        List<Passenger> age11to20Passengers = getPassengersByAgeRange(11, 20);
        this.ageStatistics.put("11-20", ((float) age11to20Passengers.size()/this.passengers.size())*100);
        List<Passenger> age21to30Passengers = getPassengersByAgeRange(21, 30);
        this.ageStatistics.put("21-30" , ((float) age21to30Passengers.size()/this.passengers.size())*100);
        List<Passenger> age31to40Passengers = getPassengersByAgeRange(31, 40);
        this.ageStatistics.put("31-40", ((float) age31to40Passengers.size()/this.passengers.size())*100);
        List<Passenger> age41to50Passengers = getPassengersByAgeRange(41, 50);
        this.ageStatistics.put("41-50", ((float) age41to50Passengers.size()/this.passengers.size())*100);
        List<Passenger> age51to120Passengers = getPassengersByAgeRange(51, 120);
        this.ageStatistics.put("50+", ((float) age51to120Passengers.size()/this.passengers.size())*100);
        this.ageStatistics = sortMapByValue(this.ageStatistics);


        List<Passenger> hasFamilyPassengers = this.passengers
                .stream()
                .filter(passenger -> passenger.getSibSp() + passenger.getParch() >= 1)
                .toList();
        this.hasFamilyStatistics.put("Has family", ((float) hasFamilyPassengers.size()/this.passengers.size())*100);
        List<Passenger> hasNoFamilyPassengers = this.passengers
                .stream()
                .filter(passenger -> passenger.getSibSp() + passenger.getParch() == 0)
                .toList();
        this.hasFamilyStatistics.put("No family", ((float) hasNoFamilyPassengers.size()/this.passengers.size())*100);
        this.hasFamilyStatistics = sortMapByValue(this.hasFamilyStatistics);


        List<Passenger> fare0to10Passengers = getPassengersByFareRange(0, 10);
        this.ticketCostStatistics.put("0-10", ((float) fare0to10Passengers.size()/this.passengers.size())*100);
        List<Passenger> fare11to30Passengers = getPassengersByFareRange(11, 30);
        this.ticketCostStatistics.put("11-30", ((float) fare11to30Passengers.size()/this.passengers.size())*100);
        List<Passenger> fare30AndAbovePassengers = getPassengersByFareRange(30, 1000000);
        this.ticketCostStatistics.put("30+", ((float) fare30AndAbovePassengers.size()/this.passengers.size())*100);
        this.ticketCostStatistics = sortMapByValue(this.ticketCostStatistics);


        List<Passenger> embarkedFromCherbourgPassengers = getPassengersByEmbarked('C');
        this.pierEmbarkStatistics.put("C", ((float) embarkedFromCherbourgPassengers.size()/this.passengers.size())*100);
        List<Passenger> embarkedFromQueenstownPassengers = getPassengersByEmbarked('Q');
        this.pierEmbarkStatistics.put("Q", ((float) embarkedFromQueenstownPassengers.size()/this.passengers.size())*100);
        List<Passenger> embarkedFromSouthamptonPassengers = getPassengersByEmbarked('S');
        this.pierEmbarkStatistics.put("S", ((float) embarkedFromSouthamptonPassengers.size()/this.passengers.size())*100);
        this.pierEmbarkStatistics = sortMapByValue(this.pierEmbarkStatistics);
    }

    public Map<String, Float> sortMapByValue(Map<String, Float> toSort){
        toSort = toSort
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Float>comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        return toSort;
    }

    public void showGroupStatistic(Map<String, Float> toShow, String title){
        String result = title + "\n";
        for (Map.Entry<String,Float> entry : toShow.entrySet()) {
            result += entry.getKey() + " = " + String.format("%.2f", entry.getValue()) + "\n";
        }
        this.groupStatistics.setText(result);
    }

    public void dataGrouping(){
        // do a switch case
        switch (this.sortedStatisticsBox.getSelectedItem().toString()) {
            case "Class" ->{
                showGroupStatistic(this.classStatistics, "Group by Class");
            }
            case "Gender" -> {
                showGroupStatistic(this.genderStatistics, "Group by Gender");
            }
            case "Age" -> {
                showGroupStatistic(this.ageStatistics, "Group by Age");
            }
            case "HasFamily" -> {
                showGroupStatistic(this.hasFamilyStatistics, "Group by HasFamily");
            }
            case "Ticket Cost" -> {
                showGroupStatistic(this.ticketCostStatistics, "Group by Ticket Cost");
            }
            case "Pier Embarked" -> {
                showGroupStatistic(this.pierEmbarkStatistics, "Group by Pier Embarked");
            }
            case "None" -> {
                this.groupStatistics.setText(null);
            }
        }

    }
}
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class ManageScreen extends JPanel {
    private JComboBox<String> classComboBox;
    private JComboBox<String> genderComboBox;
    private JComboBox<String> pierEmbarkComboBox;
    private JTextField rangeMinTextField;
    private JTextField rangeMaxTextField;
    private JTextField nameTextField;
    private JTextField sibSpTextField;
    private JTextField parchTextField;
    private JTextField ticketNumberTextField;
    private JTextField ticketMinCostTextField;
    private JTextField ticketMaxCostTextField;
    private JTextField cabinNumberTextField;
    private JLabel filterResultLabel;
    private JButton statisticResultButton;
    private JButton filterButton;
    private List<Passenger> passengers;
    private final String SAVED_SEARCH_FILE_PATH = "src\\data\\";
    private final String SAVED_STATISTICS_FILE_PATH = "src\\data\\Statistics.txt";
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
            this.filterResultLabel.setBounds(x + Constants.MARGIN_FROM_LEFT + 25, y + Constants.LABEL_HEIGHT * 15, Constants.LABEL_WIDTH * 5, Constants.LABEL_HEIGHT);
            this.filterResultLabel.setFont(new Font("", Font.ITALIC, 20));
            this.filterResultLabel.setVisible(true);
            this.add(this.filterResultLabel);

            this.statisticResultButton = new JButton("Create Statistics File");
            this.statisticResultButton.setBounds(x + Constants.MARGIN_FROM_LEFT + 90, y + Constants.LABEL_HEIGHT * 13, Constants.LABEL_WIDTH * 2, Constants.LABEL_HEIGHT);
            this.statisticResultButton.setFont(new Font("Create Statistics File", Font.ITALIC, 15));
            this.statisticResultButton.setVisible(true);
            this.add(this.statisticResultButton);

            readTitanicPassengerData(file);

            this.filterButton.addActionListener((e) -> filterPassengers());
            this.statisticResultButton.addActionListener((e) -> createStatisticsFile());
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
        String gender = (String) this.genderComboBox.getSelectedItem();
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
                        .sorted(Comparator.comparing(Passenger::getFormattedName))
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

    public int getSurvivedCountInAgeRange(int min, int max, List<Passenger> anyAgeSurvivedPassengers){
        return (int) anyAgeSurvivedPassengers
                .stream()
                .filter(passenger -> passenger.getAge() >= min && passenger.getAge() <= max)
                .count();
    }

    public int getSurvivedInTicketRange(int min, int max, List<Passenger> anyAgeSurvivedPassengers){
        return (int) anyAgeSurvivedPassengers
                .stream()
                .filter(passenger -> passenger.getFare() >= min && passenger.getFare() <= max)
                .count();
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
            File savedSearch = new File(SAVED_SEARCH_FILE_PATH + this.fileCount + ".csv");
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
            List<Passenger> anyAgeSurvivedPassengers = this.passengers
                    .stream()
                    .filter(Passenger::isSurvived)
                    .toList();

            int ageOto10Survived = getSurvivedCountInAgeRange(0, 10, anyAgeSurvivedPassengers);
            double ageOto10SurvivedAvg = (double) ageOto10Survived / anyAgeSurvivedPassengers.size();
            statisticsData.add("Age (0-10) Avg: " + String.format("%.2f", ageOto10SurvivedAvg*100) +"%");

            int age11to20Survived = getSurvivedCountInAgeRange(11, 20, anyAgeSurvivedPassengers);
            double age11to20SurvivedAvg = (double) age11to20Survived / anyAgeSurvivedPassengers.size();
            statisticsData.add("Age (11-20) Avg: " + String.format("%.2f", age11to20SurvivedAvg*100) +"%");

            int age21to30Survived = getSurvivedCountInAgeRange(21, 30, anyAgeSurvivedPassengers);
            double age21to30SurvivedAvg = (double) age21to30Survived / anyAgeSurvivedPassengers.size();
            statisticsData.add("Age (21-30) Avg: " + String.format("%.2f", age21to30SurvivedAvg*100) +"%");

            int age31to40Survived = getSurvivedCountInAgeRange(31, 40, anyAgeSurvivedPassengers);
            double age31to40SurvivedAvg = (double) age31to40Survived / anyAgeSurvivedPassengers.size();
            statisticsData.add("Age (31-40) Avg: " + String.format("%.2f", age31to40SurvivedAvg*100) +"%");

            int age41to50Survived = getSurvivedCountInAgeRange(41, 50, anyAgeSurvivedPassengers);
            double age41to50SurvivedAvg = (double) age41to50Survived / anyAgeSurvivedPassengers.size();
            statisticsData.add("Age (41-50) Avg: " + String.format("%.2f", age41to50SurvivedAvg*100) +"%");

            int age50PlusSurvived = getSurvivedCountInAgeRange(50, 120, anyAgeSurvivedPassengers);
            double age50PlusSurvivedAvg = (double) age50PlusSurvived / anyAgeSurvivedPassengers.size();
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


            int fare0to10Survived = calculateSurvivedPassengers(anyAgeSurvivedPassengers);
            double fare0to10SurvivedAvg = (double) fare0to10Survived / anyAgeSurvivedPassengers.size();
            statisticsData.add("Fare 0-10 Avg: " + String.format("%.2f", hasNoFamilyPassengersSurvivedAvg*100) +"%");



            //Statistics file creation
            File savedStatistics = new File(SAVED_STATISTICS_FILE_PATH);
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
}
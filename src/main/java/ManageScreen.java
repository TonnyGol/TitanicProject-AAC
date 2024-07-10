import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    private final String SAVED_STATISTICS_FILE_PATH = "src\\data\\";
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
            this.statisticResultButton.setFocusable(true);
            this.add(this.statisticResultButton);

            readTitanicPassengerData(file);

            this.filterButton.addActionListener((e) -> {
                filterPassengers();
            });
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

        survivedPassengers = (int) filteredPassenger
                .stream()
                .filter(Passenger::isSurvived)
                .count();

        writeLogFile(filteredPassenger);

        if (!filteredPassenger.isEmpty()) {
            String result = "Total Rows: " + filteredPassenger.size() + " (" + survivedPassengers + " survived, " + (filteredPassenger.size() - survivedPassengers) + " did not)";
            this.filterResultLabel.setText(result);
        } else {
            this.filterResultLabel.setText("No passengers found.a");
        }
    }

    public void writeLogFile(List<Passenger> filteredPassenger){
        try {
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

    public void statistic(List passengers) {
        File savedStatistics = new File(SAVED_STATISTICS_FILE_PATH + ".csv");
        System.out.println("created stats");
        FileWriter fileWriter2 = null;
        try {
            fileWriter2 = new FileWriter(savedStatistics);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter2);
        try {
            bufferedWriter.write(String.join(",", "gay"));
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
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


}
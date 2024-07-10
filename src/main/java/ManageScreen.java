import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

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
    private JButton filterButton;
    private List<Passenger> passengers;

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
            this.rangeMaxTextField.setBounds(rangeLabel.getX() + rangeLabel.getWidth()*2, rangeLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.rangeMaxTextField.setEditable(true);
            this.rangeMaxTextField.setVisible(true);
            this.rangeMaxTextField.setFocusable(true);
            this.add(this.rangeMaxTextField);

            JLabel nameLabel = new JLabel("Name: ");
            nameLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y + Constants.LABEL_HEIGHT*2, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(nameLabel);
            this.nameTextField = new JTextField();
            this.nameTextField.setBounds(nameLabel.getX() + nameLabel.getWidth() + 1, nameLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.nameTextField.setEditable(true);
            this.nameTextField.setVisible(true);
            this.nameTextField.setFocusable(true);
            this.add(this.nameTextField);

            JLabel sexLabel = new JLabel("Gender: ");
            sexLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y + Constants.LABEL_HEIGHT*3, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(sexLabel);
            this.genderComboBox = new JComboBox<>(Constants.PASSENGER_GENDER_OPTIONS);
            this.genderComboBox.setBounds(sexLabel.getX() + sexLabel.getWidth() + 1, sexLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(this.genderComboBox);

            JLabel sibSpLabel = new JLabel("Sibling Amount: ");
            sibSpLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y + Constants.LABEL_HEIGHT*4, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(sibSpLabel);
            this.sibSpTextField = new JTextField();
            this.sibSpTextField.setBounds(sibSpLabel.getX() + sibSpLabel.getWidth() + 1, sibSpLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.sibSpTextField.setEditable(true);
            this.sibSpTextField.setVisible(true);
            this.sibSpTextField.setFocusable(true);
            this.add(this.sibSpTextField);

            JLabel parchLabel = new JLabel("Parch: ");
            parchLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y + Constants.LABEL_HEIGHT*5, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(parchLabel);
            this.parchTextField  = new JTextField();
            this.parchTextField.setBounds(parchLabel.getX() + parchLabel.getWidth() + 1, parchLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.parchTextField.setEditable(true);
            this.parchTextField.setVisible(true);
            this.parchTextField.setFocusable(true);
            this.add(this.parchTextField);

            JLabel ticketNumberLabel = new JLabel("Ticket Number: ");
            ticketNumberLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y + Constants.LABEL_HEIGHT*6, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(ticketNumberLabel);
            this.ticketNumberTextField  = new JTextField();
            this.ticketNumberTextField.setBounds(ticketNumberLabel.getX() + ticketNumberLabel.getWidth() + 1, ticketNumberLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.ticketNumberTextField.setEditable(true);
            this.ticketNumberTextField.setVisible(true);
            this.ticketNumberTextField.setFocusable(true);
            this.add(this.ticketNumberTextField);

            JLabel ticketCostLabel = new JLabel("Ticket Cost-Min/Max ");
            ticketCostLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y + Constants.LABEL_HEIGHT*7, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(ticketCostLabel);
            this.ticketMinCostTextField = new JTextField();
            this.ticketMinCostTextField.setBounds(ticketCostLabel.getX() + ticketCostLabel.getWidth() + 1, ticketCostLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.ticketMinCostTextField.setEditable(true);
            this.ticketMinCostTextField.setVisible(true);
            this.ticketMinCostTextField.setFocusable(true);
            this.add(this.ticketMinCostTextField);

            this.ticketMaxCostTextField = new JTextField();
            this.ticketMaxCostTextField.setBounds(ticketCostLabel.getX() + ticketCostLabel.getWidth()*2, ticketCostLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.ticketMaxCostTextField.setEditable(true);
            this.ticketMaxCostTextField.setVisible(true);
            this.ticketMaxCostTextField.setFocusable(true);
            this.add(this.ticketMaxCostTextField);

            JLabel cabinNumberLabel = new JLabel("Cabin Number: ");
            cabinNumberLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y + Constants.LABEL_HEIGHT*8, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(cabinNumberLabel);
            this.cabinNumberTextField  = new JTextField();
            this.cabinNumberTextField.setBounds(cabinNumberLabel.getX() + cabinNumberLabel.getWidth() + 1, cabinNumberLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.cabinNumberTextField.setEditable(true);
            this.cabinNumberTextField.setVisible(true);
            this.cabinNumberTextField.setFocusable(true);
            this.add(this.cabinNumberTextField);

            JLabel embarkedLabel = new JLabel("Pier Embarked: ");
            embarkedLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y + Constants.LABEL_HEIGHT*9, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(embarkedLabel);
            this.pierEmbarkComboBox = new JComboBox<>(Constants.PASSENGER_PIER_EMBARK_OPTIONS);
            this.pierEmbarkComboBox.setBounds(embarkedLabel.getX() + embarkedLabel.getWidth() + 1, embarkedLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(this.pierEmbarkComboBox);

            this.filterButton = new JButton("Filter");
            this.filterButton.setBounds(x + Constants.MARGIN_FROM_LEFT + 100, y + Constants.LABEL_HEIGHT*11, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(this.filterButton);

            try{
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

            this.classComboBox.addActionListener((e) -> {
                //do whatever you want on change

            });
            this.filterButton.addActionListener((e) -> {
                filterPassengers();
            });
        }
    }

    public void filterPassengers(){
        int minIdRange = this.rangeMinTextField.getText().isEmpty() ? 0 : Integer.parseInt(this.rangeMinTextField.getText());
        int maxIdRange = this.rangeMaxTextField.getText().isEmpty() ? 0 : Integer.parseInt(this.rangeMaxTextField.getText());
        String name = this.nameTextField.getText();
        String gender = (String) this.genderComboBox.getSelectedItem();
        int sibSp = this.sibSpTextField.getText().isEmpty() ? 0 : Integer.parseInt(this.sibSpTextField.getText());
        int parch = this.parchTextField.getText().isEmpty() ? 0 :Integer.parseInt(this.parchTextField.getText());
        String ticketString = this.ticketNumberTextField.getText();
        int minFare = this.ticketMinCostTextField.getText().isEmpty() ? 0 :Integer.parseInt(this.ticketMinCostTextField.getText());
        int maxFare = this.ticketMaxCostTextField.getText().isEmpty()  ? 0 : Integer.parseInt(this.ticketMaxCostTextField.getText());
        String cabin = this.cabinNumberTextField.getText();
        char pier = Objects.requireNonNull(this.pierEmbarkComboBox.getSelectedItem()).toString().charAt(0);

        int survivedPassengers;

        List<Passenger> filteredPassenger =
                this.passengers
                        .stream()
                        .filter(passenger -> {
                            boolean toFilter = true;
                            if (!name.isEmpty() && toFilter){
                                toFilter = passenger.getFormattedName().contains(name);
                            }
                            return toFilter;
                        })
                        .filter(passenger -> passenger.getPassengerId() >= minIdRange && passenger.getPassengerId() <= maxIdRange)
                        .filter(passenger -> passenger.getFormattedName().contains(name))
                        .filter(passenger -> passenger.getSex().equals(gender))
                        .filter(passenger -> passenger.getSibSp() == (sibSp))
                        .filter(passenger -> passenger.getParch() == (parch))
                        .filter(passenger -> passenger.getTicket().equals(ticketString))
                        .filter(passenger -> passenger.getFare() >= (minFare) && passenger.getFare() <= (maxFare))
                        .filter(passenger -> passenger.getCabin().equals(cabin))
                .toList();
        survivedPassengers = (int) filteredPassenger
                .stream()
                .filter(Passenger::isSurvived)
                .count();
        if(!filteredPassenger.isEmpty()){
            System.out.println("Total rows: " + filteredPassenger.size() + " ("+survivedPassengers+" survived,"+(filteredPassenger.size()-survivedPassengers)+" did not)");
        }else{
            System.out.println("Empty filtered passengers");
        }
    }
}

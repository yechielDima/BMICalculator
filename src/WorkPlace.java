import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class WorkPlace extends JPanel {

    private final User user;
    private final Font font1;
    private final Font font2;
    private final Font font3;
    private final Font font4;
    private final Font font5;
    private JLabel heightLabel;

    private JTextField firstNameTextField, lastNameTextField, ageTextField, weightTextField;

    private JComboBox<String> genderComboBox, bodyFrameComboBox;
    private JSlider heightSlider;
    private final JButton calculateButton;
    private final JPanel personalData;
    private final JPanel personal_H_W_Bf;
    private final JPanel results;
    private int countErrors;
    private String errorMessage;
    private boolean canCalculate;

    public WorkPlace(){
        this.setLayout(null);

        this.calculateButton = new JButton();
        this.canCalculate = false;

        this.font1 = new Font("Ariel", Font.PLAIN, 20);
        this.font2 = new Font("Ariel", Font.PLAIN, 18);
        this.font3 = new Font("MV Boli",Font.PLAIN,15);
        this.font4 = new Font("MV Boli",Font.PLAIN,40);
        this.font5 = new Font("MV Boli",Font.PLAIN,30);

        this.user = new User();

        this.personalData = new JPanel();
        this.add(getPersonalData());

        this.personal_H_W_Bf = new JPanel();
        this.add(getPersonal_H_W_Bf());

        this.results = new JPanel();
        this.add(getResults());

    }


    public JPanel getPersonalData(){
        this.personalData.setLayout(null);
        this.personalData.setBounds(30,15,170,330);

        this.personalData.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Personal data"),
                BorderFactory.createEmptyBorder(0, 0, 0, 0)));

        this.genderComboBox = null;
        final String[] genderComboTexts = { "Male", "Female" };

        JLabel firstNameLabel = new JLabel("First name");
        firstNameLabel.setFont(font1);
        JLabel lastNameLabel = new JLabel("Last name");
        lastNameLabel.setFont(font1);
        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setFont(font1);
        JLabel ageLabel = new JLabel("Age");
        ageLabel.setFont(font1);

        this.firstNameTextField = new JTextField();
        this.firstNameTextField.setFont(font2);
        this.lastNameTextField = new JTextField();
        this.lastNameTextField.setFont(font2);
        this.ageTextField = new JTextField();
        this.ageTextField.setFont(font2);

        firstNameLabel.setBounds(15,25,100,20);
        this.firstNameTextField.setBounds(15,45,140,28);
        this.personalData.add(firstNameTextField);
        this.personalData.add(firstNameLabel);

        lastNameLabel.setBounds(15,95,100,20);
        this.lastNameTextField.setBounds(15,115,140,28);
        this.personalData.add(lastNameTextField);
        this.personalData.add(lastNameLabel);

        ageLabel.setBounds(15,160,100,27);
        this.ageTextField.setBounds(15,187,140,28);
        this.personalData.add(ageTextField);
        this.personalData.add(ageLabel);


        genderLabel.setBounds(15,230,100,27);
        this.genderComboBox = new JComboBox<>(genderComboTexts);
        this.genderComboBox.setFont(font2);
        this.genderComboBox.setBounds(15,260,140,25);
        this.personalData.add(genderLabel);
        this.personalData.add(genderComboBox);


        return this.personalData;
    }

    public JPanel getPersonal_H_W_Bf() {
        this.personal_H_W_Bf.setLayout(null);
        this.personal_H_W_Bf.setBounds(250,15,320,330);

        this.personal_H_W_Bf.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("personal H W Bf"),
                BorderFactory.createEmptyBorder(0, 0, 0, 0)));

        this.bodyFrameComboBox = null;
        final String[] bodyFrameComboText = { "Small", "Medium" , "Large" };

        this.heightSlider = new JSlider(JSlider.VERTICAL, 140, 190, 160);
        this.heightSlider.setBounds(200,50,80,270);
        this.heightSlider.setMinorTickSpacing(1);
        this.heightSlider.setMajorTickSpacing(10);
        this.heightSlider.setPaintTicks(true);
        this.heightSlider.setPaintLabels(true);
        this.heightSlider.setFont(font3);
        this.heightSlider.addChangeListener((e)-> this.heightLabel.setText(this.heightSlider.getValue()+""));


        JLabel bodyFrameLabel = new JLabel("Body frame");
        bodyFrameLabel.setFont(font1);
        JLabel weightLabel = new JLabel("Weight");
        weightLabel.setFont(font1);
        JLabel headHeightLabel = new JLabel("Height scale");
        headHeightLabel.setFont(font2);
        JLabel heightLabel = new JLabel("Height:");
        heightLabel.setFont(font1);
        this.heightLabel = new JLabel(this.heightSlider.getValue()+"");
        this.heightLabel.setFont(font2);

        this.weightTextField = new JTextField();
        this.weightTextField.setFont(font2);


        bodyFrameLabel.setBounds(15,25,120,25);
        this.bodyFrameComboBox = new JComboBox<>(bodyFrameComboText);
        this.bodyFrameComboBox.setFont(font2);
        this.bodyFrameComboBox.setBounds(15,50,140,28);
        this.personal_H_W_Bf.add(bodyFrameLabel);
        this.personal_H_W_Bf.add(bodyFrameComboBox);

        weightLabel.setBounds(15,165,120,25);
        this.weightTextField.setBounds(15,192,140,28);
        this.personal_H_W_Bf.add(weightLabel);
        this.personal_H_W_Bf.add(weightTextField);


        headHeightLabel.setBounds(200,25,130,28);
        heightLabel.setBounds(15,230,80,28);
        this.heightLabel.setBounds(80,230,50,28);


        this.personal_H_W_Bf.add(heightSlider);
        this.personal_H_W_Bf.add(heightLabel);
        this.personal_H_W_Bf.add(this.heightLabel);
        this.personal_H_W_Bf.add(headHeightLabel);

        JButton saveButton = new JButton();
        saveButton.setBackground(Color.yellow);
        saveButton.setBounds(15,260,180,50);
        saveButton.setText("Save");
        saveButton.setFont(font4);

        saveButton.addActionListener((event) -> {
            this.countErrors=0;
            this.errorMessage="";
            this.user.setHeight(Integer.parseInt(this.heightLabel.getText()));

            if (this.firstNameTextField.getText().equals("")){
                this.countErrors++;
                this.errorMessage+="Invalid first name! \n";
            }else {
                this.user.setFirstName(this.firstNameTextField.getText());
            }

            if (this.lastNameTextField.getText().equals("")){
                this.countErrors++;
                this.errorMessage+="Invalid last name! \n";
            }else {
                this.user.setLastName(this.lastNameTextField.getText());
            }


            try {
                this.user.setAge(Double.parseDouble(this.ageTextField.getText()));
            } catch (NumberFormatException e1) {
                this.countErrors++;
                this.errorMessage+="Invalid age! \n";
            }

            this.user.setGender(Objects.requireNonNull(this.genderComboBox.getSelectedItem()).toString());
            this.user.setBodyFrame(Objects.requireNonNull(this.bodyFrameComboBox.getSelectedItem()).toString());

            try {
                this.user.setActualWeight(Double.parseDouble(this.weightTextField.getText()));
            } catch (NumberFormatException e1) {
                this.countErrors++;
                this.errorMessage+="Invalid weight! \n";
            }
            if (this.countErrors > 0){
                this.canCalculate = false;
                this.errorMessage+= "Please correct the details in the requested fields.";
                Toolkit toolkit=Toolkit.getDefaultToolkit();
                toolkit.beep();
                JOptionPane.showMessageDialog(new JFrame(),this.errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
            }else {
                this.canCalculate = true;
            }
        });


        this.personal_H_W_Bf.add(saveButton);


        return this.personal_H_W_Bf;
    }

    public JPanel getResults(){
        this.results.setLayout(null);
        this.results.setBounds(30 , 395 , 540 , 330);
        this.results.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Results"),
                BorderFactory.createEmptyBorder(0, 0, 0, 0)));

        JLabel firstNameLabel = new JLabel("First name:");
        firstNameLabel.setFont(font1);
        JLabel lastNameLabel = new JLabel("Last name:");
        lastNameLabel.setFont(font1);
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setFont(font1);

        JLabel firsNameDataLabel = new JLabel();
        firsNameDataLabel.setFont(font2);
        JLabel lastNameDataLabel = new JLabel();
        lastNameDataLabel.setFont(font2);
        JLabel ageDataLabel = new JLabel();
        ageDataLabel.setFont(font2);

        firstNameLabel.setBounds(15,25,150,25);
        firsNameDataLabel.setBounds(15,50,100,20);

        lastNameLabel.setBounds(15,100,150,25);
        lastNameDataLabel.setBounds(15,125,100,20);

        ageLabel.setBounds(15,170,150,25);
        ageDataLabel.setBounds(15,195,100,20);


        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(font1);
        JLabel heightLabel = new JLabel("Height:");
        heightLabel.setFont(font1);
        JLabel weightLabel = new JLabel("Weight:");
        weightLabel.setFont(font1);

        JLabel genderDataLabel = new JLabel();
        genderDataLabel.setFont(font2);
        JLabel heightDataLabel = new JLabel();
        heightDataLabel.setFont(font2);
        JLabel weightDataLabel = new JLabel();
        weightDataLabel.setFont(font2);

        genderLabel.setBounds(195,25,150,25);
        genderDataLabel.setBounds(195,50,100,20);

        heightLabel.setBounds(195,100,150,25);
        heightDataLabel.setBounds(195,125,100,20);

        weightLabel.setBounds(195,170,150,25);
        weightDataLabel.setBounds(195,195,100,20);



        JLabel BMILabel = new JLabel("BMI score:");
        BMILabel.setFont(font1);
        JLabel weightStatusLabel = new JLabel("Weight status:");
        weightStatusLabel.setFont(font1);
        JLabel idealWeightLabel = new JLabel("Ideal weight:");
        idealWeightLabel.setFont(font1);

        JLabel BMIDataLabel = new JLabel();
        BMIDataLabel.setFont(font2);
        JLabel weightStatusDataLabel = new JLabel();
        weightStatusDataLabel.setFont(font2);
        JLabel idealWeightDataLabel = new JLabel();
        idealWeightDataLabel.setFont(font2);

        BMILabel.setBounds(375,25,150,25);
        BMIDataLabel.setBounds(375,50,100,20);

        weightStatusLabel.setBounds(375,100,150,25);
        weightStatusDataLabel.setBounds(375,125,100,20);

        idealWeightLabel.setBounds(375,170,150,25);
        idealWeightDataLabel.setBounds(375,195,100,20);








        this.calculateButton.setBounds(15,260,510,50);
        this.calculateButton.setBackground(Color.yellow);
        this.calculateButton.setText("Calculate");
        this.calculateButton.setFont(font5);

        this.calculateButton.addActionListener((event) -> {
            if (this.canCalculate){
                firsNameDataLabel.setText(this.user.getFirstName());
                lastNameDataLabel.setText(this.user.getLastName());
                ageDataLabel.setText(String.valueOf(this.user.getAge()));
                genderDataLabel.setText(this.user.getGender());
                heightDataLabel.setText(String.valueOf(this.user.getHeight()));
                weightDataLabel.setText(String.valueOf(this.user.getActualWeight()));
                BMIDataLabel.setText(String.valueOf(this.user.getBMIScore()));
                weightStatusDataLabel.setText(this.user.getWeightStatus());
                idealWeightDataLabel.setText(String.valueOf(this.user.getIdealWeight()));
            }else {
                Toolkit toolkit=Toolkit.getDefaultToolkit();
                toolkit.beep();
                JOptionPane.showMessageDialog(new JFrame(),"You must save first!", "Error", JOptionPane.ERROR_MESSAGE);
            }

        });


        this.results.add(calculateButton);
        this.results.add(BMILabel);
        this.results.add(BMIDataLabel);
        this.results.add(weightStatusLabel);
        this.results.add(weightStatusDataLabel);
        this.results.add(idealWeightLabel);
        this.results.add(idealWeightDataLabel);
        this.results.add(firstNameLabel);
        this.results.add(firsNameDataLabel);
        this.results.add(lastNameLabel);
        this.results.add(lastNameDataLabel);
        this.results.add(ageLabel);
        this.results.add(ageDataLabel);
        this.results.add(genderLabel);
        this.results.add(genderDataLabel);
        this.results.add(heightLabel);
        this.results.add(heightDataLabel);
        this.results.add(weightLabel);
        this.results.add(weightDataLabel);



        return this.results;
    }


}
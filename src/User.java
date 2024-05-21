import java.text.DecimalFormat;

public class User {

    private double actualWeight;
    private double bodyFrame;
    private double age;
    private double height;
    private double BMIScore;
    private final Calculator calculator;
    private final DecimalFormat decimalFormat;
    private String firstName;
    private String lastName;
    private String gender;

    public User(){

        this.calculator = new Calculator();
        this.decimalFormat=new DecimalFormat("#.###");
    }


    public double getBMIScore() {
        this.BMIScore=Double.parseDouble(decimalFormat.format(calculator.calculateBMI(this.height, this.actualWeight)));

        return BMIScore;
    }

    public double getIdealWeight() {

        return Double.parseDouble(decimalFormat.format(calculator.calculateIdealWeight(this.bodyFrame, this.height * 100, this.age)));
    }

    public String getWeightStatus() {
        return calculator.calculateWeightStatus(BMIScore);
    }

    public void setActualWeight(double actualWeight) {
        this.actualWeight = actualWeight;
    }
    public void setAge(double age) {
        this.age = age;
    }

    public void setBodyFrame(String bodyFrame) {
        switch (bodyFrame) {
            case "Small" -> this.bodyFrame = 0.9;
            case "Medium" -> this.bodyFrame = 1.0;
            case "Large" -> this.bodyFrame = 1.1;
        }
    }
    public void setGender(String gender) {
        this.gender = gender;

    }

    public void setHeight(double height) {
        this.height = height / 100;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;

    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getAge() {
        return age;
    }

    public double getActualWeight() {
        return actualWeight;
    }

    public double getHeight() {
        return height;
    }

    public String getGender() {
        return gender;
    }
}

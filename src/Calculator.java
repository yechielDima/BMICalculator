public class Calculator {

    public double calculateBMI(double height , double actualWeight){
        return actualWeight / (height * height);
    }

    public double calculateIdealWeight(double bodyFrame , double height , double age){
        return (height - 100 + (age / 10)) * 0.9 * bodyFrame;
    }

    public String calculateWeightStatus(double BMI){
        if (BMI < 15){
            return  "Anorexic";
        }
        if (BMI >= 15 && BMI < 18.5){
            return "Underweight";
        }
        if (BMI >= 18.5 && BMI < 24.9){
            return  "Normal";
        }
        if (BMI >= 24.9 && BMI < 29.9){
            return   "Overweight";
        }
        if (BMI >= 29.9 && BMI < 35){
            return  "Obese";
        }
        if (BMI >= 35){
            return  "Extreme Obese";
        }
        return "Invalid";
    }


}

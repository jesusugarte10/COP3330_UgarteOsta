public class BodyMassIndex{

    //Declaring private values
    private double sum;
    private String category;

    //getting values from main class and creating an object
    public BodyMassIndex(double height, double weight) {

        double value = (703 * weight) / Math.pow(height, 2) ;
        this.sum = value;
    }
    
    //making a getter
    public double getSum(){
        return this.sum;
    }

    //method to return categories
    public String getCategory(){

        if (this.sum <= 18){
            this.category = "->Underweight";
        }
        else if((this.sum >= 18.5) && (this.sum <= 24.9)){
            this.category = "->Normal weight";
        }
        else if((this.sum >= 25) && (this.sum <= 29.9)){
            this.category = "->Overweight";
        }
        else if (this.sum >= 30){
            this.category = "->Obesity";
        }
        return this.category;
    }
}
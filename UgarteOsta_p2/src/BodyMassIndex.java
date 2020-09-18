public class BodyMassIndex{

    private double sum;
    private String category;

    public BodyMassIndex(double height, double weight) {

        double value = (703 * weight) / Math.pow(height, 2) ;
        this.sum = value;
    }
    
    public double getSum(){
        return this.sum;
    }

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
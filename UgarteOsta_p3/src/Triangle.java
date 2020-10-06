public class Triangle extends Shape2D{

    public String shapeName;
    public double area;

    Triangle(double n1, double n2){
        this.area = (n1*n2)/2;
    }

    @Override
    public String getName() {
        this.shapeName = "triangle";
        return this.shapeName;
    }

    @Override
    public double getArea() {
        return this.area;
    }
    
}
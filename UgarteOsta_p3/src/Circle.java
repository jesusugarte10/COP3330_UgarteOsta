public class Circle extends Shape2D{

    public String shapeName;
    public double area;

    Circle(double n1){
        this.area = Math.PI * Math.pow(n1, 2);
        this.shapeName = "circle";
        
    }

    @Override
    public String getName() {
        return this.shapeName;
    }

    @Override
    public double getArea() {
        return this.area;
    }
    
}

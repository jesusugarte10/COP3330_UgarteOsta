public class Square extends Shape2D{

    public String shapeName;
    public double area;

    Square(double n1){
        this.area = Math.pow(n1, 2);
    }

    @Override
    public String getName() {
        this.shapeName = "square";
        return this.shapeName;
    }

    @Override
    public double getArea() {
        return this.area;
    }
    
}

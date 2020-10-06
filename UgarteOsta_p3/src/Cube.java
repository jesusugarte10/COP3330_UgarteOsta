public class Cube extends Shape3D{

    public double area;
    public String shapeName;
    public double volume;

    Cube(double n1){
        this.shapeName = "cube";
        this.volume = Math.pow(n1, 3);
        this.area = 6 * Math.pow(n1, 2);
    }

    @Override
    public double getVolume() {
        return this.volume;
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

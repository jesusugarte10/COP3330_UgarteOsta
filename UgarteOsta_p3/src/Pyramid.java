public class Pyramid extends Shape3D{

    public double area;
    public String shapeName;
    public double volume;

    Pyramid(double n1, double n2, double n3){
        this.shapeName = "pyramid";
        this.volume = (n1*n2*n3)/3;
        this.area = ((n1*n2) + n1*(Math.sqrt(Math.pow(n2/2,2)+Math.pow(n3,2))) + n2*(Math.sqrt(Math.pow(n1/2,2)+Math.pow(n3,2))));   
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

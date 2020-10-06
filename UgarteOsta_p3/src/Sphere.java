public class Sphere extends Shape3D{

    public double area;
    public String shapeName;
    public double volume;

    Sphere(double n1){
        this.shapeName = "sphere";
        this.volume = (4.00/3.00) * Math.PI * Math.pow(n1, 3);
        this.area = 4 * Math.PI * Math.pow(n1, 2) ;
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

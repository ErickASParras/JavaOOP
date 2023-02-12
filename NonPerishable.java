
public class NonPerishable extends Product{
    private double volume;

    public NonPerishable(String produto, double quantidade, double volume) {
        super(produto, quantidade);
        this.volume = volume;
    }
    
    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    
}
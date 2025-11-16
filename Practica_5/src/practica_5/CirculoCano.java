
package practica_5;


public class CirculoCano extends Figura17 {
    
    private double radio;

    public CirculoCano(double radio) {
        super("Circulo");
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
    
     public void setRadio(double radio) {
        this.radio = radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }
    
}
 
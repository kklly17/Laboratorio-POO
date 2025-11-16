
package practica_5;


public class RectanguloCano extends Figura17 {
    private double base;
    private double altura;

    public RectanguloCano(double base, double altura) {
        super("Rectangulo");
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }


     public void setDimensiones(double base) {
        this.base = base;
        this.altura = base;
    }

    public void setDimensiones(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public void setDimensiones(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }
      
}


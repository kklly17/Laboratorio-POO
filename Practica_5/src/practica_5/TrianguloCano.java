package practica_5;


public class TrianguloCano extends Figura17 {

    private double base;   
    private double altura; 

    public TrianguloCano(double base, double altura) {
        super("Triangulo Rectangulo"); 
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return (base * altura) / 2.0;
    }

    @Override
    public double calcularPerimetro() {
        double hipotenusa = Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2));
        return base + altura + hipotenusa;
    }
    
     public void setDatos(double base) {
        this.base = base;
        this.altura = base;
    }

    public void setDatos(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public void setDatos(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }
}

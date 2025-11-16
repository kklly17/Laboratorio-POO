package practica_5;


 public class CalculadoraGeometrica9822 {
    
    public void mostrarCalculos(Figura17 figura) {
        System.out.println("- - - Calculos para: " + figura.getNombre() + "- - -");
        System.out.println("Area: " + figura.calcularArea());
        System.out.println("Perimetro: " + figura.calcularPerimetro());
    }
}

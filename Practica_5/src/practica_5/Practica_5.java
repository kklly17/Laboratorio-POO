
package practica_5;

public class Practica_5 {
    
    
 public static void main(String[] args) {
        
        CalculadoraGeometrica9822 calculadora = new CalculadoraGeometrica9822();

        
        Figura17[] misFiguras = new Figura17[3];
        misFiguras[0] = new CirculoCano(10.0);
        misFiguras[1] = new RectanguloCano(5.0, 8.0);
        misFiguras[2] = new TrianguloCano(3.0, 4.0);

        for (Figura17 fig : misFiguras) {
            
            calculadora.mostrarCalculos(fig);

            System.out.println("**Analisis de tipo especifico**");
            
            if (fig instanceof CirculoCano) {
                System.out.println(" -> Es un Circulo.");
            
            } 
            else if (fig instanceof RectanguloCano) {
                System.out.println("   -> Es un Rectangulo.");
            }
            
            else if (fig instanceof TrianguloCano) {
                System.out.println("   -> Es un Triangulo.");

            }
            System.out.println("------------------------------------");
        }
    }
}
    
    


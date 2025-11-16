package banco_central;

public class CuentaBancaria1703 
{
    private String numeroCuenta;
    private double saldo;
    private String titular;
    
    public CuentaBancaria1703(){
       
    }
    public CuentaBancaria1703 (String numeroCuenta, double saldo, String titular){
        setCuenta(numeroCuenta);
        setSaldo(saldo);
        setTitular(titular);
    }
    
    public String getCuenta(){
        return numeroCuenta;
    }
    
    public double getSaldo(){
        return saldo;
    }
    
    public String getTitular(){
        return titular;
    }
    
    
    public void setCuenta (String numeroCuenta){
        if(numeroCuenta == null || numeroCuenta.length() != 7 ){
            throw new IllegalArgumentException("[!] La cuenta debe tener 7 digitos");
        }
         if (!numeroCuenta.endsWith("22")) {
            throw new IllegalArgumentException("[!] Los últimos digitos de la cuenta deben ser: 22");
         }
        this.numeroCuenta = numeroCuenta;
    }
    
    public void setSaldo(double saldo){
      if(saldo < 0 ) {
          throw new IllegalArgumentException("[!] El saldo no debe ser negativo");
      }
      if( saldo > (22 * 10000)){
          throw new IllegalArgumentException("[!] Limite de saldo $220,000");
      }
    }
  
    public void setTitular(String titular) {
        String t = titular.trim();
        if (t.isEmpty()) {
            throw new IllegalArgumentException("titular no puede estar vacío");
        }
        this.titular = t;
    }
    
    @Override
    public String toString() {
        return "CuentaBancaria1703{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", saldo=" + saldo +
                ", titular='" + titular + '\'' +
                '}';
    }
}

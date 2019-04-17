import java.rmi.Naming;

public class ServidorCalculo {
    public ServidorCalculo() {
        try {
            Calculadora c = new ImplCalculadora();
            Naming.rebind("//localhost/ServicoCalculo", c);
        } catch (Exception e) {
            System.out.println("Problema: " + e);
        }
    }
    public static void main(String args[]) {
        new ServidorCalculo();
    }
}
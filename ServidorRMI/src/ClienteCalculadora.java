import java.rmi.Naming;

public class ClienteCalculadora {
    public static void main(String[] args) {
        try {
            Calculadora c = (Calculadora) Naming.lookup(
                    "rmi://localhost:1099/ServicoCalculo");
            System.out.println(c.sub(4,3));
            System.out.println(c.add(4,5));
            System.out.println(c.mul(3,6));
            System.out.println(c.div(9,3));

        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}

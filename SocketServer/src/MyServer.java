import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class MyServer implements Runnable
{
    ServerSocket ss;
    ArrayList<String> messages;


    public MyServer(int porta) throws Exception{
        ss = new ServerSocket(porta);
        this.messages = new ArrayList<>();

        new Thread(this).start();

        System.out.println("MyServer ouvindo na porta:" + porta);

    }
    public void run(){
        try{
            while(true){
                new TrataCliente(ss.accept()).start();
                System.out.println("MyServer: Cliente Atendido");
            }

        }catch(Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }
    public static void main(String[] args){
        try{
            new MyServer(8999);
        }catch(Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }
}

class TrataCliente extends Thread
{
    private Socket client;

    public TrataCliente(Socket s){
        client = s;
    }
    public void run(){
        try{
            ObjectInputStream oi = new ObjectInputStream(client.getInputStream());

            System.out.println("MyServer/Mensagem recebida:" + oi.readObject());
            client.close();}
        catch(Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }
}

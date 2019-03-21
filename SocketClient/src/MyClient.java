import java.net.*;
import java.io.*;

public class MyClient extends Thread
{
    private String server;
    private int porta;
    private String message;

    public MyClient(String server, int porta, String message){
        this.server = server;
        this.porta = porta;
        this.message = message;
    }

    public void iniciarConexao(){
        try{
//            String server = "localhost";
//            int porta = 8999;
            int numeroDeMyClients = 1;

            for(int i=0; i < numeroDeMyClients; i++){
                new MyClient(server, porta, message).start();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

//    public void run(){
//        try{
//            while(true){
//                Socket s = new Socket(server, porta);
//                System.out.println("Conectado a " + server + ":" + porta);
//                ObjectOutputStream oo = new ObjectOutputStream(s.getOutputStream());
//                oo.writeObject(this.getMessage());
////                oo.writeObject("Olá, Sockets");
//                Thread.sleep(5000);
//                s.close();
//            }
//        } catch(Exception e){
//            e.printStackTrace();
//        }
//    }
    public void run(){
        try {
            Socket s = new Socket(server, porta);
            System.out.println("Conectado a " + server + ":" + porta);
            ObjectOutputStream oo = new ObjectOutputStream(s.getOutputStream());
            oo.writeObject(this.getMessage());
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

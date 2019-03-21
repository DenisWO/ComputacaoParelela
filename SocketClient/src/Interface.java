import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Interface {
    private JFrame frame;
    private JPanel panel;
    private JLabel labelAdress;
    private JTextField textAdress;
    private JLabel labelPort;
    private JTextField textPort;
    private JLabel labelMessage;
    private JTextField textMessage;
    private JButton buttonSend;
    private JButton buttonClean;
    private JButton buttonClose;
    private ArrayList<Integer> ports;
    private MyClient client;

    public Interface(){
        this.frame = new JFrame();
        this.panel = new JPanel();
        this.labelAdress = new JLabel("IP:");
        this.textAdress = new JTextField("");
        this.labelPort = new JLabel("Porta:");
        this.textPort = new JTextField("");
        this.labelMessage = new JLabel("Mensagem:");
        this.textMessage = new JTextField("");
        this.buttonClean = new JButton("Limpar");
        this.buttonSend = new JButton("Enviar");
        this.buttonClose = new JButton("Fechar");
        this.ports = new ArrayList<>();

        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void initInterface(){
        this.initComponents();
        this.positionComponents();
        this.actionComponents();
    }

    public void closeInterface(){
        this.frame.dispose();
    }
    private void initComponents(){
        this.frame.setSize(430,375);
        this.panel.setSize(430,375);

        this.frame.add(this.panel);
        this.panel.setLayout(null);

        this.panel.add(this.labelAdress);
        this.panel.add(this.textAdress);
        this.panel.add(this.labelPort);
        this.panel.add(this.textPort);
        this.panel.add(this.labelMessage);
        this.panel.add(this.textMessage);
        this.panel.add(this.buttonClose);
        this.panel.add(this.buttonClean);
        this.panel.add(this.buttonSend);
    }
    private void positionComponents(){
        this.labelAdress.setBounds(20,20,50,25);
        this.textAdress.setBounds(70,20,130,25);
        this.labelPort.setBounds(20,60,80,25);
        this.textPort.setBounds(70,60,130,25);
        this.labelMessage.setBounds(20,100,130,25);
        this.textMessage.setBounds(20,125,390,100);
        this.buttonClose.setBounds(30,300,120,25);
        this.buttonSend.setBounds(160,300,120,25);
        this.buttonClean.setBounds(290, 300,120,25);
    }
    private void actionComponents(){
        this.buttonClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textMessage.setText("");
            }
        });
        this.buttonSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(verifyFields()) iniciaServer();
            }
        });
        this.buttonClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }
    public boolean verifyFields(){
        if(this.textAdress.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Endereço não pode ser vazio!");
            this.textAdress.requestFocus();
            return false;
        }
        if(this.textPort.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Porta não pode ser vazia!");
            this.textPort.requestFocus();
            return false;
        }
        if(this.textMessage.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Texto a ser enviado não pode ser vazio");
            this.textMessage.requestFocus();
            return false;
        }

        return true;
    }
    public void iniciaServer(){
        if(client == null){
            client = new MyClient(this.textAdress.getText(), Integer.parseInt(this.textPort.getText()), this.textMessage.getText());
            System.out.println("Campo: " + this.textMessage.getText());
            client.setMessage(this.textMessage.getText());
            client.iniciarConexao();
        }

    }
}
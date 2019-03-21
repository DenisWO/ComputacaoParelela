import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ManagerConnection {
    private JFrame frame;
    private JPanel panel;
    private JButton buttonClean;
    private JButton buttonClose;
    private JButton buttonNewConnection;
    private ArrayList<Interface> interfaces;
    private ArrayList<Integer> ports;

    public ManagerConnection(){
        this.frame = new JFrame();
        this.panel = new JPanel();
        this.buttonClean = new JButton("Limpar conexões");
        this.buttonClose = new JButton("Fechar");
        this.buttonNewConnection = new JButton("Nova conexão");
        this.interfaces = new ArrayList<>();
        this.ports = new ArrayList<>();

        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }
    public void initInterface(){
        this.initComponents();
        this.positionComponents();
        this.actionComponents();
    }

    private void initComponents(){
        this.frame.setSize(550,300);
        this.panel.setSize(550,300);

        this.frame.add(this.panel);
        this.panel.setLayout(null);
        this.panel.add(this.buttonClose);
        this.panel.add(this.buttonClean);
        this.panel.add(this.buttonNewConnection);
    }
    private void positionComponents(){
        this.buttonClose.setBounds(20,200,150,25);
        this.buttonClean.setBounds(175,200,200,25);
        this.buttonNewConnection.setBounds(380,200,150,25);
    }
    private void actionComponents(){
        this.buttonClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        this.buttonClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i<interfaces.size(); i++){
                    interfaces.get(i).closeInterface();
                }
                interfaces.clear();
            }
        });

        this.buttonNewConnection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Interface i = new Interface();
                interfaces.add(i);
                interfaces.get(interfaces.size()-1).initInterface();
            }
        });
    }

}

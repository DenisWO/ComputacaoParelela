package jantarFilosofos;

import javax.swing.*;
import java.awt.*;

public class Interface {
    private JFrame frame;
    private JPanel panel;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;

    public Interface(){
        this.frame = new JFrame();
        this.panel = new JPanel();
        this.panel1 = new JPanel();
        this.panel2 = new JPanel();
        this.panel3 = new JPanel();
        this.panel4 = new JPanel();
        this.panel5 = new JPanel();
        this.label1 = new JLabel("Filosofo 1");
        this.label2 = new JLabel("Filosofo 2");
        this.label3 = new JLabel("Filosofo 3");
        this.label4 = new JLabel("Filosofo 4");
        this.label5 = new JLabel("Filosofo 5");

        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void iniciaInterface(){
        this.frame.setSize(500,350);
        this.panel.setSize(500,350);

        this.frame.add(this.panel);
        this.panel.setLayout(null);
        this.panel.add(this.panel1);
        this.panel.add(this.panel2);
        this.panel.add(this.panel3);
        this.panel.add(this.panel4);
        this.panel.add(this.panel5);


        this.panel1.setBounds(20, 50,460,30);
        this.panel1.setBackground(Color.PINK);

        this.panel2.setBounds(20,100,460,30);
        this.panel2.setBackground(Color.PINK);

        this.panel3.setBounds(20,150,460,30);
        this.panel3.setBackground(Color.PINK);

        this.panel4.setBounds(20,200,460,30);
        this.panel4.setBackground(Color.PINK);

        this.panel5.setBounds(20,250,460,30);
        this.panel5.setBackground(Color.PINK);

        this.panel1.add(this.label1);
        this.panel2.add(this.label2);
        this.panel3.add(this.label3);
        this.panel4.add(this.label4);
        this.panel5.add(this.label5);
        this.frame.setVisible(true);
    }

    public void atualizaTela(int[] filosofos){
        for(int i=0; i<filosofos.length; i++){
            if(filosofos[i] == 1){
                this.panel.getComponent(i).setBackground(Color.GREEN);
            }
            else if (filosofos[i] == 2){
                this.panel.getComponent(i).setBackground(Color.CYAN);
            }
            else if(filosofos[i] == 3){
                this.panel.getComponent(i).setBackground(Color.RED);
            }
            atualizaTexto(filosofos[i], i+1);
        }
    }
    public void atualizaTexto(int status, int index){
        String texto = "Filosofo " + String.valueOf(index);
        if(index == 1){
            if(status == 1){
                this.label1.setText(texto + " PENSANDO");
            }
            else if(status == 2){
                this.label1.setText(texto + " COMENDO");
            }
            else if(status == 3){
                this.label1.setText(texto + " COM FOME");
            }
        }
        else if(index == 2){
            if(status == 1){
                this.label2.setText(texto + " PENSANDO");
            }
            else if(status == 2){
                this.label2.setText(texto + " COMENDO");
            }
            else if(status == 3){
                this.label2.setText(texto + " COM FOME");
            }
        }
        else if(index == 3){
            if(status == 1){
                this.label3.setText(texto + " PENSANDO");
            }
            else if(status == 2){
                this.label3.setText(texto + " COMENDO");
            }
            else if(status == 3){
                this.label3.setText(texto + " COM FOME");
            }

        }
        else if(index == 4){
            if(status == 1){
                this.label4.setText(texto + " PENSANDO");
            }
            else if(status == 2){
                this.label4.setText(texto + " COMENDO");
            }
            else if(status == 3){
                this.label4.setText(texto + " COM FOME");
            }

        }
        else if(index == 5){
            if(status == 1){
                this.label5.setText(texto + " PENSANDO");
            }
            else if(status == 2){
                this.label5.setText(texto + " COMENDO");
            }
            else if(status == 3){
                this.label5.setText(texto + " COM FOME");
            }
        }
        texto = "";

    }

}

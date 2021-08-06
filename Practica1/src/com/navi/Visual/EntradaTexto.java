package com.navi.Visual;

import com.navi.AnalizandoString;
import com.navi.SepararString;
import com.navi.TipoToken;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EntradaTexto extends JFrame implements ActionListener {
    JPanel panelCentral = new JPanel();
    JPanel panelBoton = new JPanel();
    JButton boton = new JButton();
    JTextArea areaTexto = new JTextArea();
    JPanel panelRegresar = new JPanel();
    JButton botonRegresar = new JButton();
    JLabel menu = new JLabel("", SwingConstants.CENTER);
    public static String texto;

    public void marco(){
        this.setSize(675,400);
        this.setLocationRelativeTo(null);
        this.crearElementos();
        this.setTitle("Serpientes y Escaleras");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void crearElementos() {
        menu.setLayout(new BorderLayout());
        menu.setFont(new Font("Open Sans", 3, 25));
        menu.setText("<html><br/><br/><br/>______________IDENTIFICADOR_____________<br/><br/><br/><br/></html>");
        menu.setForeground(Color.BLACK);
        panelCentral.setLayout(new GridLayout(3,1));
        areaTexto.setPreferredSize(new Dimension(300,400));
        boton.setPreferredSize(new Dimension(160,35));
        botonRegresar.setPreferredSize(new Dimension(160,30));

        boton.setText("Identificar");
        botonRegresar.setText("Regresar");
        botonRegresar.setVisible(false);

        JScrollPane scroll = new JScrollPane(areaTexto);
        scroll.setPreferredSize(new Dimension(550,300));

        panelBoton.add(boton);
        panelRegresar.add(botonRegresar);
        panelCentral.add(menu);
        panelCentral.add(scroll);
        panelRegresar.add(panelBoton);

        this.getContentPane().add(panelCentral, BorderLayout.CENTER);
        this.getContentPane().add(panelRegresar, BorderLayout.SOUTH);

        boton.addActionListener(this);
        botonRegresar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == boton){

            SwingUtilities.updateComponentTreeUI(this);
        }
    }

}

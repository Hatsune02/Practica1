package com.navi.Visual;

import com.navi.AnalizandoString;
import com.navi.SepararString;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EntradaTexto extends JFrame implements ActionListener {
    JPanel panelNorte = new JPanel();
    JPanel panelCentral = new JPanel();
    JPanel panelSur = new JPanel();
    JButton boton = new JButton();
    JTextArea areaTexto = new JTextArea();
    JTextArea mostrarTexto = new JTextArea();
    JPanel panelRegresar = new JPanel();
    JButton botonRegresar = new JButton();
    JLabel menu = new JLabel("", SwingConstants.CENTER);

    public void marco(){
        this.setSize(775,500);
        this.setLocationRelativeTo(null);
        this.crearElementos();
        this.setTitle("Practica 1");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void crearElementos() {
        menu.setLayout(new BorderLayout());
        menu.setFont(new Font("Open Sans", 3, 25));
        menu.setText("<html><br/>______________IDENTIFICADOR_____________<br/><br/></html>");
        menu.setForeground(Color.BLACK);
        panelCentral.setLayout(new GridLayout(1,2));
        //areaTexto.setPreferredSize(new Dimension(300,400));
        boton.setPreferredSize(new Dimension(160,35));
        botonRegresar.setPreferredSize(new Dimension(160,30));

        boton.setText("Identificar");
        botonRegresar.setText("Regresar");
        botonRegresar.setVisible(false);

        JScrollPane scroll = new JScrollPane(areaTexto);
        scroll.setPreferredSize(new Dimension(550,300));
        JScrollPane scroll2 = new JScrollPane(mostrarTexto);
        scroll2.setPreferredSize(new Dimension(550,300));

        panelSur.add(boton);
        panelRegresar.add(botonRegresar);
        panelNorte.add(menu);
        panelCentral.add(scroll);
        panelCentral.add(scroll2);
        panelRegresar.add(panelSur);

        this.getContentPane().add(panelNorte, BorderLayout.NORTH);
        this.getContentPane().add(panelCentral, BorderLayout.CENTER);
        this.getContentPane().add(panelRegresar, BorderLayout.SOUTH);

        boton.addActionListener(this);
        botonRegresar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == boton){
            SepararString.cantidadPalabras = 0;
            SepararString.cantidadPosiciones = 0;
            SepararString.texto = areaTexto.getText();
            SepararString.separarString();
            AnalizandoString.analizarString();
            mostrarTexto.setText(AnalizandoString.mostrarTokens());
            SwingUtilities.updateComponentTreeUI(this);
        }
    }

}

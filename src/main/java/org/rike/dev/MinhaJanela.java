package org.rike.dev;

import sun.font.TrueTypeFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinhaJanela extends JFrame {

    private JTextField caixaSenha;
    private JButton botaoGerarSenha;

    public MinhaJanela(){
        super("Gerador de senhas fortes");
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel labelSenha = new JLabel("Digite sua senha:");
        caixaSenha = new JTextField(10);

        botaoGerarSenha = new JButton("Gerar senha forte");

        JTextArea areaDeTexto = new JTextArea(8, 28);
        areaDeTexto.setEditable(false);

        JPanel painel = new JPanel();
        painel.add(labelSenha);
        painel.add(caixaSenha);
        painel.add(botaoGerarSenha);
        painel.add(areaDeTexto);

        add(painel, BorderLayout.CENTER);

        botaoGerarSenha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String senha = caixaSenha.getText();
                GeradorDeSenhaForte gerador = new GeradorDeSenhaForte();
                String senhaForte = gerador.geraSenha(senha);
                areaDeTexto.setText(senhaForte);
                JOptionPane.showMessageDialog(null, "Sua senha forte é: " + senhaForte);
            }
        });
    }
    public static void main(String[] args) {
        MinhaJanela minhaJanela = new MinhaJanela();
        minhaJanela.setVisible(true);
    }

//        GeradorDeSenhaForte senha1 = new GeradorDeSenhaForte();
//        senha1.geraSenha("kaynne");


}

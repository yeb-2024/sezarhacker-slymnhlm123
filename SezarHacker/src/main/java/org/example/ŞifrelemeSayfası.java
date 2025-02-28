package org.example;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ŞifrelemeSayfası implements ActionListener
{
    JFrame frame =  new JFrame();
    JTextField mesaj = new JTextField();
    JTextField key = new JTextField();
    JLabel mes = new JLabel("MESAJ : ");
    JLabel anahtar = new JLabel("Anahtar : ");
    JButton gönder = new JButton("Şifrele");
    JPanel sol =new JPanel();
    JPanel üst = new JPanel();
    JPanel alt = new JPanel();
    JPanel sağ = new JPanel();
    JLabel label = new JLabel();
    String SYMBOLS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public ŞifrelemeSayfası()
    {
        frame.setSize(1200,800);
        frame.setLayout(new GridLayout(1,2));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mesaj.setPreferredSize(new Dimension(40,150));
        key.setPreferredSize(new Dimension(40,150));
        mes.setFont(new Font("Arial",Font.BOLD,15));
        anahtar.setFont(new Font("Arial",Font.BOLD,15));
        gönder.addActionListener(this);

        sağ.setPreferredSize(new Dimension(600,800));
        sağ.setLayout(new GridLayout(13,2,5,5));


        sol.setPreferredSize(new Dimension(600,800));
        sol.setLayout(new GridLayout(2,1));


        üst.setPreferredSize(new Dimension(600,600));
        üst.setLayout(new FlowLayout());
        üst.add(mes);
        üst.add(mesaj);
        üst.add(anahtar);
        üst.add(key);
        üst.add(gönder);
        sol.add(üst);



        label.setFont(new Font("Arial",Font.BOLD,10));

        alt.setPreferredSize(new Dimension(600,200));
        alt.setLayout(new FlowLayout());
        alt.add(label);
        sol.add(alt);

        frame.add(sol);


        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == gönder)
        {
            String mesajtex = mesaj.getText();
            String  keytex = key.getText();

            int mesajUzunluk = mesajtex.length();
            String sonuc = "";

            for (int i = 0; i < mesajUzunluk; i++) {
                char harf = mesajtex.charAt(i);
                if (harf == ' ') {
                    sonuc += " ";
                    continue;
                }

                char buyukHarf = Character.toUpperCase(harf);
                int index = SYMBOLS.indexOf(buyukHarf);
                int yeniIndex = (index + Integer.parseInt(keytex)) % SYMBOLS.length();
                char yeniHarf = SYMBOLS.charAt(yeniIndex);
                sonuc += yeniHarf;
            }
            label.setText(sonuc);

            for (int i = 1 ;i<=SYMBOLS.length();i++)
            {
                int keys = 1;
                int mesajUzunlukk = mesajtex.length();
                String sonucsağ = "";

                for (int j = 0; j < mesajUzunlukk; j++) {
                    char harf = mesajtex.charAt(i);
                    if (harf == ' ') {
                        sonucsağ += " ";
                        continue;
                    }

                    char buyukHarf = Character.toUpperCase(harf);
                    int index = SYMBOLS.indexOf(buyukHarf);
                    int yeniIndex = ((index - Integer.parseInt(keytex))+SYMBOLS.length()) % SYMBOLS.length();
                    char yeniHarf = SYMBOLS.charAt(yeniIndex);
                    sonucsağ += yeniHarf;
                    JLabel cozulmuslabel = new JLabel(keys +":"+" "+ sonucsağ);
                    sağ.add(cozulmuslabel);
                }

            }


        }

    }
}

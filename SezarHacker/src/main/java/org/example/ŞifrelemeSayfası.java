package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ŞifrelemeSayfası implements ActionListener {
    JFrame frame = new JFrame();
    JTextField mesaj = new JTextField();
    JLabel mes = new JLabel("MESAJ: ");
    JButton gönder = new JButton("Şifrele");
    JPanel sol = new JPanel();
    JPanel üst = new JPanel();
    JPanel alt = new JPanel();
    JPanel sağ = new JPanel();
    JLabel label = new JLabel();
    String SYMBOLS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public ŞifrelemeSayfası() {
        frame.setSize(1200, 800);
        frame.setLayout(new GridLayout(1, 2));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mesaj.setPreferredSize(new Dimension(150, 50));

        mes.setFont(new Font("Arial", Font.BOLD, 15));

        gönder.addActionListener(this);

        sağ.setPreferredSize(new Dimension(600, 800));
        sağ.setLayout(new GridLayout(13, 2, 5, 5));
        sağ.setBackground(Color.pink);

        sol.setPreferredSize(new Dimension(600, 800));
        sol.setLayout(new GridLayout(2, 1));


        üst.setPreferredSize(new Dimension(600, 600));
        üst.setLayout(new FlowLayout());
        üst.add(mes);
        üst.add(mesaj);
        üst.add(gönder);
        sol.add(üst);

        label.setFont(new Font("Arial", Font.BOLD, 50));

        alt.setPreferredSize(new Dimension(600, 200));
        alt.setLayout(new FlowLayout());
        alt.add(label);
        sol.add(alt);

        frame.add(sol);
        frame.add(sağ);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gönder) {
            label.setText(mesaj.getText());
            sağ.removeAll();

            String mesajtex = mesaj.getText();

            for (int i = 1; i <= SYMBOLS.length(); i++) {
                String sonucsağ = "";

                for (char harf : mesajtex.toCharArray()) {
                    if (harf == ' ') {
                        sonucsağ += " ";
                        continue;
                    }

                    char buyukHarf = Character.toUpperCase(harf);
                    int index = SYMBOLS.indexOf(buyukHarf);
                    int yeniIndex = ((index - i) + SYMBOLS.length()) % SYMBOLS.length();
                    char yeniHarf = SYMBOLS.charAt(yeniIndex);
                    sonucsağ += yeniHarf;
                }

                JLabel cozulmuslabel = new JLabel(i + ": " + sonucsağ);
                sağ.add(cozulmuslabel);
            }

        }
    }

    public static void main(String[] args) {
        new ŞifrelemeSayfası();
    }
}

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

    public ŞifrelemeSayfası()
    {
        frame.setSize(500,500);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mesaj.setPreferredSize(new Dimension(40,150));
        key.setPreferredSize(new Dimension(40,150));
        mes.setFont(new Font("Arial",Font.BOLD,15));
        anahtar.setFont(new Font("Arial",Font.BOLD,15));
        gönder.addActionListener(this);
        frame.add(mes);
        frame.add(mesaj);
        frame.add(anahtar);
        frame.add(key);
        frame.add(gönder);

        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == gönder)
        {
            String mesajtex = mesaj.getText();
            String  keytex = key.getText();

            ŞifrelemeServisi servis = new ŞifrelemeServisi();

            servis.encrypt(mesajtex,Integer.parseInt(keytex));
        }

    }
}

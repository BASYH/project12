import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Kod extends JFrame {
private JTextField input = new JTextField("");
private JButton button = new JButton("������ � ���.�");
private JButton button1 = new JButton("������");
private JButton button2 = new JButton("������� ������� � ���. ��.");
private JButton button3 = new JButton("����������");
private JLabel label = new JLabel("��-220");
private JLabel label14 = new JLabel("����� ��");
private JLabel label15 = new JLabel("�������� ��������������� ����������� ����������� �����������");
private JLabel label16 = new JLabel("������������: �������� �.�.");
private JLabel label2 = new JLabel("��������� ������ ��������� ");
private JLabel label3 = new JLabel("");
private JLabel label4 = new JLabel("������� ���������� ���������� ");
private JLabel label5 = new JLabel("");
private JLabel label6 = new JLabel("������� ���������� �������� ");
private JLabel label7 = new JLabel("");
private JLabel label8 = new JLabel("�������� ������ �������� ");
private JLabel label9 = new JLabel("");
private JLabel label11 = new JLabel("���������� ������� ���������");
private JLabel label12 = new JLabel("");
private JLabel label10 = new JLabel();
private JLabel label13 = new JLabel();
private JLabel website = new JLabel();
private JLabel label17 = new JLabel("������ ���������� ���������");

public Kod() {
super("Simple Example");
this.setBounds(300,600,420,300);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setContentPane(new BgPanel());
button.addActionListener(new ButtonEventListener());
Container container = this.getContentPane();
container.setLayout(new GridLayout(23,2,0,0));
container.add(label14);
container.add(label15);
container.add(label);
container.add(label2);
container.add(label3);
container.add(label4);
container.add(label5);
container.add(label6);
container.add(label7);
container.add(label8);
container.add(label9);
container.add(label11);
container.add(label12);
container.add(input);
container.add(button);
container.add(label10);
container.add(button2);
container.add(button1);
container.add(button3);
container.add(label17);
container.add(label13);
container.add(label16);

website.setText("<html> ������ : "
+ "<a href=\"\">��� �����</a></html>");
website.setCursor(new Cursor(Cursor.HAND_CURSOR));
container.add(website);
goWebsite(website);

JFrame snakeFrame = new JFrame();
snakeFrame.setBounds(100, 200, 800, 800);
snakeFrame.setVisible(false);
snakeFrame.add(new JLabel(new ImageIcon("src/mnemo.png")));
snakeFrame.pack();
button1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent p) {
snakeFrame.setVisible(true);
}
});
ActionListener actionListener = new TestActionListener();
button2.addActionListener(actionListener);

}
class ButtonEventListener implements ActionListener {
public void actionPerformed(ActionEvent e) {
try {
int a = 60*Integer.parseInt(input.getText())*200/100;
label10.setText("����� ��������������� �����: "+a+" ���. �.");
}
catch (NumberFormatException a ) {
label10.setText("������� �������� ��������");

}
}
}

public class TestActionListener implements ActionListener {
public void actionPerformed(ActionEvent r) {
try {
int b = 60*Integer.parseInt(input.getText())*200;
label10.setText("����� ��������������� �����: "+b+" ���. ��.");
}
catch (NumberFormatException a ) {
label10.setText("������� �������� ��������");
}
}
}
private void goWebsite(JLabel website) {
website.addMouseListener(new MouseAdapter() {
@Override
 
public void mouseClicked(MouseEvent e) {
try {
Desktop.getDesktop().browse(new URI("http://asu.ugatu.ac.ru/"));
} catch (URISyntaxException | IOException ex) {
}
}
});
}

public static void main(String[] args) {
Kod app = new Kod();
app.setVisible(true);
}
class BgPanel extends JPanel{
public void paintComponent(Graphics g){
Image im = null;
try {
im = ImageIO.read(new File("src/logo.png"));
} catch (IOException e) {}
g.drawImage(im, 205,50, null);
}
}
}
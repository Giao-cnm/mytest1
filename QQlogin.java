import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class QQlogin {
	QQlogin(String title) {
		JFrame jframe = new JFrame();
		jframe.setLocation(350,200);  //���ڵ�����
		jframe.setTitle(title);   //���ڱ���
		jframe.setSize(300,200);  //���ڴ�С
		jframe.setVisible(true);  //���ô���Ϊ�ɼ�
		JPanel jpanel = new JPanel(); 
		BorderLayout borderlayout = new BorderLayout();
		JButton jbutton1 = new JButton("��¼");  //���ð�ť
		JButton jbutton2 = new JButton("ȡ��");
		JLabel lab1 = new JLabel("�û���");  //���ñ�ǩ
		JLabel lab2 = new JLabel("����");
		JTextField jtfl = new JTextField(20);    //�ı��򳤶�
		JPasswordField jp = new JPasswordField(20);
		jbutton1.setBounds(100,100,60,22);   //���������Ϳ�ȸ߶ȡ�
		jbutton2.setBounds(189,100,60,22);
		lab1.setBounds(50,35,80,22);
		lab2.setBounds(50,65,80,22);
		jtfl.setBounds(100,35,150,22);
		jp.setBounds(100,65,150,22);
		jpanel.setLayout(null);  //���ò���
		jpanel.add(jbutton1);    //�������õļ������
		jpanel.add(jbutton2);
		jpanel.add(lab1);
		jpanel.add(lab2);
		jpanel.add(jtfl );  
		jpanel.add(jp);
		jframe.add(jpanel);   //�����ӵ��˴�����
		jframe.setResizable(false);  //���ô��ڲ��ɸ��Ĵ�С
		jframe.getDefaultCloseOperation();   //Ĭ�Ϲر�
		//jframe.setDefaultCloseOperation(1);
	}
	public static void main(String[] args) {
		QQlogin qq = new QQlogin("QQ");
		Myclendar myclendar = new Myclendar();
	}
}

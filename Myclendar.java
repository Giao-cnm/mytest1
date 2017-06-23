import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Myclendar extends JFrame {
	JLabel lab_year = new JLabel("���"); // ����ָ���ı�����ݡ��͡��·ݡ���ǩ����
	JLabel lab_month = new JLabel("�·�");
	JComboBox com_year = new JComboBox(); // ������ݺ��·��б����
	JComboBox com_month = new JComboBox();
	JLabel lab[] = new JLabel[49]; // ����49������������ں����ڵĿձ�ǩ�������
	JPanel pan1 = new JPanel(); // ����������ݺ��·��б�����1����
	JPanel pan2 = new JPanel(new GridLayout(7, 7)); // �����������ں����ڵ����2����
	JPanel pan = new JPanel(new BorderLayout()); // �����������1��2������������������Ϊ�߽粼�ֹ���
	ImageIcon imageIcon = new ImageIcon(); // ����ͼ���ʽ����
	Calendar calendar = Calendar.getInstance(); // ���������෵�صĵ�ǰʱ���µ���������getInstance()�Ƿ��ص�ǰʱ���µ�������

	Myclendar() {// ���������������ϣ�Ȼ��������壬�ٰѸ������������úõĴ�����
		com_year.setBackground(Color.WHITE); // ���б���ɫ����Ϊ��ɫ
		com_month.setBackground(Color.WHITE);
		pan1.setOpaque(false); // �������1͸��
		pan1.add(lab_year); // �����±�ǩ���б�������η��������1��
		pan1.add(com_year);
		pan1.add(lab_month);
		pan1.add(com_month);
		for (int i = 0; i < 49; i++) {
			lab[i] = new JLabel(""); // ��ʼ����ǩ
			pan2.add(lab[i]); // ���ո��ǩ�ӵ����2��
		}
		pan.add(pan1, BorderLayout.NORTH);// �����1����������ϣ����ҷŵ����ı���
		pan.add(pan2, BorderLayout.CENTER);// �����2����������ϣ����ҷŵ������м�
		this.setContentPane(pan); // �������������ݴ�����
		this.init(); // ����������������ھ��廯�����м���
		com_year.addActionListener(new ClockActionListener()); // �������б����ʱ���������������ѡ��ʱActionListener������һ��ActionEvent
		com_month.addActionListener(new ClockActionListener());
		imageIcon = new ImageIcon("C:\\Users\\CR\\Pictures\\1.gif"); // ����ͼƬ����һ��ͼ�����
		JLabel imagelabel = new JLabel(imageIcon);// ��ͼ����ʾ��һ����ǩ����
		imagelabel.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());// �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������
		this.getLayeredPane().add(imagelabel, new Integer(Integer.MIN_VALUE));// �ѷű���ͼƬ�ı�ǩ���ڷֲ����ײ�
		pan.setOpaque(false); // ������壱�����������͸������ֹ�ڸǱ���ͼƬ
		pan1.setOpaque(false);
		pan2.setOpaque(false);
		this.setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight()); // ����ͼƬ��С���ô��ڴ�С
		this.setTitle("��������");
		this.setVisible(true); // ���ô��ڿɼ�
		this.setResizable(false); // ���ô��ڴ�С���ɸ���
	}

	public void init() { // �����ҵ�������������������
		for (int i = 0; i < 10000; i++) { // Ϊ�����б������
			com_year.addItem("" + i);
		}
		for (int i = 1; i < 13; i++) {
			com_month.addItem("" + i);
		}
		int year_now, month_now, firstday_month; // ���õ�ǰ���º͵�ǰ�µ�һ��ȱ���
		year_now = calendar.get(Calendar.YEAR); // �����ص�����������ݸ�ֵ��year_now����
		month_now = calendar.get(Calendar.MONTH); // �����ص����������·ݸ�ֵ��month_now����
		com_year.setSelectedIndex(year_now); // ѡ���б��е�year_now��
		com_month.setSelectedIndex(month_now); // ѡ���б��е�month_now��
		String week[] = { "��", "һ ", "��", "��", "��", "��", "��" };// �������ڸ�ֵ������week[]
		for (int i = 0; i < 7; i++) { // ���������η����ڱ�ǩ��
			lab[i].setText(week[i]); // �������ı����η����ڱ�ǩ�У�setText(String
										// text)�����Ƕ������������ʾ���ı��ַ�����
		}
		for (int i = 0; i < 49; i = i + 7) {
			lab[i].setForeground(Color.WHITE); // ������������ǰ��ɫ����Ϊ��ɫ
		}
		for (int i = 6; i < 49; i = i + 7) { // ��������������Ϊ��ɫ
			lab[i].setForeground(Color.WHITE); // ������������ǰ��ɫ����Ϊ��ɫ
		}
		firstday_month = getFirstDayOfMonth(year_now, month_now); // ���ҵ�������getFirstDayOfMonth�����ĵ���ǰ�µ�һ��
		addDay(year_now, month_now, firstday_month); // ���ҵ�������addDay�����õ������������ϵ��������ڣ�����б�û��ѡ��ĳ�������������ʾ����
	}

	class ClockActionListener implements ActionListener { // ���ü̳м����ӿڵ�ʱ�������
		public void actionPerformed(ActionEvent e) { // ���б�������ʱ���ã����б�ѡ��ĳ��ʱ����
			int year_now, month_now, firstday_month; // �����ձ���
			year_now = Integer.parseInt(com_year.getSelectedItem().toString());// �����صĵ�ǰ��ѡ�������ֵ��ֵ��year_now
			month_now = Integer.parseInt(com_month.getSelectedItem().toString()) - 1; // �����صĵ�ǰ��ѡ�������ֵ��ֵ��month_now
			firstday_month = getFirstDayOfMonth(year_now, month_now); // ���ҵ�������getFirstDayOfMonth�����õ���ǰ�µ�һ��
			addDay(year_now, month_now, firstday_month); // ���ҵ�������addDay�����õ���Ӧ�ľ�������
		}
	}

	public int getFirstDayOfMonth(int year_now, int month_now) // �ɵ�ǰ���µõ���ǰ�µ�һ��
	{
		int firstday_month;
		calendar.set(year_now, month_now, 1); // ����/ָ���ҵ������е�ǰ���º͵�ǰ���µĵ�һ��
		firstday_month = calendar.get(Calendar.DAY_OF_WEEK);// ���ص�һ���Ӧ�����ڵĵڼ����ֵ��ע��һ�����ڵ�һ����������
		return firstday_month; // ���ص�ǰ�µ�һ��
	}

	public void addDay(int year_now, int month_now, int firstday_month) // �ɵ�ǰ���º͵�ǰ�µ�һ��õ���ǰ��������
	{
		int firstday = 1; // ���õ�һ�죬���һ�죬count�Ⱦֲ�����
		int lastday_month = 0;
		int count = 1;
		calendar.set(year_now, month_now, 1);// ����/ָ���ҵ������е�ǰ���º͵�ǰ�µ�һ��
		lastday_month = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); // ��õ�һ�������µ����ֵ����ֵ��lastday_month
		for (int j = 7; j < 49; j++) {
			lab[j].setText(""); // ��ʼ����ǩ
		}
		firstday = firstday_month + 7 - 1; // �õ���һ���ڱ�ǩ�ϵ�λ��
		lastday_month = lastday_month + firstday - 1; // �õ����һ���ڱ�ǩ�ϵ�λ��
		for (int i = firstday; i <= lastday_month; i++) // �����ڷ��õ���ǩ��
		{
			lab[i].setText(count + "");
			count++;
		}
	}
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

public class Insert_STU extends BFrame implements ActionListener{

	JPanel pan1 = new JPanel();
	JButton bt1 = new JButton("���ΰ�ħ");
	JButton bt2 = new JButton("�л����");
	JButton bt3 = new JButton("�л��˻�");
	JButton bt4 = new JButton("�л�����");
	JButton bt5 = new JButton("�л�����");
	JButton bt6 = new JButton("���ư���");
	JPanel pan2 = new JPanel();
	
	JTable table;
	JScrollPane scpan;
	
	String col[] = {"�й�", "�̸�", "�ֹι�ȣ","����","�Ϻ����","IT��","��ȭ��ȣ","���"};
	
	
	DAO dao = new DAO();
	ArrayList<STUBean> list;
	STUBean bean;
	
	public Insert_STU() {
		this.setTitle("�л����");
		list = dao.allstu();
		init();
	}
	
	public Insert_STU(ArrayList<STUBean> list) {
		this.setTitle("�л����");
		this.list = list;
		init();
	}
	
	private void init() {
		Container con = this.getContentPane();
		
		bt1.setBackground(Color.white);
		bt2.setBackground(Color.white);
		bt3.setBackground(Color.white);
		bt4.setBackground(Color.white);
		bt5.setBackground(Color.white);
		bt6.setBackground(Color.white);
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
		bt5.addActionListener(this);
		bt6.addActionListener(this);
		pan1.add(bt1);
		pan1.add(bt2);
		pan1.add(bt3);
		pan1.add(bt4);
		pan1.add(bt5);
		pan1.add(bt6);
		
		String record[][] = new String[list.size()][col.length];
		for(int i = 0; i<list.size();i++) {
			bean = list.get(i);
			String s = Integer.toString(bean.getNum());
			record[i][0] = s;
			record[i][1] = bean.getName();
			record[i][2] = bean.getJumin();
			record[i][3] = bean.getSex();
			record[i][4] = bean.getJp();
			record[i][5] = bean.getIt();
			record[i][6] = bean.getPhone();
			record[i][7] = bean.getNo();
		}
		
		table = new JTable(record,col);
		scpan = new JScrollPane(table);
		JPanel panline = new JPanel(new BorderLayout());
		panline.setBorder(new TitledBorder(new EtchedBorder(),"�л����"));
		panline.add(scpan,BorderLayout.CENTER);
		con.add("North", pan1);
		con.add("Center", panline);
		this.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("���ΰ�ħ")){
			dispose();
			new Insert_STU();
		}else if(e.getActionCommand().equals("�л����")){
			new Input_STU();
		}else if(e.getActionCommand().equals("�л��˻�")){
			new Search_STU();
		}else if(e.getActionCommand().equals("�л�����")){
			new Update_STU();
		}else if(e.getActionCommand().equals("�л�����")){
			new Delete_STU();
		}else if(e.getActionCommand().equals("���ư���")){
			dispose();
		}
		
	}

}

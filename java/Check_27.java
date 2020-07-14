import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class Check_27 extends BFrame implements ActionListener{
	JPanel pan1 = new JPanel();
	JButton bt1 = new JButton("���ΰ�ħ");
	JButton bt2 = new JButton("�˻�");
	JButton bt3 = new JButton("���ư���");
	
	JPanel pan2 = new JPanel();
	
	JTable table;
	JScrollPane scpan;
	
	String col[] = {"��¥","���", "�й�", "�̸�","�Ϻ����","�⼮","����Ƽ��", "�⼮"};
	
	DAO dao = new DAO();
	ArrayList<_27Bean> list;
	_27Bean bean;
	
	public Check_27(){
		this.setTitle("27�� �⼮Ȯ��");
		list = dao.check_all27();
		init();
	}
	public Check_27(ArrayList<_27Bean> list){
		this.setTitle("27�� �⼮Ȯ��");
		this.list = list;
		init();
	}
	private void init() {
		Container con = this.getContentPane();
		bt1.setBackground(Color.white);
		bt2.setBackground(Color.white);
		bt3.setBackground(Color.white);
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		
		pan1.add(bt1);
		pan1.add(bt2);
		pan1.add(bt3);
		
		
		String record[][] = new String[list.size()][col.length];
		for(int i = 0; i<list.size();i++) {
			bean = list.get(i);
			String s = Integer.toString(bean.getNum());
			record[i][0] = bean.getDate();
			record[i][1] = bean.getNo();
			record[i][2] = s;
			record[i][3] = bean.getName();
			record[i][4] = bean.getJp();
			record[i][5] = bean.getJp_att();
			record[i][6] = bean.getIt();
			record[i][7] = bean.getIt_att();
		}
		
		table = new JTable(record,col);
		scpan = new JScrollPane(table);
		JPanel panline = new JPanel(new BorderLayout());
		panline.setBorder(new TitledBorder(new EtchedBorder(),"27�� �л����"));
		panline.add(scpan,BorderLayout.CENTER);
		con.add("North", pan1);
		con.add("Center", panline);
		this.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("�˻�")){
			new CheckSearch_27();
		}else if(e.getActionCommand().equals("���ư���")){
			dispose();
		}else if(e.getActionCommand().equals("���ΰ�ħ")){
			dispose();
			new Check_27();
		}

	}
}

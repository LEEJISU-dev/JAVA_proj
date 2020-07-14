import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Update_STU extends BFrame implements ActionListener{
	JLabel lab = new JLabel("�й�");
	JTextField txtf = new JTextField(10);
	JButton bt = new JButton("�˻�");
	JPanel pan = new JPanel();
	
	
	JLabel lab1 = new JLabel("�̸�");
	JLabel lab2 = new JLabel("�ֹι�ȣ");
	JLabel lab3 = new JLabel("����");
	JLabel lab4 = new JLabel("�Ϻ����");
	JLabel lab5 = new JLabel("����Ƽ��");
	JLabel lab6 = new JLabel("��ȭ��ȣ");
	JLabel lab7 = new JLabel("���");
	
	String arrJp[] = {"---","�ʱ�1", "�ʱ�2","�߱�","���"};
	String arrIt[] = {"---","A��","B��"};
	String arrNo[] = {"---","26��","27��"};
	String arrS[] = {"---","����", "����"};
    
	JTextField txt = new JTextField(10);
	JTextField txtf1 = new JTextField(10);
	JTextField txtf2 = new JTextField(10);
	JTextField txtf3 = new JTextField(10);
	
	JComboBox jpcb = new JComboBox(arrJp);
	JComboBox itcb = new JComboBox(arrIt);
	JComboBox nocb = new JComboBox(arrNo);
	JComboBox scb = new JComboBox(arrS);
	JPanel pan1 = new JPanel();
	
	JButton bt1 = new JButton("����");
	JButton bt2 = new JButton("���");
	JPanel pan2 = new JPanel();
	
	String col[] = {"�й�", "�̸�", "�ֹι�ȣ","����","�Ϻ����","IT��","��ȭ��ȣ","���"};
	DAO dao = new DAO();
	ArrayList<STUBean> list;
	STUBean bean;
	
	public Update_STU(){
		this.setTitle("�л� ���� ����");
		init();
	}
	private void init(){
		Container con = this.getContentPane();
		txt.setEnabled(false);
		
		pan.add(lab);
		pan.add(txtf);
		pan.add(bt);
		
		pan1.setLayout(new GridLayout(8, 1));
		pan1.add(lab);
		pan1.add(txt);
		pan1.add(lab1);
		pan1.add(txtf1);
		pan1.add(lab2);
		pan1.add(txtf2);
		pan1.add(lab3);
		pan1.add(scb);
		pan1.add(lab4);
		pan1.add(jpcb);
		pan1.add(lab5);
		pan1.add(itcb);
		pan1.add(lab6);
		pan1.add(txtf3);
		pan1.add(lab7);
		pan1.add(nocb);
		
		pan2.add(bt1);
		pan2.add(bt2);
		
		bt1.setBackground(Color.white);
		bt2.setBackground(Color.white);
		bt.setBackground(Color.white);

		bt.addActionListener(this);
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		scb.addActionListener(this);
		jpcb.addActionListener(this);
		itcb.addActionListener(this);
		nocb.addActionListener(this);
		
		con.add("North", pan);
		con.add("Center",pan1);
		con.add("South",pan2);
		
		this.pack();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("�˻�")){
			String num = txtf.getText();
			list= dao.updateSTU(num);
			txt.setText(num);
			txtf1.setText(list.get(0).getName());
			txtf2.setText(list.get(0).getJumin());
			scb.setSelectedItem(list.get(0).getSex());
			jpcb.setSelectedItem(list.get(0).getJp());
			itcb.setSelectedItem(list.get(0).getIt());
			txtf3.setText(list.get(0).getPhone());
			nocb.setSelectedItem(list.get(0).getNo());
			
		}else if(e.getActionCommand().equals("����")){
			String num =txt.getText();
			String name = txtf1.getText();
			String jumin = txtf2.getText();
			String sex = (String)scb.getSelectedItem();
			String jp = (String)jpcb.getSelectedItem();
			String it = (String)itcb.getSelectedItem();
			String phone = txtf3.getText();
			String no =(String)nocb.getSelectedItem();
			dao.updateSTU2(num, name, jumin, sex, jp, it, phone, no);
			JOptionPane.showMessageDialog(this, "�����Ǿ����ϴ�");
			dispose();
		}else if(e.getActionCommand().equals("���")){
			dispose();
		}
		
	}

}

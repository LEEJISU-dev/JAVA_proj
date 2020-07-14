import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

public class Input_STU extends BFrame implements ActionListener{
	JLabel lab = new JLabel("�л����");
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
      
	JTextField txtf1 = new JTextField(10);
	JTextField txtf2 = new JTextField(10);
	JTextField txtf3 = new JTextField(10);
	
	JComboBox jpcb = new JComboBox(arrJp);
	JComboBox itcb = new JComboBox(arrIt);
	JComboBox nocb = new JComboBox(arrNo);
	JComboBox scb = new JComboBox(arrS);
	
	JPanel cpan = new JPanel();
	
	JButton bt = new JButton("Ȯ��");
	JButton bt1 = new JButton("���");
	JPanel span = new JPanel();
	DAO dao = new DAO();
	ArrayList<STUBean> list;
	
	public Input_STU(){
		this.setTitle("ȸ�����");
		init();
	}
	
	private void init(){
		Container con = this.getContentPane();
		pan.setBackground(Color.DARK_GRAY);
		lab.setForeground(Color.white);
		pan.add(lab);
		
		cpan.setLayout(new GridLayout(8, 1));
		cpan.add(lab1);
		cpan.add(txtf1);
		cpan.add(lab2);
		cpan.add(txtf2);
		cpan.add(lab3);
		cpan.add(scb);
		cpan.add(lab4);
		cpan.add(jpcb);
		cpan.add(lab5);
		cpan.add(itcb);
		cpan.add(lab6);
		cpan.add(txtf3);
		cpan.add(lab7);
		cpan.add(nocb);
		
		bt1.setBackground(Color.white);
		bt.setBackground(Color.white);
		
		bt.addActionListener(this);
		bt1.addActionListener(this);
		scb.addActionListener(this);
		jpcb.addActionListener(this);
		itcb.addActionListener(this);
		nocb.addActionListener(this);
		
		span.add(bt);
		span.add(bt1);
		
		con.add("North", pan);
		con.add("Center", cpan);
		con.add("South", span);
		
		this.pack();
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Ȯ��")){
			String name = txtf1.getText();
			String jumin = txtf2.getText();
			String sex = (String)scb.getSelectedItem();
			String jp = (String)jpcb.getSelectedItem();
			String it = (String)itcb.getSelectedItem();
			String phone = txtf3.getText();
			String no =(String)nocb.getSelectedItem();
			dao.insertSTU(name, jumin, sex, jp, it, phone, no);
			JOptionPane.showMessageDialog(this, "��ϵǾ����ϴ�");
			dispose();
		}else if(e.getActionCommand().equals("���")){
			dispose();
			
			
			
		}
		
	}
	
	

}

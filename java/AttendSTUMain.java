import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class AttendSTUMain extends BFrame implements ActionListener{
	JPanel pan1 = new JPanel();
	
	JButton bt1 = new JButton("27�� �Ϻ����");
	JButton bt2 = new JButton("27�� IT��");
	JButton bt3 = new JButton("26�� �Ϻ����");
	JButton bt4 = new JButton("26�� IT��");
	JButton bt5 = new JButton("���ư���");

	DAO dao = new DAO();
	ArrayList<STUBean> list;
	STUBean bean;
	
	public AttendSTUMain(){
		this.setTitle("�⼮����");
		init();
	}
	
	public AttendSTUMain(ArrayList<STUBean> list){
		this.setTitle("�⼮����");
		init();
	}
	private void init() {
		Container con = this.getContentPane();
		bt1.setBackground(Color.white);
		bt2.setBackground(Color.white);
		bt3.setBackground(Color.white);
		bt4.setBackground(Color.white);
		bt5.setBackground(Color.white);

		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
		bt5.addActionListener(this);
		
		pan1.add(bt5);
		
		JPanel panline = new JPanel(new FlowLayout());
		
		panline.add(bt1,BorderLayout.CENTER);
		panline.add(bt2,BorderLayout.CENTER);
		panline.add(bt3,BorderLayout.CENTER);
		panline.add(bt4,BorderLayout.CENTER);
		con.add("North", pan1);
		con.add("Center", panline);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("27�� �Ϻ����")){
			new JP_STU27();
		}else if(e.getActionCommand().equals("27�� IT��")){
			new IT_STU27();
		}else if(e.getActionCommand().equals("26�� �Ϻ����")){
			new JP_STU26();
		}else if(e.getActionCommand().equals("26�� IT��")){
			new IT_STU26();
		}else 
			dispose();
		
	}

	

}

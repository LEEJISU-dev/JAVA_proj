import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class CheckSTUMain extends BFrame implements ActionListener{
	JPanel pan1 = new JPanel();
	
	JButton bt = new JButton("���ư���");
	JButton bt1 = new JButton("27��");
	JButton bt2 = new JButton("26��");
	
	DAO dao = new DAO();
	ArrayList<STUBean> list;
	STUBean bean;
	
	public CheckSTUMain() {
		this.setTitle("�⼮Ȯ��");
		init();
	}
	
	private void init() {
		Container con = this.getContentPane();
		bt.setBackground(Color.lightGray);
		bt1.setBackground(Color.white);
		bt2.setBackground(Color.white);
		bt.addActionListener(this);
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		
		pan1.add(bt);
		
		JPanel panline = new JPanel(new FlowLayout());
		
		panline.add(bt1,BorderLayout.CENTER);
		panline.add(bt2,BorderLayout.CENTER);

		con.add("North", pan1);
		con.add("Center", panline);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("27��")){
			new Check_27();
		}else if(e.getActionCommand().equals("26��")){
			new Check_26();
		}else if(e.getActionCommand().equals("���ư���"))
			dispose();
		
	}

}

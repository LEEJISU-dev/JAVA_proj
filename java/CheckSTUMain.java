import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class CheckSTUMain extends BFrame implements ActionListener{
	JPanel pan1 = new JPanel();
	
	JButton bt = new JButton("돌아가기");
	JButton bt1 = new JButton("27기");
	JButton bt2 = new JButton("26기");
	
	DAO dao = new DAO();
	ArrayList<STUBean> list;
	STUBean bean;
	
	public CheckSTUMain() {
		this.setTitle("출석확인");
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
		if(e.getActionCommand().equals("27기")){
			new Check_27();
		}else if(e.getActionCommand().equals("26기")){
			new Check_26();
		}else if(e.getActionCommand().equals("돌아가기"))
			dispose();
		
	}

}

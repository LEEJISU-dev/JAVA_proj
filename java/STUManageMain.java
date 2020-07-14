import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class STUManageMain extends BFrame implements ActionListener{
	ButtonGroup group = new ButtonGroup();
	JButton bt1 = new JButton("학생 관리");
	JButton bt2 = new JButton("출석 관리");
	JButton bt3 = new JButton("출석 확인");
	JButton bt4 = new JButton("종료");
	JPanel pan = new JPanel();
	JPanel pan1 = new JPanel();
	JPanel pan1_1 = new JPanel();
	ImageIcon img = new ImageIcon("D:\\img\\main.jpg");
	JLabel lab = new JLabel(img);
	JPanel pan2 = new JPanel();
	DAO mgr = new DAO();
	
	public STUManageMain(){
		this.setTitle("학생 출석 관리 프로그램");
		this.setBounds(100,200,300,300);
		init();
	}
	
	private void init() {
		Container con = this.getContentPane();
		pan1.setBackground(Color.WHITE);
		bt1.setBackground(Color.white);
		bt2.setBackground(Color.white);
		bt3.setBackground(Color.white);
		bt4.setBackground(Color.white);
		pan1.add(pan1_1);
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
		pan1.add(bt1);
		pan1.add(bt2);
		pan1.add(bt3);
		pan1.add(bt4);
		pan.add(lab);
		con.add("North", pan1);
		con.add("South", pan);
		
		this.pack();
	}
	public static void main(String[] args) {
		new STUManageMain();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if(button.equals(bt1.getText())) {
			new Insert_STU();
		}else if(button.equals(bt2.getText())){
			new AttendSTUMain();
		}else if(button.equals(bt3.getText())){
			new CheckSTUMain();
		}else if(button.equals(bt4.getText())) {
			System.exit(0);
		}
		
	}
}

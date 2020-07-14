import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Admin_Login extends BFrame implements ActionListener {
	public static void main(String[] args) {
		new Admin_Login();
	}//1
	ImageIcon img = new ImageIcon("D:\\img\\admin.png");
	JLabel labimg = new JLabel(img);
	JPanel cpan = new JPanel();
	//4
	JLabel lab = new JLabel("관리자로그인");
	JPanel pan = new JPanel();
	///5
	
	//North
	JLabel lab1 = new JLabel("ID : ");
	JTextField txtf = new JTextField(10);
	JLabel lab2 = new JLabel("PW : ");
	JTextField txtf1 = new JPasswordField(10);
	
	JPanel pan1 = new JPanel();
	//////6
	//Center
	JButton bt = new JButton("로그인");
	JButton bt1 = new JButton("종료");
	JPanel pan2 = new JPanel();
	//7
	
	DAO mgr = new DAO();
	ArrayList<AdminBean> list;
	AdminBean bean;
	//3
	
	public Admin_Login() {
		this.setTitle("관리자 로그인");
		list = mgr.login();
		init();
	}
	//8
	private void init() {
		Container con = this.getContentPane();
		pan.setBackground(Color.black);
		lab.setForeground(Color.white);
		pan.add(lab);
		pan1.add(labimg);
		bt1.setBackground(Color.white);
		bt.setBackground(Color.white);
		bt.addActionListener(this);
		bt1.addActionListener(this);
		pan2.add(lab1);
		pan2.add(txtf);
		pan2.add(lab2);
		pan2.add(txtf1);
		pan2.add(bt);
		pan2.add(bt1);
		
		con.add("Center", pan1);
		con.add("South", pan2);
		
		this.pack();
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if(str.equals("로그인")) {
			String id = txtf.getText();
			String pw = txtf1.getText();
			
			if(id.equals(list.get(0).getId())&&pw.equals(list.get(0).getPw())) {
				STUManageMain bmm = new STUManageMain();
				dispose();
			}else {
				JOptionPane.showMessageDialog(null, "Login Erro..","ErrorMessage",JOptionPane.ERROR_MESSAGE);
				txtf.setText("");
				txtf1.setText("");
			}
		}else {
			dispose();
		}
		
	}
}

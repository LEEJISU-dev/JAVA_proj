import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

public class Input_STU extends BFrame implements ActionListener{
	JLabel lab = new JLabel("학생등록");
	JPanel pan = new JPanel();
	
	JLabel lab1 = new JLabel("이름");
	JLabel lab2 = new JLabel("주민번호");
	JLabel lab3 = new JLabel("성별");
	JLabel lab4 = new JLabel("일본어반");
	JLabel lab5 = new JLabel("아이티반");
	JLabel lab6 = new JLabel("전화번호");
	JLabel lab7 = new JLabel("기수");
	
	String arrJp[] = {"---","초급1", "초급2","중급","상급"};
	String arrIt[] = {"---","A반","B반"};
	String arrNo[] = {"---","26기","27기"};
	String arrS[] = {"---","남자", "여자"};
      
	JTextField txtf1 = new JTextField(10);
	JTextField txtf2 = new JTextField(10);
	JTextField txtf3 = new JTextField(10);
	
	JComboBox jpcb = new JComboBox(arrJp);
	JComboBox itcb = new JComboBox(arrIt);
	JComboBox nocb = new JComboBox(arrNo);
	JComboBox scb = new JComboBox(arrS);
	
	JPanel cpan = new JPanel();
	
	JButton bt = new JButton("확인");
	JButton bt1 = new JButton("취소");
	JPanel span = new JPanel();
	DAO dao = new DAO();
	ArrayList<STUBean> list;
	
	public Input_STU(){
		this.setTitle("회원등록");
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
		if(e.getActionCommand().equals("확인")){
			String name = txtf1.getText();
			String jumin = txtf2.getText();
			String sex = (String)scb.getSelectedItem();
			String jp = (String)jpcb.getSelectedItem();
			String it = (String)itcb.getSelectedItem();
			String phone = txtf3.getText();
			String no =(String)nocb.getSelectedItem();
			dao.insertSTU(name, jumin, sex, jp, it, phone, no);
			JOptionPane.showMessageDialog(this, "등록되었습니다");
			dispose();
		}else if(e.getActionCommand().equals("취소")){
			dispose();
			
			
			
		}
		
	}
	
	

}

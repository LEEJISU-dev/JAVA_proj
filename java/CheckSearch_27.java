import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class CheckSearch_27 extends BFrame implements ActionListener{
	JLabel lab = new JLabel("��¥�˻�");
	JPanel pan = new JPanel();
	
	JLabel lab1 = new JLabel("��¥");
	JTextField txtf = new JTextField(10);
	JPanel cpan = new JPanel();
	
	JButton bt = new JButton("�˻�");
	JButton bt1 = new JButton("���");
	JPanel span = new JPanel();
	DAO dao = new DAO();
	ArrayList<_27Bean> list;
	
	public CheckSearch_27(){
		this.setTitle("��¥ �˻�");
		init();
	}
	
	private void init(){
		Container con = this.getContentPane();
		pan.setBackground(Color.DARK_GRAY);
		lab.setForeground(Color.white);
		pan.add(lab);
		bt1.setBackground(Color.white);
		bt.setBackground(Color.white);
		bt.addActionListener(this);
		bt1.addActionListener(this);
		cpan.add(lab1);
		cpan.add(txtf);
		span.add(bt);
		span.add(bt1);
		
		con.add("North", pan);
		con.add("Center", cpan);
		con.add("South", span);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("�˻�")){
				String day =txtf.getText();
				list = dao.search27(day);
			JOptionPane.showMessageDialog(this, "��ȸ�Ǿ����ϴ�");
			new Check_27(list);
		}else if(e.getActionCommand().equals("���")){
			dispose();
		}
		
	}
}

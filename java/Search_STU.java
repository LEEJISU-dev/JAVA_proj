import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Search_STU extends BFrame implements ActionListener{
	
	JLabel lab = new JLabel("학생검색");
	JPanel pan = new JPanel();
	
	JLabel lab1 = new JLabel("학생학번");
	JTextField txtf = new JTextField(10);
	JPanel cpan = new JPanel();
	
	JButton bt = new JButton("검색");
	JButton bt1 = new JButton("취소");
	JPanel span = new JPanel();
	DAO dao = new DAO();
	ArrayList<STUBean> list;
	
	public Search_STU(){
		this.setTitle("학생 검색");
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
		if(e.getActionCommand().equals("검색")){
				String num =txtf.getText();
				list = dao.searchSTU(num);
			JOptionPane.showMessageDialog(this, "조회되었습니다");
			new Insert_STU(list);
		}else if(e.getActionCommand().equals("취소")){
			dispose();
		}
		
	}

}

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;

public class Update_it26 extends BFrame implements ActionListener{
	Date d= new Date();
	SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	
	JLabel lab = new JLabel("날짜");
	JTextField txtf = new JTextField(10);
	JLabel labb = new JLabel("학번");
	JTextField txtff = new JTextField(10);
	JButton bt = new JButton("검색");
	JPanel pan = new JPanel();
	
	JLabel lab1 = new JLabel("날짜");
	JLabel lab2 = new JLabel("기수");
	JLabel lab3 = new JLabel("학번");
	JLabel lab4 = new JLabel("이름");
	JLabel lab5 = new JLabel("아이티반");
	JLabel lab6 = new JLabel("출석여부");
	
	String arrA[] = {"출석","결석","지각"};
	
	JTextField txtf1 = new JTextField(10);
	JTextField txtf2 = new JTextField(10);
	JTextField txtf3 = new JTextField(10);
	JTextField txtf4 = new JTextField(10);
	JTextField txtf5 = new JTextField(10);
	
	JComboBox Attcb = new JComboBox(arrA);
	JPanel pan1 = new JPanel();
	
	String col[] = {"날짜","기수", "학번", "이름","아이티반","출석여부"};

	JButton bt1 = new JButton("수정");
	JButton bt2 = new JButton("취소");
	JPanel pan2 = new JPanel();
	
	DAO2 dao = new DAO2();
	ArrayList<it27Bean> list;
	it27Bean bean;
	
	public Update_it26(){
		this.setTitle("출석수정");
		init();
	}
	
	private void init() {
		Container con = this.getContentPane();
	
		/*txtf2.setEnabled(false);
		txtf3.setEnabled(false);
		txtf4.setEnabled(false);
		txtf5.setEnabled(false);*/
		
		pan.add(lab);
		pan.add(txtf);
		pan.add(labb);
		pan.add(txtff);
		pan.add(bt);

		pan1.setLayout(new GridLayout(6, 1));
		pan1.add(lab1);
		pan1.add(txtf1);
		pan1.add(lab2);
		pan1.add(txtf2);
		pan1.add(lab3);
		pan1.add(txtf3);
		pan1.add(lab4);
		pan1.add(txtf4);
		pan1.add(lab5);
		pan1.add(txtf5);
		pan1.add(lab6);
		pan1.add(Attcb);
		
		
		pan2.add(bt1);
		pan2.add(bt2);
	    
		bt.setBackground(Color.white);
		bt1.setBackground(Color.white);
		bt2.setBackground(Color.white);
		
		bt.addActionListener(this);
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		Attcb.addActionListener(this);
		
		con.add("North", pan);
		con.add("Center", pan1);
		con.add("South", pan2);
		
		this.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("검색")){
			String day = txtf.getText();
			String num = txtff.getText();
			list = dao.update_It26(day, num);
			
			txtf1.setText(day);
			txtf2.setText(list.get(0).getNo());
			txtf3.setText(num);
			txtf4.setText(list.get(0).getName());
			txtf5.setText(list.get(0).getIt());
			Attcb.setSelectedItem(list.get(0).getIt_att());

		}else if(e.getActionCommand().equals("수정")){
			String num = txtff.getText();
			String day = txtf1.getText();
			String it_att = (String)Attcb.getSelectedItem();
			dao.update2_It26(num,day, it_att);
			JOptionPane.showMessageDialog(this, "수정되었습니다");
			dispose();
		}else if(e.getActionCommand().equals("취소"))
			dispose();
		
	}

}

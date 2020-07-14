import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class Check_27 extends BFrame implements ActionListener{
	JPanel pan1 = new JPanel();
	JButton bt1 = new JButton("새로고침");
	JButton bt2 = new JButton("검색");
	JButton bt3 = new JButton("돌아가기");
	
	JPanel pan2 = new JPanel();
	
	JTable table;
	JScrollPane scpan;
	
	String col[] = {"날짜","기수", "학번", "이름","일본어반","출석","아이티반", "출석"};
	
	DAO dao = new DAO();
	ArrayList<_27Bean> list;
	_27Bean bean;
	
	public Check_27(){
		this.setTitle("27기 출석확인");
		list = dao.check_all27();
		init();
	}
	public Check_27(ArrayList<_27Bean> list){
		this.setTitle("27기 출석확인");
		this.list = list;
		init();
	}
	private void init() {
		Container con = this.getContentPane();
		bt1.setBackground(Color.white);
		bt2.setBackground(Color.white);
		bt3.setBackground(Color.white);
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		
		pan1.add(bt1);
		pan1.add(bt2);
		pan1.add(bt3);
		
		
		String record[][] = new String[list.size()][col.length];
		for(int i = 0; i<list.size();i++) {
			bean = list.get(i);
			String s = Integer.toString(bean.getNum());
			record[i][0] = bean.getDate();
			record[i][1] = bean.getNo();
			record[i][2] = s;
			record[i][3] = bean.getName();
			record[i][4] = bean.getJp();
			record[i][5] = bean.getJp_att();
			record[i][6] = bean.getIt();
			record[i][7] = bean.getIt_att();
		}
		
		table = new JTable(record,col);
		scpan = new JScrollPane(table);
		JPanel panline = new JPanel(new BorderLayout());
		panline.setBorder(new TitledBorder(new EtchedBorder(),"27기 학생목록"));
		panline.add(scpan,BorderLayout.CENTER);
		con.add("North", pan1);
		con.add("Center", panline);
		this.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("검색")){
			new CheckSearch_27();
		}else if(e.getActionCommand().equals("돌아가기")){
			dispose();
		}else if(e.getActionCommand().equals("새로고침")){
			dispose();
			new Check_27();
		}

	}
}

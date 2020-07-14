import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

public class JP_STU27 extends BFrame implements ActionListener {

	Date d = new Date();
	SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	JPanel pan1 = new JPanel();
	JButton bt1 = new JButton("새로고침");
	JButton bt2 = new JButton("출석등록");
	JButton bt3 = new JButton("출석수정");
	JButton bt4 = new JButton("돌아가기");
	JPanel pan2 = new JPanel();

	JTable table;
	JScrollPane scpan;

	String col[] = { "날짜", "기수", "학번", "이름", "일본어반", "출석여부" };

	DAO dao = new DAO();
	ArrayList<jp27Bean> list;
	jp27Bean bean;

	public JP_STU27() {
		this.setTitle("27기 일본어 학생 목록");
		list = dao.alljp_27();
		init();
	}

	public JP_STU27(ArrayList<jp27Bean> list) {
		this.setTitle("27기 일본어 학생 목록");
		this.list = list;
		init();
	}

	private void init() {
		Container con = this.getContentPane();
		bt1.setBackground(Color.white);
		bt2.setBackground(Color.white);
		bt3.setBackground(Color.white);
		bt4.setBackground(Color.white);
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);

		pan1.add(bt1);
		pan1.add(bt2);
		pan1.add(bt3);
		pan1.add(bt4);

		String record[][] = new String[list.size()][col.length];
		for (int i = 0; i < list.size(); i++) {
			bean = list.get(i);
			String s = Integer.toString(bean.getNum());
			record[i][0] = bean.getDate();
			record[i][1] = bean.getNo();
			record[i][2] = s;
			record[i][3] = bean.getName();
			record[i][4] = bean.getJp();
			record[i][5] = bean.getJp_att();
		}

		table = new JTable(record, col);
		scpan = new JScrollPane(table);
		JPanel panline = new JPanel(new BorderLayout());
		panline.setBorder(new TitledBorder(new EtchedBorder(), "27기 일본어반 학생목록"));
		panline.add(scpan, BorderLayout.CENTER);
		con.add("North", pan1);
		con.add("Center", panline);
		this.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("새로고침")) {
			dispose();
			new JP_STU27();
		} else if (e.getActionCommand().equals("출석등록")) {
			list = dao.insertJp_27();
			try {
				if (date.format(d).equals(bean.getDate())) {
					dao.delete_Jp27(date.format(d));
				}
			} catch (NullPointerException ee) {
				ee.printStackTrace();
			}
			new Input_jp27();

		} else if (e.getActionCommand().equals("출석수정")) {
			new Update_jp27();
		} else
			dispose();

	}

}
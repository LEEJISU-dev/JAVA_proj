import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import javax.swing.text.ChangedCharSetException;
import java.util.*;

public class Input_it26 extends BFrame implements ActionListener {
	Date d = new Date();
	SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	JPanel pan1 = new JPanel();

	JTable table;
	JScrollPane scpan;

	String col[] = { "날짜", "기수", "학번", "이름", "아이티반", "출석여부" };

	JComboBox atcb = new JComboBox();

	JButton bt1 = new JButton("확인");
	JButton bt2 = new JButton("취소");

	DAO2 dao = new DAO2();
	ArrayList<it27Bean> list;
	it27Bean bean;

	public Input_it26() {
		this.setTitle("출석등록");
		list = dao.allit_26();
		init();
	}

	private void init() {
		Container con = this.getContentPane();
		bt1.setBackground(Color.white);
		bt2.setBackground(Color.white);

		String record[][] = new String[list.size()][col.length];
		for (int i = 0; i < list.size(); i++) {
			bean = list.get(i);
			String s = Integer.toString(bean.getNum());
			if (bean.getDate() == null) {
				record[i][0] = date.format(d);
			} else {
				record[i][0] = bean.getDate();
			}
			record[i][1] = bean.getNo();
			record[i][2] = s;
			record[i][3] = bean.getName();
			record[i][4] = bean.getIt();
			record[i][5] = (String) atcb.getSelectedItem();
		}

		pan1.add(bt1);
		pan1.add(bt2);

		table = new JTable(record, col);
		changeCellEditor(table, table.getColumnModel().getColumn(5));
		scpan = new JScrollPane(table);
		JPanel panline = new JPanel(new BorderLayout());
		panline.setBorder(new TitledBorder(new EtchedBorder(), "26기 아이티반 출석 등록"));
		panline.add(scpan, BorderLayout.CENTER);

		// atcb.addActionListener(this);
		bt1.addActionListener(this);
		bt2.addActionListener(this);

		con.add("Center", panline);
		con.add("South", pan1);
		this.pack();
	}

	public void changeCellEditor(JTable table, TableColumn column) {
		atcb.addItem("출석");
		atcb.addItem("결석");
		atcb.addItem("지각");
		// atcb.setSelectedIndex(0);
		column.setCellEditor(new DefaultCellEditor(atcb));
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		column.setCellRenderer(renderer);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("확인")) {
			String record[][] = new String [list.size()][col.length];
			for(int i=0; i<list.size();i++){
			bean = list.get(i);	
			String s = Integer.toString(bean.getNum());
			record [i][0] = date.format(d); 
			record [i][2] = s;
			record [i][5] = (String)atcb.getSelectedItem();
			dao.input_It26(record[i][0], record[i][5], record[i][2]);
			}
			JOptionPane.showMessageDialog(this, "등록되었습니다");
			dispose();
		} else
			dispose();

	}
}

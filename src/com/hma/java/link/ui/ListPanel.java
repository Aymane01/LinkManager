package com.hma.java.link.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hma.java.link.model.Link;

public class ListPanel extends JPanel {
	private DefaultTableModel model;
	private JTable tableList;

	public ListPanel(MouseListener listener) {
		super();
		setOpaque(true);
 		setBackground(Color.decode("#4a5e8f"));

		String[] columnNames = { "Label", "Link" };
		String[][] data = {};
		model = new DefaultTableModel(data, columnNames);

		tableList = new JTable(model) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tableList.addMouseListener(listener);
		tableList.getColumn(columnNames[1]).setPreferredWidth(150);
		JScrollPane scrollPane = new JScrollPane(tableList);
		scrollPane.getViewport().setBackground(Color.decode("#4a5e8f"));
		tableList.getTableHeader().setBackground(Color.white);
		tableList.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 11));
		tableList.getTableHeader().setForeground(Color.decode("#FFFFFF"));
		tableList.getTableHeader().setBackground(Color.decode("#637fc1"));
		add(scrollPane);
	}

	public void addLinkRow(Link link) {
		String data[] = { link.getLabel(), link.getValue() };
		model.addRow(data);
	}

	public void addLinkRows(ArrayList<Link> links) {
		deleteAllRows();
		for (Link link : links) {
			addLinkRow(link);
		}
	}

	public void deleteAllRows() {
		int count = model.getRowCount();
		for (int i = count - 1; i >= 0; i--) {
			model.removeRow(i);
		}

	}

	public int getSelectionRow() {
		return tableList.getSelectedRow();
	}
}

package com.hma.java.link.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ButtonPanelUX extends JPanel implements MouseListener {
	private MainPanel mainPanel;
	private JLabel add;
	private JLabel update;
	private JLabel delete;
	private JLabel info;
	private final int LABEL_WIDTH = 80;
	private final int LABEL_HEIGHT = 20;
	private boolean flag = true;

	public ButtonPanelUX() {
	}

	public ButtonPanelUX(MainPanel mainPanel) {
		super();
		setOpaque(true);
		setBackground(Color.decode("#637fc1"));
		this.mainPanel = mainPanel;

		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		add = new JLabel("Create", SwingConstants.CENTER);
		update = new JLabel("Update", SwingConstants.CENTER);
		delete = new JLabel("Delete", SwingConstants.CENTER);
		info = new JLabel("Info", SwingConstants.CENTER);

		// info.setName("Info");
		// info.setPreferredSize(new Dimension(50, LABEL_HEIGHT + 2));
		add(add);
		add(update);
		add(delete);
		add(info);
		doUX(add);
		doUX(update);
		doUX(delete);
		doUX(info);
	}

	public void doUX(JLabel label) {
		label.setOpaque(true);
		label.setPreferredSize(new Dimension(116, LABEL_HEIGHT + 2));
		label.setBackground(Color.decode("#637fc1"));
		label.setForeground(Color.white);
		label.setFont(new Font("Verdana", Font.BOLD, 10));
		label.addMouseListener(this);
	}

	public void mouseClicked(MouseEvent e) {
		mainPanel.doEvent(e);
	}

	public void mouseEntered(MouseEvent e) {

		flag = false;

		JLabel label = (JLabel) e.getSource();
		label.setBackground(Color.decode("#4a5e8f"));
		label.setForeground(Color.white);
	}

	public void mouseExited(MouseEvent e) {
		JLabel label = (JLabel) e.getSource();
		label.setBackground(Color.decode("#637fc1"));
		label.setForeground(Color.white);
		flag = true;
	}

	public void mousePressed(MouseEvent e) {
		JLabel label = (JLabel) e.getSource();
		label.setBackground(Color.white);
		label.setForeground(Color.decode("#4a5e8f"));
	}

	public void mouseReleased(MouseEvent e) {
		if (!flag) {
			mouseEntered(e);
		} else {
			mouseExited(e);
		}
	}

}

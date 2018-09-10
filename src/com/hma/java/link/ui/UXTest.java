package com.hma.java.link.ui;

import javax.swing.JFrame;

public class UXTest extends JFrame {
	public UXTest() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new ButtonPanelUX());
		pack();
	}

	public static void main(String[] args) {
		new UXTest();
	}
}

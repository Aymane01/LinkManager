package com.hma.java.link.manager;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;

import org.apache.commons.io.IOUtils;

import com.hma.java.link.ui.MainPanel;

public class Main extends JFrame {
	public Main() {
		InputStream input = getClass().getClassLoader().getResourceAsStream("resources/icons/link.png");
		ImageIcon img = null;
		try {
			img = new ImageIcon(IOUtils.toByteArray(input));
			setIconImage(img.getImage());
		} catch (IOException e) {
			System.out.println("Here : " + e.getMessage());
		}
		setIconImage(img.getImage());
		setTitle("LinkManager v2.1 ©");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainPanel mainPanel = new MainPanel();
		add(mainPanel);
		setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		JPopupMenu popUpMenu = new JPopupMenu("A pop menu");

		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

	}

	public static void main(String[] args) {

		new Main();
	}
}

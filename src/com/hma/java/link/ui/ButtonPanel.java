
package com.hma.java.link.ui;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
	private JButton add;
	private JButton update;
	private JButton delete;

	public ButtonPanel(ActionListener listener) {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add = new JButton("Ajouter");
		update = new JButton("Modifier");
		delete = new JButton("Supprimer");
		add.addActionListener(listener);
		update.addActionListener(listener);
		delete.addActionListener(listener);
		add(add);
		add(update);
		add(delete);
	}
}

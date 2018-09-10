package com.hma.java.link.ui;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.TableModelEvent;

import com.hma.java.link.manager.LinkManager;
import com.hma.java.link.manager.LinkManagerService;
import com.hma.java.link.model.Link;

public class MainPanel extends JPanel implements MouseListener {
	private LinkManagerService service;
	private ButtonPanel butonPanel;
	private ListPanel listPanel;

	public MainPanel() {
		super();
		setOpaque(true);
		// setBackground(Color.decode("#637fc1"));
		// setBackground(Color.decode("#FFFFFF"));
		service = new LinkManagerService(new LinkManager());
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		listPanel = new ListPanel(this);
		add(listPanel);
		ButtonPanelUX buttonPanelUX = new ButtonPanelUX(this);
		add(buttonPanelUX);

		listPanel.addLinkRows(service.getLinks());
	}

	public void doEvent(MouseEvent e) {

		JLabel b = (JLabel) e.getSource();
		if ("Create".equals(b.getText())) {
			String label = JOptionPane.showInputDialog(this, "Saisir le libellé : ");
			if (label != null)
				if ("".equals(label.trim())) {
					JOptionPane.showMessageDialog(this, "Veuillez à bien saisir le libellé");
				} else {
					String value = JOptionPane.showInputDialog(this, "Saisir le lien : ");
					if (value != null)
						if ("".equals(value.trim())) {
							JOptionPane.showMessageDialog(this, "Veuillez à bien saisir le lien");
						} else {
							int r = service.addLink(new Link(label, value));
							if (r == 1) {
								Reload();
								JOptionPane.showMessageDialog(this, "Lien enregistré avec succès");

							} else {

								JOptionPane.showMessageDialog(this, "Erreur lors de l'enregistrement du lien");
							}

						}
				}

		} else if ("Delete".equals(b.getText())) {
			int index = listPanel.getSelectionRow();
			if (index == -1) {
				JOptionPane.showMessageDialog(this, "Veuillez sélectionner un lien à supprimer");
			} else {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(this, "Voulez-vous supprimer le lien sélectionné",
						"Confirmation de supression", JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					service.deleteLink(index);
					Reload();
					JOptionPane.showMessageDialog(this, "Lien supprimé avec succès");

				}
			}

		} else if ("Update".equals(b.getText())) {
			int index = listPanel.getSelectionRow();
			if (index == -1) {
				JOptionPane.showMessageDialog(this, "Veuillez sélectionner un lien à modifier");
			} else {
				Link link = service.getLinkByIndex(index);
				String label = JOptionPane.showInputDialog(this, "Saisir le libellé : ", link.getLabel());
				if (label != null)
					if ("".equals(label.trim())) {
						JOptionPane.showMessageDialog(this, "Veuillez à bien saisir le libellé");
					} else {
						String value = JOptionPane.showInputDialog(this, "Saisir le lien : ", link.getValue());
						if (value != null)
							if ("".equals(value.trim())) {
								JOptionPane.showMessageDialog(this, "Veuillez à bien saisir le lien");
							} else {
								link.setLabel(label);
								link.setValue(value);
								int r = service.updateLink(link, index);
								if (r == 1) {
									Reload();
									JOptionPane.showMessageDialog(this, "Lien modifié avec succès");

								} else {

									JOptionPane.showMessageDialog(this, "Erreur lors de l'enregistrement du lien");
								}
							}
					}

			}
		} else if ("Info".equals(b.getText())) {
			JOptionPane.showMessageDialog(this,
					"LinkManager 2.1\n\nThis Tool has been built in order to provide a quick way to manage Links \nCopyright © 2018, Aymane HAMMIOUI\naymane.hamioui@gmail.com ");
		}

	}

	public void Reload() {
		listPanel.addLinkRows(service.getLinks());

	}

	public void tableChanged(TableModelEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			Link link = service.getLinkByIndex(listPanel.getSelectionRow());
			StringSelection selection = new StringSelection(link.getValue());
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(selection, null);
			JOptionPane.showMessageDialog(this, link.getLabel() + " est copié dans le presse-papier");

		}
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}
}

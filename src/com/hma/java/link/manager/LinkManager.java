package com.hma.java.link.manager;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import com.hma.java.link.model.Link;

public class LinkManager {
	private String path = "";
	private String userHome;
	private String FILE_NAME = "links.txt";
	public final static String DEFAULT_PATH = "/LinkManager/resources/";

	public LinkManager(String path) {
		this.path = path;
		this.userHome = System.getProperty("user.home");
	}

	public LinkManager() {
		this(DEFAULT_PATH);
		run();
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ArrayList<Link> laodLinks() {
		ArrayList<Link> links = new ArrayList<>();
		try {
			LineNumberReader reader = new LineNumberReader(new FileReader(userHome + path + FILE_NAME));
			String line = "";
			while ((line = reader.readLine()) != null) {
				StringTokenizer stk = new StringTokenizer(line, "|");
				String lib = stk.nextToken();
				String val = stk.nextToken();
				links.add(new Link(lib, val));
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erreur technique : " + e.getMessage());
		}

		return links;
	}

	public int saveLinks(ArrayList<Link> links) {
		try {

			FileWriter writer = new FileWriter(new File(userHome + path + FILE_NAME));

			for (Link link : links) {
				writer.write(link.toString());
			}
			writer.close();
			return 1;
		} catch (Exception e) {
			System.err.println(
					">> Erreur lors d'enregistrement de la resource : " + path + "\n Source : " + e.getMessage());
			return 0;
		}

	}

	public void run() {
		try {
			File f = new File(userHome + path);
			if (!f.exists()) {
				f.mkdirs();
				f = new File(userHome + path + FILE_NAME);
				f.createNewFile();
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erreur technique : " + e.getMessage());
		}
	}
}

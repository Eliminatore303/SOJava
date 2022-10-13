package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Notecontrol;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Note extends JFrame implements WindowListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private String name;
	private int key;
	private Image image;
	private ImageIcon icon;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_7;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmNewMenuItem_6;

	public Note() {
		name="Uknown";
		setTitle(name+" - NotePad");
		icon= new ImageIcon(getClass().getClassLoader().getResource("notepad.png"));
		image = icon.getImage();
		setIconImage(image);
		setBounds(100, 100, 621, 376);
		contentPane = new JPanel();
		addWindowListener(this);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setVisible(true);
		setResizable(false);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(textArea);
		
		menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);
		
		mnNewMenu = new JMenu("File");
		mnNewMenu.setMnemonic('f');
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem_1 = new JMenuItem("New");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_2 = new JMenuItem("Open");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		mntmNewMenuItem_3 = new JMenuItem("Save");
		mnNewMenu.add(mntmNewMenuItem_3);
		
		mntmNewMenuItem_4 = new JMenuItem("Save as...");
		mnNewMenu.add(mntmNewMenuItem_4);
		
		mntmNewMenuItem_5 = new JMenuItem("Exit");
		mnNewMenu.add(mntmNewMenuItem_5);
		
		mnNewMenu_1 = new JMenu("Option");
		mnNewMenu_1.setMnemonic('o');
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_6 = new JMenuItem("Char width");
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		mntmNewMenuItem_7 = new JMenuItem("Date");
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
	}
	public void setName(String s) {
		setTitle(s+" - NotePad");
		name=s;
		//the key of the note it is saved, so when I closed the file it will not be more aviable
		key=Integer.parseInt(s);
	}
	public String getName() {
		return name;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
	
	public JMenuItem getMntmNewMenuItem_7() {
		return mntmNewMenuItem_7;
	}
	
	public void setMntmNewMenuItem_7(JMenuItem mntmNewMenuItem_7) {
		this.mntmNewMenuItem_7 = mntmNewMenuItem_7;
	}
	
	public JMenuItem getMntmNewMenuItem_1() {
		return mntmNewMenuItem_1;
	}
	
	public void setMntmNewMenuItem_1(JMenuItem mntmNewMenuItem_1) {
		this.mntmNewMenuItem_1 = mntmNewMenuItem_1;
	}
	
	public JMenuItem getMntmNewMenuItem_2() {
		return mntmNewMenuItem_2;
	}
	
	public void setMntmNewMenuItem_2(JMenuItem mntmNewMenuItem_2) {
		this.mntmNewMenuItem_2 = mntmNewMenuItem_2;
	}
	
	public JMenuItem getMntmNewMenuItem_3() {
		return mntmNewMenuItem_3;
	}
	
	public void setMntmNewMenuItem_3(JMenuItem mntmNewMenuItem_3) {
		this.mntmNewMenuItem_3 = mntmNewMenuItem_3;
	}
	
	public JMenuItem getMntmNewMenuItem_4() {
		return mntmNewMenuItem_4;
	}
	
	public void setMntmNewMenuItem_4(JMenuItem mntmNewMenuItem_4) {
		this.mntmNewMenuItem_4 = mntmNewMenuItem_4;
	}
	
	public JMenuItem getMntmNewMenuItem_5() {
		return mntmNewMenuItem_5;
	}
	
	public void setMntmNewMenuItem_5(JMenuItem mntmNewMenuItem_5) {
		this.mntmNewMenuItem_5 = mntmNewMenuItem_5;
	}
	
	public JMenuItem getMntmNewMenuItem_6() {
		return mntmNewMenuItem_6;
	}
	
	public void setMntmNewMenuItem_6(JMenuItem mntmNewMenuItem_6) {
		this.mntmNewMenuItem_6 = mntmNewMenuItem_6;
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		//chiusura finestra, impostazione combobox a stato originale(-1), pulizia textArea, eliminazione nome attuale
		textArea.setText("");
		Notecontrol.setFileOpenNo(key);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

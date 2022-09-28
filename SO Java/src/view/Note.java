package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Notecontrol;

import javax.swing.JToolBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Note extends JFrame implements WindowListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JToolBar toolBar;
	private JToolBar toolBar_1;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_3;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private Notecontrol n;
	private String name;
	private int key;
	private Image image;
	private ImageIcon icon;

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
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		toolBar = new JToolBar();
		panel.add(toolBar, BorderLayout.CENTER);
		
		panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		toolBar.add(panel_2);
		
		lblNewLabel = new JLabel("File");
		panel_2.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("                        ");
		panel_2.add(lblNewLabel_1);
		
		lblNewLabel_3 = new JLabel("Option");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_2.add(lblNewLabel_3);
		
		toolBar_1 = new JToolBar();
		panel.add(toolBar_1, BorderLayout.SOUTH);
		
		panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		toolBar_1.add(panel_3);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"","New", "Open", "Save", "Save as...", "Exit"}));
		panel_3.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"","Char width", "Date"}));
		panel_3.add(comboBox_1);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(textArea);
		
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

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public JComboBox getComboBox_1() {
		return comboBox_1;
	}

	public void setComboBox_1(JComboBox comboBox_1) {
		this.comboBox_1 = comboBox_1;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		//chiusura finestra, impostazione combobox a stato originale(-1), pulizia textArea, eliminazione nome attuale
		comboBox.setSelectedIndex(0);
		comboBox_1.setSelectedIndex(0);
		textArea.setText("");
		Notecontrol.setFileOpenNo(key);
		//n=new Notecontrol(this);
		//n.setNameEmpty();
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

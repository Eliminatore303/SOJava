package view;

import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FileExplorer extends JFrame implements WindowListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox comboBox;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_2;
	private JButton btnNewButton_3;
	private Image image;
	private ImageIcon icon;

	public FileExplorer() {
		setResizable(false);
		setTitle("File Explorer");
		setBounds(100, 100, 450, 190);
		icon= new ImageIcon(getClass().getClassLoader().getResource("explorer.png"));
		image = icon.getImage();
		setIconImage(image);
		contentPane = new JPanel();
		setVisible(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		addWindowListener(this);
		
		comboBox = new JComboBox();
		comboBox.setBounds(96, 14, 150, 23);
		contentPane.add(comboBox);
		
		String[] files;
	 	File f = new File("./src/file");
	 	files = f.list();
		for (int i = 0; i < files.length; i++) {
			comboBox.addItem(new String(files[i]));
		}
		
		btnNewButton = new JButton("Select file");
		btnNewButton.setBounds(256, 14, 103, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("Choose file:");
		lblNewLabel.setBounds(10, 14, 76, 23);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Open file:");
		lblNewLabel_1.setBounds(10, 47, 76, 23);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(96, 47, 150, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton_1 = new JButton("Open file");
		btnNewButton_1.setBounds(256, 47, 103, 23);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_2 = new JLabel("Delete file:");
		lblNewLabel_2.setBounds(10, 80, 76, 23);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(96, 80, 150, 23);
		contentPane.add(textField_1);
		
		btnNewButton_2 = new JButton("Delete file");
		btnNewButton_2.setBounds(256, 80, 103, 23);
		contentPane.add(btnNewButton_2);
		
		lblNewLabel_3 = new JLabel("New file:");
		lblNewLabel_3.setBounds(10, 113, 76, 23);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(96, 113, 150, 23);
		contentPane.add(textField_2);
		
		btnNewButton_3 = new JButton("Create file");
		btnNewButton_3.setBounds(256, 113, 103, 23);
		contentPane.add(btnNewButton_3);
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}

	public JButton getBtnNewButton_3() {
		return btnNewButton_3;
	}

	public void setBtnNewButton_3(JButton btnNewButton_3) {
		this.btnNewButton_3 = btnNewButton_3;
	}

	public JButton getBtnNewButton_1() {
		return btnNewButton_1;
	}

	public void setBtnNewButton_1(JButton btnNewButton_1) {
		this.btnNewButton_1 = btnNewButton_1;
	}

	public JButton getBtnNewButton_2() {
		return btnNewButton_2;
	}

	public void setBtnNewButton_2(JButton btnNewButton_2) {
		this.btnNewButton_2 = btnNewButton_2;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		comboBox.removeAllItems();
		String[] files;
	 	File f = new File("./src/file");
	 	files = f.list();
		for (int i = 0; i < files.length; i++) {
			comboBox.addItem(new String(files[i]));
		}
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
	
	public void refresh() {
		//comboBox.setModel(new DefaultComboBoxModel (new String[] {""}));
		comboBox.removeAllItems();
		String[] files;
	 	File f = new File("./src/file");
	 	files = f.list();
		for (int i = 0; i < files.length; i++) {
			comboBox.addItem(new String(files[i]));
		}
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
	}
	
}

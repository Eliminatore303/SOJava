package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;
	private Icon icon;
	private Icon icon2;
	private Icon icon3;
	private Icon icon4;
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton_3;
	private JLabel lblNewLabel_4;

	public Window() {
		setTitle("Sistema operativo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setVisible(true);
		
		icon = new ImageIcon("./src/image/calc.png");
		btnNewButton = new JButton(icon);
		btnNewButton.setBounds(10, 11, 100, 100);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("Calc");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 122, 100, 14);
		contentPane.add(lblNewLabel);
		
		icon2 = new ImageIcon("./src/image/notepad.png");
		btnNewButton_1 = new JButton(icon2);
		btnNewButton_1.setBounds(145, 11, 100, 100);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_1 = new JLabel("NotePad");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(145, 122, 100, 14);
		contentPane.add(lblNewLabel_1);
		
		icon3 = new ImageIcon("./src/image/clock.png");
		btnNewButton_2 = new JButton(icon3);
		btnNewButton_2.setBounds(10, 146, 100, 100);
		contentPane.add(btnNewButton_2);
		
		lblNewLabel_3 = new JLabel("Clock");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 257, 100, 14);
		contentPane.add(lblNewLabel_3);
		
		icon4 = new ImageIcon("./src/image/explorer.png");
		btnNewButton_3 = new JButton(icon4);
		btnNewButton_3.setBounds(145, 146, 100, 100);
		contentPane.add(btnNewButton_3);
		
		lblNewLabel_4 = new JLabel("File Explorer");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(145, 257, 100, 14);
		contentPane.add(lblNewLabel_4);
		
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}

	public JButton getBtnNewButton_1() {
		return btnNewButton_1;
	}

	public void setBtnNewButton_1(JButton btnNewButton_1) {
		this.btnNewButton_1 = btnNewButton_1;
	}

	public JButton getBtnNewButton_3() {
		return btnNewButton_3;
	}

	public void setBtnNewButton_3(JButton btnNewButton_3) {
		this.btnNewButton_3 = btnNewButton_3;
	}

	public JButton getBtnNewButton_2() {
		return btnNewButton_2;
	}

	public void setBtnNewButton_2(JButton btnNewButton_2) {
		this.btnNewButton_2 = btnNewButton_2;
	}
	
	
}

package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

public class Calc extends JFrame implements WindowListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField textFieldW;
	private JTextField textFieldS;
	
	private JPanel panel;
	private JButton button5;
	private JButton button6;
	private JButton buttonMinus;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton buttonMulti;
	private JButton buttonDec;
	private JButton button0;
	private JButton buttonResult;
	private JButton buttonDiv;
	private JPanel panel_5;
	private JPanel panel_7;
	private Image image;
	private ImageIcon icon;
	private JButton button4;
	private JButton button7;
	private JButton buttonPlus;
	private JButton button9;
	private JButton button8;
	private JButton buttonCanc;
	
	public Calc() {
		icon= new ImageIcon(getClass().getClassLoader().getResource("calc.png"));
		image = icon.getImage();
		setIconImage(image);
		setResizable(false);
		setTitle("Calcolatrice");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(this);
		setBounds(100, 100, 364, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setVisible(true);
		
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		button7 = new JButton("7");
		button7.setBounds(87, 5, 45, 23);
		panel.add(button7);
		
		buttonPlus = new JButton("+");
		buttonPlus.setBounds(237, 5, 45, 23);
		panel.add(buttonPlus);
		
		button9 = new JButton("9");
		button9.setBounds(187, 5, 45, 23);
		panel.add(button9);
		
		button8 = new JButton("8");
		button8.setBounds(137, 5, 45, 23);
		panel.add(button8);
		
		buttonCanc = new JButton("Canc");
		buttonCanc.setBounds(15, 5, 65, 23);
		panel.add(buttonCanc);
		
		button4 = new JButton("4");
		button4.setBounds(87, 39, 45, 23);
		panel.add(button4);
		
		button5 = new JButton("5");
		button5.setBounds(137, 39, 45, 23);
		panel.add(button5);
		
		button6 = new JButton("6");
		button6.setBounds(187, 39, 45, 23);
		panel.add(button6);
		
		buttonMinus = new JButton("-");
		buttonMinus.setBounds(237, 39, 45, 23);
		panel.add(buttonMinus);
		
		button1 = new JButton("1");
		button1.setBounds(87, 72, 45, 23);
		panel.add(button1);
		
		button2 = new JButton("2");
		button2.setBounds(137, 72, 45, 23);
		panel.add(button2);
		
		button3 = new JButton("3");
		button3.setBounds(187, 72, 45, 23);
		panel.add(button3);
		
		buttonMulti = new JButton("*");
		buttonMulti.setBounds(237, 72, 45, 23);
		panel.add(buttonMulti);
		
		buttonDec = new JButton(".");
		buttonDec.setBounds(87, 106, 45, 23);
		panel.add(buttonDec);
		
		button0 = new JButton("0");
		button0.setBounds(137, 106, 45, 23);
		panel.add(button0);
		
		buttonResult = new JButton("=");
		buttonResult.setBounds(187, 106, 45, 23);
		panel.add(buttonResult);
		
		buttonDiv = new JButton("/");
		buttonDiv.setBounds(237, 106, 45, 23);
		panel.add(buttonDiv);
		
		panel_5 = new JPanel();
		contentPane.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		textFieldW = new JTextField();
		panel_5.add(textFieldW, BorderLayout.SOUTH);
		textFieldW.setEditable(false);
		
		textFieldW.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldW.setText("0");
		textFieldW.setColumns(10);
		
		textFieldS = new JTextField();
		textFieldS.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldS.setEditable(false);
		panel_5.add(textFieldS, BorderLayout.NORTH);
		textFieldS.setColumns(10);
		
		panel_7 = new JPanel();
		contentPane.add(panel_7, BorderLayout.EAST);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));
		
		
	}

	public JButton getButtonCanc() {
		return buttonCanc;
	}



	public void setButtonCanc(JButton buttonCanc) {
		this.buttonCanc = buttonCanc;
	}



	public JTextField getTextFieldW() {
		return textFieldW;
	}


	public void setTextFieldW(JTextField textFieldW) {
		this.textFieldW = textFieldW;
	}


	public JTextField getTextFieldS() {
		return textFieldS;
	}


	public void setTextFieldS(JTextField textFieldS) {
		this.textFieldS = textFieldS;
	}


	public JButton getButton7() {
		return button7;
	}

	public void setButton7(JButton button7) {
		this.button7 = button7;
	}

	public JButton getButton8() {
		return button8;
	}

	public void setButton8(JButton button8) {
		this.button8 = button8;
	}

	public JButton getButton9() {
		return button9;
	}

	public void setButton9(JButton button9) {
		this.button9 = button9;
	}

	public JButton getButtonPlus() {
		return buttonPlus;
	}

	public void setButtonPlus(JButton buttonPlus) {
		this.buttonPlus = buttonPlus;
	}

	public JButton getButton4() {
		return button4;
	}

	public void setButton4(JButton button4) {
		this.button4 = button4;
	}

	public JButton getButton5() {
		return button5;
	}

	public void setButton5(JButton button5) {
		this.button5 = button5;
	}

	public JButton getButton6() {
		return button6;
	}

	public void setButton6(JButton button6) {
		this.button6 = button6;
	}

	public JButton getButtonMinus() {
		return buttonMinus;
	}

	public void setButtonMinus(JButton buttonMinus) {
		this.buttonMinus = buttonMinus;
	}

	public JButton getButton1() {
		return button1;
	}

	public void setButton1(JButton button1) {
		this.button1 = button1;
	}

	public JButton getButton2() {
		return button2;
	}

	public void setButton2(JButton button2) {
		this.button2 = button2;
	}

	public JButton getButton3() {
		return button3;
	}

	public void setButton3(JButton button3) {
		this.button3 = button3;
	}

	public JButton getButtonMulti() {
		return buttonMulti;
	}

	public void setButtonMulti(JButton buttonMulti) {
		this.buttonMulti = buttonMulti;
	}

	public JButton getButtonDec() {
		return buttonDec;
	}

	public void setButtonDec(JButton buttonDec) {
		this.buttonDec = buttonDec;
	}

	public JButton getButton0() {
		return button0;
	}

	public void setButton0(JButton button0) {
		this.button0 = button0;
	}

	public JButton getButtonResult() {
		return buttonResult;
	}

	public void setButtonResult(JButton buttonResult) {
		this.buttonResult = buttonResult;
	}

	public JButton getButtonDiv() {
		return buttonDiv;
	}

	public void setButtonDiv(JButton buttonDiv) {
		this.buttonDiv = buttonDiv;
	}
	
	
	
	

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		textFieldW.setText("0");
		textFieldS.setText("");
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

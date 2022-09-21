package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.Toolkit;

public class Calc extends JFrame implements WindowListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField textFieldW;
	private JTextField textFieldS;
	
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JButton button7;
	private JButton button8;
	private JButton button9;
	private JButton buttonPlus;
	private JButton button4;
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
	private JPanel panel_6;
	private JButton buttonCanc;
	private JPanel panel_7;
	
	public Calc() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Calc.class.getResource("/image/calc.png")));
		setResizable(false);
		setTitle("Calcolatrice");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(this);
		setBounds(100, 100, 374, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setVisible(true);
		
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		panel_6 = new JPanel();
		panel_6.setBackground(Color.LIGHT_GRAY);
		panel_6.setBounds(10, 5, 67, 33);
		panel.add(panel_6);
		
		buttonCanc = new JButton("Canc");
		panel_6.add(buttonCanc);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(87, 5, 190, 33);
		panel.add(panel_1);
		
		button7 = new JButton("7");
		panel_1.add(button7);
		
		button8 = new JButton("8");
		panel_1.add(button8);
		
		button9 = new JButton("9");
		panel_1.add(button9);
		
		buttonPlus = new JButton("+");
		panel_1.add(buttonPlus);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(87, 43, 190, 33);
		panel.add(panel_2);
		
		button4 = new JButton("4");
		panel_2.add(button4);
		
		button5 = new JButton("5");
		panel_2.add(button5);
		
		button6 = new JButton("6");
		panel_2.add(button6);
		
		buttonMinus = new JButton("-");
		panel_2.add(buttonMinus);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(87, 81, 190, 33);
		panel.add(panel_3);
		
		button1 = new JButton("1");
		panel_3.add(button1);
		
		button2 = new JButton("2");
		panel_3.add(button2);
		
		button3 = new JButton("3");
		panel_3.add(button3);
		
		buttonMulti = new JButton("*");
		panel_3.add(buttonMulti);
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(87, 119, 190, 33);
		panel.add(panel_4);
		
		buttonDec = new JButton(".");
		
		button0 = new JButton("0");
		
		buttonResult = new JButton("=");
		
		buttonDiv = new JButton("/");
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_4.add(buttonDec);
		panel_4.add(button0);
		panel_4.add(buttonResult);
		panel_4.add(buttonDiv);
		
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

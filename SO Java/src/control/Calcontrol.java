package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JButton;

import view.Calc;

public class Calcontrol implements ActionListener{
	private Calc calc;
	private static String lastsign="";
	//try
	public Calcontrol(Calc calc) {
		this.calc=calc;
		calc.getButton0().addActionListener(this);
		calc.getButton1().addActionListener(this);
		calc.getButton2().addActionListener(this);
		calc.getButton3().addActionListener(this);
		calc.getButton4().addActionListener(this);
		calc.getButton5().addActionListener(this);
		calc.getButton6().addActionListener(this);
		calc.getButton7().addActionListener(this);
		calc.getButton8().addActionListener(this);
		calc.getButton9().addActionListener(this);
		calc.getButtonDec().addActionListener(this);
		
		calc.getButtonDiv().addActionListener(this);
		calc.getButtonMinus().addActionListener(this);
		calc.getButtonPlus().addActionListener(this);
		calc.getButtonMulti().addActionListener(this);
		calc.getButtonResult().addActionListener(this);
		
		calc.getButtonCanc().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s= "", c="", p="";
		s=calc.getTextFieldW().getText();
		BigDecimal x,y;
		
		JButton button=(JButton) e.getSource();
		if (button.getText().compareTo("Canc")!=0) {
			if (s.compareTo("Division by zero")==0 || s.compareTo("Division undefined")==0 ) {
				calc.getTextFieldW().setText(""+button.getText());
				calc.getTextFieldS().setText("");
			}else {
				if (button.getText().compareTo(".")!=0) {
				try {
					//numeri
					Integer.parseInt(button.getText());
					if (s.compareTo("0")!=0) {
						if (lastsign.compareTo("=")==0) {
							s=button.getText();
							calc.getTextFieldW().setText(s);
							calc.getTextFieldS().setText("");
						}else {
							s+=button.getText();
							calc.getTextFieldW().setText(s);
						}
					}
					if (s.compareTo("0")==0) {
						s=button.getText();
						calc.getTextFieldW().setText(s);
					}
					
					
				} catch (NumberFormatException e2) {
					//simboli
					
					if (calc.getTextFieldS().getText().isEmpty() || lastsign.compareTo("=")==0) {
						calc.getTextFieldS().setText(s+button.getText());
						calc.getTextFieldW().setText("0");
						lastsign=button.getText();
					}else {
						//calcolo risultato nella casella s
						// s testo sotto, c testo sopra
						calc.getTextFieldS().setText(calc.getTextFieldS().getText()+s+button.getText());
						c=calc.getTextFieldS().getText();
						p=c.substring(0, c.length()-s.length()-2);
						x = new BigDecimal(p);
						y = new BigDecimal(s);
						
						if (button.getText().compareTo("=")==0) {
							switch (lastsign) {
							case "+":
								calc.getTextFieldW().setText(""+x.add(y));
								break;
							case "-":
								//calc.getTextFieldW().setText("0");
								calc.getTextFieldW().setText(""+x.subtract(y));
								break;
							case "*":
								//calc.getTextFieldW().setText("0");
								calc.getTextFieldW().setText(""+x.multiply(y));
								break;
							case "/":
								try {
									calc.getTextFieldW().setText(""+x.divide(y, 8, RoundingMode.CEILING));
								} catch (ArithmeticException ex) {
									calc.getTextFieldW().setText(ex.getMessage());
								}
								break;
							}
						}else {
							switch (lastsign) {
							case "+":
								calc.getTextFieldS().setText(""+x.add(y)+button.getText());
								calc.getTextFieldW().setText("0");
								break;
							case "-":
								//calc.getTextFieldW().setText("0");
								calc.getTextFieldS().setText(""+x.subtract(y)+button.getText());
								calc.getTextFieldW().setText("0");
								break;
							case "*":
								//calc.getTextFieldW().setText("0");
								calc.getTextFieldS().setText(""+x.multiply(y)+button.getText());
								calc.getTextFieldW().setText("0");
								break;
							case "/":
								try {
									calc.getTextFieldS().setText(""+x.divide(y)+button.getText());
									calc.getTextFieldW().setText("0");
								} catch (ArithmeticException ex) {
									calc.getTextFieldW().setText(ex.getMessage());
								}
								break;
							case "=":
								switch (button.getText()) {
									case "+":
										calc.getTextFieldS().setText(""+x.add(y)+button.getText());
										calc.getTextFieldW().setText("0");
										break;
									case "-":
										//calc.getTextFieldW().setText("0");
										calc.getTextFieldS().setText(""+x.subtract(y)+button.getText());
										calc.getTextFieldW().setText("0");
										break;
									case "*":
										//calc.getTextFieldW().setText("0");
										calc.getTextFieldS().setText(""+x.multiply(y)+button.getText());
										calc.getTextFieldW().setText("0");
										break;
									case "/":
										try {
											calc.getTextFieldS().setText(""+x.divide(y)+button.getText());
											calc.getTextFieldW().setText("0");
										} catch (ArithmeticException ex) {
											calc.getTextFieldW().setText(ex.getMessage());
										}
										break;
								}
								break;
							}
							
						}
						lastsign=button.getText();
					}
				}
				}else {
					//decimali
					try {
					
						Integer.parseInt(s);
						s+=button.getText();
						calc.getTextFieldW().setText(s);
					} catch (NumberFormatException e2) {
						// TODO: handle exception
					}
				
				}
			}
		}else {
			calc.getTextFieldS().setText("");
			calc.getTextFieldW().setText("0");
			lastsign="";
		}
	}
		
		
}


package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import javax.swing.JButton;

import view.Calc;

public class Calcontrol implements ActionListener,KeyListener{
	private Calc calc;
	private static String lastsign="";
	private ArrayList<Integer> vn, vs;
	//vn -> values of numbers of KeyListener
	//vs -> values of special chars of KeyListener
	
	//try
	public Calcontrol(Calc calc) {
		this.calc=calc;
		vn= new ArrayList<Integer>();
		vn.add(48);vn.add(49);vn.add(50);vn.add(51);vn.add(52);
		vn.add(53);vn.add(54);vn.add(55);vn.add(56);vn.add(57);
		vn.add(96);vn.add(97);vn.add(98);vn.add(99);vn.add(100);
		vn.add(101);vn.add(102);vn.add(103);vn.add(104);vn.add(105);
		vs= new ArrayList<Integer>();
		vs.add(45);vs.add(46);vs.add(106);vs.add(107);vs.add(109);
		vs.add(110);vs.add(111);vs.add(127);vs.add(521);
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
		
		calc.getTextFieldW().addKeyListener(this);
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		String s= "", c="", p="";
		String valueKey="";
		s=calc.getTextFieldW().getText();
		BigDecimal x,y;
		//return the int value of the keypressed
		//key = e.getKeyCode();
		//return the char value of the keypressed
		//key = e.getKeyChar();
		System.out.println(vn.contains(e.getKeyCode()));
		if (vn.contains(e.getKeyCode()) || vs.contains(e.getKeyCode())) {
			valueKey=""+e.getKeyChar();
			//canc: 127
			if (e.getKeyCode()!=127) {
				calc.getTextFieldW().setText(""+e.getKeyChar());
				if (s.compareTo("Division by zero")==0 || s.compareTo("Division undefined")==0 ) {
					calc.getTextFieldW().setText(""+valueKey);
					calc.getTextFieldS().setText("");
				}else {
					if (valueKey.compareTo(".")!=0) {
						try {
							//numeri
							Integer.parseInt(valueKey);
							if (s.compareTo("0")!=0) {
								if (lastsign.compareTo("=")==0) {
									s=valueKey;
									calc.getTextFieldW().setText(s);
									calc.getTextFieldS().setText("");
								}else {
									s+=valueKey;
									calc.getTextFieldW().setText(s);
								}
							}
							if (s.compareTo("0")==0) {
								s=valueKey;
								calc.getTextFieldW().setText(s);
							}
							
							
						} catch (NumberFormatException e2) {
							//simboli
							
							if (calc.getTextFieldS().getText().isEmpty() || lastsign.compareTo("=")==0) {
								calc.getTextFieldS().setText(s+valueKey);
								calc.getTextFieldW().setText("0");
								lastsign=valueKey;
							}else {
								//calcolo risultato nella casella s
								// s testo sotto, c testo sopra
								calc.getTextFieldS().setText(calc.getTextFieldS().getText()+s+valueKey);
								c=calc.getTextFieldS().getText();
								p=c.substring(0, c.length()-s.length()-2);
								x = new BigDecimal(p);
								y = new BigDecimal(s);
								
								if (valueKey.compareTo("=")==0) {
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
										calc.getTextFieldS().setText(""+x.add(y)+valueKey);
										calc.getTextFieldW().setText("0");
										break;
									case "-":
										//calc.getTextFieldW().setText("0");
										calc.getTextFieldS().setText(""+x.subtract(y)+valueKey);
										calc.getTextFieldW().setText("0");
										break;
									case "*":
										//calc.getTextFieldW().setText("0");
										calc.getTextFieldS().setText(""+x.multiply(y)+valueKey);
										calc.getTextFieldW().setText("0");
										break;
									case "/":
										try {
											calc.getTextFieldS().setText(""+x.divide(y)+valueKey);
											calc.getTextFieldW().setText("0");
										} catch (ArithmeticException ex) {
											calc.getTextFieldW().setText(ex.getMessage());
										}
										break;
									case "=":
										switch (valueKey) {
											case "+":
												calc.getTextFieldS().setText(""+x.add(y)+valueKey);
												calc.getTextFieldW().setText("0");
												break;
											case "-":
												//calc.getTextFieldW().setText("0");
												calc.getTextFieldS().setText(""+x.subtract(y)+valueKey);
												calc.getTextFieldW().setText("0");
												break;
											case "*":
												//calc.getTextFieldW().setText("0");
												calc.getTextFieldS().setText(""+x.multiply(y)+valueKey);
												calc.getTextFieldW().setText("0");
												break;
											case "/":
												try {
													calc.getTextFieldS().setText(""+x.divide(y)+valueKey);
													calc.getTextFieldW().setText("0");
												} catch (ArithmeticException ex) {
													calc.getTextFieldW().setText(ex.getMessage());
												}
												break;
										}
										break;
									}
									
								}
								lastsign=valueKey;
							}
						}
						}else {
							//decimali
							try {
							
								Integer.parseInt(s);
								s+=valueKey;
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

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
		
		
}


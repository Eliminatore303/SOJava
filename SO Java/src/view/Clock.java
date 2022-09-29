package view;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class Clock extends JFrame implements WindowListener, Runnable{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private String time;
	private SimpleDateFormat dateFormat;
	//private boolean flag;

	public Clock() {
		//setIconImage(Toolkit.getDefaultToolkit().getImage(Calc.class.getResource("./image/clock.png")));
		setResizable(false);
		setTitle("Clock");
		setBounds(500, 100, 250, 150);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setVisible(true);
		setContentPane(contentPane);
		addWindowListener(this);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVisible(true);
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		
		dateFormat = new SimpleDateFormat("hh:mm:ss a");
		time=dateFormat.format(Calendar.getInstance().getTime());
		lblNewLabel.setText(time);
		//flag=true;
	}
	@Override
	public void run() {
		while (true) {
			time=dateFormat.format(Calendar.getInstance().getTime());
			lblNewLabel.setText(time);
			//System.out.println("hello");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//flag=true;
	}
	/*public void setTime() {
		
	}*/
	/*public void stop() {
		flag=false;
	}*/
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		//stop();
		setVisible(false);
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

package view;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class fin extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private String time;
	private SimpleDateFormat dateFormat;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;

	public static void main(String[] args) {
		new fin();
		
	}

	public fin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);
		setResizable(false);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(99, 96, 186, 14);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(10, 192, 89, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(10, 226, 46, 14);
		contentPane.add(lblNewLabel_1);
		lblNewLabel.setVisible(true);
		
		dateFormat = new SimpleDateFormat("hh:mm:ss a");
		//time=dateFormat.format(Calendar.getInstance().getTime());
		//lblNewLabel.setText(time);
		setTime();
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}
	
	public void setTime() {
		
		while (true) {
			time=dateFormat.format(Calendar.getInstance().getTime());
			lblNewLabel.setText(time);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

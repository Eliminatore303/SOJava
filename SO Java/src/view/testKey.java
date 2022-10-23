package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class testKey extends JFrame {

	private static final long serialVersionUID = 1870919025285400393L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private int key;
	private String s;
	private KeyEvent ke;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testKey frame = new testKey();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public testKey() {
		setTitle("KeyListener");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 407, 273);
		contentPane = new JPanel();
		setVisible(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 320, 150);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				key = e.getKeyCode();
				
				s=textArea.getText();
				textArea.setText(s+" "+e.getKeyChar()+": "+e.getKeyCode());
				/*
				 * result:
				 * e.getKeyChar() -> the char written on the keyboard
				 * e.getKeyCode() -> int value of the keypressed
				 * 
				 */
			}
		});
		scrollPane.setViewportView(textArea);
	}
}

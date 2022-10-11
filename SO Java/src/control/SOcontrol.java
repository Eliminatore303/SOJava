package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Calc;
import view.Clock;
import view.FileExplorer;
import view.Note;
import view.Window;

public class SOcontrol implements ActionListener{
	private Window fin;
	private Clock clock;
	private FileExplorerontrol fileEC;
	private FileExplorer fileE;
	private static int count=0;
	
	public SOcontrol(Window fin, Clock clock) {
		this.fin=fin;
		this.clock=clock;
		fileE = new FileExplorer();
		fileEC = new FileExplorerontrol(fileE);
		fileE.setVisible(false);
		fin.getBtnNewButton().addActionListener(this);
		fin.getBtnNewButton_1().addActionListener(this);
		fin.getBtnNewButton_2().addActionListener(this);
		fin.getBtnNewButton_3().addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==fin.getBtnNewButton()) {
			new Calcontrol(new Calc());
		}
		if (e.getSource()==fin.getBtnNewButton_1()) {
			Note n= new Note();
			Notecontrol nc;
			n.setName(""+count);
			nc=new Notecontrol(n);
			count++;
		}
		if (e.getSource()==fin.getBtnNewButton_2()) {
			clock.setVisible(true);
		}
		if (e.getSource()==fin.getBtnNewButton_3()) {
			fileE.setVisible(true);
		}
	}
}

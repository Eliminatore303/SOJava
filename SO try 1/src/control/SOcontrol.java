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
	private static int count=1;
	
	public SOcontrol(Window fin, Clock clock) {
		this.fin=fin;
		this.clock=clock;
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
			Note a= new Note();
			a.setName(""+count);
			new Notecontrol(a);
			count++;
		}
		if (e.getSource()==fin.getBtnNewButton_2()) {
			clock.setVisible(true);
		}
		if (e.getSource()==fin.getBtnNewButton_3()) {
			new FileExplorerontrol(new FileExplorer());
		}
	}
}

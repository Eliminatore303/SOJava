package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Calc;
import view.Clock;
import view.FileExplorer;
import view.Note;
import view.Window;

public class SOcontrol implements ActionListener{
	//per le istanze del blocco note bisogna creare istanze con nomi diversi e autoincrementali
	//la creazione delle istanze è nella classe di controllo del Note
	//quando apro un file o salvo, il nome dell' istanza cambia nel nome del file
	//se provo ad aprire un file, controllo che non esistano istanze con il nome del file che voglio aprire
	private Window fin;
	private Clock clock;
	
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
			new Notecontrol(new Note());
		}
		if (e.getSource()==fin.getBtnNewButton_2()) {
			clock.setVisible(true);
		}
		if (e.getSource()==fin.getBtnNewButton_3()) {
			new FileExplorerontrol(new FileExplorer());
		}
	}
}

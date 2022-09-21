package main;

import java.awt.EventQueue;

import control.SOcontrol;
import view.Clock;
import view.Window;

public class Main {
	private static Clock clock = new Clock();
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SOcontrol socontrol = new SOcontrol(new Window(),clock);
					
					// immagine S.O.
					
					// calendario in ( Textfield o Button ) con aggiornamento dell' ora e,
					// - in caso di clic apertura finestra per scelta e controllo data / ora
					
					// esplora file con visualizzazione della cartella file, con: 
					// - apertura - creazione - elimina
					
					// paint?
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		clock.run();
		//System.out.println(clock.getClass());
	}

}

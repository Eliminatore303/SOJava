#FileChooser

Pakage di Java che permette di scegliere un file con una OptionPane apposita.
Cose da fare:
- Studiare come funziona (Done);
- Inserire relative funzioni in Note:
	- Scelta;
	- Scrittura;
	- Lettura;
- Sostituzione di codice del Note con chiamata a funzioni;
- FileExplorer quando aperto non carica più i file da /file:
	- Se selezionato il bottone, aprirà una finestra dove permette di scegliere il file;
- Gestione Eccezione:
	- Modifica posizione file già aperto;
	- Modifica nome file già aperto;

Consiglio:
per prendere il nome del File da FileChooser esiste .getName(File) essa ritorna il nome del file con percorso inserito
es.: fileChooser.getNane(C:/user/desktop/pippo.txt) -> pippo.txt
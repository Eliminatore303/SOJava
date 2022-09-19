Gestione della eccezione riguardo all' apertura di un file già aperto:

1) Per le istanze del Note bisogna creare istanze con nomi diversi e autoincrementali
2) La creazione delle istanze è nella classe di controllo del Sistema Operativo
3) Quando apro un file o salvo, il nome dell' istanza cambia nel nome del file in questione
4) Se provo ad aprire un file, controllo che non esistano istanze con il nome del file che voglio aprire
4.1) Se presenti istanze di file con nome del file da aprire, non avvio l'istanza altrimenti la avvio
	
Gestione della eccezione riguardo all' apertura di un file già aperto:

1) Per le istanze del Note bisogna creare istanze con nomi diversi e autoincrementali (Done)
2) La creazione delle istanze è nella classe di controllo del Sistema Operativo (Done)
3) Quando apro un file o salvo, il nome dell' istanza cambia nel nome del file in questione (Done)

4) Per poter controllare tutte le istanze è necessario creare un meccanismo che salvi tutte le istanze con indici e relativi nomi (Mappa, Matrice, Arraylist?) (Done)
4.1) Ogni operazione: creazione, rinomia ecc... vanno salvate nel meccanismo, altrimenti non funziona (Done)
4.2) Per controllare il nome scorro l'array con un ciclo e al relativo indice che analizzo controllo anche il nome dell' istanza (Done)
[0,pippo.txt]
[1,hello.txt]
[2,by.txt]

5) Se provo ad aprire un file, controllo che non esistano istanze con il nome del file che voglio aprire (Done)
5.1) Se presenti istanze di file con nome del file da aprire, non avvio l'istanza altrimenti la avvio (Done)
	

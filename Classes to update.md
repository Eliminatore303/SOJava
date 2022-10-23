#Classes to update

NotePad:
1) sostituzione toolBar con JMenuBar (Done);
2) nella JMenuBar vanno aggiunti 5 + 2 JMenuItem (Done);
3) collegare eventi a JMenuItem (Done);
4) nella apertura dei file, per scegliere il file si usa l'elemento FileChooser;

JMenuItem 1 -> File : "New", "Open", "Save", "Save as...", "Exit";
JMenuItem 2 -> Option: "Char width", "Date";

Calc:
1) rinominare i bottoni in maniera corretta (Done);
2) aggiungere evento KeyListener alla textFiled (Done);
3) completare keyListenere sulla textfiled (Done);
3.1) controllo di tasto premuto con funzione di cerca su ArrayList dei valori numerici (Done);
4) aggiungere opzioni a calcolatrice:
4.1) backspace "<-";
4.2) cambio sengo "+/-";
5) sistemare errore dove bisogna selezionare la casella di test per far funzionare i keyListener;
6) sistemare errore dove i valori dei tasti non corrispondono se si usa lo "shift";

Valori numerici KeyListener:
Numerici:
0 -> 48, 96; 1 -> 49, 97; 2 -> 50, 98; 3 -> 51, 99; 4 -> 52, 100;
5 -> 53, 101; 6 -> 54, 102; 7 -> 55, 103; 8 -> 56, 104; 9 -> 57, 105;
Segni:
+ -> 521, 107; - -> 45, 409; * -> 106; / -> 111;
canc -> 127; . -> 46,110;

Clock:
1) integrare orologio nella finestra principale (sistemazione di errore bloccante dell' orologio );
1.1) integrare giorno-mese-anno assieme all' orologio;
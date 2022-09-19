package control;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import view.Note;

public class Notecontrol implements ActionListener{
	private Note note;
	private String name="";
	
	public Notecontrol(Note note) {
		this.note=note;
		note.getComboBox().addActionListener(this);
		note.getComboBox_1().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String txt="";
		JComboBox comboBox = (JComboBox) e.getSource();
        String o = ""+comboBox.getSelectedItem();
       if (o.compareTo("Date")==0) {
    	   java.util.Date date = new java.util.Date();    
    	   txt=note.getTextArea().getText();
    	   note.getTextArea().setText(txt+date);
       }
       if (o.compareTo("Char width")==0) {
    	   // se sceglie formato, appare finestra con 3 combo box: tipo, formato, 
           // dimensione ed adatta tutta area di testo a quello
    	   
    	   JComboBox nameFont = new JComboBox();
    	   nameFont.setModel(new DefaultComboBoxModel(new String[] {"PLAIN","BOLD","ITALIC"}));
    	   JComboBox styleFont = new JComboBox();
    	   styleFont.setModel(new DefaultComboBoxModel(new String[] {"Arial","Calibri","Monospaced"}));
    	   JComboBox sizeFont = new JComboBox();
    	   JButton button = new JButton();
    	   button.setText("Select font!!");
    	   for (int i = 0; i < 40; i++) {
    		   sizeFont.addItem(""+i);
    	   }
    	   sizeFont.setSelectedIndex(14);
    	   nameFont.setSelectedIndex(1);
    	   styleFont.setSelectedIndex(1);
    	   
    	   Object[] option= new Object[] {};
    	   JOptionPane jop=new JOptionPane("Font type: ",JOptionPane.QUESTION_MESSAGE,JOptionPane.DEFAULT_OPTION,null,option,null);
    	   jop.add(nameFont);
    	   jop.add(styleFont);
    	   jop.add(sizeFont);
    	   jop.add(button);
    	   
    	   JDialog diag = new JDialog();
    	   diag.setBounds(150, 150, 340, 130);
	       diag.getContentPane().add(jop);
	       diag.pack();
	       diag.setResizable(false);
	       diag.setVisible(true);
    	   
	       button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String s=""+nameFont.getSelectedItem();
					int x=0,y=0;
					switch (s) {
					case "PLAIN":
						x=0;
						break;
					case "BOLD":
						x=1;
						break;
					case "ITALIC":
						x=2;
						break;
					}
					y=Integer.parseInt(""+sizeFont.getSelectedItem());
					note.getTextArea().setFont(new Font(""+styleFont.getSelectedItem(), x, y));
					sizeFont.setSelectedIndex(14);
			    	nameFont.setSelectedIndex(1);
			    	styleFont.setSelectedIndex(1);
			    	diag.setVisible(false);
				}
	       });
       }
       if (o.compareTo("Exit")==0) {
    	 // se chiudi, chiude sessione attuale
    	 // se file è aperto, salvo sessione corrente su file e chiudo tutto
    	if (name.compareTo("")!=0) {
       		txt=note.getTextArea().getText();
       		FileWriter writer;
	   		try {
	   			writer = new FileWriter("./src/file/"+name);
	   			writer.write(txt);
	   			writer.close();
	   		} catch (IOException e1) {
	   			e1.printStackTrace();
	   		}
   		}
   		note.getTextArea().setText("");
   		note.setVisible(false);
   		note.getComboBox().setSelectedIndex(0);
   		note.getComboBox_1().setSelectedIndex(0);
   		note.setTitle("Uknown - NotePad");
   		name="";
       }
       
       if (o.compareTo("Save")==0) {
    	   //se salva, salvo stato corrente ma continuo a far scrivere
           //se salva come, salvo sessione corrente, con un testo scelto dallo user
    	   txt=note.getTextArea().getText();
    	   try {
    		   //scrittura su file e quindi salvataggio in file
    		    FileWriter writer = new FileWriter("./src/file/"+name);
   				writer.write(txt);
   				writer.close();
   				JOptionPane.showMessageDialog(null, "Save successful!!");
    			} catch (IOException e1) {
    				e1.printStackTrace();
    		}
       }
       if (o.compareTo("Open")==0) {
    	   // se un file è già aperto pulisco textarea e apro nuova scheda
    	   // se Open, faccio scegliere il documento e lo apro (come prima)
    	   if (name.compareTo("")!=0) {
    		   note.getTextArea().setText("");
        	   note.setVisible(false);
        	   note.setVisible(true);
        	   note.getComboBox().setSelectedIndex(0);
        	   note.getComboBox_1().setSelectedIndex(0);
        	   note.setTitle(name+" - NotePad");
    	   }
    	   String[] files;
    	   File f = new File("./src/file");
    	   JComboBox fileList=new JComboBox();
    	   JButton bottone_1= new JButton();
    	   bottone_1.setText("Select File!");
    	   // Populates the array with names of files and directories
    	   files = f.list();
    	   //System.out.println(Arrays.toString(files));
	       for (int i = 0; i < files.length; i++) {
	    	   fileList.addItem(new String(files[i]));
	       }
	       //creazione finestra con relativi file e quindi opzioni di apertura
    	   fileList.setSelectedIndex(0);
    	   Object[] option= new Object[] {};
    	   JOptionPane jop=new JOptionPane("Lista di File ",JOptionPane.QUESTION_MESSAGE,JOptionPane.DEFAULT_OPTION,null,option,null);
    	   jop.add(fileList);
    	   jop.add(bottone_1);
    	   
    	   JDialog diag = new JDialog();
	       diag.getContentPane().add(jop);
	       diag.setBounds(150, 150, 340, 130);
	       diag.pack();
	       diag.setResizable(false);
	       diag.setVisible(true);
    	   
	       bottone_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s="";
				name=(String) fileList.getSelectedItem();
				diag.setVisible(false);
				FileReader reader;
				try {
					//lettura file e apertura documento e scrittura dentro a text area di testo già scritto
					note.setTitle(name+" - NotePad");
					reader = new FileReader("./src/file/"+name);
					 int character;
			           while ((character = reader.read()) != -1) {
			           	s=s+(char) character;
			           }
			           reader.close();
			         note.getTextArea().setText(s);
			         s="";
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
	       });
       }
       if (o.compareTo("New")==0) {
    	//se apro nuova finestra, pulisco text area e libero il nome del file aperto
    	//se New, salvo stato corrente, chiudo finestra e apro finestra nuova
        // -> se c'è un file aperto, salvo il file, lo chiudo e apro quello nuovo
    	if (name.compareTo("")!=0) {
    		txt=note.getTextArea().getText();
    		FileWriter writer;
			try {
				writer = new FileWriter("./src/file/"+name);
				writer.write(txt);
				writer.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		note.getTextArea().setText("");
		note.setVisible(false);
		note.setVisible(true);
		note.getComboBox().setSelectedIndex(0);
		note.getComboBox_1().setSelectedIndex(0);
		note.setTitle("Uknown - NotePad");
		name="";
       }
       if (o.compareTo("Save as...")==0) {
    	   //se sceglie di salvare, se file inesistente lo crea e salva il documento se non è vuoto
    	   // -> se il file esite già, lo sovrascrive
    	   String input = JOptionPane.showInputDialog("Save file as:");
    	   name=input;
    	   note.getComboBox().setSelectedIndex(0);
    	   note.getComboBox_1().setSelectedIndex(0);
    	   note.setTitle(name+" - NotePad");
    	   txt=note.getTextArea().getText();
    	   if (! txt.isBlank()) {
    		   try {
	   				File myObj = new File("./src/file/"+name);
			  	    if (myObj.createNewFile()) {
			  	        System.out.println("File created: " + myObj.getName());
			  	        FileWriter writer;
		   				writer = new FileWriter("./src/file/"+name);
		   				writer.write(txt);
		   				writer.close();
			  	    } else {
			  	    	JOptionPane.showMessageDialog(null, "The file will be overwrite!");
			  	        FileWriter writer;
		   				writer = new FileWriter("./src/file/"+name);
		   				writer.write(txt);
		   				writer.close();
			  	    }
	   			} catch (IOException e1) {
	   				e1.printStackTrace();
	   			}
    	   }
       }
	}
	public void setNameEmpty() {
		name="";
	}
	public void openFile(String fileS) {
		String s="";
		name=fileS;
		FileReader reader;
		try {
			//lettura file e apertura documento e scrittura dentro a text area di testo già scritto
			note.setTitle(name+" - NotePad");
			reader = new FileReader("./src/file/"+name);
			int character;
	        while ((character = reader.read()) != -1) {
	        	s=s+(char) character;
	        }
	       // reader.close();
	        note.getTextArea().setText(s);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}

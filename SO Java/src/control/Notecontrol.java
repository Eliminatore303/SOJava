package control;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JMenuItem;
import view.Note;

public class Notecontrol implements ActionListener{
	private Note note;
	private String txt;
	private String name="";
	private String saveN="";
	//get the file i will open
	private String openF="";
	//i need an integer for saving the window i am working on, so i can modify the file it is using
	//the noteCount is the starting name of the note and it will be the key to acces to his position
	private int noteCount;
	private static int count=0;
	//the variable is static so that every time one Note is created it will be add to the list
	//this variabile is necessary to save the current state of the file and know all the opened file
	private static ArrayList<String> fileList =new ArrayList<String>();
	//it is necessary this variables to choose the file
	private JFileChooser fileChooser;
	private String userDir;
	private File selectedFile;
	
	public Notecontrol(Note note) {
		this.note=note;
		note.getMntmNewMenuItem_1().addActionListener(this);
		note.getMntmNewMenuItem_2().addActionListener(this);
		note.getMntmNewMenuItem_3().addActionListener(this);
		note.getMntmNewMenuItem_4().addActionListener(this);
		note.getMntmNewMenuItem_5().addActionListener(this);
		note.getMntmNewMenuItem_6().addActionListener(this);
		note.getMntmNewMenuItem_7().addActionListener(this);
		//selectedFile= new File(note.getName());
		//System.out.println(note.getName());
		noteCount=count;
		count++;
		addNoteToList();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		txt="";
		JMenuItem  menuItem= (JMenuItem) e.getSource();
        String o = ""+menuItem.getText();
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
    	if (selectedFile.getName().compareTo("Uknown")!=0) {
       		txt=note.getTextArea().getText();
       		FileWriter writer;
	   		try {
	   			writer = new FileWriter(selectedFile);
	   			writer.write(txt);
	   			writer.close();
	   		} catch (IOException e1) {
	   			e1.printStackTrace();
	   		}
   		}
   		note.getTextArea().setText("");
   		note.setVisible(false);
   		note.setTitle("Uknown - NotePad");
   		setFileListName("Uknown");
   		selectedFile=new File("Uknown");
       }
       
       if (o.compareTo("Save")==0) {
    	   //se salva, salvo stato corrente ma continuo a far scrivere
           //se salva come, salvo sessione corrente, con un testo scelto dallo user
    	   txt=note.getTextArea().getText();
    	   if (fileList.get(noteCount).compareTo(""+noteCount)!=0 || selectedFile.getName().compareTo("Uknown")!=0) {
    		   printFileList();
    		   System.out.println(selectedFile);
    		   System.out.println(txt);
    		   try {
        		   //scrittura su file aperto e quindi salvataggio in file
        		    FileWriter writer = new FileWriter(selectedFile);
       				writer.write(txt);
       				writer.close();
       				JOptionPane.showMessageDialog(null, "Save successful!!");
        			} catch (IOException e1) {
        				e1.printStackTrace();
        		}
    	   }
    	   
       }
       if (o.compareTo("Open")==0) {
    	   // se un file è già aperto pulisco textarea e apro nuova scheda
    	   // se Open, faccio scegliere il documento e lo apro (come prima)
    	   if ((""+selectedFile).compareTo("Uknown")!=0) {
    		   note.getTextArea().setText("");
        	   note.setVisible(false);
        	   note.setVisible(true);
        	   note.setTitle(selectedFile+" - NotePad");
        	   setFileListName(""+selectedFile);
    	   }
    	   String[] files;
    	   File f = new File("./file/");
    	   JComboBox fileList=new JComboBox();
    	   JButton bottone_1= new JButton();
    	   bottone_1.setText("Select File!");
    	   // Populates the array with names of files and directories
    	   files = f.list();
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
				openF=(String) fileList.getSelectedItem();
				diag.setVisible(false);
				//if the file i want to open is already open, it will not be open otherwise it can be open
				if (! fileIsOpen(openF)) {
					FileReader reader;
					try {
						//lettura file e apertura documento e scrittura dentro a text area di testo già scritto
						note.setTitle(openF+" - NotePad");
						setFileListName(openF);
						reader = new FileReader("./file/"+openF);
						 int character;
				           while ((character = reader.read()) != -1) {
				           	s=s+(char) character;
				           }
				           reader.close();
				         note.getTextArea().setText(s);
				         s="";
				         name=openF;
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "File already open you can't open it an other time!!!");
				}
				
			}
	       });
       }
       if (o.compareTo("New")==0) {
    	//se apro nuova finestra, pulisco text area e libero il nome del file aperto
    	//se New, salvo stato corrente, chiudo finestra e apro finestra nuova
        // -> se c'è un file aperto, salvo il file, lo chiudo e apro quello nuovo
    	if ((""+selectedFile).compareTo("Uknown")!=0) {
    		txt=note.getTextArea().getText();
    		FileWriter writer;
			try {
				writer = new FileWriter(selectedFile);
				writer.write(txt);
				writer.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		note.getTextArea().setText("");
		note.setVisible(false);
		note.setVisible(true);
		note.setTitle("Uknown - NotePad");
		setFileListName("Uknown");
		selectedFile=new File("Uknown");
       }
       if (o.compareTo("Save as...")==0) {
    	   //se sceglie di salvare, se file inesistente lo crea e salva il documento se non è vuoto
    	   // -> se il file esite già, lo sovrascrive
    	   String input = JOptionPane.showInputDialog("Save file as:");
    	   saveN=input;
    	   if (! fileIsOpen(saveN) || ( fileIsOpen(saveN) && saveN.compareTo(selectedFile.getName())==0)) {
    		   if (saveN==null && ((""+selectedFile).compareTo("Uknown")!=0 || fileList.get(noteCount).compareTo(""+noteCount)!=0)) {
    	    		 //salvo in file già aperto
    	    		 //ho un file aperto
    				 //altrimenti non ho file aperto
    	        	   note.setTitle(""+selectedFile);
    	        	   setFileListName(""+selectedFile);
    	        	   txt=note.getTextArea().getText();
    	        	   try {
	    	   				File myObj = new File(""+selectedFile);
	    			  	    if (myObj.createNewFile()) {
	    			  	        FileWriter writer;
	    		   				writer = new FileWriter(selectedFile);
	    		   				writer.write(txt);
	    		   				writer.close();
	    			  	    } else {
	    			  	    	JOptionPane.showMessageDialog(null, "The file will be overwrite!");
	    			  	        FileWriter writer;
	    		   				writer = new FileWriter(selectedFile);
	    		   				writer.write(txt);
	    		   				writer.close();
	    			  	    }
	    	   			} catch (IOException e1) {
	    	   				e1.printStackTrace();
	    	   			}
    	    	   }else {
    				 //ho inserito testo nella input e quindi salvo nel file richiesto
	            	   note.setTitle(saveN+" - NotePad");
	            	   setFileListName(saveN);
	            	   txt=note.getTextArea().getText();
	            	   try {
       	   				File myObj = new File("./file/"+saveN);
       			  	    if (myObj.createNewFile()) {
       			  	        FileWriter writer;
       		   				writer = new FileWriter("./file/"+saveN);
       		   				writer.write(txt);
       		   				writer.close();
       			  	    } else {
       			  	    	JOptionPane.showMessageDialog(null, "The file will be overwrite!");
       			  	        FileWriter writer;
       		   				writer = new FileWriter("./file/"+saveN);
       		   				writer.write(txt);
       		   				writer.close();
       			  	    }
       	   			} catch (IOException e1) {
       	   				e1.printStackTrace();
       	   			}
	            	   //name=saveN;
	            	   selectedFile=new File(saveN);
    	    	   }
    	   }else {
    		   //the user is trying to save in a file that is already open 
			JOptionPane.showMessageDialog(null, "The file you are trying to save in is already open from an other note, try an other one!!!");
    	   }
    	   
       }
	}
	public void setNameEmpty() {
		name="";
	}
	public void openFile(String fileS) {
		String s="";
		FileReader reader;
		File file= new File(fileS);
		selectedFile= new File(fileS);
		try {
			//lettura file e apertura documento e scrittura dentro a text area di testo già scritto
			note.setName(""+noteCount);
			note.setTitle(fileS+" - NotePad");
			setFileListName(fileS);
			reader = new FileReader(fileS);
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
	public void addNoteToList() {
		fileList.add(""+selectedFile);
	}
	public void printFileList() {
		System.out.println("File list: ");
		for (int i = 0; i < fileList.size(); i++) {
			System.out.println("cell: "+i+" file open: "+fileList.get(i));
		}
	}
	public static void printFileListS() {
		System.out.println("File list: ");
		for (int i = 0; i < fileList.size(); i++) {
			System.out.println("cell: "+i+" file open: "+fileList.get(i));
		}
	}
	public static boolean fileIsOpen(String fileName) {
		int x=0;
		//return TRUE if the file is open otherwise return false
		boolean flag=true;
		boolean found=false;
		while(flag) {
			if (x<fileList.size()) {
				if (fileList.get(x).compareTo(fileName)==0) {
					//file I am searcing for is in the list
					found=true;
					flag=false;
				}else {
					x++;
				}
			}else {
				flag=false;
			}
		}
		return found;//true found, otherwise not found
	}
	public static void setFileOpenNo(int key) {
		//the note that is closing will be nullifed in the list
		fileList.set(key, " ");
	}
	private void setFileListName(String s) {
		fileList.set(noteCount, s);
	}
	private void getFile() {
		userDir = System.getProperty("user.home");
		fileChooser = new JFileChooser(userDir +"/Desktop");
		int result = fileChooser.showOpenDialog(fileChooser);
		if (result == JFileChooser.APPROVE_OPTION) {
			selectedFile = fileChooser.getSelectedFile();
			//fileChooser.getn
			//selectedFile will replace the variable that save the file
		}
	}
	private void writeOnFile(String s) {
    	FileWriter writer;
		try {
			writer = new FileWriter(selectedFile);
			writer.write(s);
			writer.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	private String readFile() {
		String s="";
		return s;
	}
}

package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import view.FileExplorer;
import view.Note;

public class FileExplorerontrol implements ActionListener{
	private FileExplorer fileE;
	private String s,t,v,n;
	private JFileChooser fileChooser;
	private String userDir;
	private File selectedFile;
	
	public FileExplorerontrol(FileExplorer fileExplorer) {
		this.fileE=fileExplorer;
		fileE.getBtnNewButton().addActionListener(this);
		fileE.getBtnNewButton_1().addActionListener(this);
		fileE.getBtnNewButton_2().addActionListener(this);
		fileE.getBtnNewButton_3().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//per resettare la finestra, usare fileE.refresh()
		if (e.getSource()==fileE.getBtnNewButton()) {
			//if button selected, open a fileChooser window
			userDir = System.getProperty("user.home");
			fileChooser = new JFileChooser(userDir +"/Desktop");
			int result = fileChooser.showOpenDialog(fileChooser);
			if (result == JFileChooser.APPROVE_OPTION) {
				selectedFile = fileChooser.getSelectedFile();
				fileE.getTextField().setText(""+selectedFile);
				fileE.getTextField_1().setText(""+selectedFile);
			}
		}
		if (e.getSource()==fileE.getBtnNewButton_1()) {
			t=""+fileE.getTextField().getText();
			if (! t.isBlank()) {
				//open file
				
				//if file is not already open, open the file, otherwise open an error message
				if (! Notecontrol.fileIsOpen(t)) {
					//false the file is not open so i open it
					new Notecontrol(new Note()).openFile(t);
					fileE.refresh();
				}else {
					//true show a message error
					JOptionPane.showMessageDialog(null, "File already open!!!");
				}
			}
		}
		if (e.getSource()==fileE.getBtnNewButton_2()) {
			v=""+fileE.getTextField_1().getText();
			if (! v.isBlank()) {
				//delete file
				File myObj = new File(v);
				
				if (! Notecontrol.fileIsOpen(v)) {
					if (myObj.delete()) { 
					      //System.out.println("File deleted: " + myObj.getName());
					      JOptionPane.showMessageDialog(null, "File deleted: "+v);
					    } else {
					      //System.out.println("Failed to delete the file.");
					    	JOptionPane.showMessageDialog(null, "Failed to delete the file.");
					    }
					    fileE.refresh();
					//falso il file non � in uso
				}else {
					//vero il file � in uso
					JOptionPane.showMessageDialog(null, "File is open you can't delete it!!!");
				}
			}
		}
		if (e.getSource()==fileE.getBtnNewButton_3()) {
			n=""+fileE.getTextField_2().getText();
			if (! n.isBlank()) {
				//create new file
				//check if file don't exist, in this case create it
				try {
	   				File myObj = new File(n);
			  	    if (myObj.createNewFile()) {
			  	        System.out.println("File created: " + myObj.getName());
			  	        JOptionPane.showMessageDialog(null, "File created: "+n);
			  	    } else {
			  	    	JOptionPane.showMessageDialog(null, "The file already exist!");
			  	    }
	   			} catch (IOException e1) {
	   				e1.printStackTrace();
	   			}
				fileE.refresh();
			}
		}
	}
	
}

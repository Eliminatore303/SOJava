package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import view.FileExplorer;
import view.Note;

public class FileExplorerontrol implements ActionListener{
	private FileExplorer fileE;
	private String s,t,v,n;
	
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
			s=""+fileE.getComboBox().getSelectedItem();
			if (! s.isBlank()) {
				fileE.getTextField().setText(s);
				fileE.getTextField_1().setText(s);
			}
		}
		if (e.getSource()==fileE.getBtnNewButton_1()) {
			t=""+fileE.getTextField().getText();
			if (! t.isBlank()) {
				//open file
				new Notecontrol(new Note()).openFile(t);
				fileE.refresh();
			}
		}
		if (e.getSource()==fileE.getBtnNewButton_2()) {
			v=""+fileE.getTextField_1().getText();
			if (! v.isBlank()) {
				//delete file
				File myObj = new File("./src/file/"+v);
				//System.out.println(v);
			    if (myObj.delete()) { 
			      //System.out.println("File deleted: " + myObj.getName());
			      JOptionPane.showMessageDialog(null, "File deleted: "+v);
			    } else {
			      //System.out.println("Failed to delete the file.");
			    	JOptionPane.showMessageDialog(null, "Failed to delete the file.");
			    }
			    fileE.refresh();
			}
		}
		if (e.getSource()==fileE.getBtnNewButton_3()) {
			n=""+fileE.getTextField_2().getText();
			if (! n.isBlank()) {
				//create new file
				//check if file don't exist, in this case create it
				try {
	   				File myObj = new File("./src/file/"+n);
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

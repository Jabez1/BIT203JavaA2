package CRS;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

/**The JDialog that allows users to 
 * Import or Export their CRS instance 
 * 
 * @author Chin Ze Han B1901647
 *
 */
public class GUIFileManage extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private CRS newCrs;
	private boolean modCheck;

	/**
	 * Create the dialog.
	 */
	public GUIFileManage(CRS crs) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		contentPanel.setLayout(new GridLayout(0, 2, 20, 10));
		contentPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
		setTitle("CRS File Manager");
		
		JFileChooser flChsr = new JFileChooser();
		flChsr.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = 
				new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		flChsr.setFileFilter(filter);
		{
			JButton btnExport = new JButton("Export Data");
			btnExport.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int returnValue = flChsr.showSaveDialog(contentPanel);
					if (returnValue == JFileChooser.APPROVE_OPTION) {
						File file = flChsr.getSelectedFile();
						try (ObjectOutputStream oos = new ObjectOutputStream(
							new FileOutputStream(file));
							PrintWriter pw = new PrintWriter(new FileWriter(
								file.getName() + ".txt"));) {
							
							oos.writeObject(crs);
							
						} catch (IOException ioe) {
							System.out.println(ioe);
							JOptionPane.showMessageDialog(contentPanel,
								"Error while exporting");
						}
					}
				}
			});
			contentPanel.add(btnExport);
		}
		{
			JButton btnImport = new JButton("Import Data");
			btnImport.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int returnValue = flChsr.showOpenDialog(contentPanel);
					if (returnValue == JFileChooser.APPROVE_OPTION) {
						File file = flChsr.getSelectedFile();
						try (
							ObjectInputStream ois = new ObjectInputStream(
							new FileInputStream(file));
							BufferedReader br = new BufferedReader(new FileReader(
								file.getName() + ".txt"));) {
							
							setNewCrs((CRS) ois.readObject());
							
							
						} catch (ClassNotFoundException cnfe) {
							JOptionPane.showMessageDialog(contentPanel,
									"Error while importing");						
						} catch (IOException ioe) {
							JOptionPane.showMessageDialog(contentPanel,
								"Error while importing");
						}
					}
				}
			});
			contentPanel.add(btnImport);
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			{
				JLabel FileLabel = new JLabel("");
				panel.add(FileLabel);
			}
		}
	}

	/**
	 * 
	 * @return new exported CRS object
	 */
	public CRS getNewCrs() {
		return newCrs;
	}

	/**
	 * 
	 * @param newCrs sets new CRS object
	 */
	public void setNewCrs(CRS newCrs) {
		this.newCrs = newCrs;
	}

	/**
	 * 
	 * @return true if crs has been modified
	 * 	  	   false if crs has not been modified
	 */
	public boolean isModCheck() {
		return modCheck;
	}

	/**
	 * sets bool modCheck
	 * @param modCheck
	 */
	public void setModCheck(boolean modCheck) {
		this.modCheck = modCheck;
	}

}

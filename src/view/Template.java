package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controller.BuildTables;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Template {

	private JFrame frmCollegeSystem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Template window = new Template();
					window.frmCollegeSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Template() {
		try {
			new BuildTables();
			initialize();
		} catch (Exception e) {
			System.out.println("Failed to connect to database\n" + e);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCollegeSystem = new JFrame();
		frmCollegeSystem.setTitle("College System");
		frmCollegeSystem.setBounds(100, 100, 450, 300);
		frmCollegeSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmCollegeSystem.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmCreate = new JMenuItem("Create");
		mntmCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				frmCollegeSystem.getContentPane().removeAll();
				CreateStudent createPanel = new CreateStudent();
				frmCollegeSystem.getContentPane().add(createPanel);
				frmCollegeSystem.getContentPane().repaint();
				frmCollegeSystem.getContentPane().revalidate();
			}
		});
		mnFile.add(mntmCreate);
		
		JMenuItem mntmRead = new JMenuItem("Read");
		mntmRead.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				frmCollegeSystem.getContentPane().removeAll();
				ReadStudent readPanel = new ReadStudent();
				frmCollegeSystem.getContentPane().add(readPanel);
				frmCollegeSystem.getContentPane().repaint();
				frmCollegeSystem.getContentPane().revalidate();
			}
		});
		mnFile.add(mntmRead);
		
		JMenuItem mntmUpdate = new JMenuItem("Update");
		mntmUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				frmCollegeSystem.getContentPane().removeAll();
				UpdateStudent updatePanel = new UpdateStudent();
				frmCollegeSystem.getContentPane().add(updatePanel);
				frmCollegeSystem.getContentPane().repaint();
				frmCollegeSystem.getContentPane().revalidate();
			}
		});
		mnFile.add(mntmUpdate);
		
		JMenuItem mntmDelete = new JMenuItem("Delete");
		mntmDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				frmCollegeSystem.getContentPane().removeAll();
				DeleteStudent deletePanel = new DeleteStudent();
				frmCollegeSystem.getContentPane().add(deletePanel);
				frmCollegeSystem.getContentPane().repaint();
				frmCollegeSystem.getContentPane().revalidate();
			}
		});
		mnFile.add(mntmDelete);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
	}
}

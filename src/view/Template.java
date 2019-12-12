package view;

import java.awt.EventQueue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Template {

	private JFrame frmCollegeSystem;
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	
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
			factory = Persistence.createEntityManagerFactory("student");
			manager = factory.createEntityManager();
			initialize();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Failed to connect to database\n");
			e.printStackTrace();
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
				
				CreateStudent createPanel = new CreateStudent(manager);
				
				frmCollegeSystem.getContentPane().add(createPanel);
				frmCollegeSystem.getContentPane().repaint();
				frmCollegeSystem.getContentPane().revalidate();
			}
		});
		mnFile.add(mntmCreate);
		
		JMenuItem mntmRead = new JMenuItem("Read / Update");
		mntmRead.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				frmCollegeSystem.getContentPane().removeAll();
				ReadAndUpdateStudent readPanel = new ReadAndUpdateStudent(manager);
				frmCollegeSystem.getContentPane().add(readPanel);
				frmCollegeSystem.getContentPane().repaint();
				frmCollegeSystem.getContentPane().revalidate();
			}
		});
		mnFile.add(mntmRead);
		
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
				factory.close();
				manager.close();
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
	}
}
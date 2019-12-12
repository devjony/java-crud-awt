package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.persistence.EntityManager;
import javax.swing.JButton;
import javax.swing.JTextField;

import controller.ManipulateTables;
import model.Student;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreateStudent extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6362883120008410026L;
	private JTextField nameTextField;
	private JTextField emailTextField;
	private JTextField courseTextField;
	private JTextField idTextField;

	/**
	 * Create the panel.
	 */
	public CreateStudent(EntityManager manager) {
		setLayout(null);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setBounds(125, 87, 48, 14);
		add(nameLabel);
		
		JLabel emailLabel = new JLabel("E-mail:");
		emailLabel.setBounds(125, 120, 48, 14);
		add(emailLabel);
		
		JLabel courseLabel = new JLabel("Course:");
		courseLabel.setBounds(125, 153, 48, 14);
		add(courseLabel);
		
		JButton btnSave = new JButton("Save");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Student student = new Student();
				
				student.setName(nameTextField.getText());
				student.setEmail(emailTextField.getText());
				student.setCourse(courseTextField.getText());
				
				if(student.getName().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Student name cannot be empty.");
				} else if(student.getEmail().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Student e-mail cannot be empty.");
				} else if(student.getCourse().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Student course cannot be empty.");
				} else {
					ManipulateTables.createStudent(manager, student);
					
					JOptionPane.showMessageDialog(null, student.getName() + " successfully registered.");
					nameTextField.setText("");
					emailTextField.setText("");
					courseTextField.setText("");
				}
			}
		});
		btnSave.setBounds(183, 190, 89, 23);
		add(btnSave);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(183, 85, 135, 20);
		add(nameTextField);
		nameTextField.setColumns(10);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(183, 118, 135, 20);
		add(emailTextField);
		emailTextField.setColumns(10);
		
		courseTextField = new JTextField();
		courseTextField.setBounds(183, 151, 135, 20);
		add(courseTextField);
		courseTextField.setColumns(10);
		
		JLabel createStudentTitleLabel = new JLabel("Create Student");
		createStudentTitleLabel.setBounds(182, 18, 106, 14);
		add(createStudentTitleLabel);
		
		JLabel idLabel = new JLabel("ID:");
		idLabel.setBounds(125, 54, 48, 14);
		add(idLabel);
		
		idTextField = new JTextField();
		idTextField.setEditable(false);
		idTextField.setColumns(10);
		idTextField.setBounds(183, 52, 48, 20);
		add(idTextField);
	}
}
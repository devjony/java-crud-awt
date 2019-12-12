package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
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

	/**
	 * Create the panel.
	 */
	public CreateStudent() {
		setLayout(null);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setBounds(138, 67, 48, 14);
		add(nameLabel);
		
		JLabel emailLabel = new JLabel("E-mail:");
		emailLabel.setBounds(138, 108, 48, 14);
		add(emailLabel);
		
		JLabel courseLabel = new JLabel("Course:");
		courseLabel.setBounds(138, 144, 48, 14);
		add(courseLabel);
		
		JButton btnSave = new JButton("Save");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Student student = new Student();
				
				student.setName(nameTextField.getText());
				student.setEmail(emailTextField.getText());
				student.setCourse(courseTextField.getText());
				
				ManipulateTables.createStudent(student);
			}
		});
		btnSave.setBounds(168, 189, 89, 23);
		add(btnSave);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(196, 64, 120, 20);
		add(nameTextField);
		nameTextField.setColumns(10);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(196, 105, 120, 20);
		add(emailTextField);
		emailTextField.setColumns(10);
		
		courseTextField = new JTextField();
		courseTextField.setBounds(196, 141, 120, 20);
		add(courseTextField);
		courseTextField.setColumns(10);
		
		JLabel createStudentTitleLabel = new JLabel("Create Student");
		createStudentTitleLabel.setBounds(168, 22, 106, 14);
		add(createStudentTitleLabel);
	}
}
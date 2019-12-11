package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class UpdateStudent extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6362883120008410026L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public UpdateStudent() {
		setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(138, 68, 48, 14);
		add(lblId);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(138, 110, 48, 14);
		add(lblName);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(138, 154, 48, 14);
		add(lblEmail);
		
		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setBounds(138, 189, 48, 14);
		add(lblCourse);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(168, 231, 89, 23);
		add(btnSave);
		
		textField = new JTextField();
		textField.setBounds(196, 65, 96, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(196, 107, 96, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(196, 147, 96, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(196, 187, 96, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCreateStudent = new JLabel("Update Student");
		lblCreateStudent.setBounds(168, 22, 106, 14);
		add(lblCreateStudent);
	}
}

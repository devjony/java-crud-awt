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
		lblId.setBounds(125, 54, 48, 14);
		add(lblId);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(125, 87, 48, 14);
		add(lblName);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(125, 120, 48, 14);
		add(lblEmail);
		
		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setBounds(125, 153, 48, 14);
		add(lblCourse);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(183, 190, 89, 23);
		add(btnSave);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(183, 52, 48, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(183, 85, 135, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(183, 118, 135, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(183, 151, 135, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCreateStudent = new JLabel("Update Student");
		lblCreateStudent.setBounds(182, 18, 106, 14);
		add(lblCreateStudent);
	}
}
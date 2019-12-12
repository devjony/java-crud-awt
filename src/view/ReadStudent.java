package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ReadStudent extends JPanel {
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
	public ReadStudent() {
		setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(134, 50, 48, 14);
		add(lblId);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(134, 92, 48, 14);
		add(lblName);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(134, 136, 48, 14);
		add(lblEmail);
		
		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setBounds(134, 171, 48, 14);
		add(lblCourse);
		
		textField = new JTextField();
		textField.setBounds(192, 47, 96, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(192, 89, 96, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(192, 129, 96, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(192, 169, 96, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCreateStudent = new JLabel("Read Student");
		lblCreateStudent.setBounds(168, 22, 106, 14);
		add(lblCreateStudent);
		
		JButton btnRead = new JButton("Read");
		btnRead.setBounds(168, 200, 89, 23);
		add(btnRead);
	}
}
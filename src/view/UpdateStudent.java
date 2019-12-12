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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateStudent extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6362883120008410026L;
	private JTextField idTextField;
	private JTextField nameTextField;
	private JTextField emailTextField;
	private JTextField courseTextField;

	/**
	 * Create the panel.
	 */
	public UpdateStudent(EntityManager manager) {
		setLayout(null);
		
		JLabel idLabel = new JLabel("ID:");
		idLabel.setBounds(125, 54, 48, 14);
		add(idLabel);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setBounds(125, 87, 48, 14);
		add(nameLabel);
		
		JLabel emailLabel = new JLabel("E-mail:");
		emailLabel.setBounds(125, 120, 48, 14);
		add(emailLabel);
		
		JLabel courseLabel = new JLabel("Course:");
		courseLabel.setBounds(125, 153, 48, 14);
		add(courseLabel);
		
		idTextField = new JTextField();
		idTextField.setBounds(183, 52, 48, 20);
		add(idTextField);
		idTextField.setColumns(10);
		
		nameTextField = new JTextField();
		nameTextField.setEditable(false);
		nameTextField.setBounds(183, 85, 135, 20);
		add(nameTextField);
		nameTextField.setColumns(10);
		
		emailTextField = new JTextField();
		emailTextField.setEditable(false);
		emailTextField.setBounds(183, 118, 135, 20);
		add(emailTextField);
		emailTextField.setColumns(10);
		
		courseTextField = new JTextField();
		courseTextField.setEditable(false);
		courseTextField.setBounds(183, 151, 135, 20);
		add(courseTextField);
		courseTextField.setColumns(10);
		
		JLabel readStudentTitleLabel = new JLabel("Update Student");
		readStudentTitleLabel.setBounds(182, 18, 106, 14);
		add(readStudentTitleLabel);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please read a student before update data.");
					nameTextField.setText("");
					emailTextField.setText("");
					courseTextField.setText("");
					btnUpdate.setEnabled(false);
				} else {
					idTextField.setEditable(false);
					nameTextField.setEditable(true);
					emailTextField.setEditable(true);
					courseTextField.setEditable(true);
					btnUpdate.setVisible(false);
					JButton btnSave = new JButton("Save");
					btnSave.setBounds(229, 190, 89, 23);
					add(btnSave);
					
					btnSave.addMouseListener(new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent e) {
							if(idTextField.getText().isEmpty()) {
								JOptionPane.showMessageDialog(null, "Please insert an ID to update data.");
							} else {
								Student student = new Student();
								student.setId(Long.parseLong(idTextField.getText()));
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
									ManipulateTables.updateStudent(manager, student);
									
									JOptionPane.showMessageDialog(null, "Student data updated.");
									
									idTextField.setEditable(true);
									nameTextField.setEditable(false);
									emailTextField.setEditable(false);
									courseTextField.setEditable(false);
									
									btnSave.setVisible(false);
									btnUpdate.setVisible(true);
									btnUpdate.setEnabled(false);
									
									idTextField.setText("");
									nameTextField.setText("");
									emailTextField.setText("");
									courseTextField.setText("");
								}
							}
						}
					});
				}
			}
		});
		btnUpdate.setEnabled(false);
		btnUpdate.setBounds(229, 190, 89, 23);
		add(btnUpdate);
		
		JButton btnRead = new JButton("Read");
		btnRead.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(idTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Student ID cannot be empty.");
					idTextField.setText("");
					nameTextField.setText("");
					emailTextField.setText("");
					courseTextField.setText("");
					btnUpdate.setEnabled(false);
				} else {
					try{
						Student student = ManipulateTables.readStudent(manager, idTextField.getText());
						nameTextField.setText(student.getName());
						emailTextField.setText(student.getEmail());
						courseTextField.setText(student.getCourse());
						btnUpdate.setEnabled(true);
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Student not found");
						idTextField.setText("");
						nameTextField.setText("");
						emailTextField.setText("");
						courseTextField.setText("");
					}	
				}
			}
		});
		btnRead.setBounds(125, 190, 89, 23);
		add(btnRead);
		
	}
}
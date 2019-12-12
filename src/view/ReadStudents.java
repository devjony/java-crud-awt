package view;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JLabel;
import model.Student;
import javax.swing.JScrollPane;

public class ReadStudents extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2473893908519469787L;

	/**
	 * Create the panel.
	 */
	public ReadStudents(EntityManager manager) {
		setLayout(null);
		
		JLabel lblReadStudents = new JLabel("Read Students");
		lblReadStudents.setBounds(182, 18, 84, 14);
		add(lblReadStudents);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 43, 385, 182);
		add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		String queryJPQL = "from Student";
		StringBuilder studentsText = new StringBuilder();
		
		@SuppressWarnings("unchecked")
		List<Student> students = manager.createQuery(queryJPQL).getResultList();
		for (Student student : students) {
			studentsText.append("ID: " + student.getId());
			studentsText.append("\nName: " + student.getName());
			studentsText.append("\nE-mail: " + student.getEmail());
			studentsText.append("\nCourse: " + student.getCourse());
			studentsText.append("\n\n");
		}
		
		textArea.setText(studentsText.toString());
		
	}
}

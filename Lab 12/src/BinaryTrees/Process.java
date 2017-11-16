package BinaryTrees;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Process {

	// main method
	public static void main(String[] args) {

		// variables
		String currLine;
		int id;
		String name;
		double GPA;
		String advisor;
		boolean isGraduate = false;

		// objects
		StringTokenizer token;
		BinarySearchTree<GraduateStudentGPA> gpas = new BinarySearchTree<GraduateStudentGPA>(); // binary search tree
		GraduateStudentGPA[] allStudents = new GraduateStudentGPA[10]; // temporary container for the students
		File in = new File("C:\\Code\\students.in"); // file that holds student data

		try {
			// scanner to import data from the file
			Scanner scan = new Scanner(in);

			// for each line in the file, import the line and tokenize it, then insert the
			// data from each line into a GraduateStudentGPA object
			for (int i = 0; i < 10; i++) {
				// get next line and create the tokenizer for it
				currLine = scan.nextLine();
				token = new StringTokenizer(currLine);

				// set all the data values
				id = Integer.parseInt(token.nextToken());
				name = token.nextToken();
				GPA = Double.parseDouble(token.nextToken());
				advisor = null;

				if (token.hasMoreTokens()) {
					isGraduate = true;
					advisor = token.nextToken();
				}

				if (isGraduate == true) {
					allStudents[i] = new GraduateStudentGPA(id, name, GPA, advisor);
				} else {
					allStudents[i] = new GraduateStudentGPA(id, name, GPA);
				}
			}

			for (int i = 0; i < 10; i++) {
				gpas.insert(allStudents[i]);
			}

			TreeIterator<GraduateStudentGPA> point = new TreeIterator(gpas, 0);

			GraduateStudentGPA temp;
			StudentGPA student;

			while (point.hasNext()) {
				System.out.println(point.next());
			}

		} catch (FileNotFoundException ex) {
			System.out.println("The file does not exist");
		}
	}
}

// for (int i = 0; i < allStudents.length; i++) {
// for (int j = 0; j < allStudents.length-(i+1); j++) {
// if (allStudents[j].compareTo(allStudents[j+1]) > 0)
// {
// GraduateStudentGPA temp = allStudents[j];
// allStudents[j] = allStudents[j+1];
// allStudents[j+1] = temp;
// }
// }
// }
//
//
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
		boolean isGraduate = false;

		// data values for the StudentGPA and GraduateStudentGPA objects
		int id;
		String name;
		double GPA;
		String advisor;

		// objects
		StringTokenizer token; // tokenizer to process the strings from the file
		BinarySearchTree<GraduateStudentGPA> gpas = new BinarySearchTree<GraduateStudentGPA>(); // binary search tree
		GraduateStudentGPA[] allStudents = new GraduateStudentGPA[10]; // temporary container for the students
		File in = new File("C:\\Code\\students.in"); // file that holds student data

		// try to import data and process it
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

				// if there is an extra token, the student is a graduate student, so set the
				// advisor value
				if (token.hasMoreTokens()) {
					isGraduate = true;
					advisor = token.nextToken();
				}

				// if there is an advisor token, use the constructor with the advisor parameter,
				// otherwise use the one without the advisor parameter
				if (isGraduate == true) {
					allStudents[i] = new GraduateStudentGPA(id, name, GPA, advisor);
				} else {
					allStudents[i] = new GraduateStudentGPA(id, name, GPA);
				}
			}

			// add all the students to the binary search tree
			for (int i = 0; i < 10; i++) {
				gpas.insert(allStudents[i]);
			}

			// create the TreeIterator and set it to inorder traversal mode
			TreeIterator<GraduateStudentGPA> point = new TreeIterator<GraduateStudentGPA>(gpas, 0);

			// traverse the tree and print out the toStrings for the students
			while (point.hasNext()) {
				System.out.println(point.next());
			}

			// if the file cannot be access, print a message to the screen
		} catch (FileNotFoundException ex) {
			System.out.println("The file does not exist");
		}
	}
}

// Bubble sort for testing (to have correct output to compare to)
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
/*
The output was found to be

(100,JKL,2.8, null)
(60,FGH,2.9, null)
(80,HIJ,3.1, null)
(20,BCD,3.2, null)
(50,EFG,3.4, BOSS1)
(10,ABC,3.5, BOSS3)
(40,DEF,3.6, null)
(70,GHI,3.7, BOSS2)
(90,IJK,3.8, BOSS3)
(30,CDE,4.0, BOSS1)

with both the bubble sort and the tree
*/
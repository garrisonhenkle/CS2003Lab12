package BinaryTrees;


public class StudentGPA implements Comparable<StudentGPA> {
 
    protected int id;
    protected String name;
    protected double GPA;

  public StudentGPA(int id, String name, double gpa) {
    this.GPA = gpa;
    this.name = name;
    this.id = id;
  }  // end constructor

  public String toString() {
      return "("+ id + "," + name + ","+GPA+")";
  } // end toString

  public int compareTo(StudentGPA stu){
	  return Double.compare(GPA, stu.GPA);
	  //GPA.compareTo(stu.GPA); original code
  }
 
}

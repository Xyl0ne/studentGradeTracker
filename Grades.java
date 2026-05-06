package StudentGrade;

import java.util.Scanner;

public class Grades extends AcademicPerformance {
    
    Grades(double grade[][]){
        setGrades(grade);
    }

    public void addGrades(double gr1[]) {
       
        
        double cg[][] = getGrades();
        double gr[][] = new double[cg.length +1][5];

        for(int i = 0; i < getGrades().length; i++){
            gr[i] = cg[i];
        }

        gr[gr.length - 1] = gr1;
        setGrades(gr);
    }

    public void editGrades(int index) {
    
        double[][] currentGrades = getGrades();

        if (index >= 0 && index < currentGrades.length) {
            Scanner sc = new Scanner(System.in); 
            
            System.out.println("\nMATCH FOUND: Editing Student #" + index);
            
            
            for (int col = 0; col < currentGrades[index].length; col++) {
                System.out.print("Current Grade [" + currentGrades[index][col] + "] -> Enter New Grade: ");
                
            
                currentGrades[index][col] = sc.nextDouble();
            }
            
            System.out.println("Student Grade updated.");
        } else {
            System.out.println("NO MATCH: The index " + index + " does not exist.");
        }
    }
    
    public static String padRight(String s, int n) {
        if (s.length() >= n)
            return s;
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() < n) {
            sb.append(" ");
        }
        return sb.toString();
    }
}

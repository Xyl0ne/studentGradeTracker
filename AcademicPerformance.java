package StudentGrade;

abstract class AcademicPerformance {

   private static double grades[][];

    static void setGrades(double grade[][]){
        grades = grade;
    }

    static double [][]getGrades(){
        return grades;
    }
}
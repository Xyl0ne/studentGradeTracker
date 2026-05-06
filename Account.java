package StudentGrade;

public abstract class Account {
    

    private String student[];
    void setStudent(String student[]){
        this.student = student;
    }
    public String []getStudent(){
        return this.student;
    }
    
    private double grades[][];
    void setGrades(double grades [][]){
        this.grades = grades;
    }
    public double [][]getGrades(){
        return this.grades;
    }

    private static String course[];
    static void setCourse(String c[]){
        course = c;
    }
    public static String []getCourse(){
        return course;
    }
    private static int units[];
    static void setUnit(int u[]){
        units = u;
    }
    public static int [] getUnit(){
        return units;
    }

    private static int leng;
    void setLen(int leng){
        this.leng = leng;
    }
    int getLen(){
        return this.leng;
    }

    private static int courseStrLen;
    static void setCourseStrLen(int l){
        courseStrLen = l;
    }
    static int getCourseStrLen(){
        return courseStrLen;
    }
    
}

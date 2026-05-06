package StudentGrade;

import java.text.NumberFormat.Style;
import java.util.Scanner;

public class main {
    
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String testEmail = "test@gmail.com";
        String testPass = "test1234";

        
        String mail[]={
                "levypoyaoan@gmail.com",
                "stephen@gmail.com",
                "nyekk@gmail.com",
                "kurt@gmail.com",
                "gregor@gmail.com"
        };
        String pass[] = {
            "levy1234",
            "stephen1234",
            "nyekk1234",
            "kurt1234",
            "gregor1234"
        };

        String students[] = {
            "Levy S. Poyaoan", "Stephen Tapiador", "Raineier Poquiz", "kurt Mendoza", "Gregor Cajas"
        };
        
        String course[]={
            "subject1", "subjet2", "subject3", "subject4","subject5"
        };
        int units[]={
            3, 3, 3, 3, 3
        };
        double grades[][]={
            {1.75, 1.25, 1.00, 1.25,1.25},
            {1.75, 1.50, 1.00, 1.25,1.25},
            {1.75, 1.50, 1.00, 1.25,1.25},
            {1.75, 1.50, 1.00, 1.25,1.25},
            {1.75, 1.50, 1.00, 1.25,1.25},
        };


        Student s = new Student(students);
        Course c = new Course(course, units);
        Grades g = new Grades(grades);
        Record r = new Record();
        boolean isTrue =true;
        /* 
        c.updatedCourse();
        r.uXg(0);*/

/* 
        r.print();*/


        while (true) {
            System.out.println("--------Welcome--------\n");

            System.out.print("[0] Faculty \n[1] Student\nInput: ");

            char logIn = scan.next().toLowerCase().charAt(0);

            if(logIn == '0'){
                while(isTrue){
                    System.out.print("\n[0]Student List\n[1]Student Grades\n[x]exit\nInput: ");

                    char ch = scan.next().toLowerCase().charAt(0);

                    if (ch == '0') {
                        while (isTrue) {
                            
                            s.studentList();
                            System.out.print("\n[a]add\n[x]exit\nInput: ");
                            char a = scan.next().toLowerCase().charAt(0);

                            if (a == 'a') {

                                System.out.print("\nStudent Name: ");
                                String add = scan.next();

                                double temp[] = new double[5];
                                for (int i = 0; i < course.length; i++) {
                                    double n = 0;
                                    temp[i] = n;
                                }

                                s.addStudent(add);
                                g.addGrades(temp);

                                System.out.println();
                            } else if (a == 'x') {
                                isTrue = false;
                            } else {
                                System.out.println("Invalid input");
                            }
                        }
                        isTrue =true;

                    } else if (ch == '1') {
                        s.print();

                        System.out.print("Input: ");
                        char e = scan.next().toLowerCase().charAt(0);
                        if (e == 'e') {
                            System.out.print("Student ID: ");
                            int index = scan.nextInt();
                            g.editGrades(index);
                        }
                    }else if(ch =='x'){
                        isTrue =false;
                    }else{
                        System.out.println("Invalid Input");
                    }
                }
                isTrue =true;
                
            }else if(logIn == '1'){
                while (isTrue) {
                    System.out.print("\n[0]Enrolled Courses\n[1]Transcript of Records\n[x]exit\n\nInput: ");
                    char a = scan.next().toLowerCase().charAt(0);

                    if(a == '0'){
                        while (isTrue) {
                            r.print();
                            System.out.print("\n[x]exit\nInput: ");
                            char x = scan.next().toLowerCase().charAt(0);

                            if (x == 'x') {
                                isTrue = false;
                            } else {
                                System.out.println("Invalid Input");
                            }
                        }
                        isTrue =true;
                    }else if(a =='1'){
                        while (isTrue) {
                            c.updatedCourse();
                            r.uXg(0);
                            System.out.print("\n[x]exit\nInput: ");
                            char x = scan.next().toLowerCase().charAt(0);

                            if (x == 'x') {
                                isTrue = false;
                            } else {
                                System.out.println("Invalid Input");
                            }
                        }
                        isTrue =true;
                    }else if(a == 'x'){
                        isTrue = false;
                    }else{System.out.println("Invalid Input ");}
                }
                isTrue =true;
            }
            
        }
        
        
    
    }
}

abstract class Account {

    private String student[];

    void setStudent(String student[]) {
        this.student = student;
    }

    public String[] getStudent() {
        return this.student;
    }

    private double grades[][];

    void setGrades(double grades[][]) {
        this.grades = grades;
    }

    public double[][] getGrades() {
        return this.grades;
    }

    private static String course[];

    static void setCourse(String c[]) {
        course = c;
    }

    public static String[] getCourse() {
        return course;
    }

    private static int units[];

    static void setUnit(int u[]) {
        units = u;
    }

    public static int[] getUnit() {
        return units;
    }

    private static int leng;

    void setLen(int leng) {
        this.leng = leng;
    }

    int getLen() {
        return this.leng;
    }

    private static int courseStrLen;

    static void setCourseStrLen(int l) {
        courseStrLen = l;
    }

    static int getCourseStrLen() {
        return courseStrLen;
    }

}

class Student extends Account {

    Student(String s[]) {
        this.setStudent(s);
    }

    /*------------------------------------------------------------ */
    public void print() {
        len();
        double studenGrades[][] = AcademicPerformance.getGrades();
        String arr[] = getStudent();
        String n = "Name";
        int t = getLen();

        while (n.length() < t + 3) {
            n = n.concat(" ");
        }
        System.out.println("\n==================================================================");
        System.out.print("|" + n + "|");

        for (int i = 0; i < getCourse().length; i++) {
            System.out.print(getCourse()[i] + "|");
        }

        System.out.println("\n==================================================================");
        for (int i = 0; i < studenGrades.length; i++) {
            System.out.print("|" + "[" + i + "]" + arr[i] + "|");
            for (int j = 0; j < studenGrades[i].length; j++) {
                String str = pad(studenGrades[i][j], j);
                System.out.print(str + "|");
            }

            System.out.println();
        }
        System.out.println("==================================================================");
        System.out.println("\n[e]edit\n[x]exit");
    }

    public String pad(double n, int j) {
        String s = Double.toString(n);

        String[] courseArray = getCourse();

        String name = courseArray[j];
        while (s.length() < name.length()) {
            s += " ";
        }
        return s;
    }

    public void studentList() {
        System.out.println();
        for (int i = 0; i < getStudent().length; i++) {
            System.out.print("[" + i + "]" + getStudent()[i]);
            System.out.println();
        }
    }

    /*------------------------------------------------------------- */
    public void addStudent(String add) {
        String temp[] = new String[getStudent().length + 1];

        for (int i = 0; i < getStudent().length; i++) {
            temp[i] = getStudent()[i];
        }
        temp[temp.length - 1] = add;

        super.setStudent(temp);
        System.out.println();

    }

    /*------------------------------------------------------------- */
    public void len() {

        String arr[] = getStudent();
        int temp = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i].length() > temp) {
                temp = arr[i].length();

            }
        }
        setLen(temp);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() < temp) {
                while (arr[i].length() < temp) {
                    arr[i] = arr[i].concat(" ");
                }
            }

        }
        super.setStudent(arr);

    }

}

class Course extends Account {

    Course(String c[], int u[]) {
        setCourse(c);
        setUnit(u);
    }

    void print() {
        updatedCourse();

        String n = "Name";
        int t = getLen();

        while (n.length() < t + 3) {
            n = n.concat(" ");
        }
        System.out.print("|" + n + "|\n");
        for (int i = 0; i < getCourse().length; i++) {
            System.out.print(getCourse()[i] + "    |");
            System.out.println();
        }
    }

    void updatedCourse() {
        String arr[] = getCourse();
        int temp = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i].length() > temp) {
                temp = arr[i].length();

            }
        }
        setCourseStrLen(temp);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() < temp) {
                while (arr[i].length() < temp) {
                    arr[i] = arr[i].concat(" ");
                }
            }

        }
        super.setCourse(arr);
    }
}

abstract class AcademicPerformance {

    private static double grades[][];

    static void setGrades(double grade[][]) {
        grades = grade;
    }

    static double[][] getGrades() {
        return grades;
    }
}

class Grades extends AcademicPerformance {

    Grades(double grade[][]) {
        setGrades(grade);
    }

    public void addGrades(double gr1[]) {

        double cg[][] = getGrades();
        double gr[][] = new double[cg.length + 1][5];

        for (int i = 0; i < getGrades().length; i++) {
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

class Record extends AcademicPerformance {

    void print() {

        String s[] = Account.getCourse();
        int u[] = Account.getUnit();

        int t = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i].length() > t) {
                t = s[i].length();
            }
        }

        for (int i = 0; i < s.length; i++) {
            if (s[i].length() < t) {

                while (s[i].length() < t) {
                    s[i] += " ";
                }

            }
        }
        System.out.print("-----Enrolled Courses-----\n\n");
        System.out.println("================");
        System.out.println("|Courses |Units|");
        System.out.println("---------------- ");

        for (int i = 0; i < s.length; i++) {
            System.out.print("|" + s[i] + "|  " + u[i] + "  |");
            System.out.println();
        }
        System.out.println("================");

    }

    public void uXg(int idx) {
        double grades[][] = getGrades();
        String courses[] = Account.getCourse();
        int len = Account.getCourseStrLen();
        int unit[] = Account.getUnit();
        System.out.println();

        double temp[] = new double[5];

        String g[] = {
                "Course  ",
                "Grades",
                "Units",
                "Unit x Grades"
        };

        String h = "Grades";
        String j = "Units";
        String x = "Unit x Grades";

        System.out.print("====================================\n|");
        for (int i = 0; i < g.length; i++) {
            System.out.print(g[i] + "|");
        }
        System.out.println("\n------------------------------------");

        for (int i = 0; i < courses.length; i++) {

            double t = unit[i] * grades[idx][i];

            String str = Double.toString(grades[idx][i]);
            String strU = Integer.toString(unit[i]);
            String strX = Double.toString(t);
            String u = padS(strU, g[1].length());
            String s = padS(str, g[2].length());
            String k = padS(strX, g[3].length());

            temp[i] = t;

            System.out.print("|" + courses[i] + "|" + s + "|" + u + "|" + k + "|");
            System.out.println();
        }
        System.out.println("====================================");

        gwa(temp, unit);

    }

    public String padS(String str, int len) {

        String s = str;

        while (s.length() < len) {
            s += " ";
        }
        return s;
    }

    public void gwa(double d[], int unit[]) {

        double temp = 0;
        int n = 0;

        for (int i = 0; i < d.length; i++) {
            temp += d[i];
            n += unit[i];
        }
        System.out.println("General Weight Average -> " + temp / n);

    }
}

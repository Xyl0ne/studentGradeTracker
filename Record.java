package StudentGrade;

public class Record extends AcademicPerformance {

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

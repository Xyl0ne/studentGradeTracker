package StudentGrade;

public class Course extends Account {
    
    Course(String c[], int u[]){
        setCourse(c);
        setUnit(u);
    }

    void print(){
        updatedCourse();
        
        String n ="Name";
        int t = getLen();

        while(n.length() < t+3){
           n = n.concat(" ");
        }
        System.out.print("|" + n+"|\n");
        for(int i =0; i< getCourse().length; i++){
            System.out.print(getCourse()[i]+"    |");
            System.out.println();
        }
    }

    void updatedCourse(){
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

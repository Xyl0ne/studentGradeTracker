package StudentGrade;

public class Student extends Account{
    
    

    Student(String s[]){
        this.setStudent(s);
    }
/*------------------------------------------------------------ */  
    public void print(){
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
        for(int i =0; i< studenGrades.length; i++){
            System.out.print("|" + "[" + i + "]" + arr[i] + "|");
            for(int j =0; j<studenGrades[i].length; j++){
                String str =pad(studenGrades[i][j], j);
                System.out.print(str+"|");
            }                      
            
            System.out.println();
        }
        System.out.println("==================================================================");
        System.out.println("\n[e]edit\n[x]exit");
    }

    public String pad(double n, int j){
        String s = Double.toString(n);

        
        String[] courseArray = getCourse();
         
        String name = courseArray[j];
        while (s.length() < name.length()) {
            s += " ";
        }
        return s;
    }

    
    public void studentList(){
        System.out.println();
        for(int i = 0 ; i <getStudent().length;i++){
            System.out.print("[" + i +"]" + getStudent()[i]);
            System.out.println();
        }
    }
/*------------------------------------------------------------- */
    public void addStudent(String add){
        String temp[] = new String[getStudent().length+1];

        for(int i = 0; i< getStudent().length ; i++){
            temp[i] = getStudent()[i];
        }
        temp[temp.length-1] = add;

        super.setStudent(temp);
        System.out.println();
        
    }

/*------------------------------------------------------------- */
    public void len(){

        String arr[] = getStudent();
        int temp = 0;

        for(int i = 0; i < arr.length; i++){

            if(arr[i].length() > temp){
                temp = arr[i].length();
                
            }
        }
        setLen(temp);

        for(int i = 0; i< arr.length;i++){
            if(arr[i].length() < temp){
                while (arr[i].length() < temp) {
                    arr[i] = arr[i].concat(" ");
                }
            }
            
        }
        super.setStudent(arr);
        
    }
   
    
}

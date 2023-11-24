public class User {
    private String id;
    private String name;
    private double salary;
    private String jobPos;

    public User(String id, String name){
        this.id = id;
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public void setJobPos(String jobPos){
        this.jobPos = jobPos;
    }

    public void displayEmployee(){
        System.out.println("_________________________________");
        System.out.println("\nID = " + this.id);
        System.out.println("Name = " + this.name);
        System.out.println("Salary = " + this.salary);
        System.out.println("Job position = " + this.jobPos);
        System.out.println("_________________________________");
    }
}

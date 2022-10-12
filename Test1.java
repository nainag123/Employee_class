import java.util.Scanner;
import java.util.Date;
class Employee
{
    private static int access_pass=9897;
    private static String company_name="Naina's Restaurant";
    private static int num_of_employees=0;
    private static String office_mail="naina.worker.ac.in";
    Scanner sc = new Scanner(System.in);
    int emp_id,emp_age;
    double emp_salary;
    String emp_name,emp_address,emp_gender,emp_mailid;
    Boolean full_time;
    Date date_of_joining=new Date();
    Employee(String name,String gender,int age,String address,boolean full_time_,double salary)
    {
        Employee.num_of_employees++;
        emp_name=name;
        emp_id=5000+num_of_employees;
        emp_mailid=emp_id+emp_name+"@"+office_mail;
        emp_age=age;
        emp_salary=salary;
        emp_address=address;
        emp_gender=gender;
        full_time=full_time_;
    }
    Employee change_details(String name)//Method Overloading
    {
        emp_name=name;
        return this;
    }
    Employee change_details(Boolean full_time_)//Method Overloading 
    {
        full_time=full_time_;
        return this;
    }
    Employee change_details(float salary)//Method Overloading 
    {
        emp_salary=salary;
        return this;
    }
    static void change_office_mail(int pass,String mail)
    {
        if(pass==access_pass)
        {
            Employee.office_mail=mail;
            System.out.println("Successfully Changed");
        }        
        else 
            System.out.println("Wrong pass");
    }
    static void change_comp_name(int pass,String name)
    {
        if(pass==access_pass)
        {
            Employee.company_name=name;
            System.out.println("Successfully Changed");
        }        
        else 
            System.out.println("Wrong pass");
    }
    static String access_company_name()
    {
        String comp_name=Employee.company_name;
        return comp_name;
    }
    static String access_office_mail()
    {
        String mail=Employee.office_mail;
        return mail;
    }
    public void disp(){
        System.out.println("Id : "+emp_id);
        System.out.println("Name : "+emp_name);
        System.out.println("Mail ID : "+emp_mailid);
        System.out.println("Gender : "+emp_gender);
        System.out.println("Age : "+emp_age);
        System.out.println("Salary : "+emp_salary);
        System.out.println("Date of Joining : "+date_of_joining);
        if(full_time)
            System.out.println("Full Time Employee");
        else
            System.out.println("Part Time Employee");
    }
    public static void disp_total_emp()
    {
        System.out.println("Total Employees in the Company: "+num_of_employees);
    }
}   
class Manager extends Employee{
    static int num_of_managers=0;
    static double increment_rate=10;
    String post;
    Manager(String name,String gender,int age,double salary,String address,boolean full_time_,String post_){
        super(name,gender,age,address,full_time_,salary);
        num_of_managers++;
        post=post_;
    }
    public static void set_increment_rate(int increment_rate_){
        increment_rate=increment_rate_;
    }
    public void disp(){                     //method overriding
        super.disp();
        System.out.println("Increment Rate: "+increment_rate);
    }
    public void increment_salary(){
        emp_salary=(emp_salary+(emp_salary*(increment_rate/100.0)));
    }
}
public class Test1{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Manager M[] = new Manager[10];
        int ch=0;
        do
        {
            System.out.println("Enter 1 for Manager");
            System.out.println("Enter 2 To check and change Company Defaults.");
            System.out.println("Enter 3 to exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();
            sc.nextLine();
            switch(ch)
            {
                case 1:
                {
                    int ch1=0;
                    do
                    {
                        System.out.println("enter 1 to create Manager ");
                        System.out.println("enter 2 to display details");
                        System.out.println("enter 3 to change the increment rate");
                        System.out.println("enter 4 to increase the salary");
                        System.out.println("enter 5 to Change Details");
                        System.out.println("Enter 6 to go back");
                        System.out.print("enter choice :");
                        ch1=sc.nextInt();
                        sc.nextLine();
                        switch(ch1)
                        {
                            case 1:
                            {
                                sc = new Scanner(System.in);
                                System.out.print("enter name :");
                                String name_= sc.nextLine();
                                System.out.print("enter gender :");
                                String gender_= sc.nextLine();
                                System.out.print("enter address:");
                                String address_=sc.nextLine();
                                System.out.print("Enter Post: ");
                                String post_=sc.nextLine();
                                System.out.print("Enter age :");
                                int age_=sc.nextInt();
                                System.out.print("Enter salary :");
                                int salary_= sc.nextInt();                                
                                System.out.print("enter true for full time else false: ");
                                Boolean Time_=sc.nextBoolean();
                                M[Manager.num_of_managers]=new Manager(name_, gender_, age_, salary_, address_, Time_, post_);
                                break;
                            }
                            case 2:
                            {
                                if(Manager.num_of_managers!=0)
                                {
                                    for(int i=0; i<Manager.num_of_managers;i++)
                                       System.out.println("Enter "+i+" For "+M[i].emp_name);
                                    System.out.print("Enter Choice : ");
                                    int manager_choice = sc.nextInt();
                                    M[manager_choice].disp();
                                }
                                else
                                    System.out.println("No manager Exists");
                                break;
                            }
                            case 3:
                            {
                                System.out.print("enter the increment rate: ");
                                int increment_rate_ = sc.nextInt();
                                Manager.set_increment_rate(increment_rate_);
                                break;
                            }
                            case 4:
                            {
                                if(Manager.num_of_managers!=0)
                                {
                                for(int i=0; i<Manager.num_of_managers;i++)
                                {
                                    System.out.println("enter"  +i+" For "+M[i].emp_name);
                                }
                                System.out.println("enter choice :");
                                int manager_choice = sc.nextInt();
                                M[manager_choice].increment_salary();
                                System.out.println("Increased salary is :"+M[manager_choice].emp_salary);
                                }
                                else
                                {
                                    System.out.println("no manager exist");
                                }

                                break;
                            }
                            case 5:
                            {
                                if(Manager.num_of_managers!=0)
                                {
                                int change_choice=0;
                                do{
                                    System.out.println("enter 1 to Change Name");
                                    System.out.println("enter 2 to Change Salary");
                                    System.out.println("enter 3 to Change Full Time");
                                    System.out.println("enter 4 to Change All Details");
                                    System.out.println("enter 5 to go back");
                                    System.out.println("enter choice :");
                                    change_choice=sc.nextInt();
                                    sc.nextLine();
                                    switch(change_choice)
                                    {
                                        case 1:
                                        {
                                            for(int i=0; i<Manager.num_of_managers;i++)
                                            {
                                                System.out.println(i+" For "+M[i].emp_name);
                                            }
                                            System.out.println("enter choice :");
                                            int manager_choice = sc.nextInt();
                                            sc.nextLine();
                                            System.out.println("enter Name :");
                                            String name = sc.nextLine();
                                            M[manager_choice].change_details(name);
                                            break;
                                        }
                                        case 2:
                                        {
                                            for(int i=0; i<Manager.num_of_managers;i++)
                                            {
                                                System.out.println(i+" For "+M[i].emp_name);
                                            }
                                            System.out.println("enter choice :");
                                            int manager_choice = sc.nextInt();
                                            System.out.println("enter Salary :");
                                            int Salary = sc.nextInt();
                                            M[manager_choice].change_details(Salary);
                                            break;
                                        }
                                        case 3:
                                        {
                                            for(int i=0; i<Manager.num_of_managers;i++)
                                            {
                                                System.out.println("enter" +i+" For "+M[i].emp_name);
                                            }
                                            System.out.println("enter choice :");
                                            int manager_choice = sc.nextInt();
                                            System.out.println("enter Full Time :");
                                            Boolean full_time_ = sc.nextBoolean();
                                            M[manager_choice].change_details(full_time_);
                                            break;
                                        }
                                        case 4:
                                        {
                                            for(int i=0; i<Manager.num_of_managers;i++)
                                            {
                                                System.out.println(i+" For "+M[i].emp_name);
                                            }
                                            System.out.println("enter choice :");
                                            int manager_choice = sc.nextInt();
                                            sc.nextLine();
                                            System.out.println("enter Name :");
                                            String name = sc.nextLine();
                                            System.out.println("enter Full Time :");
                                            Boolean full_time_ = sc.nextBoolean();
                                            System.out.println("enter Salary :");
                                            int Salary = sc.nextInt();
                                            M[manager_choice].change_details(name).change_details(full_time_).change_details(Salary);
                                            break;
                                        }
                                        case 5:
                                        {
                                            System.out.println("Going Back");
                                            break;
                                        }
                                    }
                                }while(change_choice!=5);
                                break;
                            }
                            else
                            {
                                System.out.println("No Manager Exist.");
                            }
                            }
                        
                            case 6:
                            {
                                System.out.println("Exiting ");
                                break;
                            }
                        }
                    }while(ch1!=6);
                break;
                }
                case 2:
                {
                    int ch2=0;
                    do{
                        System.out.println("Enter 1 to change Office Mail.");
                        System.out.println("Enter 2 to change company name.");
                        System.out.println("Enter 3 to Display Current Details.");
                        System.out.println("Enter 4 to Go back.");
                        System.out.print("Enter Choice: ");
                        ch2=sc.nextInt();
                        sc.nextLine();
                        switch(ch2)
                        {
                            case 1:
                            {
                                System.out.println("Current Mail: "+Employee.access_office_mail());
                                System.out.print("Enter New Mail: ");
                                String new_mail=sc.nextLine();
                                System.out.print("Enter pass: ");
                                int pass=sc.nextInt();
                                Employee.change_office_mail(pass,new_mail);
                                break;
                            }
                            case 2:
                            {
                                System.out.println("Current Company Name: "+Employee.access_company_name());
                                System.out.print("Enter New Name: ");
                                String new_name=sc.nextLine();
                                System.out.println("Enter pass: ");
                                int pass=sc.nextInt();
                                Employee.change_comp_name(pass,new_name);
                                break;
                            }
                            case 3:
                            {
                                System.out.println("Company Name: "+Employee.access_company_name());
                                System.out.println("Company Mail: "+Employee.access_office_mail());
                                Employee.disp_total_emp();
                                break;
                            }
                            case 4:
                            {
                                System.out.println("Exiting ");
                                break;
                            }
                            default:
                            {
                                System.out.println("Incorrect Choice");
                            }
                        }
                    }while(ch2!=4);
                }

            }
        }while(ch!=3);
    }
}
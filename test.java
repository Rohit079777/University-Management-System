import java.util.Scanner;

//This Is a Login class (1)
class Login {
    String un;
    int pass;
    Scanner s1;

    //This Is a Constructor of Login class
    public Login(Scanner s1) {
        this.s1 = s1;
    }

    //This Is a admin method or function
    public void admin() {
        System.out.print("Enter Admin Username:-- ");
        un = s1.next();

        System.out.print("Enter Admin Password:-- ");
        pass = s1.nextInt();
    }

    //This Is a student method 
    public void student() {
        System.out.print("Enter Student Username:-- ");
        un = s1.next();

        System.out.print("Enter Student Password:-- ");
        pass = s1.nextInt();
    }

    //This Is a validate method
    public void validate() {
        if (un.equals("admin") && (pass == 1234)) {
            Menu m = new Menu(s1);
            m.adminMenuDetail();
        } else if (un.equals("student") && pass == 1202) {
            Menu m = new Menu(s1);
            m.studentMenuDetail();
        } else {
            System.out.println("Login Username and Password Incorrect");
        }
    }

    //This Is a loginPage method part-1
    public void loginPage() {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("|                    Welcome to the Login Page                       |");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("1. Admin Login");
        System.out.println("2. Student Login");
        System.out.print("Choose your login type (1 or 2): ");
        int choice = s1.nextInt();
        s1.nextLine();

        //This Is a loginPage method part-2
        switch (choice) {
            case 1:
                admin();
                validate();
                break;
            case 2:
                student();
                validate();
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }
}

//This Is a Menu class (2)
class Menu {
    Scanner s1;
    String[] courses = {"BCA", "MCA", "JAVA", "DotNet", "C", "C++"};
    String[] courseDetails = {
        "BCA Course: Bachelor of Computer Applications.\n" +
        "Duration:       3 years.\n" +
        "Fees:           $3000.\n" +
        "Description:    A 3-year undergraduate program focusing on computer applications and software development.",

        "MCA Course: Master of Computer Applications.\n" +
        "Duration:       3 years.\n" +
        "Fees:           $4000.\n" +
        "Description:    A 3-year postgraduate program focusing on advanced computer science and applications.",

        "JAVA Course: Java Programming Language.\n" +
        "Duration:       6 months.\n" +
        "Fees:           $1000.\n" +
        "Description:    A comprehensive course covering basic to advanced topics in Java programming.",

        "DotNet Course: Microsoft .NET Framework.\n" +
        "Duration:       6 months.\n" +
        "Fees:           $1200.\n" +
        "Description:    Focuses on building web and desktop applications using the .NET framework.",

        "C Course: C Programming Language.\n" +
        "Duration:       2 months.\n" +
        "Fees:           $500.\n" +
        "Description:    An introductory course covering fundamentals and data structures in C programming.",

        "C++ Course: C++ Programming Language.\n" +
        "Duration:       2 months.\n" +
        "Fees:           $600.\n" +
        "Description:    An advanced programming course covering object-oriented programming and data structures."
    };

    //This Is a Constructor of Menu class
    public Menu(Scanner s1) {
        this.s1 = s1;
    }

    //This Is a adminMenuDetail method part-1
    public void adminMenuDetail() {
        boolean exit = false;
        while (!exit) {
            System.out.println("************* Admin Menu *************");
            System.out.println("1... Course Detail");
            System.out.println("2... Show Record");
            System.out.println("3... Update Record");
            System.out.println("4... Delete Record");
            System.out.println("5... Log Out");
            System.out.println("6... Exit");
            System.out.print("Choose an option: ");
            int choice = s1.nextInt();
            s1.nextLine(); // newline

            //This Is a adminMenuDetail method part-2
            switch (choice) {
                case 1:
                    showCourseDetails();
                    enrollStudent(); // Call the enrollment method after showing course details
                    break;
                case 2:
                    showRecord();
                    break;
                case 3:
                    System.out.println("Updating record...");
                    break;
                case 4:
                    System.out.println("Deleting record...");
                    break;
                case 5:
                    System.out.println("Logging out...");
                    exit = true;
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    //This Is a studentMenuDetail method
    public void studentMenuDetail() {
        boolean exit = false;
        while (!exit) {
            System.out.println("************* Student Menu *************");
            System.out.println("1... View Courses");
            System.out.println("2... Show Record");
            System.out.println("3... Log Out");
            System.out.println("4... Exit");
            System.out.print("Choose an option: ");
            int choice = s1.nextInt();
            s1.nextLine();

            switch (choice) {
                case 1:
                    showCourseDetails();
                    break;
                case 2:
                    showRecord();
                    break;
                case 3:
                    System.out.println("Logging out...");
                    exit = true;
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    //This Is a showCourseDetails method
    public void showCourseDetails() {
        System.out.println("\n------------------- Available Courses -------------------");
        for (int i = 0; i < courses.length; i++) {
            System.out.println((i + 1) + "... " + courses[i]);
        }
        System.out.print("Select a course to see details (1-6): ");
        int choice = s1.nextInt();
        s1.nextLine();

        if (choice >= 1 && choice <= courses.length) {
            System.out.println("\n=================== Course Details ===================="); 
            System.out.println(courseDetails[choice - 1]);
            System.out.println("========================================================\n");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    //This Is a enrollStudent method
    public void enrollStudent() {
        System.out.print("Enroll a student in this course now? (yes/no): ");
        String response = s1.nextLine();

        if (response.equalsIgnoreCase("yes")) {
            System.out.print("Enter Full Name: ");
            String fullName = s1.nextLine();
            System.out.print("Enter Address: ");
            String address = s1.nextLine();
            System.out.print("Enter Email: ");
            String email = s1.nextLine();
            System.out.print("Enter Phone Number: ");
            String phone = s1.nextLine();

            System.out.println("\n================= !!!Thanks For Enrollment!!! =================");
            System.out.println("================= Your Enrollment Details =================");
            System.out.println("| Name    : " + fullName);
            System.out.println("| Address : " + address);
            System.out.println("| Email   : " + email);
            System.out.println("| Phone   : " + phone);
            System.out.println("======================================================\n");
        } else {
            System.out.println("Enrollment canceled.");
        }
    }

    public void showRecord() {
        System.out.println("Displaying records...");
    }
}

public class test {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        Login obj = new Login(s1);
        obj.loginPage(); // Show the login page
    }
}

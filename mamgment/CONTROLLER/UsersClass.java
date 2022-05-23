package mamgment.CONTROLLER;

import mamgment.MODEL.UserDataBaseManager;
import java.util.*;

public class UsersClass {

    Scanner input = new Scanner(System.in);
    public static String Fname;
    public static String Lname;
    public static String email;
    public static String typee;
    public static int id;
    public static int grade;
    public static int c_id;

    UsersInput inputData = new UsersInput();
    private final UserDataBaseManager UsersDB;

    public UsersClass(UserDataBaseManager UsersDB) {
        this.UsersDB = UsersDB;
        this.UsersDB.UserConnectDB();
    }

    public void StudentInsert() {

        this.UsersDB.insertStudent_ToDatabase(Fname, Lname, email, c_id);

    }

    public void TeacherInsert() {
   
        this.UsersDB.insertTeacher_ToDatabase(Fname, Lname, email, c_id);

    }

    public void studentsearch() {
    
        this.UsersDB.returnStudentSearchResult_FromDatabase(id, Fname, Lname, email, c_id, grade);

    }

    public void teachersearch() {
      
        this.UsersDB.returnTeacherSearchResult_FromDatabase(id, Fname, Lname, email, c_id);

    }

    public void update_st() {
  
        this.UsersDB.UpdateStudent_Database(id, Fname, Lname, email, c_id, grade);

    }

    public void update_te() {

        this.UsersDB.Updateteacher_Database(id, Fname, Lname, email, c_id);

    }

    public void deletestudentsall() {
        this.UsersDB.deletestudentsall();

    }

    public void deleteteachersall() {
        this.UsersDB.deleteteachersall();

    }

    public void deletestudentbyid() {
        this.UsersDB.deletestudentbyid(id);

    }

    public void deleteteacherbyid() {
        this.UsersDB.deleteteacherbyid(id);

    }

    public void insertprivrlligestudent() {
        c_id = input.nextInt();
        typee = "Student";
        this.UsersDB.insertprivrlligestudent(id, c_id, typee);

    }

    public void insertprivrlligeteacher() {
        c_id = input.nextInt();
        typee = "teacher";
        this.UsersDB.insertprivrlligeteacher(id, c_id, typee);

    }

    public void deleteprivilege() {
        this.UsersDB.deleteprivilege();

    }

    public void blockaccessstudent() {
        this.UsersDB.blockaccessstudent(id, typee);

    }

    public void blockaccessteacher() {

        this.UsersDB.blockaccessteacher(id, typee);

    }

}

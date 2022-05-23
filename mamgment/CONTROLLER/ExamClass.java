package mamgment.CONTROLLER;

import mamgment.MODEL.ExamDataBaseManager;

public class ExamClass {

    public static int C_ID;
    public static int num_done;
    public static int num_Exam;
    public static int total;
    public static String choice;
    public static int Deletechoice;
    public static int Updatechoice;

    ExamInput inputData = new ExamInput();
    private ExamDataBaseManager ExamDB;

    public ExamClass(ExamDataBaseManager ExamDB) {
        this.ExamDB = ExamDB;
        this.ExamDB.ExamConnectDB();
    }

    public int correct(String Name, int id) {
        num_done++;
        choice = inputData.InputAnswer();
        char[] answers = new char[4];
        for (int i = 0; i < 4; i++) {
            char x = Character.toUpperCase(choice.charAt(0));
            answers[i] = x;
        }
        char[] keys = {'A', 'B', 'b', 'a'};
        int grade = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == keys[i]) {
                grade++;
            }
        }
        System.out.println("your grade is " + grade);
        state(grade, total);
        return grade;
    }

    public void state(int grade, int total) {
        if (grade == total) {
            System.out.println("\ncongratulation you get A");
        } else if (grade < total && grade > total / 1.5) {
            System.out.println("\nyou get B");
        } else if (grade < total && grade > total / 2) {
            System.out.println("\nyou get C");
        } else {
            System.out.println("\nyou get D");
        }
    }

    public void insertExam() {

        this.ExamDB.insertExam_ToDatabase(C_ID, num_done, num_Exam, total);

    }

    public void ExamSearch() {
        this.ExamDB.returnSearchResult_FromDatabase(C_ID, num_done, num_Exam, total);
    }

    public void ExamUpdate() {
        ExamSearch();
        do {

            Updatechoice = inputData.InputUpdateOptions();
            switch (Updatechoice) {
                case 1:
                    updateByNumOfStudentTested();
                    break;
                case 2:
                    updateBynum_Exam();
                    break;
                case 3:
                    updateBytotal();
                    break;
                case 4:
                    updateAll();
                    break;
                default:
                    System.out.println("Invalid value");
            }
        } while (Updatechoice != 4);

    }

    public void updateByNumOfStudentTested() {
        this.ExamDB.updateByNumOfStudentTestedQuery(C_ID, num_done);

    }

    public void updateBynum_Exam() {
        this.ExamDB.updateBynum_ExamQuery(C_ID, num_Exam);

    }

    public void updateBytotal() {
        this.ExamDB.updateBytotalQuery(C_ID, total);

    }

    public void updateAll() {

        this.ExamDB.UpdateAllQuery_Database(C_ID, num_done, num_Exam, total);
    }

    public void ExamDelete() {
        do {
            Updatechoice = inputData.InputDeleteOptions();
            switch (Deletechoice) {
                case 1:
                    this.ExamDB.deleteAll();
                    break;
                case 2:
                    ExamSearch();
                    this.ExamDB.deleteById(C_ID);
                    break;
                default:
                    System.out.println("Invalid value");
            }
        } while (Updatechoice != 2);

    }

}

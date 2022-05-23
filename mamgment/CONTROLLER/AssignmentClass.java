package mamgment.CONTROLLER;

import mamgment.MODEL.AssignmentDatabaseManager;

public class AssignmentClass {

    public static String OldName;
    public static String AssignmentName;
    public static String AssignmentDate;
    public static String AssignmentType;
    public static int CourseId;
    public static int Deletechoice;
    public static int Updatechoice;

    AssignmentInput input = new AssignmentInput();

    private AssignmentDatabaseManager AssignmentDB;

    public AssignmentClass(AssignmentDatabaseManager AssignmentDB) {
        this.AssignmentDB = AssignmentDB;
        this.AssignmentDB.AssignmentConnectDB();
    }

    public void AssignmentsShowAll() {
        this.AssignmentDB.ShowAllAssignments();
    }

    public void AssignmentInsert() {

        this.AssignmentDB.insertAssignment_ToDatabase(CourseId, AssignmentName, AssignmentDate, AssignmentType);
    }

    public void AssignmentSearch() {

        this.AssignmentDB.returnSearchResult_FromDatabase(AssignmentName);
    }

    public void AssignmentDelete() {
        Deletechoice = input.InputDeleteOptions();

        switch (Deletechoice) {
            case 1:
                this.AssignmentDB.deleteAll();
                break;
            case 2:
                AssignmentSearch();
                this.AssignmentDB.deleteByName();
                break;
            default:
                System.out.println("invalid choice");
        }
    }

    public void AssignmentUpdate() {

        AssignmentSearch();

        do {

            Updatechoice = input.InputUpdateOptions();

            switch (Updatechoice) {
                case 1:
                    updateAssignmentAll();
                    break;
                case 2:
                    updateAssignmentName();
                    break;
                case 3:
                    updateAssignmentDate();
                    break;
                case 4:
                    updateAssignmentType();
                    break;
                case 5:
                    System.out.println("Assignment Data Updated");
                    break;
                default:
                    System.out.println("invalid value");
            }
        } while (Updatechoice != 5);
    }

    public void updateAssignmentAll() {
        this.AssignmentDB.UpdateAllQuery_Database(OldName, AssignmentName, AssignmentDate, AssignmentType);
    }

    public void updateAssignmentName() {
        this.AssignmentDB.UpdateNameQuery_Database(OldName, AssignmentName);
    }

    public void updateAssignmentDate() {
        this.AssignmentDB.UpdateAssignmentDateQuery_Database(OldName, AssignmentDate);
    }

    public void updateAssignmentType() {
        this.AssignmentDB.UpdateTypeQuery_Database(OldName, AssignmentType);
    }

}

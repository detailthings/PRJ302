package model;

public class MemberOfProject{
    String UserID;
    String Major;
    String GroupName;
    String ProjectID;

    public MemberOfProject() {
    }

    public MemberOfProject(String UserID, String Major, String GroupName, String ProjectID) {
        this.UserID = UserID;
        this.Major = Major;
        this.GroupName = GroupName;
        this.ProjectID = ProjectID;
    }

    public String getUserID() {
        return UserID;
    }

    public String getMajor() {
        return Major;
    }

    public String getGroupName() {
        return GroupName;
    }

    public String getProjectID() {
        return ProjectID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public void setMajor(String Major) {
        this.Major = Major;
    }

    public void setGroupName(String GroupName) {
        this.GroupName = GroupName;
    }

    public void setProjectID(String ProjectID) {
        this.ProjectID = ProjectID;
    }
    
}
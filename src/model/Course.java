 package model;

public class Course {
    private int courseID;
    private String code;
    private String courseName;
    private int    sks;
    private int    semester;

    public Course(String code, String courseName, int sks, int semester) {
        this.code       = code;
        this.courseName = courseName;
        this.sks        = sks;
        this.semester   = semester;
    }

    @Override
    public String toString() {
        return this.courseName;
    }

    public String getCode() {
        return code;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getSKS() {
        return sks;
    }

    public int getSemester() {
        return semester;
    }
    public int getCourseID() {
    return courseID;
    }

    public void setCourseID(int courseID) {
    this.courseID = courseID;
    }
}
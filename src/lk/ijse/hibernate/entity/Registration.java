/**
 * Powered By : MINDARTLK.
 * version:0.1.0
 */
package lk.ijse.hibernate.entity;

public class Registration implements SuperEntity {
    private String studentId;
    private String programId;
    private String regDate;

    public Registration() {
    }

    public Registration(String studentId, String programId, String regDate) {
        this.studentId = studentId;
        this.programId = programId;
        this.regDate = regDate;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "studentId='" + studentId + '\'' +
                ", programId='" + programId + '\'' +
                ", regDate='" + regDate + '\'' +
                '}';
    }
}
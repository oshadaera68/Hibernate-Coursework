/**
 * Powered By : MINDARTLK.
 * version:0.1.0
 */
package lk.ijse.hibernate.dto;

import java.util.Objects;

public class RegistrationDTO {
    private int registrationId;
    private String studentId;
    private String programId;
    private String date;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String studentId, String programId, String date) {
        this.studentId = studentId;
        this.programId = programId;
        this.date = date;
    }

    public RegistrationDTO(int registrationId, String studentId, String programId, String date) {
        this.registrationId = registrationId;
        this.studentId = studentId;
        this.programId = programId;
        this.date = date;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationDTO that = (RegistrationDTO) o;
        return registrationId == that.registrationId && Objects.equals(studentId, that.studentId) && Objects.equals(programId, that.programId) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationId, studentId, programId, date);
    }

    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "registrationId=" + registrationId +
                ", studentId='" + studentId + '\'' +
                ", programId='" + programId + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

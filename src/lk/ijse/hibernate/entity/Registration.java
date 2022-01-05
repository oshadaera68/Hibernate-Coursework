/**
 * Powered By : MINDARTLK.
 * version:0.1.0
 */
package lk.ijse.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Registration implements SuperEntity {

    @Id
    private int registrationId;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Program program;
    private String regDate;

    public Registration(Student student, Program program, String date) {
    }

    public Registration(int registrationId, Student student, Program program, String regDate) {
        this.registrationId = registrationId;
        this.student = student;
        this.program = program;
        this.regDate = regDate;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registration that = (Registration) o;
        return registrationId == that.registrationId && Objects.equals(student, that.student) && Objects.equals(program, that.program) && Objects.equals(regDate, that.regDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationId, student, program, regDate);
    }

    @Override
    public String toString() {
        return "Registration{" +
                "registrationId=" + registrationId +
                ", student=" + student +
                ", program=" + program +
                ", regDate='" + regDate + '\'' +
                '}';
    }
}
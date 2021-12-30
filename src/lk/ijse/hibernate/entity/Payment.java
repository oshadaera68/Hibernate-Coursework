/**
 * Powered By : MINDARTLK.
 * version:0.1.0
 */
package lk.ijse.hibernate.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Payment implements SuperEntity {
    @Id
    private String pId;
    private String date;
    @ManyToOne
    @JoinColumn(name = "studentId", referencedColumnName = "id")
    private Student student;
    @OneToMany(mappedBy = "payment")
    private List<PaymentDetails> paymentDetails;

    public Payment() {
    }

    public Payment(String pId, String date, Student student, List<PaymentDetails> paymentDetails) {
        this.pId = pId;
        this.date = date;
        this.student = student;
        this.paymentDetails = paymentDetails;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<PaymentDetails> getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(List<PaymentDetails> paymentDetails) {
        this.paymentDetails = paymentDetails;
    }
}

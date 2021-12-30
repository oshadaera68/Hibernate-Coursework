/**
 * Powered By : MINDARTLK.
 * version:0.1.0
 */
package lk.ijse.hibernate.entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class PaymentDetails implements SuperEntity{
    String id;


    @ManyToOne
    @JoinColumn(name = "paymentId", referencedColumnName = "pId")
    private Payment payment;
}

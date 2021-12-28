/**
 * Powered By:MINDARTLK.
 * version:0.1.0
 */

package lk.ijse.hibernate.dto;

import lk.ijse.hibernate.entity.Program;

import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

public class StudentDTO {
    private String id;
    private String name;
    private String nic;
    private String email;
    private String address;
    private String contactNo;


    public StudentDTO(String id, String name, String nic, String email, String address, String contactNo) {
    }

    public StudentDTO(String id, String name, String nic, String email, String address, String contactNo, List<Program> programs) {
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.email = email;
        this.address = address;
        this.contactNo = contactNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

}
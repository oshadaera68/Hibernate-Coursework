package lk.ijse.hibernate.bo.custom.Impl;

import lk.ijse.hibernate.dto.StudentDTO;
import lk.ijse.hibernate.entity.Student;

import java.util.ArrayList;

public interface StudentBO extends SuperBO {
    boolean saveStudent(Student dto);

    boolean updateStudent(Student dto);

    boolean deleteCustomer(String id);

    ArrayList<StudentDTO> getAllStudents();
}

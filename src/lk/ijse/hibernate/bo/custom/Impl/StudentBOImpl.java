/**
 * Powered By:MINDARTLK.
 * version:0.1.0
 */

package lk.ijse.hibernate.bo.custom.Impl;

import lk.ijse.hibernate.dao.custom.Impl.DAOFactory;
import lk.ijse.hibernate.dao.custom.Impl.StudentDAO;
import lk.ijse.hibernate.dto.StudentDTO;
import lk.ijse.hibernate.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {
    private final StudentDAO stu = (StudentDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.STUDENT);

    @Override
    public boolean saveStudent(Student dto) {
        return stu.save(new Student(dto.getId(), dto.getName(), dto.getNic(), dto.getEmail(), dto.getAddress(), dto.getContactNo()));
    }

    @Override
    public boolean updateStudent(Student dto) {
        return stu.update(new Student(dto.getId(), dto.getName(), dto.getNic(), dto.getEmail(), dto.getAddress(), dto.getContactNo()));
    }

    @Override
    public boolean deleteCustomer(String id) {
        return stu.delete(id);
    }

    @Override
    public ArrayList<StudentDTO> getAllStudents() {
        List<Student> list = stu.findAll();
        ArrayList<StudentDTO> arrayList = new ArrayList<>();
        for (Student student : list) {
            arrayList.add(new StudentDTO(student.getId(),student.getName(),student.getNic(),student.getEmail(),student.getAddress(), student.getContactNo()));
        }
        return arrayList;
    }
}

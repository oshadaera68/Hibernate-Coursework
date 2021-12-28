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
    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.STUDENT);

    @Override
    public boolean saveStudent(Student dto) {
        return studentDAO.save(new Student(dto.getId(), dto.getName(), dto.getNic(), dto.getEmail(), dto.getAddress(), dto.getContactNo()));
    }

    @Override
    public boolean updateStudent(Student dto) {
        return studentDAO.update(new Student(dto.getId(), dto.getName(), dto.getNic(), dto.getEmail(), dto.getAddress(), dto.getContactNo()));
    }

    @Override
    public boolean deleteCustomer(String id) {
        return studentDAO.delete(id);
    }

    @Override
    public ArrayList<Student> getAllStudents() {
        List<Student> list = studentDAO.findAll();
        ArrayList<Student> arrayList = new ArrayList<>();
        for (Student student : list) {
            arrayList.add(new Student(student.getId(),student.getName(),student.getNic(),student.getEmail(),student.getAddress(), student.getContactNo()));
        }
        return arrayList;
    }

    public Student searchById(String studentId) {
        return studentDAO.get(studentId);
    }
}

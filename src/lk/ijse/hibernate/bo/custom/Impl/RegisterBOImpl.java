/**
 * Powered By : MINDARTLK.
 * version:0.1.0
 */
package lk.ijse.hibernate.bo.custom.Impl;

import lk.ijse.hibernate.dao.custom.Impl.DAOFactory;
import lk.ijse.hibernate.dao.custom.Impl.ProgramDAO;
import lk.ijse.hibernate.dao.custom.Impl.RegisterDAO;
import lk.ijse.hibernate.dao.custom.Impl.StudentDAO;
import lk.ijse.hibernate.dto.RegistrationDTO;
import lk.ijse.hibernate.entity.Program;
import lk.ijse.hibernate.entity.Registration;
import lk.ijse.hibernate.entity.Student;

public class RegisterBOImpl implements RegisterBO {
    private final RegisterDAO registerDAO = (RegisterDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.REGISTRATION);
    private final ProgramDAO programDAO = (ProgramDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.PROGRAM);
    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.STUDENT);

    public boolean saveReg(RegistrationDTO dto) {
        Student student = studentDAO.get(dto.getStudentId());
        Program program = programDAO.get(dto.getProgramId());
        return registerDAO.save(new Registration(student, program, dto.getDate()));
    }
}
/**
 * Powered By : MINDARTLK.
 * version:0.1.0
 */
package lk.ijse.hibernate.bo.custom.Impl;

import lk.ijse.hibernate.dao.custom.Impl.DAOFactory;
import lk.ijse.hibernate.dao.custom.Impl.RegisterDAO;
import lk.ijse.hibernate.entity.Registration;

public class RegisterBOImpl implements RegisterBO {
    private final RegisterDAO registerDAO = (RegisterDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.REGISTRATION);

    public boolean saveReg(Registration reg){
        return registerDAO.save(new Registration(reg.getRegistrationId(), reg.getStudent(), reg.getProgram(), reg.getRegDate()));
    }
}
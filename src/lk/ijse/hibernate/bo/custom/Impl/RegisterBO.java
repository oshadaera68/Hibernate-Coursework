package lk.ijse.hibernate.bo.custom.Impl;

import lk.ijse.hibernate.dto.RegistrationDTO;
import lk.ijse.hibernate.entity.Registration;

public interface RegisterBO extends SuperBO{
    boolean saveReg(RegistrationDTO reg);
}

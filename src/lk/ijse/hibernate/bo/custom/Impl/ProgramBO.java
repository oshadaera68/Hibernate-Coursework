package lk.ijse.hibernate.bo.custom.Impl;

import lk.ijse.hibernate.dto.ProgramDTO;
import lk.ijse.hibernate.entity.Program;

import java.util.ArrayList;

public interface ProgramBO extends SuperBO {
    boolean saveProgram(Program dto);

    boolean updateProgram(Program dto);

    boolean deleteProgram(String id);

    ArrayList<ProgramDTO> getAllPrograms();
}

package lk.ijse.hibernate.bo.custom.Impl;

import lk.ijse.hibernate.dto.ProgramDTO;

import java.util.ArrayList;

public interface ProgramBO extends SuperBO {
    boolean saveProgram(ProgramDTO dto);

    boolean updateProgram(ProgramDTO dto);

    boolean deleteProgram(String id);

    ArrayList<ProgramDTO> getAllPrograms();
}

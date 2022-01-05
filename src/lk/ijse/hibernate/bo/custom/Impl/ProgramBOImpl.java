/**
 * Powered By:MINDARTLK.
 * version:0.1.0
 */

package lk.ijse.hibernate.bo.custom.Impl;

import lk.ijse.hibernate.dao.custom.Impl.DAOFactory;
import lk.ijse.hibernate.dao.custom.Impl.ProgramDAO;
import lk.ijse.hibernate.entity.Program;

import java.util.ArrayList;
import java.util.List;

public class ProgramBOImpl implements ProgramBO {
    private final ProgramDAO programDAO = (ProgramDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.PROGRAM);

    @Override
    public boolean saveProgram(Program dto) {
        return programDAO.save(new Program(dto.getProgramId(), dto.getProgramName(), dto.getDuration(), dto.getFee()));
    }

    @Override
    public boolean updateProgram(Program dto) {
        return programDAO.update(new Program(dto.getProgramId(), dto.getProgramName(), dto.getDuration(), dto.getFee()));
    }

    @Override
    public boolean deleteProgram(String id) {
        return programDAO.delete(id);
    }

    @Override
    public ArrayList<Program> getAllPrograms() {
        List<Program> list = programDAO.findAll();
        ArrayList<Program> arrayList = new ArrayList<>();
        for (Program program : list) {
            arrayList.add(new Program(program.getProgramId(), program.getProgramName(), program.getDuration(), program.getFee()));
        }
        return arrayList;
    }

    public Program getProgram(String id) {
        return programDAO.get(id);
    }
}

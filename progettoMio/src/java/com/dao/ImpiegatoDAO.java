package java.com.dao;

import java.com.entities.DipartimentoEntity;
import java.com.entities.ImpiegatoEntity;
import java.util.List;

public interface ImpiegatoDAO {
    public List<ImpiegatoEntity> getAllImpiegati();
    public List<DipartimentoEntity> getAllDipartimenti();
    public void addEmployee(ImpiegatoEntity imp);
}
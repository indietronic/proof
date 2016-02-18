package java.com.services;

import java.com.entities.DipartimentoEntity;
import java.com.entities.ImpiegatoEntity;
import java.util.List;

public interface ImpiegatoManager {
	
	public List<ImpiegatoEntity> getAllImpiegati();
    public List<DipartimentoEntity> getAllDipartimenti();
    public void addEmployee(ImpiegatoEntity imp);

}

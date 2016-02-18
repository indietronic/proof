package java.com.services;

import java.com.dao.ImpiegatoDAO;
import java.com.entities.DipartimentoEntity;
import java.com.entities.ImpiegatoEntity;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpiegatoManagerImpl implements ImpiegatoManager{

	@Autowired
	ImpiegatoDAO impiegato;
	
	@Override
	public List<ImpiegatoEntity> getAllImpiegati() {
		return impiegato.getAllImpiegati();
	}

	@Override
	public List<DipartimentoEntity> getAllDipartimenti() {
		return impiegato.getAllDipartimenti();
	}

	@Override
	public void addEmployee(ImpiegatoEntity imp) {
		impiegato.addEmployee(imp);
	}

}

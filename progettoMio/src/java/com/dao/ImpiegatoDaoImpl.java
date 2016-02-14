package java.com.dao;

import java.com.entities.DipartimentoEntity;
import java.com.entities.ImpiegatoEntity;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ImpiegatoDaoImpl implements ImpiegatoDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<ImpiegatoEntity> getAllImpiegati() {
		List<ImpiegatoEntity> ie = entityManager.createQuery("Select a From ImpiegatoEntity a", ImpiegatoEntity.class).getResultList();
		return ie;
	}

	@Override
	public List<DipartimentoEntity> getAllDipartimenti() {
		List<DipartimentoEntity> de = entityManager.createQuery("Select a From DipartimentoEntity a", DipartimentoEntity.class).getResultList();
		return de;
	}

	public DipartimentoEntity getDipartimentoById(Integer id) 
    {
        return entityManager.find(DipartimentoEntity.class, id);
    }
	
	@Override
	public void addEmployee(ImpiegatoEntity imp) {
		imp.setDepartment(getDipartimentoById(imp.getId()));
	}

}

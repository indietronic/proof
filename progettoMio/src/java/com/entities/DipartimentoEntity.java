package java.com.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="department")
public class DipartimentoEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	
	@OneToMany(mappedBy="department", cascade=CascadeType.PERSIST)
	private List<ImpiegatoEntity> impiegati = new ArrayList<ImpiegatoEntity>();
		

	
	public DipartimentoEntity(){}
	
	public DipartimentoEntity(Integer id, String name){
		super();
		this.setId(id);
		this.setName(name);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
    public String toString() {
        return "DepartmentVO [id=" + id + ", name=" + name + "]";
    }
	
	
	
	

}

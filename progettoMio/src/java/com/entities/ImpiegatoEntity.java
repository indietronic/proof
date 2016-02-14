package java.com.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table (name="employee")
public class ImpiegatoEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    private Integer id;
     
    @NotEmpty
    private String firstName;
    private String lastName;
    private String email;

    @NotNull
    @ManyToOne
    private DipartimentoEntity department;

    
    public ImpiegatoEntity() {}
    
    public ImpiegatoEntity(String name, DipartimentoEntity department) {
        this.firstName = name;
        this.department = department;
    }
    
    @Override
    public String toString() {
        return "EmployeeVO [id=" + id + ", firstName=" + firstName
                + ", lastName=" + lastName + ", email=" + email
                + ", department=" + department + "]";
    }
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public DipartimentoEntity getDepartment() {
		return department;
	}

	public void setDepartment(DipartimentoEntity department) {
		this.department = department;
	}

	}

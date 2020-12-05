package aed.examen.hibernate.tablas;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author Ayoze Amaro
 *
 */
@Entity
@Table(name = "descomponente")
public class DesComponente {
	
	@Id
	@GeneratedValue(generator = "myForeign")
	@GenericGenerator(name = "myForeign", strategy = "foreign",
	parameters = {@org.hibernate.annotations.Parameter(name = "property", value = "ComponenteXXX")})
	private Integer codComponente;

	@Column(columnDefinition = "varchar(200)")
	private String descripcion;
	
	@OneToOne (cascade={CascadeType.PERSIST,CascadeType.REFRESH}, fetch=FetchType.EAGER)
	@PrimaryKeyJoinColumn
	private Componentes ComponenteXXX;

	public DesComponente() { 
		super();
	}

	public DesComponente(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public Integer getCodComponente() {
		return codComponente;
	}

	public void setCodComponente(Integer codComponente) {
		this.codComponente = codComponente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Componentes getComponenteXXX() {
		return ComponenteXXX;
	}

	public void setComponenteXXX(Componentes componenteXXX) {
		ComponenteXXX = componenteXXX;
	}

	@Override
	public String toString() {
		return  descripcion;
	}

}

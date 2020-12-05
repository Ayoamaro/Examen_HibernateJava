package aed.examen.hibernate.tablas;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * @author Ayoze Amaro
 *
 */
@Entity
@Table(name = "categorias")
public class Categorias {
	
	@Id
	@Column(columnDefinition = "char(7)")
	private String codCategoria;

	@Column(columnDefinition = "varchar(50)")
	private String nombre;

	@OneToMany(cascade={CascadeType.PERSIST,CascadeType.REFRESH}, fetch=FetchType.LAZY, mappedBy="categoriasXXX")
	private List<Componentes> componentes = new ArrayList<Componentes>();

	public Categorias() { 
		super();
	}

	public Categorias(String codCategoria, String nombre) {
		super();
		this.codCategoria = codCategoria;
		this.nombre = nombre;
	}

	public String getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(String codCategoria) {
		this.codCategoria = codCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Componentes> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<Componentes> componentes) {
		this.componentes = componentes;
	}

	@Override
	public String toString() {
		return  codCategoria + " - " + nombre;
	}
}

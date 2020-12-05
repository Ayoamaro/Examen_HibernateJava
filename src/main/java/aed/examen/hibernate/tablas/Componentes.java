package aed.examen.hibernate.tablas;

import java.util.Date;
import javax.persistence.*;

/**
 * @author Ayoze Amaro
 *
 */
@Entity
@Table(name = "componentes")
public class Componentes {

	@Id
	@Column (columnDefinition= "integer")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer codComponente;
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.REFRESH}, fetch=FetchType.LAZY)
	@JoinColumn(name="codCategoria")
	private Categorias categoriasXXX;
	
	@Column (columnDefinition= "varchar(30)")
	private String nombre;

	@Column(columnDefinition = "int(11)")
	private int precio;
	
	@Column(columnDefinition = "date")
	private Date fecha;
	
	@Column (columnDefinition= "bit")
	private boolean activo;
	
	@OneToOne (cascade={CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn (name = "codComponente") 
	private DesComponente desComponenteXXX;

	public Componentes() { 
		super();
	}

	public Componentes(Categorias categoriasXXX, String nombre, Integer precio, Date fecha, boolean activo) {
		super();
		this.categoriasXXX = categoriasXXX;
		this.nombre = nombre;
		this.precio = precio;
		this.fecha = fecha;
		this.activo = activo;
	}

	public Integer getCodComponente() {
		return codComponente;
	}

	public void setCodComponente(Integer codComponente) {
		this.codComponente = codComponente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Categorias getCategoriasXXX() {
		return categoriasXXX;
	}

	public void setCategoriasXXX(Categorias categoriasXXX) {
		this.categoriasXXX = categoriasXXX;
	}

	public DesComponente getDesComponenteXXX() {
		return desComponenteXXX;
	}

	public void setDesComponenteXXX(DesComponente desComponenteXXX) {
		this.desComponenteXXX = desComponenteXXX;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "{" + getCodComponente() + "}:" + " " + getNombre() + " - " + getCategoriasXXX().getNombre() + " - " + getPrecio() + " - " + getFecha() + " - " + isActivo();
	}
}

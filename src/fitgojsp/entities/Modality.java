package fitgojsp.entities;
 
import java.io.Serializable;
import java.util.Date;
 
public class Modality implements Serializable {
	private static final long serialVersionUID = -309513637403441918L;
 
	private Long id;
 
	private String nome;
 
	public Modality() {}
 
	public Modality(Long id) {
		super();
		this.id = id;
	}
 
	public Modality(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
 
	public Long getMatricula() {
		return id;
	}
 
	public String getNome() {
		return nome;
	}
 
 
	public void setMatricula(Long id) {
		this.id = id;
	}
 
	public void setNome(String nome) {
		this.nome = nome;
	}
 
 
	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + "nome]";
	}
}
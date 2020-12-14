package fitgojsp.entities;
 
import java.io.Serializable;
import java.util.Date;
 
public class Student implements Serializable {
	private static final long serialVersionUID = -309513637403441918L;
 
	private Long matricula;
 
	private String nome;
 
	private String telefone;
 
	private String email;
  
	public Student() {}
 
	public Student(Long matricula) {
		super();
		this.matricula = matricula;
	}
 
	public Student(Long matricula, String nome) {
		super();
		this.matricula = matricula;
		this.nome = nome;
	}
 
	public String getEmail() {
		return email;
	}
 
	public Long getMatricula() {
		return matricula;
	}
 
	public String getNome() {
		return nome;
	}
 
	public String getTelefone() {
		return telefone;
	}
 
	public void setEmail(String email) {
		this.email = email;
	}
 
	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}
 
	public void setNome(String nome) {
		this.nome = nome;
	}
 
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
 
	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome
				+ ", telefone=" + telefone + ", email=" + "email ]";
	}
}
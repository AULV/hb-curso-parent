package mx.habil.curso.model.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import mx.habil.support.HabilDto;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="HB_USUARIO")
public class UsuarioDto extends HabilDto{
	private static final long serialVersionUID = 6988232371460296525L;

	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid2")
	@Column(name="ID_EVT", unique=true, length=37)
	private @Getter @Setter String id;
	
	@Column(name="CLAVE", unique=true, length=50)
	private @Getter @Setter String cveUsuario;
	
	@Column(name="NOMBRE", unique=false, length=100)
	private @Getter @Setter String nombre;
	
	@Column(name="APPATERNO", unique=false, length=100)
	private @Getter @Setter String apPaterno;
	
	@Column(name="APMATERNO", unique=false, length=100)
	private @Getter @Setter String apMaterno;
	
	@Column(name="ACTIVO")
	private @Getter @Setter Boolean activo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECREG", updatable=false)
	private @Getter @Setter Date fechaRegistro;
	
	@OneToMany(mappedBy="usuario")
	private @Getter @Setter List<EventoDto> eventos;
}

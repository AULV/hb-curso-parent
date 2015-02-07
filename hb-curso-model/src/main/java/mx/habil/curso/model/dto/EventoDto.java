package mx.habil.curso.model.dto;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import mx.habil.support.HabilDto;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="HB_EVENTO")
public class EventoDto extends HabilDto{
	private static final long serialVersionUID = 20150207001L;
	
	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid2")
	@Column(name="ID_EVT", unique=true, length=37)
	private @Getter @Setter String id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECEVT")	
	private @Getter @Setter Date fechaEvento;
	

	@Column(name="EVT", length=80)
	private @Getter @Setter String evento;
	
	@Column(name="CLASE", length=80)
	private @Getter @Setter String clase;
	
	@Column(name="SUBCLASE", length=80)
	private @Getter @Setter String subClase;
	
	@Lob 
	@Basic(fetch=FetchType.LAZY)
	@Column(name="COMENTARIOS")
	private @Getter @Setter String comentarios;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECREG", updatable=false)
	private @Getter @Setter Date fechaRegistro;
}

package mx.habil.curso.front.vo;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

public class UsuarioGuardarVo {
	@NotNull
	private @Getter @Setter String cveUsuario;
	
	@NotNull
	private @Getter @Setter String nombre;
	
	@NotNull
	private @Getter @Setter String apPaterno;
	
	@NotNull
	private @Getter @Setter String apMaterno;
	
	@NotNull
	private @Getter @Setter Boolean activo;
	
}	

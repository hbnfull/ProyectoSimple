package servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.boot.SpringApplication;

public class main {
	private final UsuarioRepository usuarioRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	
	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	}
	
	
	public Usuario getUsuario( Long id ) {
		return usuarioRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("El usuario con el id "
						+ id+"no existe")
				);
	}
	
	public Usuario deleteUsuario(Long id ) {
		Usuario userTmp=null;
		if (usuarioRepository.existsById(id)) {
			userTmp=usuarioRepository.findById(id).get();
			usuarioRepository.deleteById(id);
		}
		return userTmp;
	}

	public Usuario addUsuario(Usuario usuario) {
		Usuario tmp=null;
		if (usuarioRepository.findByCorreo(usuario.getCorreo()).isEmpty()) {
			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
			tmp=usuarioRepository.save(usuario);
		}
		return tmp;
	}


	public Usuario updateUsuario(Long id, ChangePassword changePassword) {
		Usuario tmp=null;
		if (usuarioRepository.existsById(id)) {
			if ((changePassword.getPassword()!=null) && (changePassword.getNewPassword()!=null)) {
				tmp=usuarioRepository.findById(id).get();
				if(passwordEncoder.matches(changePassword.getPassword(), tmp.getPassword())) {

					tmp.setPassword(passwordEncoder.encode(changePassword.getNewPassword()));
					usuarioRepository.save(tmp);
				}else {
					tmp=null;
				}
			}
		}else {
			System.out.println("Update - El usuario con id "+id+" no existe");
		}
		return tmp;
	}
	
	
	public boolean validateUsuario(Usuario usuario) {
		Optional<Usuario> userByEmail=usuarioRepository.findByCorreo(usuario.getCorreo());
		
		if (userByEmail.isPresent()) {
			Usuario user=userByEmail.get();
			//if (user.getPassword().equals(usuario.getPassword())) {
			if (passwordEncoder.matches(usuario.getPassword(), user.getPassword())) {	
			return true;
			}
			
		}
		return false;
	}
	
	public Usuario updateUsuarioOther(Long id, String rol,String foto,String telefono ) {
			Usuario tmp=null;
			if (usuarioRepository.existsById(id)) {
				tmp=usuarioRepository.findById(id).get();
				
				if (rol!=null)	tmp.setRol(rol);
				if (foto!=null) tmp.setFoto(foto);
				if (telefono!=null)	tmp.setTelefono(telefono);
				usuarioRepository.save(tmp);
			}else {
				System.out.println("Update - El usuario con id "+id+" no existe");
			}
		return tmp;
	}
			
	



}


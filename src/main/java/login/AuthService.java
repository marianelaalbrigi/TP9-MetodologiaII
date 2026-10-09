package login;
@SuppressWarnings("PMD.MethodArgumentCouldBeFinal")
public class AuthService {
  private final UsuarioRepositorio usuarioRepo;

  public AuthService(UsuarioRepositorio usuarioRepo) {
    this.usuarioRepo = usuarioRepo;
  }

  public Usuario login(String nombre, String clave) {
    if (nombre == null || nombre.isBlank()) {
      throw new IllegalArgumentException("Error de Autenticación: El nombre de usuario es     obligatorio");
    }

    if (clave == null || clave.isBlank()) {
      throw new IllegalArgumentException("Error de Autenticación: La contraseña es obligatoria.");
    }

    Usuario usuario = usuarioRepo.findByUsuario(nombre);

    if (usuario == null) {
      throw new IllegalArgumentException("Error de Autenticación: El usuario no existe.");
    }

    if (!usuario.getContrasenia().equals(clave)) {
      throw new IllegalArgumentException("Error de Autenticación: La contraseña no es válida.");
    }

    return usuario;
  }
}

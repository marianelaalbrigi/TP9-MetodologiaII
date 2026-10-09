package login;
@SuppressWarnings("PMD.MethodArgumentCouldBeFinal")
public class AuthService {
  private final UsuarioRepositorio usuarioRepo;

  public AuthService(UsuarioRepositorio usuarioRepo) {
    this.usuarioRepo = usuarioRepo;
  }

  public Usuario login(String nombre, String clave) {
    if (nombre != null) {
      if (!nombre.isBlank()) {
        if (clave != null) {
          if (!clave.isBlank()) {
            Usuario usuario = usuarioRepo.findByUsuario(nombre);
            if (usuario != null) {
              if (clave.equals(usuario.getContrasenia())) {
                return usuario;
              } else {
                throw new IllegalArgumentException("Clave incorrecta");
              }
            } else {
              throw new IllegalArgumentException("Error de autenticación: usuario no encontrado");
            }
          } else {
            throw new IllegalArgumentException("Error de autenticación: clave vacía");
          }
        } else {
          throw new IllegalArgumentException("Error de autenticación: clave nula");
        }
      } else {
        throw new IllegalArgumentException("Error de autenticación: nombre vacío");
      }
    } else {
      throw new IllegalArgumentException("Error de autenticación: nombre nulo");
    }
  }
}

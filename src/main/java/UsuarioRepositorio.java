import java.util.HashMap;
import java.util.Map;

public class UsuarioRepositorio {
  private final Map<String, Usuario> listaUsuarios = new HashMap<>();

  public UsuarioRepositorio() {
    listaUsuarios.put("admin", new Usuario("admin", "claveCorrecta"));
    listaUsuarios.put("Jorge Diaz", new Usuario("Jorge Diaz", "claveCorrecta"));
  }

  public Usuario findByUsuario(String nombreUsuario) {
    return listaUsuarios.get(nombreUsuario);
  }
}

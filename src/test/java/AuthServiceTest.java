import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuthServiceTest {

  private AuthService authService;

  @BeforeEach
  void setUp() {
    UsuarioRepositorio repositorio = new UsuarioRepositorio();
    authService = new AuthService(repositorio);
  }

  @Test
  void loginExitoso() {
    Usuario usuario = authService.login("admin", "claveCorrecta");
    assertEquals("admin", usuario.getNombreUsuario());
  }

  @Test
  void loginClaveInvalida() {
    assertThrows(
        IllegalArgumentException.class, () -> authService.login("admin", "claveIncorrecta"));
  }

  @Test
  void loginClaveVacia() {
    assertThrows(IllegalArgumentException.class, () -> authService.login("admin", ""));
  }

  @Test
  void loginClaveNull() {
    assertThrows(IllegalArgumentException.class, () -> authService.login("admin", null));
  }

  @Test
  void loginUsuarioNoRegistrado() {
    assertThrows(
        IllegalArgumentException.class, () -> authService.login("Roberto Diaz", "claveCorrecta"));
  }

  @Test
  void loginUsuarioVacio() {
    assertThrows(IllegalArgumentException.class, () -> authService.login("", "claveIncorrecta"));
  }

  @Test
  void loginUsuarioNull() {
    assertThrows(IllegalArgumentException.class, () -> authService.login(null, "claveCorrecta"));
  }
}

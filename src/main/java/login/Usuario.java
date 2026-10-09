package login;

public class Usuario {
  private String nombreUsuario;
  private String contrasenia;

  public Usuario() {}

  public Usuario(String nombreUsuario, String contrasenia) {
    if (nombreUsuario == null || nombreUsuario.isBlank()) {
      throw new IllegalArgumentException("El nombre de usuario no puede ser nulo ni vacío");
    }
    if (contrasenia == null || contrasenia.isBlank()) {
      throw new IllegalArgumentException("La contraseña no puede ser nula ni vacía");
    }

    this.nombreUsuario = nombreUsuario;
    this.contrasenia = contrasenia;
  }

  public String getNombreUsuario() {
    return nombreUsuario;
  }

  public String getContrasenia() {
    return contrasenia;
  }
}

package mbrtechnology.com.mbrt_app.models;

/**
 * Created by ASUS on 19/07/2017.
 */

public class Usuario {

    private Integer id;
    private Integer login;
    private String password;
    private String nombre;
    private String telefono;
    private String correo;
    private String direccion;
    private String role;

    public Usuario(){

    }

    public Usuario(Integer id, Integer login, String password, String nombre, String telefono, String correo, String direccion, String role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.role = role;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getLogin() { return login; }
    public void setLogin(Integer login) { this.login = login; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo;}

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", login=" + login +
                ", password='" + password + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

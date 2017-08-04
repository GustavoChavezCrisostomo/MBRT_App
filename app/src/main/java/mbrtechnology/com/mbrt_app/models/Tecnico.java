package mbrtechnology.com.mbrt_app.models;

/**
 * Created by ASUS on 2/08/2017.
 */

public class Tecnico {

    private Integer id;
    private String nombre;
    private String estado;

    public Tecnico(){
    }

    public Tecnico(Integer id, String nombre, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Tecnico{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}

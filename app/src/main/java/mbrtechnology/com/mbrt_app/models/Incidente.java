package mbrtechnology.com.mbrt_app.models;

/**
 * Created by ASUS on 5/07/2017.
 */

public class Incidente {
    private Integer id;
    private String contacto;
    private String area;
    private String descripcion;
    private String estado;
    private String tecnico;

    public Incidente(){
    }

    public Incidente(String contacto, String area, String descripcion, String estado, String tecnico){
        this.contacto = contacto;
        this.area = area;
        this.descripcion = descripcion;
        this.estado = estado;
        this.tecnico = tecnico;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getContacto() {
        return contacto;
    }
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTecnico() { return tecnico; }
    public void setTecnico(String tecnico) { this.tecnico = tecnico; }

    @Override
    public String toString() {
        return "Incidente{" +
                "id=" + id +
                ", contacto='" + contacto + '\'' +
                ", area='" + area + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}

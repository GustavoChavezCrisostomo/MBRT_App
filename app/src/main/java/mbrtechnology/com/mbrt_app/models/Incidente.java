package mbrtechnology.com.mbrt_app.models;

/**
 * Created by ASUS on 5/07/2017.
 */

public class Incidente {
    private int id;
    private String contacto;
    private String area;
    private String descripcion;
    private String estado;

    public Incidente(){

    }

    public Incidente(String contacto, String area, String descripcion, String estado){
        this.contacto = contacto;
        this.area = area;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
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

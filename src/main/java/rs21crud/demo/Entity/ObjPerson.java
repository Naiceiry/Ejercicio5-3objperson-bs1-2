package rs21crud.demo.Entity;

public class ObjPerson {
    private int id;
    private String nombre;
    private int edad;
    private String poblacion;

    public ObjPerson(String nombre, int edad, String poblacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.poblacion = poblacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }
}




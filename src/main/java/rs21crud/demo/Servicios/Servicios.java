package rs21crud.demo.Servicios;

import org.springframework.stereotype.Service;
import rs21crud.demo.Entity.ObjPerson;
import java.util.ArrayList;
import java.util.Objects;
import static java.util.Objects.isNull;
@Service
public class Servicios {

    private ArrayList<ObjPerson> personas;
    private int sumtId = 1;

    public Servicios() {
        this.personas = new ArrayList<ObjPerson>();
    }
    public ObjPerson add(ObjPerson objPerson) {
        objPerson.setId(this.sumtId++);
        this.personas.add(objPerson);
        return objPerson;
    }

    public ObjPerson porId(int id){
        System.out.println("porID"+ id);
        for (ObjPerson persona : this.personas) {
            System.out.println("service delete"+" "+ id );
            if (persona.getId() == id) {
                System.out.println("entra al if");
                return persona;
            }
        }
        return null;
    }

    public ObjPerson porNombre(String nombre){
        for (ObjPerson persona : this.personas) {
            if (Objects.equals(persona.getNombre(), nombre)) {
                return persona;
            }
        }
        return null;
    }
//022-06-02 10:24:18.384 ERROR 3424 --- [nio-8080-exec-3] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is
// java.lang.NullPointerException: Cannot invoke "rs21crud.demo.Entity.ObjPerson.setNombre(String)" because "upp" is null] with root cause
    public ObjPerson update(int id, ObjPerson objPerson){
        System.out.println("update"+ ""+ id +""+ objPerson );
        ObjPerson upp = this.porId(id);
        if (upp != null){
            return upp;
        }
        if (objPerson.getNombre() != null){
            upp.setNombre(objPerson.getNombre());
        }
        if (!isNull(objPerson.getEdad())){
            upp.setEdad(objPerson.getEdad());
        }
        if (objPerson.getPoblacion() != null){
            upp.setPoblacion(objPerson.getPoblacion());
        }
        return upp;}

    public void delete(int id){
        System.out.println("service delete"+" "+ id );
        ObjPerson upp = this.porId(id);
      /*  if (upp != null) {
            System.out.println("Borrado");
            this.personas.remove(upp);
        }*/
    }


}

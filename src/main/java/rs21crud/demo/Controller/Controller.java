package rs21crud.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs21crud.demo.Entity.ObjPerson;
import rs21crud.demo.Servicios.Servicios;

import java.util.ArrayList;

@RestController
public class Controller {
    //⦁	Añadir Persona. Petición POST. Body:  { “name”:”Jesús” …. } ⦁	http://URL/persona

    @Autowired
    private Servicios service;

    //ResponseEntity: configurar el cuerpo, el estado y los encabezados de una respuesta HTTP
    @RequestMapping(value="/person", method = RequestMethod.POST, consumes = "application/json" )
    public  ResponseEntity<ObjPerson> addPerson(@RequestBody ObjPerson objPerson){
        System.out.println("Post Realizado" );
        objPerson=this.service.add(objPerson);
        return new ResponseEntity<>(objPerson, HttpStatus.CREATED);
    }

    //⦁	Modificar por id. Petición PUT. ⦁	http://URL/⦁	persona/⦁	{id} - Body se manda los datos.
    @PutMapping("/{id}")
    public ResponseEntity<ObjPerson> putPerson(@PathVariable int id, @RequestBody ObjPerson objPerson){
        System.out.println("Controller putPerson"+" "+ id +" "+objPerson ); // sale bien
        ObjPerson persona = this.service.update(id, objPerson);
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }

//⦁	Consultar por id y por nombre.
// Petición GET ⦁	http://URL/⦁	persona/⦁	{id} y ⦁	http://URL/⦁	persona/⦁	nombre/{nombre}

    @GetMapping("/person/{nombre}")
    public ResponseEntity<ObjPerson> porNombre(
            @PathVariable String nombre
    ){
        ObjPerson persona = this.service.porNombre(nombre);
        if (persona == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<ObjPerson> porId(@PathVariable int id){
        ObjPerson persona = this.service.porId(id);
        if (persona == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(persona, HttpStatus.OK );
    }

    //⦁	Borrar (por id). Petición DELETE. ⦁	http://URL/⦁	persona/⦁	{id}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePersona(@PathVariable int id){
        System.out.println("Controller deletePersona"+" "+ id );
        this.service.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}

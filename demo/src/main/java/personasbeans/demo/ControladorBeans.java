package personasbeans.demo;


        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.beans.factory.annotation.Qualifier;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorBeans {

    @Autowired
    @Qualifier("creaClasePersona1") // Aqui va e nobre de la funcion creada en el bin, note  creaClasePersona1()
    ClasePersona persona1;

    @Autowired
    @Qualifier("creaClasePersona2") /*El @Qualifier se utiliza para resolver dependencias ambiguas, es decir, ayuda a @Autowired anotaciones a elegir una de las dependencias.*/
    ClasePersona persona2;

    @Autowired
    @Qualifier("creaClasePersona3")
    ClasePersona persona3;

    @GetMapping("/controlador/bean/{bean}")
    public ClasePersona createPerson(@PathVariable("bean") String bean) { /*para manejar variables de plantilla en la asignación de URI de solicitud y establecerlas como parámetros de método*/
        System.out.println(bean);
        if (bean.equalsIgnoreCase("bean1")) { /*El método compara dos cadenas, ignorando las diferencias entre minúsculas y mayúsculas.equalsIgnoreCase()
                                                   Este método devuelve true si las cadenas son iguales y false si no.*/
            return persona1;
        } else if (bean.equalsIgnoreCase("bean2")) {
            return persona2;
        } else if (bean.equalsIgnoreCase("bean3")) {
            return persona3;
        }
        return null;
    }
}


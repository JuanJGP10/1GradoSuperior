<<<<<<< HEAD:Programacion/src/main/java/programacion/tema10/Examen/examen/src/main/java/examen/GestorEmpleados.java
package programacion.tema10.Examen.examen.src.main.java.examen;
=======
package programacion.tema10.Examenbien;
>>>>>>> 836fd5250a527698c239f428829112d98c2cb924:Programacion/src/main/java/programacion/tema10/Examenbien/GestorEmpleados.java

import java.util.ArrayList;
import java.util.Collections;

public class GestorEmpleados {
    ArrayList<Empleado> empleados;

    public GestorEmpleados() {
        this.empleados = new ArrayList<>();
    }

    public double calcularTotalSalarios() {
        double suma = 0;
        for (Empleado empl : empleados) {
            suma += empl.calcularSalario();
        }

        return suma;
    }

    public ArrayList<EmpleadoDesarrollo> desarrolladores() {
        ArrayList<EmpleadoDesarrollo> lista = new ArrayList<>();

        for (Empleado empleado : empleados) {
            if (empleado instanceof EmpleadoDesarrollo e && e.getEspecialidad().equals(Especialidad.DESARROLLO))
                lista.add(e);
        }

        Collections.sort(lista);

        return lista;
    }

    public void añadirEmpleado(Empleado e) {
<<<<<<< HEAD:Programacion/src/main/java/programacion/tema10/Examen/examen/src/main/java/examen/GestorEmpleados.java
        if (e == null)
            throw new GestorException("Empleado no valido: NULO ");
        empleados.add(e);
=======
        try {
            empleados.add(e);
        } catch (EmpleadoException exc) {
            exc.getMessage();
            throw new GestorException("Empleado no dado de alta");
        }
>>>>>>> 836fd5250a527698c239f428829112d98c2cb924:Programacion/src/main/java/programacion/tema10/Examenbien/GestorEmpleados.java
    }
}

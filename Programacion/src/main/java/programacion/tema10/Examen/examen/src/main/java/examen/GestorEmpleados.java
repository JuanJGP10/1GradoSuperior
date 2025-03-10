package programacion.tema10.Examen.examen.src.main.java.examen;

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
        if (e == null)
            throw new GestorException("Empleado no valido: NULO ");
        empleados.add(e);
    }
}

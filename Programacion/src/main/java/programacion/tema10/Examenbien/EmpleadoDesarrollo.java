<<<<<<< HEAD:Programacion/src/main/java/programacion/tema10/Examen/examen/src/main/java/examen/EmpleadoDesarrollo.java
package programacion.tema10.Examen.examen.src.main.java.examen;
=======
package programacion.tema10.Examenbien;
>>>>>>> 836fd5250a527698c239f428829112d98c2cb924:Programacion/src/main/java/programacion/tema10/Examenbien/EmpleadoDesarrollo.java

/**
 * Clase Empleado desarrollo que representa a los empleados que so
 * desarrolladores de una empresa, hereda de la clase empleado.
 */
public class EmpleadoDesarrollo extends Empleado implements Comparable<EmpleadoDesarrollo> {
    /**
     * Esta es un atributo que sera la especialidad del empleado, viene de una
     * enumeracion Especialidad
     */
    private Especialidad especialidad;

    /**
     * Este es un atributo de tipo array de strings que almacenara los proyectos
     * realizados por los empleados
     */
    private String[] proyectosRealizados;

    /**
     * Constructor que recibe todos los parámetros del padre más la especialidad y
     * un array de proyectos.
     * La especialidad no puede ser vacía, se lanzará una excepción no capturada.
     * 
     * @param dni
     * @param nombre
     * @param direccion
     * @param especialidad
     * @param proyectosRealizados
     */
    public EmpleadoDesarrollo(String dni, String nombre, Direccion direccion, Especialidad especialidad,
            String[] proyectosRealizados) {
        super(dni, nombre, direccion);
        setEspecialidad(especialidad);
        this.proyectosRealizados = proyectosRealizados;
    }

    /**
     * Constructor adicional que use un valor por defecto de especialidad
     * (DESARROLLO) y un array de proyectos vacío.
     * Usará el primer constructor.
     * 
     * @param dni
     * @param nombre
     * @param direccion
     */
    public EmpleadoDesarrollo(String dni, String nombre, Direccion direccion) {
        this(dni, nombre, direccion, Especialidad.DESARROLLO, new String[0]);

    }

    /**
     * Getter de especialidad
     * 
     * @return Enumeracion de especialidades
     */
    public Especialidad getEspecialidad() {
        return especialidad;
    }

    /**
     * Setter de especialidad
     * 
     * @param especialidad
     */
    public void setEspecialidad(Especialidad especialidad) {
        if (especialidad == null)
            throw new EmpleadoException("La especialidad no puede ser vacia");
        this.especialidad = especialidad;
    }

    /**
     * Getter de Proyectos realizados
     * 
     * @return array con los proyectos
     */
    public String[] getProyectosRealizados() {
        return proyectosRealizados;
    }

    /**
     * Setter de proyectos realizados
     * 
     * @param proyectosRealizados
     */
    public void setProyectosRealizados(String[] proyectosRealizados) {

        this.proyectosRealizados = proyectosRealizados;
    }

    /**
     * Metodo calcular salario que calculara el salario del empleado segun su
     * especialidad
     * 
     * @return salario
     */
    @Override
    public double calcularSalario() {
<<<<<<< HEAD:Programacion/src/main/java/programacion/tema10/Examen/examen/src/main/java/examen/EmpleadoDesarrollo.java
        return switch (especialidad) {
            case DESARROLLO -> 3000;
            case DISEÑO -> 2800;
            case INFRAESTRUCTURA -> 3200;
            case GESTION -> 3500;
        };
        // if (especialidad.equals(Especialidad.DESARROLLO))
        // return 3000;
        // else if (especialidad.equals(Especialidad.DISEÑO))
        // return 2800;
        // else if (especialidad.equals(Especialidad.INFRAESTRUCTURA))
        // return 3200;
        // else if (especialidad.equals(Especialidad.GESTION))
        // return 3500;
        // else
        // return 0;
=======
        if (especialidad.equals(Especialidad.DESARROLLO))
            return 3000;
        else if (especialidad.equals(Especialidad.DISEÑO))
            return 2800;
        else if (especialidad.equals(Especialidad.INFRAESTRUCTURA))
            return 3200;
        else if (especialidad.equals(Especialidad.GESTION))
            return 3500;
        else
            return 0;
>>>>>>> 836fd5250a527698c239f428829112d98c2cb924:Programacion/src/main/java/programacion/tema10/Examenbien/EmpleadoDesarrollo.java
    }

    /**
     * Metodo que obtiene los n proyectos realizados mas complejos, por complejo nos
     * referimos al tamaño del nombre del proyecto
     * 
     * @param n numero de proyectos que queremos devolver
     * @return array con los proyectos
     */
    public String[] obtenerProyectosMasComplejos(int n) { // Se ha intentado
        if (n < 0)
            return new String[0];

        if (proyectosRealizados.length == 0)
            return new String[0];

        String[] proyectosComplejos = new String[n];
        int contador = 0;
        int contador1 = 1;
        int masGrande = 0;

        if (proyectosRealizados.length > proyectosComplejos.length) {
            while (contador < n) {

                for (int i = 0; i < proyectosRealizados.length; i++) {
                    String siguiente = proyectosRealizados[i];
<<<<<<< HEAD:Programacion/src/main/java/programacion/tema10/Examen/examen/src/main/java/examen/EmpleadoDesarrollo.java
                    int masGrande = 0;
=======
                    masGrande = 0;
>>>>>>> 836fd5250a527698c239f428829112d98c2cb924:Programacion/src/main/java/programacion/tema10/Examenbien/EmpleadoDesarrollo.java

                    if (siguiente.length() > proyectosRealizados[masGrande].length())
                        masGrande = i;

<<<<<<< HEAD:Programacion/src/main/java/programacion/tema10/Examen/examen/src/main/java/examen/EmpleadoDesarrollo.java
                    for (int j = 0; j < contador1; j++) {
                        proyectosComplejos[j] = proyectosRealizados[masGrande];
                        contador++;
                    }

                }

=======
                }

                for (int j = 0; j < contador1; j++) {
                    proyectosComplejos[j] = proyectosRealizados[masGrande];
                    contador++;
                }

                contador1++;

>>>>>>> 836fd5250a527698c239f428829112d98c2cb924:Programacion/src/main/java/programacion/tema10/Examenbien/EmpleadoDesarrollo.java
            }

        } else {

            int masGrande1 = 0;
            for (int i = 0; i < proyectosRealizados.length; i++) {
                for (int j = 0; j < proyectosRealizados.length; j++) {
                    String siguiente = proyectosRealizados[i];
<<<<<<< HEAD:Programacion/src/main/java/programacion/tema10/Examen/examen/src/main/java/examen/EmpleadoDesarrollo.java
                    masGrande = 0;

                    if (siguiente.length() > proyectosRealizados[masGrande].length())
                        masGrande = i;
=======
                    masGrande1 = 0;

                    if (siguiente.length() > proyectosRealizados[masGrande1].length())
                        masGrande1 = i;
>>>>>>> 836fd5250a527698c239f428829112d98c2cb924:Programacion/src/main/java/programacion/tema10/Examenbien/EmpleadoDesarrollo.java
                }
                proyectosRealizados[i] = proyectosRealizados[masGrande1];
            }
            return proyectosRealizados;
        }
        return proyectosComplejos;

    }

    /**
     * Metodo heredado de la interfaz comparable, habiendo sido declarada la
     * implementacion en la clase padre (Empleado)
     * Lo utilizaremos para ordenar a los empleados de desarrollo
     * 
     * @param e empleado
     * @return devuelve si el objetos es mayo menor o igual
     */
    @Override
    public int compareTo(EmpleadoDesarrollo e) {
        int nombre = this.getNombre().compareTo(e.getNombre());

        if (nombre == 0)
<<<<<<< HEAD:Programacion/src/main/java/programacion/tema10/Examen/examen/src/main/java/examen/EmpleadoDesarrollo.java
            return Double.valueOf(this.calcularSalario()).compareTo(e.calcularSalario()); // Asi mejor
        // return (int) (this.calcularSalario() - e.calcularSalario());
=======
            return (int) (this.calcularSalario() - e.calcularSalario());
>>>>>>> 836fd5250a527698c239f428829112d98c2cb924:Programacion/src/main/java/programacion/tema10/Examenbien/EmpleadoDesarrollo.java

        return nombre;
    }

}

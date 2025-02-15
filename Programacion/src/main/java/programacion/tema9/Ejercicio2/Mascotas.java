package programacion.tema9.Ejercicio2;

abstract class Mascotas {
    protected String nombre;
    protected int edad;
    protected String estado;
    protected String fechaNacimiento;

    public Mascotas(String nombre, int edad, String estado, String fechaNacimiento) {
        this.nombre = nombre;
        this.edad = edad;
        this.estado = estado;
        this.fechaNacimiento = fechaNacimiento;
    }

    public abstract void muestra();

    public void cumpleaños() {
        System.out.println("Cumpleaños: " + fechaNacimiento);
    }

    public void morir() {
        System.out.println("Passed away... RIP");
    }

    public abstract void habla();
}

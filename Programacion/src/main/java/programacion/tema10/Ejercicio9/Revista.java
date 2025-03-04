package programacion.tema10.Ejercicio9;

public class Revista extends Publicacion implements Comparable<Revista> {
    private final String issn;
    private final String nombre;
    private final int numero;

    public Revista(String issn, String nombre, int numero) throws PublicacionException {
        if (!issn.matches("[0-9]{8}"))
            throw new PublicacionException("issn incorrecto son 8 digitos");
        if (numero < 0)
            throw new PublicacionException("numero incorrecto, no puede ser menor que 0");

        this.issn = issn;
        this.nombre = nombre;
        this.numero = numero;
    }

    public String getIssn() {
        return issn;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public void mostrarEnLinea() {
        System.out.printf("%-15s %-30s %-10d\n", issn, nombre,
                numero);
    }

    @Override
    public int compareTo(Revista otra) {
        int comparacionNombre = this.nombre.compareToIgnoreCase(otra.nombre);

        // si comparacion nombre da 0 es que los nombre son iguales
        if (comparacionNombre == 0) {
            return this.issn.compareTo(otra.issn);
        }

        return comparacionNombre;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((issn == null) ? 0 : issn.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Revista other = (Revista) obj;
        if (issn == null) {
            if (other.issn != null)
                return false;
        } else if (!issn.equals(other.issn))
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }

}

package programacion.tema10.Ejercicios.Ejercicio8;

public class DawBank {

    public static void main(String[] args) {
        String opcion = "";
        do {
            System.out.println("""
                    1. Datos de la cuenta. Mostrará el IBAN, el titular y el saldo.
                    2. IBAN. Mostrará el IBAN.
                    3. Titular. Mostrará el titular.
                    4. Saldo. Mostrará el saldo disponible.
                    5. Ingreso. Pedirá la cantidad a ingresar y realizará el ingreso si es posible.
                    6. Retirada. Pedirá la cantidad a retirar y realizará la retirada si es posible.
                    7. Movimientos. Mostrará una lista con el historial de movimientos.
                    8. Salir. Termina el programa.
                    """);

            switch (opcion) {
                case "1":

                    break;

                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "6":

                    break;
                case "7":

                    break;
                case "8":
                    System.out.println("Saliendo....");
                    break;
                default:
                    System.out.println("Entrada no esperada");
                    break;
            }

        } while (!opcion.equals("8"));
    }
}

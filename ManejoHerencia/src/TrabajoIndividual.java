
import java.util.Scanner;

/**
 *
 * @author Lenin Cuenca
 */
class Persona {
    public String nombre;
    public String apellido;
    public String userName;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String userName) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", userName=" + userName + '}';
    }
    
}

class InstitucionEducativa {
    public String nombre;
    public String siglas;

    public InstitucionEducativa() {
    }

    public InstitucionEducativa(String nombre, String siglas) {
        this.nombre = nombre;
        this.siglas = siglas;
    }
}

class Prestamo {
    public Persona beneficiario;
    public double tiempoPrestamoMes;
    public String ciudadPrestamo;

    public Prestamo() {
    }

    public Prestamo(Persona beneficiario, double tiempoPrestamoMes) {
        this.beneficiario = beneficiario;
        this.tiempoPrestamoMes = tiempoPrestamoMes;
    }

    public void setCiudadPrestamo(String ciudadPrestamo) {
        this.ciudadPrestamo = ciudadPrestamo;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "beneficiario=" + beneficiario +
                ", tiempoPrestamoMes=" + tiempoPrestamoMes +
                ", ciudadPrestamo='" + ciudadPrestamo + '\'' +
                '}';
    }
}

class PrestamoAutomovil extends Prestamo {
    public String tipoAutomovil;
    public String marcaAutomovil;
    public Persona garante1;
    public double valorAutomovil;
    public double valorMensualPagoPrestamo;

    public PrestamoAutomovil() {
    }

    public PrestamoAutomovil(String tipoAutomovil, String marcaAutomovil, Persona garante1, double valorAutomovil) {
        this.tipoAutomovil = tipoAutomovil;
        this.marcaAutomovil = marcaAutomovil;
        this.garante1 = garante1;
        this.valorAutomovil = valorAutomovil;
    }

    public double calcularValorMensual() {
        this.valorMensualPagoPrestamo = valorAutomovil / tiempoPrestamoMes;
        return valorMensualPagoPrestamo;
    }

    @Override
    public String toString() {
        return super.toString() + " - Tipo Automóvil: " + tipoAutomovil + " - Marca Automóvil: " + marcaAutomovil +
                " - Garante: " + garante1 + " - Valor Automóvil: " + valorAutomovil +
                " - Valor Mensual Pago Préstamo: " + valorMensualPagoPrestamo;
    }
}

class PrestamoEducativo extends Prestamo {
    public String nivelEstudio;
    public InstitucionEducativa centroEducativo;
    public double valorCarrera;
    public double valorMensualPagoCarrera;

    public PrestamoEducativo() {
    }

    public PrestamoEducativo(String nivelEstudio, InstitucionEducativa centroEducativo, double valorCarrera) {
        this.nivelEstudio = nivelEstudio;
        this.centroEducativo = centroEducativo;
        this.valorCarrera = valorCarrera;
    }

    public void calcularValorMensualPagoCarrera() {
        this.valorMensualPagoCarrera = (valorCarrera / tiempoPrestamoMes) - (0.1 * (valorCarrera / tiempoPrestamoMes));
    }

    @Override
    public String toString() {
        return super.toString() + " - Nivel de Estudio: " + nivelEstudio + " - Centro Educativo: " +
                centroEducativo.nombre + " (" + centroEducativo.siglas + ")" + " - Valor Carrera: " + valorCarrera +
                " - Valor Mensual Pago Carrera: " + valorMensualPagoCarrera;
    }
}
public class TrabajoIndividual {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Prestamo[] prestamos = new Prestamo[100];
        int numPrestamos = 0;

        int opcion;
        boolean salir = false;
        while (!salir) {
            System.out.println("Menú:");
            System.out.println("1. Ingresar datos para un préstamo de tipo PrestamoAutomovil");
            System.out.println("2. Ingresar datos para un préstamo de tipo PrestamoEducativo");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    scanner.nextLine();

                    System.out.print("Nombre del beneficiario: ");
                    String nombreBeneficiario = scanner.nextLine();
                    System.out.print("Apellido del beneficiario: ");
                    String apellidoBeneficiario = scanner.nextLine();
                    System.out.print("Username del beneficiario: ");
                    String usernameBeneficiario = scanner.nextLine();
                    Persona beneficiario = new Persona(nombreBeneficiario, apellidoBeneficiario, usernameBeneficiario);

                    System.out.print("Tiempo de préstamo en meses: ");
                    double tiempoPrestamo = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Ciudad del préstamo: ");
                    String ciudadPrestamo = scanner.nextLine();

                    System.out.print("Tipo de automóvil: ");
                    String tipoAutomovil = scanner.nextLine();
                    System.out.print("Marca del automóvil: ");
                    String marcaAutomovil = scanner.nextLine();

                    System.out.print("Nombre del garante: ");
                    String nombreGarante = scanner.nextLine();
                    System.out.print("Apellido del garante: ");
                    String apellidoGarante = scanner.nextLine();
                    System.out.print("Username del garante: ");
                    String usernameGarante = scanner.nextLine();
                    Persona garante1 = new Persona(nombreGarante, apellidoGarante, usernameGarante);

                    System.out.print("Valor del automóvil: ");
                    double valorAutomovil = scanner.nextDouble();

                    PrestamoAutomovil prestamoAutomovil = new PrestamoAutomovil(tipoAutomovil, marcaAutomovil,
                            garante1, valorAutomovil);
                    prestamoAutomovil.beneficiario = beneficiario;
                    prestamoAutomovil.tiempoPrestamoMes = tiempoPrestamo;
                    prestamoAutomovil.setCiudadPrestamo(ciudadPrestamo);
                    prestamoAutomovil.calcularValorMensual();

                    prestamos[numPrestamos] = prestamoAutomovil;
                    numPrestamos++;
                    break;

                case 2:
                    scanner.nextLine();

                    System.out.print("Nombre del beneficiario: ");
                    nombreBeneficiario = scanner.nextLine();
                    System.out.print("Apellido del beneficiario: ");
                    apellidoBeneficiario = scanner.nextLine();
                    System.out.print("Username del beneficiario: ");
                    usernameBeneficiario = scanner.nextLine();
                    beneficiario = new Persona(nombreBeneficiario, apellidoBeneficiario, usernameBeneficiario);

                    System.out.print("Tiempo de préstamo en meses: ");
                    tiempoPrestamo = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Ciudad del préstamo: ");
                    ciudadPrestamo = scanner.nextLine();

                    System.out.print("Nivel de estudio: ");
                    String nivelEstudio = scanner.nextLine();

                    System.out.print("Nombre del centro educativo: ");
                    String nombreCentroEducativo = scanner.nextLine();
                    System.out.print("Siglas del centro educativo: ");
                    String siglasCentroEducativo = scanner.nextLine();
                    InstitucionEducativa centroEducativo =
                            new InstitucionEducativa(nombreCentroEducativo, siglasCentroEducativo);

                    System.out.print("Valor de la carrera: ");
                    double valorCarrera = scanner.nextDouble();

                    PrestamoEducativo prestamoEducativo = new PrestamoEducativo(nivelEstudio, centroEducativo,
                            valorCarrera);
                    prestamoEducativo.beneficiario = beneficiario;
                    prestamoEducativo.tiempoPrestamoMes = tiempoPrestamo;
                    prestamoEducativo.setCiudadPrestamo(ciudadPrestamo);
                    prestamoEducativo.calcularValorMensualPagoCarrera();

                    prestamos[numPrestamos] = prestamoEducativo;
                    numPrestamos++;
                    break;

                case 0:
                    salir = true;
                    break;
            }
        }
        System.out.println("Lista de préstamos:");
        for (int i = 0; i < numPrestamos; i++) {
            System.out.println(prestamos[i]);
        }
    }
}

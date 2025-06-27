
/**
 * Se desea desarrollar un sistema de nómina para los trabajadores de una empresa.
 * Los datos personales de los trabajadores son nombre y apellidos, dirección y DNI.
 * Además, existen diferentes tipos de trabajadores:
 *
 * Fijos Mensuales: que cobran una cantidad fija al mes.
 * Comisionistas: cobran un porcentaje fijo por las ventas que han realizado
 * Por Horas: cobran un precio por cada una de las horas que han realizado durante
 * el mes. El precio es fijo para las primeras 40 horas y es otro para las horas
 * realizadas a partir de la 40 hora mensual.
 * Jefe: cobra un sueldo fijo (no hay que calcularlo). Cada empleado tiene
 * obligatoriamente un jefe (exceptuando los jefes que no tienen ninguno). El
 * programa debe permitir dar de alta a trabajadores, así como fijar horas o
 * ventas realizadas e imprimir la nómina correspondiente al final de mes.
 *
 * Note
 *
 * Diseñe la jerarquia de clases UML basado en herencia, que defina de mejor forma
 * el escenario planteado.
 * Para probar el diseño de clases, instancia en el clase de prueba Ejecutor (la-s
 * clase-s respectiva-s), con datos aleatorios.
 * En los escenarios de prueba verifique su solución con al menos 2 tipos de
 * trabajadores.
 *
 * @author Andrea
 */
public class Problema4_NominaTrabajadores {

    public static void main(String[] args) {
        Jefe jefe = new Jefe("Adrian", "Medina", "Av.Occidental", "15000A", 2000.0);

        FijosMensuales empleado1 = new FijosMensuales(1350.0, "Sofia", "Jimenez", "La paz", "0000000B", jefe);
        Comisionistas empleado2 = new Comisionistas(750.0, 1000.0, "Miguel", "Flores", "Calle Rocafuerte", "74000C", jefe);

        Horas empleado3 = new Horas(15.0, 45, "Camila", "Tamayo", "Zamora Huayco", "423938744D", jefe);

        System.out.println("Nomina Jefe: " + jefe.calcularSueldo());
        System.out.println("Nomina Fijo Mensual: " + empleado1.calcularSueldo());
        System.out.println("Nomina Comisionista: " + empleado2.calcularSueldo());
        System.out.println("Nomina Por Horas: " + empleado3.calcularSueldo());
    }
}

class Trabajador {

    public String nombre;
    public String apellidos;
    public String direccion;
    public String dni;
    public Trabajador jefe;

    public Trabajador(String nombre, String apellidos, String direccion, String dni, Trabajador jefe) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.dni = dni;
        this.jefe = jefe;
    }

    public double calcularNomina() {
        return 0.0;
    }
}

class FijosMensuales extends Trabajador {

    public double sueldo;

    public FijosMensuales(double sueldoFijo, String nombre, String apellidos, String direccion, String dni, Trabajador jefe) {
        super(nombre, apellidos, direccion, dni, jefe);
        this.sueldo = sueldoFijo;
    }

    public double calcularSueldo() {
        return sueldo;
    }
}

class Comisionistas extends Trabajador {

    public double ventas;
    public double comision;

    public Comisionistas(double ventas, double comision, String nombre, String apellidos, String direccion, String dni, Trabajador jefe) {
        super(nombre, apellidos, direccion, dni, jefe);
        this.ventas = ventas;
        this.comision = comision;
    }

    public double calcularSueldo() {
        return ventas * comision;
    }
}

class Horas extends Trabajador {

    public double valorHora;
    public int hTrabajadas;

    public Horas(double valorHora, int hTrabajadas, String nombre, String apellidos, String direccion, String dni, Trabajador jefe) {
        super(nombre, apellidos, direccion, dni, jefe);
        this.valorHora = valorHora;
        this.hTrabajadas = hTrabajadas;
    }

    public double calcularSueldo() {
        if (hTrabajadas <= 40) {
            return hTrabajadas * valorHora;
        } else {
            return 40 * valorHora + (hTrabajadas - 40) * (valorHora * 1.5);
        }
    }
}

class Jefe extends Trabajador {

    double sueldo;

    public Jefe(String nombres, String apellidos, String direccion, String dni, double sueldo) {
        super(nombres, apellidos, direccion, dni, null);
        this.sueldo = sueldo;
    }

    public double calcularSueldo() {
        return sueldo;
    }
}

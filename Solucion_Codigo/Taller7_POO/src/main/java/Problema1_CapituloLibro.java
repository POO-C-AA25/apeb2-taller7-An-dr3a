
import java.util.ArrayList;

/**
 * Dibujad un diagrama de clases que muestra la estructura de un capítulo de
 * libro ; un capítulo está compuesto por varias secciones , cada una de las
 * cuales comprende varios párrafos y figuras . Un párrafo incluye varias
 * sentencias , cada una de las cuales contiene varias palabras .
 *
 * Nota
 *
 * Supongamos que en un futuro se prevé que el sistema gestione además de
 * párrafos y figuras otros componentes, como tablas, listas, viñetas, etc.
 * Supongamos además que una palabra puede aparecer en varias sentencias.
 *
 * @author Andrea Criollo
 */
public class Problema1_CapituloLibro {

    public static void main(String[] args) {
        Palabras plb1 = new Palabras("Querido");
        Palabras plb2 = new Palabras("Lector");

        Sentencia sen = new Sentencia();
        sen.palabras.add(plb1);
        sen.palabras.add(plb2);

        Parrafo prr = new Parrafo();
        prr.sent.add(sen);

        Figura fig = new Figura("imagen.jpg");

        Secciones sec = new Secciones("Chernobil");
        sec.sec.add(prr);
        sec.sec.add(fig);

        CapituloLibro cl = new CapituloLibro("Energia Nuclear");
        cl.secciones.add(sec);
        System.out.println(cl);
    }
}

class CapituloLibro {

    String titulo;
    ArrayList<Secciones> secciones = new ArrayList<>();

    public CapituloLibro(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "CapituloLibro{" + "titulo=" + titulo + ", secciones=" + secciones + '}';
    }

}

class Secciones {

    String titulo;
    ArrayList<Secciones> sec = new ArrayList<>();

    public Secciones(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Secciones{" + "titulo=" + titulo + ", sec=" + sec + '}';
    }

}

class Parrafo extends Secciones {

    ArrayList<Sentencia> sent;

    public Parrafo() {
        super("");
    }
}

class Figura extends Secciones {

    String imagen;

    public Figura(String imagen) {
        super("");
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Figura{" + "imagen=" + imagen + '}';
    }

}

class Sentencia {

    ArrayList<Palabras> palabras = new ArrayList<>();

    @Override
    public String toString() {
        return "Sentencia{" + "palabras=" + palabras + '}';
    }

}

class Palabras {

    String texto;

    public Palabras(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Palabras{" + "texto=" + texto + '}';
    }

}

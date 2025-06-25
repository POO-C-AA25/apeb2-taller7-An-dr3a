
import java.util.ArrayList;

/**
 * Un videoclub dispone de una serie de películas que pueden estar en DVD (con
 * capacidad en Gb.) o en VHS (una sola cinta por película y con cierto tipo de
 * cinta magnética) . De las películas interesa guardar el título, el autor, el
 * año de edición y el idioma (o los idiomas, en caso de DVD) . El precio de
 * alquiler de las películas varía en función del tipo de película. Las DVD
 * siempre son 10% más caras que las de VHS .
 *
 * Nota
 *
 * Analice los tipos de relación de las siguientes clases posibles: Película,
 * Dvd, Vhs, Soporte, etc, y justifique su diseño. Para probar el diseño
 * jerarquico de clases, instancia en la clase de prueba Ejecutor (la-s clase-s
 * respectiva-s) , con datos aleatorios. Los escenarios de prueba pueden ocurrir
 * para el alquiler de una o varias películas según la preferencia del usuario.
 *
 * @author Andrea Criollo
 */
public class Problema2_Pelicula {

    public static void main(String[] args) {
        Pelicula peli1 = new Pelicula("Inception", "Christopher Nolan", 2010);
        Pelicula peli2 = new Pelicula("Titanic", "James Cameron", 1997);

        ArrayList<Pelicula> listaPeliculasDVD = new ArrayList<>();
        listaPeliculasDVD.add(peli1);

        DVD dvd = new DVD(new String[]{"Español", "Inglés"}, listaPeliculasDVD, 10.0);
        dvd.calcularPrecioAlq();
        VHS vhs = new VHS("Español", peli2, 10.0);

        System.out.println(dvd);
        System.out.println(vhs);
    }
}

class SoportePelicula {

    public double precioAlq;

    public SoportePelicula(double precioAlq) {
        this.precioAlq = precioAlq;
    }

    @Override
    public String toString() {
        return "soportePelicula{" + "precioAlq=" + precioAlq + '}';
    }
}

class DVD extends SoportePelicula {

    public String[] idioma;
    public ArrayList<Pelicula> pelicula;

    public DVD(String[] idioma, ArrayList<Pelicula> pelicula, double precioAlq) {
        super(precioAlq);
        this.idioma = idioma;
        this.pelicula = pelicula;
    }

    public void calcularPrecioAlq() {
        this.precioAlq += (this.precioAlq * 0.1);
    }

    @Override
    public String toString() {
        return "DVD{" + "idioma=" + idioma + ", pelicula=" + pelicula + '}';
    }
}

class VHS extends SoportePelicula {

    public String idioma;
    public Pelicula pelicula;

    public VHS(String idioma, Pelicula pelicula, double precioAlq) {
        super(precioAlq);
        this.idioma = idioma;
        this.pelicula = pelicula;
    }

    @Override
    public String toString() {
        return "VHS{" + "idioma=" + idioma + ", pelicula=" + pelicula + '}';
    }
}

class Pelicula {

    public String titulo;
    public String autor;
    public int anioEdi;

    public Pelicula(String titulo, String autor, int anioEdi) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioEdi = anioEdi;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "titulo=" + titulo + ", autor=" + autor + ", anioEdi=" + anioEdi + '}';
    }

}

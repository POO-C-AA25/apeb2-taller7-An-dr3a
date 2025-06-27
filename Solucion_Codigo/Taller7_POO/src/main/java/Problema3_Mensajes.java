
/**
 * Implemente un sistema de envío de mensajes a móviles. Existen dos tipos de
 * mensajes que se pueden enviar entre móviles, mensajes de texto (SMS) y
 * mensajes que contienen imágenes (MMS) . Por un lado, los mensajes de texto
 * contienen un mensaje en caracteres que se desea enviar de un móvil a otro.
 * Por otro lado, los mensajes que contienen imágenes almacenan información
 * sobre la imagen a enviar, la cual se representará por el nombre del fichero
 * que la contiene. Independientemente del tipo de mensaje, cada mensaje tendrá
 * asociado un remitente de dicho mensaje y un destinatario. Ambos estarán
 * definidos obligatoriamente por un número de móvil, y opcionalmente se podrá
 * guardar información sobre su nombre. Además, los métodos enviarMensaje y
 * visualizarMensaje deben estar definidos.
 *
 * Nota
 *
 * Para probar el diseño jerarquico de clases, instancia en la clase de prueba
 * Ejecutor, con datos ficticios.
 *
 * @author Andrea Criollo
 */
public class Problema3_Mensajes {

    public static void main(String[] args) {
        SMS sms = new SMS("1111111111111", "2222222222222", "Te vas a la fiesta?");
        sms.nombreRemi = "Victoria";

        MMS mms = new MMS("1111111111111", "2222222222222", "imagen.jpg");
        mms.nombreRemi = "Camila";
        mms.nombreDesti = "Andrea";

        System.out.println(sms.remi);
        sms.enviar();
        System.out.println(mms.visulizar());
    }
}

class Mensajes {

    public String remi;
    public String desti;
    public String nombreRemi;
    public String nombreDesti;

    public Mensajes(String remi, String desti) {
        this.remi = remi;
        this.desti = desti;
    }

    public void enviar() {
        System.out.println("Enviando mensaje.....");
    }

    public String visualizar() {

        return "Envio un mensaje" + remi;

    }
}

class SMS extends Mensajes {

    public String mensaje;

    public SMS(String mensaje, String remi, String desti) {
        super(remi, desti);
        this.mensaje = mensaje;
    }

    @Override
    public void enviar() {
        System.out.println("Escribiendo mensaje a: " + desti + "\n" + mensaje);
    }

    public String visulizar() {
        return "Mensaje de" + nombreRemi + "\n" + remi + "\n" + mensaje;
    }

}

class MMS extends Mensajes {

    public String imagen;

    public MMS(String imagen, String remi, String desti) {
        super(remi, desti);
        this.imagen = imagen;
    }

    @Override
    public void enviar() {
        System.out.println("Escribiendo imagen a: " + desti + "\n" + imagen);
    }

    public String visulizar() {
        return "Mensaje de" + nombreRemi + "\n" + remi + "\n" + imagen;
    }
}

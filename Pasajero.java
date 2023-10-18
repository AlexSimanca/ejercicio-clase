import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class Pasajero {
    private String Nombres;
    private String Apellidos;
    private String NumPasaporte;
    private String Asiento;
    private int Edad;

    // Constructor
    public Pasajero(String nombres, String apellidos, String numPasaporte, String asiento, int edad) {
        setNombres(nombres);
        setApellidos(apellidos);
        setNumPasaporte(numPasaporte);
        setAsiento(asiento);
        setEdad(edad);
    }

    public void setNombres(String nombres) {
        if (nombres == null || nombres.isEmpty()) {
            System.out.println("Error en los datos de entrada");
        }
        this.Nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        if (apellidos == null || apellidos.isEmpty()) {
            System.out.println("Error en los datos de entrada");
        }
        this.Apellidos = apellidos;
    }

    public void setNumPasaporte(String numPasaporte) {
        if (numPasaporte == null || numPasaporte.isEmpty()) {
            System.out.println("Error en los datos de entrada");
        }
        this.NumPasaporte = numPasaporte;
    }

    public void setAsiento(String asiento) {
        if (asiento == null || asiento.isEmpty()) {
            System.out.println("Error en los datos de entrada");
        }
        this.Asiento = asiento;
    }

    public void setEdad(int edad) {
        if (edad < 0) {
            System.out.println("Error en los datos de entrada");
        }
        this.Edad = edad;
    }

    // Método estático para obtener el pasajero más joven de una colección
    public static Pasajero obtenerPasajeroMasJoven(Collection<Pasajero> pasajeros) {
        if (pasajeros.isEmpty()) {
            return null; // Retorna null si la colección está vacía
        }

        Pasajero pasajeroMasJoven = null;
        for (Pasajero pasajero : pasajeros) {
            if (pasajeroMasJoven == null || pasajero.getEdad() < pasajeroMasJoven.getEdad()) {
                pasajeroMasJoven = pasajero;
            }
        }
        return pasajeroMasJoven;
    }

    public String getNombres() {
        return Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public String getNumPasaporte() {
        return NumPasaporte;
    }

    public String getAsiento() {
        return Asiento;
    }

    public int getEdad() {
        return Edad;
    }
}
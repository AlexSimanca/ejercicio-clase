import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class Pasajero {
    private String Nombres;
    private String Apellidos;
    private String NumPasaporte;
    private String Asiento;
    private int Edad;

    public Pasajero() {
        Nombres = "";
        Apellidos = "";
        NumPasaporte = "";
        Asiento = "";
        Edad = 0;
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

class Vuelo {
    private String nombre;
    private String codigo;
    private String origen;
    private String destino;
    private int capacidad;
    private Collection<Pasajero> pasajeros;

    public Vuelo(String nombre, String codigo, String origen, String destino, int capacidad) {
        validarDatos(nombre, codigo, origen, destino, capacidad);
        this.nombre = nombre;
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
        this.capacidad = capacidad;
        this.pasajeros = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Collection<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public int obtenerNumeroDePasajeros() {
        return pasajeros.size();
    }

    public void agregarPasajero(String nombres, String apellidos, String numPasaporte, String asiento, int edad) {
        if (capacidad <= pasajeros.size() || pasajeroConMismoPasaporte(numPasaporte) || pasajeroConMismoAsiento(asiento)) {
            System.out.println("No se pudo agregar al pasajero debido a restricciones.");
            return;
        }
        Pasajero nuevoPasajero = new Pasajero();
        nuevoPasajero.setNombres(nombres);
        nuevoPasajero.setApellidos(apellidos);
        nuevoPasajero.setNumPasaporte(numPasaporte);
        nuevoPasajero.setAsiento(asiento);
        nuevoPasajero.setEdad(edad);
        pasajeros.add(nuevoPasajero);
    }

    public void eliminarPasajeroPorNumPasaporte(String numPasaporte) {
        Iterator<Pasajero> iterator = pasajeros.iterator();
        while (iterator.hasNext()) {
            Pasajero pasajero = iterator.next();
            if (pasajero.getNumPasaporte().equals(numPasaporte)) {
                iterator.remove();
                return;
            }
        }
    }

  public String obtenerPasajeroMasJoven() {
      Pasajero pasajeroMasJoven = Pasajero.obtenerPasajeroMasJoven(pasajeros);
      if (pasajeroMasJoven != null) {
          return "El pasajero más joven del vuelo es " + pasajeroMasJoven.getNombres() + " " + pasajeroMasJoven.getApellidos() +
                  " (pasaporte: " + pasajeroMasJoven.getNumPasaporte() + "). Tiene " + pasajeroMasJoven.getEdad() + " años y está sentado en el asiento " +
                  pasajeroMasJoven.getAsiento() + ".";
      } else {
          return "El vuelo está vacío.";
      }
  }

    private void validarDatos(String nombre, String codigo, String origen, String destino, int capacidad) {
        if (nombre == null || nombre.isEmpty() ||
            codigo == null || codigo.isEmpty() ||
            origen == null || origen.isEmpty() ||
            destino == null || destino.isEmpty() ||
            capacidad <= 0) {
            throw new IllegalArgumentException("Los datos proporcionados no son válidos.");
        }
    }

    private boolean pasajeroConMismoPasaporte(String numPasaporte) {
        for (Pasajero pasajero : pasajeros) {
            if (pasajero.getNumPasaporte().equals(numPasaporte)) {
                return true;
            }
        }
        return false;
    }

    private boolean pasajeroConMismoAsiento(String asiento) {
        for (Pasajero pasajero : pasajeros) {
            if (pasajero.getAsiento().equals(asiento)) {
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Pasajero pasajero1 = new Pasajero();
        pasajero1.setNombres("Alex");
        pasajero1.setApellidos("Simanca");
        pasajero1.setNumPasaporte("12345");
        pasajero1.setAsiento("A1");
        pasajero1.setEdad(20);

        Pasajero pasajero2 = new Pasajero();
        pasajero2.setNombres("Alejandro");
        pasajero2.setApellidos("Dallos");
        pasajero2.setNumPasaporte("67890");
        pasajero2.setAsiento("B2");
        pasajero2.setEdad(21);

        Vuelo vuelo = new Vuelo("Vuelo001", "V001", "Bogota", "Cali", 100);

        vuelo.agregarPasajero(pasajero1.getNombres(), pasajero1.getApellidos(), pasajero1.getNumPasaporte(), pasajero1.getAsiento(), pasajero1.getEdad());
        vuelo.agregarPasajero(pasajero2.getNombres(), pasajero2.getApellidos(), pasajero2.getNumPasaporte(), pasajero2.getAsiento(), pasajero2.getEdad());

        System.out.println("Número de pasajeros en el vuelo: " + vuelo.obtenerNumeroDePasajeros());

        String pasajeroMasJoven = vuelo.obtenerPasajeroMasJoven();
        System.out.println(pasajeroMasJoven);
    }
}

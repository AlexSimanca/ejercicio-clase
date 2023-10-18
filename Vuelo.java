class Vuelo {
    private String nombre;
    private String codigo;
    private String origen;
    private String destino;
    private int capacidad;
    private Collection<Pasajero> pasajeros;

    public Vuelo(String nombre, String codigo, String origen, destino, int capacidad) {
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
        Pasajero nuevoPasajero = new Pasajero(nombres, apellidos, numPasaporte, asiento, edad);
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
        if (pasajeroMasJoven == null) {
            return "El vuelo está vacío.";
        } else {
            return "El pasajero más joven del vuelo es " + pasajeroMasJoven.getNombres() + " " + pasajeroMasJoven.getApellidos() +
                " (pasaporte: " + pasajeroMasJoven.getNumPasaporte() + "). Tiene " + pasajeroMasJoven.getEdad() + " años y está sentado en el asiento " +
                pasajeroMasJoven.getAsiento() + ".";
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
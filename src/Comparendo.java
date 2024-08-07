public class Comparendo {

    private static final int[] LIMITES_CARRO = {65, 66, 85};
    private static final int[] LIMITES_CAMION = {75, 76, 95};
    private static final int[] LIMITES_MULA = {95, 96, 110};

    private int[] limites;

    public Comparendo(int[] limites) {
        this.limites = limites;
    }

    public Comparendo() {
        this.limites = LIMITES_CARRO;
    }

    public void construirFotoMulta(int velocidad, String tipoVehiculo) {
        int cpa = calcularComparendo(velocidad, tipoVehiculo);
        String txt = enviarCorreoFotomulta(tipoVehiculo);
        if (cpa == -1) {
            System.out.println("No hay cálculo para el tipo de vehículo " + tipoVehiculo + ". Correo: " + txt);
        } else {
            System.out.println("---- El tipo de comparendo es: " + cpa + ". Cuerpo del correo: " + txt);
        }
    }

    public int calcularComparendo(int velocidad, String tipoVehiculo) {
        int[] limites = getLimites(tipoVehiculo);
        if (limites.length == 0) {
            return -1;
        }

        if (velocidad <= limites[0]) {
            return 0;
        } else if (velocidad >= limites[1] && velocidad <= limites[2]) {
            return 1;
        }
        return 2;
    }

    private int[] getLimites(String tipoVehiculo) {
        switch (tipoVehiculo) {
            case "CARRO":
                return LIMITES_CARRO;
            case "CAMION":
                return LIMITES_CAMION;
            case "MULA":
                return LIMITES_MULA;
            default:
                return new int[0];
        }
    }

    public String enviarCorreoFotomulta(String tipoVehiculo) {
        String cuerpoMensaje = "//enviando correo para el tipo " + tipoVehiculo + ".";
        String asunto = "//asunto: comparendo " + tipoVehiculo;
        return asunto + cuerpoMensaje;
    }
}

package service_layer_automation.common;

public class CentiToFaren {

    /**
     * Converts temperature from kevin to celsius
     *
     * @param tempInKelvin
     * @return temperature in celsius format
     */
    public static int conversion(float tempInKelvin) {
        int tempInCenti = (int) (tempInKelvin - 273.15);
        return tempInCenti;
    }
}
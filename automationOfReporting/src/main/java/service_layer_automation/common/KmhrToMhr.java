package service_layer_automation.common;

public class KmhrToMhr {

    /**
     * Converts km/hr to m/s
     *
     * @param windSpeed
     * @return speed in meter per second
     */
    public static int conversion(int windSpeed) {
        return windSpeed * 5 / 18;
    }
}
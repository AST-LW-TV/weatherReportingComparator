package service_layer_automation.common;

public class CentiToFaren {

    public static int conversion(float tempInKelvin){
        int tempInCenti=(int)(tempInKelvin-273.15);
        return tempInCenti;
    }

}

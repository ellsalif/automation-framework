package automation.utils;

import automation.drivers.DriverSingleton;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Random;


public class Utils {
    public  static String decode64(String encodedStr)
    {
        Base64.Decoder decoder = Base64.getDecoder();
        return  new String(decoder.decode(encodedStr.getBytes()));
    }

    public  static boolean takeScreenshot(){

        File file = ((TakesScreenshot) DriverSingleton.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileCopyUtils.copy(file, new File(Constants.SCREENSHOTS_FOLDER+ genererateRandomString(Constants.LENGTH)+".png"));
            return  true;
        } catch (IOException e) {
            return false;
        }

    }

    public  static  String genererateRandomString(int length){
        String seedChars ="AZERTYUIOPQSDFGHJKLMWXCVBN";
        StringBuilder sb = new StringBuilder();
        int i=0 ;
        Random random = new Random();
        while (i< length)
        {
            sb.append(seedChars.charAt(random.nextInt(seedChars.length())));
            i++;
        }
 return sb.toString();
    }
}

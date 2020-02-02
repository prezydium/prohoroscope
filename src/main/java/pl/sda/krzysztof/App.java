package pl.sda.krzysztof;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Wprowadź swój znak zodiaku:");
        String userInput = sc.next();
        String requestResult = Connector.getPage(userInput);
        String horoscopeMessage = "";
        if (!requestResult.equals(Connector.NOT_FOUND)){
            horoscopeMessage = HoroscopeExtractor.getHoroscopeText(requestResult);
        }
        System.out.println(horoscopeMessage);
    }

    private static void testHoroscopeExtractor(){
        String horoscopeText = HoroscopeExtractor.getHoroscopeText("TRALALALA LALA!");
        System.out.println(horoscopeText);

    }
}

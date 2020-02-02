package pl.sda.krzysztof;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hej, jak się zwiesz?");
        String userName = sc.next();
        System.out.println("Którego dnia miesiąca się urodziłeś?");
        Integer day = sc.nextInt();
        sc.nextLine();
        System.out.println("W którym miesiącu się urodziłeś? Podaj liczbę");
        Integer month = sc.nextInt();
        String sign = ZodiacSignRecogniser.getSign(day, month);

        String requestResult = Connector.getPage(sign);
        String horoscopeMessage = "";
        if (!requestResult.equals(Connector.NOT_FOUND)) {
            horoscopeMessage = HoroscopeExtractor.getHoroscopeText(requestResult);
        }
        System.out.println(horoscopeMessage);
    }

    private static void testHoroscopeExtractor() {
        String horoscopeText = HoroscopeExtractor.getHoroscopeText("TRALALALA LALA!");
        System.out.println(horoscopeText);

    }
}

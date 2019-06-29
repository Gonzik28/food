import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class BotTest {

    @Test
    public void test() {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        String foodOfTheDay = null;
        switch (dayOfWeek) {
            case 1:
                foodOfTheDay = "Тайская еда";
                break;
            case 2:
                foodOfTheDay = "Барбекю-бургер";
                break;
            case 3:
                foodOfTheDay = "Индийская кухня";
                break;
            case 4:
                foodOfTheDay = "Пицца";
                break;
            case 5:
                foodOfTheDay = "Китайская еда";
                break;
            case 6:
                foodOfTheDay = "Хлопья";
                break;
            case 7:
                foodOfTheDay = "Побалуй себя";
                break;
        }
        System.out.println(foodOfTheDay);
    }
}
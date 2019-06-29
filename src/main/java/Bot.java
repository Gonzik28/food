import com.fasterxml.jackson.annotation.JsonFormat;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Calendar;
import java.util.Date;


public class Bot extends TelegramLongPollingBot {
    private JsonFormat.Value DateTimeFormat;

    public static void main(String[] args) {
        ApiContextInitializer.init(); // Инициализируем апи
        TelegramBotsApi botapi = new TelegramBotsApi();
        try {
            botapi.registerBot(new Bot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "USER";
        //возвращаем юзера
    }

    @Override
    public void onUpdateReceived(Update e) {
        // Тут будет то, что выполняется при получении сообщения
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
        //TODO chatId
        sendMsg("1", foodOfTheDay);

    }

    @Override
    public String getBotToken() {
        return "YOUR_BOT_TOKEN";
        //Токен бота
    }

    public synchronized void sendMsg(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}

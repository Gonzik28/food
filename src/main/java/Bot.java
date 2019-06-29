import com.fasterxml.jackson.annotation.JsonFormat;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;


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
            int dayOfWeek = LocalDate.getDayOfWeek();
            Locale locale = Locale.US;
            DateTimeFormatter formatterOutput = DateTimeFormat.forPattern("E").withLocale(locale);
            String output = formatterOutput.print(localDate);
            String outputQuebecois = formatterOutput.withLocale(Locale.CANADA_FRENCH).print(localDate);
            if equals(String dayOfWeek, String "Понедельник"){
                System.out.print("Тайская еда");
            }
            if equals(String dayOfWeek, String "Вторник"){
                System.out.print("Барбекю-бургер");
            }
            if equals(String dayOfWeek, String "Среда"){
                System.out.print("Индийская кухня");
            }
            if equals(String dayOfWeek, String "Четверг"){
                System.out.print("Пицца");
            }
            if equals(String dayOfWeek, String "Пятница"){
                System.out.print("Китайская еда");
            }
            if equals(String dayOfWeek, String "Суббота"){
                System.out.print("Хлопья");
            }
            if equals(String dayOfWeek, String "Воскресенье"){
                System.out.print("Побалуй себя");
            }


            String message = "test";
            Throwable update;
            sendMsg(update.getMessage().getChatId().toString(), message);

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
}

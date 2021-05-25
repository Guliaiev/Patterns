package ru.netology;


import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;

@Data


public class DataGenerator {
    private DataGenerator() {
    }

    public static Faker faker = new Faker(new Locale("ru"));



    public static String forwardDate(int plusDays) {
        LocalDate today = LocalDate.now();
        LocalDate newDate = today.plusDays(plusDays);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return formatter.format(newDate);

    }
    public static String makeName() {
        faker = new Faker(new Locale("ru"));
        return faker.name().fullName();
    }
    public static String makePhone() {
        faker = new Faker(new Locale("ru"));
        return faker.phoneNumber().phoneNumber();
    }
    public static String makeCity() {
        String[] myCityList = new String[]{
                "Абакан", "Анадырь", "Архангельск", "Астрахань", "Барнаул", "Белгород", "Биробиджан", "Благовещенск", "Брянск",
                "Великий Новгород", "Владивосток", "Владикавказ", "Владимир", "Волгоград", "Вологда", "Воронеж", "Горно-Алтайск",
                "Грозный", "Екатеринбург", "Иваново", "Ижевск", "Иркутск", "Йошкар-Ола", "Казань", "Калининград", "Калуга", "Кемерово",
                "Киров", "Кострома", "Краснодар", "Красноярск", "Курган", "Курск", "Кызыл", "Липецк", "Магадан", "Магас", "Майкоп",
                "Махачкала", "Москва", "Мурманск", "Нальчик", "Нарьян-Мар", "Нижний Новгород", "Новосибирск", "Омск", "Орёл", "Оренбург",
                "Пенза", "Пермь", "Петрозаводск", "Петропавловск-Камчатский", "Псков", "Ростов-на-Дону", "Рязань", "Салехард", "Самара",
                "Санкт-Петербург", "Саранск", "Саратов", "Севастополь", "Симферополь", "Смоленск", "Ставрополь", "Сыктывкар",
                "Тамбов", "Тверь", "Томск", "Тула", "Тюмень", "Улан-Удэ", "Ульяновск", "Уфа", "Хабаровск", "Ханты-Мансийск", "Чебоксары",
                "Челябинск", "Черкесск", "Чита", "Элиста", "Южно-Сахалинск", "Якутск", "Ярославль"};
        int city = (int) Math.floor(Math.random() * myCityList.length);
        return myCityList[city];
    }

    public static void correctFieldsCheks (){
        String name = DataGenerator.makeName();
        String phone = DataGenerator.makePhone();
        String city = DataGenerator.makeCity();
        $("[data-test-id=city] input").setValue(city);
        $("[data-test-id=date] input").sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").sendKeys(DataGenerator.forwardDate(3));
        $("[data-test-id=name] input").setValue(name);
        $("[data-test-id=phone] input").setValue(phone);
    }

    public static void clickButton(){
        $("[data-test-id=agreement]").click();
        $(".button__text").click();
    }
}


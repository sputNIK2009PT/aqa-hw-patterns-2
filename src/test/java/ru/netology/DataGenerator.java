package ru.netology;

import com.github.javafaker.Faker;
import lombok.Value;
import java.util.Locale;

public class DataGenerator {
    private static final Faker Faker = new Faker(new Locale("ru"));

    private DataGenerator() {
    }

    public static String getRandomLogin(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + "." +  faker.name().firstName();
    }

    public static String getRandomPassword() {
        return Faker.internet().password();
    }

    public static class Registration {
        private Registration() {
        }

        public static RegistrationDto getUser(String locale) {
            return new RegistrationDto(getRandomLogin(locale), getRandomPassword(), locale);
        }

        public static RegistrationDto getRegisteredUser(String status) {
            return ApiJson.sendRequest(getUser(status));
        }
    }
    @Value
    public static class RegistrationDto {
        String login;
        String password;
        String status;
    }
}

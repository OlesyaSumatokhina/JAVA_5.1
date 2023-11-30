import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
        // не зарегистрированный пользователь + начисление 1%
    void shouldCalculateForNotRegisteredAndUnderLimit() {
        BonusService service = new BonusService();


        long amount = 1000;
        boolean registered = false;
        long expected = 10;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
        // не зарегистрированный пользователь + максимальное количество бонусов
    void shouldCalculateForNotRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 60_000;
        boolean registered = false;
        long expected = 500;


        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
        // не зарегистрированный пользователь + без начисления бонусов
    void shouldCalculateForNotRegisteredAndMinAmount() {
        BonusService service = new BonusService();

        long amount = 99;
        boolean registered = false;
        long expected = 0;


        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
        // зарегистрированный пользователь + без начисления бонусов
    void shouldCalculateForRegisteredAndMinAmount() {
        BonusService service = new BonusService();

        long amount = 99;
        boolean registered = false;
        long expected = 0;


        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }
}
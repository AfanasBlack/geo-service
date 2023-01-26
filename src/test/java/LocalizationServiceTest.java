import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceTest {
    @Test
    public void locationRu() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();

        String result = localizationService.locale(Country.RUSSIA);
        Assertions.assertEquals("Добро пожаловать", result);
    }

    @Test
    public void locationUSA() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();

        String result = localizationService.locale(Country.USA);
        Assertions.assertEquals("Welcome", result);
    }
}

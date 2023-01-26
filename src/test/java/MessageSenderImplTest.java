import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;

public class MessageSenderImplTest {

    @Test
    public void textRus() {
        GeoService geoService = Mockito.mock(GeoService.class);
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);

        Mockito.when(geoService.byIp(Mockito.anyString())).thenReturn(new Location("Moscow", Country.RUSSIA, "Arbat", 13));
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать в Россию! ");
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome to USA! ");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        String result = messageSender.send(new HashMap<String, String>());

        Assertions.assertEquals("Добро пожаловать в Россию! ", result);
    }

    @Test
    public void textEng() {
        GeoService geoService = Mockito.mock(GeoService.class);
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);

        Mockito.when(geoService.byIp(Mockito.anyString())).thenReturn(new Location("Chicago", Country.USA, "Bayside", 1101));
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать в Россию! ");
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome to USA! ");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        String result = messageSender.send(new HashMap<String, String>());

        Assertions.assertEquals("Welcome to USA! ", result);
    }
}

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceTest {

    @Test
    public void ipRu() {
        GeoServiceImpl geoService = new GeoServiceImpl();

        Location location = geoService.byIp("172.56.45.12");
        Assertions.assertEquals(Country.RUSSIA, location.getCountry());
    }

    @Test
    public void ipUsa() {
        GeoServiceImpl geoService = new GeoServiceImpl();

        Location location = geoService.byIp("96.456.34.57");
        Assertions.assertEquals(Country.USA, location.getCountry());
    }
}

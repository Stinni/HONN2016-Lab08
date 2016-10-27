package is.ru.honn.tube.test;

import is.ru.honn.tube.data.ContentDataGateway;
import is.ru.honn.tube.domain.Content;
import is.ruframework.data.RuDataAccessFactory;
import is.ruframework.domain.RuException;

import java.util.logging.Logger;
import java.util.Date;

/**
 * Created by KristinnHeiðar on 26.10.2016.
 */
public class Test1
{
    public static void main(String[] args)
    {
        Logger log = Logger.getLogger("Test");
        RuDataAccessFactory factory = null;
        try
        {
            factory = RuDataAccessFactory.getInstance("data.xml");
        }
        catch (RuException e)
        {
            log.severe("Unable to load data specification in data.xml - " + e.getMessage());
            log.info("Exiting... bye!");
            return;
        }
        ContentDataGateway contentDataGateway =
                (ContentDataGateway)factory.getDataAccess("contentDataAccess");


        contentDataGateway.add(
                new Content("Title1", "Link1", "Description1", new Date(), "Author1"));
        contentDataGateway.add(
                new Content("Title2", "Link2", "Description2", new Date(), "Author2"));
        contentDataGateway.add(
                new Content("Title3", "Link3", "Description3", new Date(), "Author3")); }
}

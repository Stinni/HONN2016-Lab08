package is.ru.honn.tube.data;

import is.ruframework.data.RuDataAccess;
import is.ru.honn.tube.domain.Content;

import java.util.List;

/**
 * Created by KristinnHeiðar on 26.10.2016.
 */
public interface ContentDataGateway extends RuDataAccess
{
    public int add(Content content);
    public List<Content> getContents();
}

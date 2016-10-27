package is.ru.honn.tube.data;

import is.ru.honn.tube.domain.Content;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import is.ruframework.data.RuData;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

/**
 * Created by KristinnHeiðar on 26.10.2016.
 */
public class ContentData extends RuData implements ContentDataGateway
{
    public int add(Content content)
    {
        SimpleJdbcInsert insertContent =
                new SimpleJdbcInsert(getDataSource())
                        .withTableName("contents")
                        .usingGeneratedKeyColumns("id");


        Map<String, Object> parameters = new HashMap<String, Object>(5);
        parameters.put("title", content.getTitle());
        parameters.put("link", content.getLink());
        parameters.put("description", content.getDescription());
        parameters.put("pubdate", content.getPubDate());
        parameters.put("author", content.getAuthor());
        int returnKey = 0;
        try
        {
            returnKey = insertContent.executeAndReturnKey(parameters).intValue();
        }
        catch (DataIntegrityViolationException divex)
        {
            // Change this to updating the object...!
            log.warning("Duplicate entry");
        }
        return returnKey;

    }


    public List getContents()
    {
        return null;
    }
}
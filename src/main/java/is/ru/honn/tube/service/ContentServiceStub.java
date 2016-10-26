package is.ru.honn.tube.service;

import java.util.ArrayList;
import java.util.List;

import is.ru.honn.tube.domain.Content;

public class ContentServiceStub implements ContentService
{
  List<Content> col = new ArrayList<Content>();

  public void addContent(Content content)
  {
    col.add(content);
  }

  public List<Content> getContents()
  {
    return col;
  }
}

package is.ru.honn.tube.service;

import is.ru.honn.tube.domain.Content;

import java.util.List;

public interface ContentService
{
  public void addContent(Content content);
  public List<Content> getContents();
}

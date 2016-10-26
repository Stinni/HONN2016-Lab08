package is.ru.honn.tube.feeds;

import is.ru.honn.tube.domain.Content;

public interface FeedHandler
{
  public void processContent(Content content);
}

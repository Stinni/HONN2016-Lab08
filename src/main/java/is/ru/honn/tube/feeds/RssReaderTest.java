package is.ru.honn.tube.feeds;

import is.ru.honn.tube.domain.Content;

public class RssReaderTest implements FeedHandler
{
  public static void main(String[] args) throws FeedException
  {
    if (args.length == 0)
    {
      System.out.println("RssReaderTest takes URL as parameter.");
      return;
    }
    new RssReaderTest(args[0]);
  }

  public RssReaderTest(String source) throws FeedException
  {
    AbstractFeedReader rssReader = new RssReader();
    rssReader.setFeedHandler(this);
    rssReader.read(source);
  }


  public void processContent(Content content)
  {
    System.out.println(content);
  }
}

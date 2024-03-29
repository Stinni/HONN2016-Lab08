package is.ru.honn.tube.feeds;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Iterator;

import is.ru.honn.tube.domain.Content;
import com.sun.syndication.io.XmlReader;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndEntry;

public class RssExample
{
  public static void main(String[] args) { new RssExample(args[0]); }

  public RssExample(String importURL)
  {
    URL feedUrl = null;
    try
    {
      feedUrl = new URL(importURL);
    }
    catch (MalformedURLException murlex)
    {
      System.out.println("Villa við lestur URLs");
    }

    SyndFeedInput input = new SyndFeedInput();
    SyndFeed syndFeed = null;
    try
    {
      syndFeed = input.build(new XmlReader(feedUrl));
    }
    catch (Exception ioex)
    {
      System.out.println("Villa við að lesa URL");
    }

    List list = syndFeed.getEntries();
    Iterator i = list.iterator();
    SyndEntry ent = null;
    Content content;
    while (i.hasNext())
    {
      ent = (SyndEntry) i.next();
      System.out.println(ent.getTitle());
      System.out.println(ent.getDescription().getValue());
    }
  }
}

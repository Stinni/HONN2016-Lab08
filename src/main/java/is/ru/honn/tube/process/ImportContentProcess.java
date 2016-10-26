package is.ru.honn.tube.process;


import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;

import is.ruframework.process.RuAbstractProcess;
import is.ru.honn.tube.feeds.FeedHandler;
import is.ru.honn.tube.feeds.FeedException;
import is.ru.honn.tube.feeds.FeedReader;
import is.ru.honn.tube.service.ContentService;
import is.ru.honn.tube.domain.Content;

public class ImportContentProcess extends RuAbstractProcess implements FeedHandler
{
  protected ContentService contentService;
  FeedReader reader;
  MessageSource msg;

  public void beforeProcess()
  {
    ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:app.xml");
    contentService = (ContentService)ctx.getBean("contentService");
    reader = (FeedReader)ctx.getBean("feedReader");
    reader.setFeedHandler(this);
    msg = (MessageSource)ctx.getBean("messageSource");
    log.info("processbefore: " + getProcessContext().getProcessName());
  }
  
  public void processContent(Content content)
  {
    contentService.addContent(content);
  }

  public void startProcess()
  {
    log.info("processstart: " + getProcessContext().getProcessName());
    try
    {
      reader.read(getProcessContext().getImportURL());
    }
    catch (FeedException e)
    {
      log.severe("process read error");
      log.severe(e.getMessage());
    }
  }

  public void afterProcess()
  {
    List<Content> col = contentService.getContents();
    for (Content cnt: col)
    {
      System.out.println(cnt);
    }
  }
}
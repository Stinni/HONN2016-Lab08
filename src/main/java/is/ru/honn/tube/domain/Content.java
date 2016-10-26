package is.ru.honn.tube.domain;

import java.util.Date;

public class Content
{
  private int id;
  private String title;
  private String link;
  private String description;
  private Date pubDate;
  private String author;

  public Content()
  {
  }

  public Content(int id, String title, String link, String description, Date pubDate, String author)
  {
    this.id = id;
    this.title = title;
    this.link = link;
    this.description = description;
    this.pubDate = pubDate;
    this.author = author;
  }

  public Content(String title, String link, String description, Date pubDate, String author)
  {
    this.title = title;
    this.link = link;
    this.description = description;
    this.pubDate = pubDate;
    this.author = author;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public String getLink()
  {
    return link;
  }

  public void setLink(String link)
  {
    this.link = link;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public Date getPubDate()
  {
    return pubDate;
  }

  public void setPubDate(Date pubDate)
  {
    this.pubDate = pubDate;
  }

  public String getAuthor()
  {
    return author;
  }

  public void setAuthor(String author)
  {
    this.author = author;
  }

  public String toString()
  {
    return title;
  }
}



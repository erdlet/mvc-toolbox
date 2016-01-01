package de.chkal.mvctoolbox.jsp;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;

public class HtmlWriter {

  private final JspWriter writer;

  public HtmlWriter(JspContext context) {
    this(context.getOut());
  }

  public HtmlWriter(JspWriter writer) {
    this.writer = writer;
  }

  public HtmlWriter beginStartTag(String name) throws IOException {
    writer.write("<");
    writer.write(name);
    return this;
  }

  public HtmlWriter attribute(String name) throws IOException {
    return attribute(name, name);
  }

  public HtmlWriter attribute(String name, Object value) throws IOException {
    writer.write(" ");
    writer.write(name);
    if (value != null) {
      writer.write("=\"");
      writer.write(value.toString());
      writer.write("\"");
    }
    return this;
  }

  public HtmlWriter selfClose() throws IOException {
    writer.write("/>");
    return this;
  }

}

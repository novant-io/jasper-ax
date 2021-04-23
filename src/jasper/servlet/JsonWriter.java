//
// Copyright (c) 2021, Novant LLC
// Licensed under the MIT License
//
// History:
//   23 Apr 2021  Andy Frank  Creation
//

package jasper.servlet;

import java.io.*;
import java.util.*;

/**
 * JsonWriter.
 */
public final class JsonWriter
{
  /** Constructor. */
  JsonWriter(OutputStream out)
  {
    this.out = new PrintWriter(out);
  }

  /** Flush underlying output stream. */
  JsonWriter flush() throws IOException
  {
    out.flush();
    return this;
  }

  /** Close underlying output stream. */
  JsonWriter close() throws IOException
  {
    out.close();
    return this;
  }

  /** Write given char to output stream. */
  JsonWriter write(char val) throws IOException
  {
    out.print(val);
    return this;
  }

  /** Write given name as "<name>": to output stream. */
  JsonWriter writeKey(String name) throws IOException
  {
    out.print('\"');
    out.print(name);  // TODO: escape
    out.print('\"');
    out.print(':');
    return this;
  }

  /** Write given int to output stream. */
  JsonWriter writeVal(int val) throws IOException
  {
    out.print(val);
    return this;
  }

  /** Write given char to output stream. */
  JsonWriter writeVal(String val) throws IOException
  {
    // TODO: escape
    out.print('\"');
    out.print(val);
    out.print('\"');
    return this;
  }

  /** Write given object to output stream. */
  JsonWriter writeVal(HashMap val) throws IOException
  {
    out.print('{');
    int i = 0;

    Iterator iter = val.entrySet().iterator();
    while (iter.hasNext())
    {
      if (i > 0) out.print(',');
      Map.Entry e = (Map.Entry)iter.next();
      writeKey((String)e.getKey());
      writeVal(e.getValue().toString());
      i++;
    }

    out.print('}');
    return this;
  }

  private PrintWriter out;
}


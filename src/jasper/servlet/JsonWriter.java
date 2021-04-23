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

  /** Write given object to output stream. */
  JsonWriter write(Object val) throws IOException
  {
    if (val instanceof HashMap) return writeHashMap((HashMap)val);

    // unsupported
    throw new IOException("Unsupported value type '" + val + "'");
  }

  private JsonWriter writeHashMap(HashMap map) throws IOException
  {
    out.print('{');

    Iterator iter = map.entrySet().iterator();
    while (iter.hasNext())
    {
      Map.Entry e = (Map.Entry)iter.next();
      out.print('\"');
      out.print(e.getKey());
      out.print('\"');
      out.print(':');
      // TODO
      out.print("\"" + e.getValue() + "\"");
    }

    out.print('}');
    return this;
  }

  private PrintWriter out;
}


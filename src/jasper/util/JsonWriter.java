//
// Copyright (c) 2021, Novant LLC
// Licensed under the MIT License
//
// History:
//   23 Apr 2021  Andy Frank  Creation
//

package jasper.util;

import java.io.*;
import java.util.*;
import javax.baja.sys.*;

/**
 * JsonWriter.
 */
public final class JsonWriter
{
  /** Constructor. */
  public JsonWriter(OutputStream out)
  {
    this.out = new PrintWriter(out);
  }

  /** Flush underlying output stream. */
  public JsonWriter flush() throws IOException
  {
    out.flush();
    return this;
  }

  /** Close underlying output stream. */
  public JsonWriter close() throws IOException
  {
    out.close();
    return this;
  }

  /** Write given char to output stream. */
  public JsonWriter write(char val) throws IOException
  {
    out.print(val);
    return this;
  }

  /** Write given name as "<name>": to output stream. */
  public JsonWriter writeKey(String name) throws IOException
  {
    out.print('\"');
    out.print(name);  // TODO: escape
    out.print('\"');
    out.print(':');
    return this;
  }

  /** Write given int to output stream. */
  public JsonWriter writeVal(int val) throws IOException
  {
    out.print(val);
    return this;
  }

  /** Write given object to output stream. */
  public JsonWriter writeVal(Object val) throws IOException
  {
    // null
    if (val == null)
    {
      out.print("null");
      return this;
    }

    // String
    if (val instanceof String)
    {
      // TODO: escape
      out.print('\"');
      out.print(val);
      out.print('\"');
      return this;
    }

    // BIBoolean
    if (val instanceof BIBoolean)
    {
      BIBoolean b = (BIBoolean)val;
      out.print(b.getBoolean());
      return this;
    }

    // BINumeric
    if (val instanceof BINumeric)
    {
      BINumeric n = (BINumeric)val;
      out.print(n.getNumeric());
      return this;
    }

    // HashMap
    if (val instanceof HashMap)
    {
      HashMap map = (HashMap)val;
      out.print('{');
      int i = 0;

      Iterator iter = map.entrySet().iterator();
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

    // unsupported type
    throw new IOException("Unsupported type '" + val + "'");
  }

  private PrintWriter out;
}


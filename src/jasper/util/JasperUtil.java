//
// Copyright (c) 2021, Novant LLC
// Licensed under the MIT License
//
// History:
//   23 Apr 2021  Andy Frank  Creation
//

package jasper.util;

import java.io.*;
import javax.baja.io.*;
import javax.baja.status.*;
import javax.baja.sys.*;
import javax.baja.util.*;
import javax.baja.web.*;
import javax.servlet.http.*;

/**
 * JasperUtil
 */
public final class JasperUtil
{

////////////////////////////////////////////////////////////////
// BComponent
////////////////////////////////////////////////////////////////

  /**
   * Get the JSON representation for the current value
   * of given point, or 'null' if not available.
   */
  static Object getPointJsonValue(BComponent c)
  {
    Object out = c.get("out");

    if (out instanceof BStatusValue)
    {
      // if status != ok return "NaN"
      BStatusValue val = (BStatusValue)out;
      if (!val.getStatus().isOk()) return "NaN";

      // return as BStatusValue and let JsonWriter encode
      return val;
    }

    // if we get here then assume no value
    return null;
  }

////////////////////////////////////////////////////////////////
// Servlet
////////////////////////////////////////////////////////////////

  /** Convenience for sendErr(404) */
  static void sendNotFound(WebOp op) throws IOException
  {
    sendErr(op, 404, "Not Found");
  }

  /** Send an error repsponse as JSON with code and msg. */
  static void sendErr(WebOp op, int code, String msg) throws IOException
  {
    HttpServletResponse res = op.getResponse();
    res.setStatus(code);
    res.setHeader("Content-Type", "application/json");
    op.getHtmlWriter().w("{\"err_msg\":\"").safe(msg).w("\"}").flush();
  }

  /** Read content from request. */
  static String readContent(WebOp op) throws IOException
  {
    StringBuffer sb = new StringBuffer();
    InputStream in = new BufferedInputStream(op.getRequest().getInputStream());
    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    String line = null;
    while ((line = br.readLine()) != null)
    {
      sb.append(line);
    }
    return sb.toString();
  }

////////////////////////////////////////////////////////////////
// URI
////////////////////////////////////////////////////////////////

  /** Split a path string into array. */
  static String[] splitPath(String path)
  {
    // TODO FIXIT: there _has_ to be a better way todo this????
    String[] orig = TextUtil.splitAndTrim(path, '/');

    // get non-empty size
    int size = 0;
    for (int i=0; i<orig.length; i++)
      if (orig[i].length() > 0) size++;

    // filter out empty
    String[] acc = new String[size];
    int p = 0;
    for (int i=0; i<orig.length; i++)
      if (orig[i].length() > 0) acc[p++] = orig[i];
    return acc;
  }
}
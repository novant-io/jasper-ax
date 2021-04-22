//
// Copyright (c) 2021, Novant LLC
// Licensed under the MIT License
//
// History:
//   21 Apr 2021  Andy Frank  Creation
//

package jasper.servlet;

import java.io.*;
import javax.baja.io.*;
import javax.baja.sys.*;
import javax.baja.web.*;
import javax.servlet.http.*;

/**
 * BJasperServlet
 */
public final class BJasperServlet extends BWebServlet
{
  /*-
  class BJasperServlet
  {
    properties
    {
    }

    actions
    {
    }
  }
   -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $jasper.servlet.BJasperServlet(2852803851)1.0$ @*/
/* Generated Wed Apr 21 15:57:23 EDT 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////

  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BJasperServlet.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  /**
   * Default constructor
   */
  public BJasperServlet()
  {
    super.setServletName("jasper");
    super.setFlags(getSlot("servletName"), Flags.READONLY | Flags.SUMMARY);
  }

////////////////////////////////////////////////////////////////
// Servlet
////////////////////////////////////////////////////////////////

  public void doGet(WebOp op) throws IOException
  {
    HttpServletResponse res = op.getResponse();
    res.setHeader("Content-Type", "text/plain");
    res.setStatus(200);

    HtmlWriter out = op.getHtmlWriter();
    out.w("Hello, World! from Jasper!");
    out.flush();
  }

  public void doPost(WebOp op) throws IOException
  {
  }
}
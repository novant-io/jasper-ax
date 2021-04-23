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
import javax.baja.util.*;
import javax.baja.web.*;
import javax.servlet.http.*;
import jasper.service.*;

/**
 * BJasperServlet
 */
public final class BJasperServlet extends BWebServlet
{
  /*-
  class BJasperServlet
  {
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

////////////////////////////////////////////////////////////////
// Constructor
////////////////////////////////////////////////////////////////

  /** Constructor. */
  public BJasperServlet()
  {
    super.setServletName("jasper");
    super.setFlags(getSlot("servletName"), Flags.READONLY | Flags.SUMMARY);
  }

  /** Set backing index */
  public void setIndex(JasperIndex index) { this.index = index; }

////////////////////////////////////////////////////////////////
// Servlet
////////////////////////////////////////////////////////////////

  public void doPost(WebOp op) throws IOException
  {
    HttpServletRequest req = op.getRequest();
    String[] path = JasperUtil.splitPath(req.getPathInfo());

    // sanity check path is long enough
    if (path.length < 3)
    {
      JasperUtil.sendNotFound(op);
      return;
    }

    // key off version
    if (path[1].equals("v1"))
    {
      if (path[2].equals("points")) { doPoints(op); return; }
    }

    // if we get here then 404
    JasperUtil.sendNotFound(op);
  }

  /** Service /v1/points request. */
  private void doPoints(WebOp op) throws IOException
  {
    HttpServletResponse res = op.getResponse();
    res.setStatus(200);
    res.setHeader("Content-Type", "application/json");

    // TODO
    JsonWriter json = new JsonWriter(res.getOutputStream());
    json.write(index.map).flush().close();
  }

////////////////////////////////////////////////////////////////
// Attributes
////////////////////////////////////////////////////////////////

  private JasperIndex index;
}
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
import javax.baja.naming.*;
import javax.baja.sys.*;
import javax.baja.util.*;
import javax.baja.web.*;
import javax.servlet.http.*;
import jasper.service.*;
import jasper.util.*;

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
      if (path[2].equals("about"))  { doAbout(op);  return; }
      if (path[2].equals("points")) { doPoints(op); return; }
      if (path[2].equals("values")) { doValues(op); return; }
    }

    // if we get here then 404
    JasperUtil.sendNotFound(op);
  }

  /** Service /v1/about request. */
  private void doAbout(WebOp op) throws IOException
  {
    HttpServletResponse res = op.getResponse();
    res.setStatus(200);
    res.setHeader("Content-Type", "application/json");

    JsonWriter json = new JsonWriter(res.getOutputStream());
    json.write('{');

    BModule baja = BComponent.TYPE.getModule();
    json.writeKey("vendor").writeVal("Tridium").write(',');
    json.writeKey("model").writeVal("Niagara AX").write(',');
    json.writeKey("version").writeVal(baja.getVendorVersion().toString());

    BModule module = BJasperService.TYPE.getModule();
    json.writeKey("moduleName").writeVal(module.getModuleName()).write(',');
    json.writeKey("moduleVersion").writeVal(module.getVendorVersion().toString()).write(',');

    json.write('}');
    json.flush().close();
  }

  /** Service /v1/points request. */
  private void doPoints(WebOp op) throws IOException
  {
    String[] ids = index.ids();

    HttpServletResponse res = op.getResponse();
    res.setStatus(200);
    res.setHeader("Content-Type", "application/json");

    JsonWriter json = new JsonWriter(res.getOutputStream());
    json.write('{');
    json.writeKey("size").writeVal(ids.length).write(',');
    json.writeKey("points").write('[');
    for (int i=0; i<ids.length; i++)
    {
      JasperPoint p = index.get(ids[i]);
      if (i > 0) json.write(',');
      json.write('{');
      json.writeKey("id").writeVal(p.id).write(',');
      json.writeKey("name").writeVal(p.name).write(',');
      json.writeKey("path").writeVal(p.path);
      if (p.unit != null)
      {
        json.write(',');
        json.writeKey("unit").writeVal(p.unit);
      }
      json.write('}');
    }
    json.write(']');
    json.write('}');
    json.flush().close();
  }

  /** Service /v1/values request. */
  private void doValues(WebOp op) throws IOException
  {
    BJasperService service = (BJasperService)this.getParent();
    String[] ids = index.ids();

    HttpServletResponse res = op.getResponse();
    res.setStatus(200);
    res.setHeader("Content-Type", "application/json");

    JsonWriter json = new JsonWriter(res.getOutputStream());
    json.write('{');
    json.writeKey("size").writeVal(ids.length).write(',');
    json.writeKey("values").write('[');
    for (int i=0; i<ids.length; i++)
    {
      JasperPoint p = index.get(ids[i]);
      BOrd h = JasperUtil.getOrdFromId(p.id);
      BComponent c = (BComponent)h.resolve(service).get();
      Object val = JasperUtil.getPointJsonValue(c);

      if (i > 0) json.write(',');
      json.write('{');
      json.writeKey("id").writeVal(p.id).write(',');
      json.writeKey("val").writeVal(val);
      json.write('}');
    }
    json.write(']');
    json.write('}');
    json.flush().close();
  }

////////////////////////////////////////////////////////////////
// Attributes
////////////////////////////////////////////////////////////////

  private JasperIndex index;
}
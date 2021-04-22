//
// Copyright (c) 2021, Novant LLC
// Licensed under the MIT License
//
// History:
//   21 Apr 2021  Andy Frank  Creation
//

package jasper.service;


import javax.baja.log.*;
import javax.baja.sys.*;
import jasper.servlet.*;

/**
 * JasperService.
 */
public final class BJasperService extends BAbstractService
{
  /*-
  class BJasperService
  {
    properties
    {
      servlet: BJasperServlet
        default{[ new BJasperServlet() ]}
    }

    actions
    {
      rebuildIndex()
    }
  }
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $jasper.service.BJasperService(4038923251)1.0$ @*/
/* Generated Wed Apr 21 21:32:17 EDT 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

////////////////////////////////////////////////////////////////
// Property "servlet"
////////////////////////////////////////////////////////////////

  /**
   * Slot for the <code>servlet</code> property.
   * @see jasper.service.BJasperService#getServlet
   * @see jasper.service.BJasperService#setServlet
   */
  public static final Property servlet = newProperty(0, new BJasperServlet(),null);

  /**
   * Get the <code>servlet</code> property.
   * @see jasper.service.BJasperService#servlet
   */
  public BJasperServlet getServlet() { return (BJasperServlet)get(servlet); }

  /**
   * Set the <code>servlet</code> property.
   * @see jasper.service.BJasperService#servlet
   */
  public void setServlet(BJasperServlet v) { set(servlet,v,null); }

////////////////////////////////////////////////////////////////
// Action "rebuildIndex"
////////////////////////////////////////////////////////////////

  /**
   * Slot for the <code>rebuildIndex</code> action.
   * @see jasper.service.BJasperService#rebuildIndex()
   */
  public static final Action rebuildIndex = newAction(0,null);

  /**
   * Invoke the <code>rebuildIndex</code> action.
   * @see jasper.service.BJasperService#rebuildIndex
   */
  public void rebuildIndex() { invoke(rebuildIndex,null,null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////

  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BJasperService.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

////////////////////////////////////////////////////////////////
// BAbstractService
////////////////////////////////////////////////////////////////

  public Type[] getServiceTypes()
  {
    Type[] t = { getType() };
    return t;
  }

  public void serviceStarted() throws Exception
  {
  }

  public void atSteadyState()
  {
    doRebuildIndex();
  }

  public void doRebuildIndex()
  {
    BJasperReindexJob job = new BJasperReindexJob(index);
    try { job.run(null); }
    catch (Exception e) { e.printStackTrace(); }
  }

////////////////////////////////////////////////////////////////
// Attributes
////////////////////////////////////////////////////////////////

  static final Log LOG = Log.getLog("jasper");

  private JasperIndex index = new JasperIndex();
}

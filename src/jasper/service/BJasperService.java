//
// Copyright (c) 2021, Novant LLC
// Licensed under the MIT License
//
// History:
//     Andy Frank  Creation
//

package jasper.service;

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
  }
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $jasper.service.BJasperService(174022339)1.0$ @*/
/* Generated Wed Apr 21 15:57:23 EDT 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

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
  }
}

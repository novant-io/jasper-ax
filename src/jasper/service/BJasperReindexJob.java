//
// Copyright (c) 2021, Novant LLC
// Licensed under the MIT License
//
// History:
//   22 Apr 2021  Andy Frank  Creation
//

package jasper.service;

import javax.baja.job.*;
import javax.baja.control.*;
import javax.baja.naming.*;
import javax.baja.sys.*;

/**
 * BJasperReindexJob
 */
public final class BJasperReindexJob extends BSimpleJob
{
  /*-
  class BJasperReindexJob
  {
  }
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $jasper.service.BJasperReindexJob(2090025795)1.0$ @*/
/* Generated Thu Apr 22 09:22:19 EDT 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////

  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BJasperReindexJob.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

////////////////////////////////////////////////////////////////
// Construction
////////////////////////////////////////////////////////////////

  public BJasperReindexJob() {}

  public BJasperReindexJob(JasperIndex index)
  {
    this.index = index;
  }

////////////////////////////////////////////////////////////////
// BSimpleJob
////////////////////////////////////////////////////////////////

  public void run(Context cx) throws Exception
  {
    // start
    BJasperService.LOG.message("JasperReindexJob started");
    BAbsTime t1 = BAbsTime.now();

    // clear index
    index.clear();

    // scan station for points
    BStation station = Sys.getStation();
    BComponent[] comps = station.getComponentSpace().getAllComponents();
    for (int i=0; i<comps.length; i++)
    {
      BComponent c = comps[i];
      if (c instanceof BNumericPoint || c instanceof BBooleanPoint)
      {
        String id   = c.getHandleOrd().toString();
        String name = c.getName();
        String path = c.getSlotPath().toString().substring(5);
        String unit = null;

        BFacets f = (BFacets)c.get("facets");
        if (f != null) unit = f.gets("units", null);

        JasperPoint point = new JasperPoint(id, name, path, unit);
        index.add(point);
      }
    }

    // complete
    BAbsTime t2 = BAbsTime.now();
    BJasperService.LOG.message("JasperReindexJob complete [" +
      t1.delta(t2) + ", " + index.size() + " points]");
  }

////////////////////////////////////////////////////////////////
// Attributes
////////////////////////////////////////////////////////////////

  private JasperIndex index;
}
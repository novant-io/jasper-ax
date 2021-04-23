//
// Copyright (c) 2021, Novant LLC
// Licensed under the MIT License
//
// History:
//   22 Apr 2021  Andy Frank  Creation
//

package jasper.service;

import java.util.*;
import javax.baja.sys.*;

/**
 * JasperIndex.
 */
public final class JasperIndex
{
  /** Constructor */
  public JasperIndex()
  {
  }

  /** Return number of points in index. */
  public int size()
  {
    return map.size();
  }

  /** Clear all entries from index. */
  public void clear()
  {
    map.clear();
  }

  /** Add a new point to index. */
  public void add(JasperPoint p)
  {
    map.put(p.id, p);
  }

  /** Get current ids in index. */
  public String[] ids()
  {
    // TODO: should we cache this?
    Set keys = map.keySet();
    String[] acc = (String[])keys.toArray(new String[keys.size()]);
    return acc;
  }

  /** Get the point for given id or null if not found. */
  public JasperPoint get(String id)
  {
    return (JasperPoint)map.get(id);
  }

  private HashMap map = new HashMap();
}

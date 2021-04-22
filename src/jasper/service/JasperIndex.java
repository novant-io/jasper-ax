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
  public void add(String path, BComponent point)
  {
    map.put(path, point);
  }

  /** Get the point for given path or null if not found. */
  public BComponent get(String path)
  {
    return (BComponent)map.get(path);
  }

  private HashMap map = new HashMap();
}

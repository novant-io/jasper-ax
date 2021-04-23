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
 * JasperPoint.
 */
public final class JasperPoint
{
  /** Constructor */
  public JasperPoint(String id, String name, String path, String kind, String unit)
  {
    this.id   = id;
    this.name = name;
    this.path = path;
    this.kind = kind;
    this.unit = unit;
  }

  /** Unique id for this point. */
  public final String id;

  /** Name of this point. */
  public final String name;

  /** Path of this point. */
  public final String path;

  /** Kind of this point, bool or num. */
  public final String kind;

  /** Unit for this point or null if not defined. */
  public final String unit;
}

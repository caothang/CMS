/*
 * Copyright (C) 2012 BigB.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see<http://www.gnu.org/licenses/>.
 */
package org.exoplatform.cms.service;

import org.exoplatform.services.jcr.util.IdGenerator;

/**
 * Created by The eXo BigB
 * Author : Vu Duy Tu
 *          duytucntt@gmail.com
 * Jul 26, 2012  
 */
public class Manufacturer {
  public static final String MANUFACTURER = "Manufacturer";

  private String             id;

  private String             name;

  private int                order;

  public Manufacturer() {
    id = MANUFACTURER.concat(IdGenerator.generate());
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }

}

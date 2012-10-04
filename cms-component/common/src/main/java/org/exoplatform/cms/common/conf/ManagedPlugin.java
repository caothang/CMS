/*
 * Copyright (C) 2012 - BigB.
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
package org.exoplatform.cms.common.conf;

import org.exoplatform.container.component.BaseComponentPlugin;
import org.exoplatform.management.annotations.Managed;
import org.exoplatform.management.annotations.ManagedDescription;
import org.exoplatform.management.annotations.ManagedName;

/**
 * A managed plugin base class
 * Created by The BigB
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Jul 18, 2009  
 */
@Managed
public abstract class ManagedPlugin extends BaseComponentPlugin {

  @Managed
  @ManagedName("Name")
  @ManagedDescription("The plugin name")
  public String getName() {
    return super.getName();
  }

  @Managed
  @ManagedName("Description")
  @ManagedDescription("The plugin description")
  public String getDescription() {
    return super.getDescription();
  }

}

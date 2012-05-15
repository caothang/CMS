/***************************************************************************
 * Copyright (C) 2003-2010 eXo Platform SAS.
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
 ***************************************************************************/
package org.exoplatform.cms.webui;

import org.exoplatform.webui.config.annotation.ComponentConfig;
import org.exoplatform.webui.core.lifecycle.UIFormLifecycle;

/**
 * Created by The eXo Platform SAS 
 * Author : Vu Duy Tu 
 *          tu.duy@exoplatform.com 
 * Jun 25, 2010, 3:32:09 PM
 */

@ComponentConfig(
    lifecycle = UIFormLifecycle.class,
    template = "app:/templates/cms/webui/UICMSManagement.gtmpl",
    events = {
    }
)
public class UICMSManagement extends BaseCMSForm {
  public static final String FIELD_SELECT_POLL_SELECTBOX = "selectPoll";


  public UICMSManagement() throws Exception {
    if (this.getId() == null)
      this.setId("UIPollManagement");
  }


}

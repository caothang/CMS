/*
 * Copyright (C) 2003-2012 BigB.
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
package org.exoplatform.cms.webui;

import org.exoplatform.cms.CMSPortletMode;
import org.exoplatform.cms.webui.portlet.UICMSPortlet;
import org.exoplatform.webui.config.annotation.ComponentConfig;
import org.exoplatform.webui.event.Event;
import org.exoplatform.webui.event.EventListener;

/**
 * Created by The BigB
 * Author : Vu Duy Tu
 *          duytucntt@gmail.com
 * Oct 8, 2012  
 */
@ComponentConfig(
    template = "app:/templates/cms/webui/UITopCategoriesProduct.gtmpl"
)
public class UITopCategoriesProduct extends BaseCMSContainer {

  
  
  static public class ReLoadPortletEventActionListener extends EventListener<UITopCategoriesProduct> {
    public void execute(Event<UITopCategoriesProduct> event) throws Exception {
      UITopCategoriesProduct product = event.getSource();
      UICMSPortlet portlet = product.getAncestorOfType(UICMSPortlet.class);
      portlet.setCmsMode(CMSPortletMode.PRD_LIST);
      UIProductContainer prContainer = portlet.findFirstComponentOfType(UIProductContainer.class);
      prContainer.setTypeRender("");
      
      
      
    }
  }
}

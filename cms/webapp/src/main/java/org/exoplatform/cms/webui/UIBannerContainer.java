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

import org.exoplatform.cms.form.UIQuickSearchForm;
import org.exoplatform.webui.config.annotation.ComponentConfig;

/**
 * Created by The BigB.
 * Author : Nguyen Cao Thang
 *          chuasonlam8484@gmail.com
 * Oct 16, 2012  
 */
@ComponentConfig(
                 template = "app:/templates/cms/webui/UIBannerContainer.gtmpl"
               )
public class UIBannerContainer extends BaseCMSContainer {
  
  public UIBannerContainer() throws Exception {
    addChild(UISubNavigation.class, null, null);
    addChild(UIQuickSearchForm.class, null, null);
  }

}

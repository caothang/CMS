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
package org.exoplatform.cms;

import javax.portlet.PortletMode;

/**
 * Created by The BigB
 * Author : Vu Duy Tu
 *          duytucntt@gmail.com
 * Oct 8, 2012  
 */
public class CMSPortletMode extends PortletMode {
  public String _name;

  public final static CMSPortletMode HOME = new CMSPortletMode ("HomePage");
  
  public final static CMSPortletMode PRD_DETAIL = new CMSPortletMode ("ProductDetail");

  public final static CMSPortletMode PRD_LIST = new CMSPortletMode ("ProductList");

  public final static CMSPortletMode SEARCH = new CMSPortletMode ("SearchAdvanced");

  public final static CMSPortletMode BUY_BUILDER = new CMSPortletMode ("BuyBuilder");

  public final static CMSPortletMode ADMIN_PANEL = new CMSPortletMode ("adminPanel");
  
  
  
  public CMSPortletMode(String name) {
    super(name);
    this._name = name;
  }

  public boolean equals(Object object) {
    if ( object instanceof CMSPortletMode )
      return _name.equals(((CMSPortletMode) object)._name);
    else
      return false;
  }
}

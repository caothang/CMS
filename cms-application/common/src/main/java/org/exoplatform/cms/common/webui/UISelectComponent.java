/**
 * Copyright (C) 2003-2007 BigB.
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
 **/
package org.exoplatform.cms.common.webui;

import org.exoplatform.webui.core.UIComponent;

/**
 * Created by The eXo Platform SARL
 * Author : Pham Tuan
 *          tuan.pham@exoplatform.com
 * Aug 29, 2007  
 */
public interface UISelectComponent {
  final public static String TYPE_USER = "0".intern() ;
  final public static String TYPE_MEMBERSHIP = "1".intern() ;
  final public static String TYPE_GROUP = "2".intern() ;
  final public static String TREE_GROUP_ID = "UITreeGroupSelector";
  final public static String BREADCUMB_GROUP_ID = "BreadcumbGroupSelector";
  public void setComponent(UIComponent uicomponent, String[] initParams) ;
}

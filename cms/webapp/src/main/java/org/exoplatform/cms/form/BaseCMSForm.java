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
package org.exoplatform.cms.form;

import org.exoplatform.cms.common.webui.BaseUIForm;
import org.exoplatform.cms.service.CMSService;
import org.exoplatform.cms.webui.portlet.UICMSPortlet;
import org.exoplatform.container.ExoContainerContext;
import org.exoplatform.webui.core.UIComponent;

/**
 * Base class for UIForm used in cms application. Provides convenience methods to access the service
 * 
 * @author Vu Duy Tu
 * @version $Revision$
 */
public class BaseCMSForm extends BaseUIForm {

  private CMSService cmsService;

  /**
   * Get a reference to the forum service
   * 
   * @return
   */
  protected CMSService getCMSService() {
    if (cmsService == null) {
      cmsService = (CMSService) ExoContainerContext.getCurrentContainer().getComponentInstanceOfType(CMSService.class);
    }
    return cmsService;
  }

  /**
   * Set cms service (used by unit tests)
   * 
   * @param cmsService
   */
  protected void setCMSService(CMSService cmsService) {
    this.cmsService = cmsService;
  }

  protected <T extends UIComponent> T openPopup(Class<T> componentType, String popupId, int width, int height) throws Exception {
    UICMSPortlet cmsPortlet = getAncestorOfType(UICMSPortlet.class);
    return openPopup(cmsPortlet, componentType, popupId, width, height);
  }

  protected <T extends UIComponent> T openPopup(Class<T> componentType, int width, int height) throws Exception {
    UICMSPortlet cmsPortlet = getAncestorOfType(UICMSPortlet.class);
    return openPopup(cmsPortlet, componentType, width, height);
  }

  protected <T extends UIComponent> T openPopup(Class<T> componentType, int width) throws Exception {
    return openPopup(componentType, width, 0);
  }

  protected <T extends UIComponent> T openPopup(Class<T> componentType, String popupId, int width) throws Exception {
    return openPopup(componentType, popupId, width, 0);
  }
}

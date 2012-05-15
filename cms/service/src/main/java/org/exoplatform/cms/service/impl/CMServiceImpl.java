/*
 * Copyright (C) 2003-2007 eXo Platform SAS.
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

package org.exoplatform.cms.service.impl;

import org.exoplatform.cms.service.CMSService;
import org.exoplatform.container.xml.InitParams;
import org.exoplatform.ks.common.jcr.KSDataLocation;
import org.exoplatform.management.jmx.annotations.NameTemplate;
import org.exoplatform.management.jmx.annotations.Property;
import org.exoplatform.services.jcr.ext.hierarchy.NodeHierarchyCreator;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.picocontainer.Startable;

@NameTemplate(@Property(key = "service", value = "poll"))
public class CMServiceImpl implements Startable, CMSService {
  private JCRDataStorage   storage_;

  private KSDataLocation   dataLocator;

  private static final Log log = ExoLogger.getLogger(CMServiceImpl.class);

  public CMServiceImpl(InitParams params, KSDataLocation locator, NodeHierarchyCreator nodeHierarchyCreator) throws Exception {
    this.dataLocator = locator;
    storage_ = new JCRDataStorage(nodeHierarchyCreator, dataLocator);
  }

  public void start() {
    try {
      log.info("initializing cms default data...");
    } catch (Exception e) {
      log.error("Failed to initializing default data for cms: ", e);
    }
  }

  public void stop() {
  }

	@Override
	public String getContentTest() {
		return "<br/><h2> Data content test from service.....</h2>";
	}


}

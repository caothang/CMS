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

@NameTemplate(@Property(key = "service", value = "cms"))
public class CMServiceImpl implements Startable, CMSService {
  private JCRDataStorage   dataStorage_;

  private CategoryImpl     categoryImpl_;

  private ProductImpl      productImpl_;

  private PartnerImpl      partnerImpl_;

  private CMSSearchImpl    searchImpl_;

  private KSDataLocation   dataLocator;

  private static final Log LOG = ExoLogger.getLogger(CMServiceImpl.class);

  public CMServiceImpl(InitParams params, KSDataLocation locator, NodeHierarchyCreator nodeHCreator) throws Exception {
    this.dataLocator = locator;
    dataStorage_ = new JCRDataStorage(nodeHCreator, dataLocator);
    categoryImpl_ = new CategoryImpl(nodeHCreator, dataLocator);
    productImpl_ = new ProductImpl(nodeHCreator, dataLocator);
    partnerImpl_ = new PartnerImpl(nodeHCreator, dataLocator);
    searchImpl_ = new CMSSearchImpl(nodeHCreator, dataLocator);
  }

  public void start() {
    try {
      LOG.info("initializing cms default data...");
    } catch (Exception e) {
      LOG.error("Failed to initializing default data for cms: ", e);
    }
  }

  public void stop() {
  }

  @Override
  public String getContentTest() {
    return "<br/><h2> Data content test from service.....</h2>";
  }

}

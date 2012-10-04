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
package org.exoplatform.cms.service.impl;

import org.exoplatform.cms.service.CMSImplementBase;
import org.exoplatform.cms.common.jcr.KSDataLocation;
import org.exoplatform.services.jcr.ext.hierarchy.NodeHierarchyCreator;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;

/**
 * Created by The BigB
 * Author : Vu Duy Tu
 *          duytucntt@gmail.com
 * Aug 29, 2012  
 */
public class PartnerImpl extends CMSImplementBase {
  private static final Log LOG = ExoLogger.getLogger(PartnerImpl.class);

  public PartnerImpl(NodeHierarchyCreator nodeHierarchyCreator, KSDataLocation dataLocator) {
    super(nodeHierarchyCreator, dataLocator);
  }

}

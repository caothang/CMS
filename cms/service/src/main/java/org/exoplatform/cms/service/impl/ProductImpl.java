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

import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

import org.exoplatform.cms.service.CMSImplementBase;
import org.exoplatform.cms.service.CMSNodeTypes;
import org.exoplatform.cms.service.Product;
import org.exoplatform.cms.common.jcr.KSDataLocation;
import org.exoplatform.services.jcr.ext.hierarchy.NodeHierarchyCreator;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;

/**
 * This class use for processing all logic about Product 
 * Created by The BigB
 * Author : Vu Duy Tu
 *          duytucntt@gmail.com
 * Aug 28, 2012  
 */

public class ProductImpl extends CMSImplementBase implements CMSNodeTypes {
  private static final Log LOG = ExoLogger.getLogger(ProductImpl.class);

  public ProductImpl(NodeHierarchyCreator nodeHierarchyCreator, KSDataLocation dataLocator) {
    super(nodeHierarchyCreator, dataLocator);
  }

  public Product getProduct(String productId) throws RepositoryException, PathNotFoundException {
    return null;
  }
}

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

import java.util.List;

import javax.jcr.RepositoryException;

import org.exoplatform.cms.service.CMSService;
import org.exoplatform.cms.service.CategoryFilter;
import org.exoplatform.cms.service.CategoryProduct;
import org.exoplatform.cms.service.CmsUser;
import org.exoplatform.cms.service.Manufacturer;
import org.exoplatform.cms.service.Partner;
import org.exoplatform.cms.service.Product;
import org.exoplatform.cms.service.ProductFilter;
import org.exoplatform.container.xml.InitParams;
import org.exoplatform.cms.common.jcr.KSDataLocation;
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
    LOG.info("Stated cms OK.");
  }

  public void stop() {
  }

  @Override
  public String getContentTest() {
    return "<br/><h2> Data content test from service.....</h2>";
  }

  @Override
  public CategoryProduct getCategory(String categoryId) throws RepositoryException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public CategoryProduct getCategorySummary(String categoryId) throws RepositoryException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public CategoryProduct updateCategory(CategoryProduct categoryProduct) throws RepositoryException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<CategoryProduct> getAllCategoryProduct() throws RepositoryException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<CategoryProduct> getCategoryProductByFilter(CategoryFilter filter) throws RepositoryException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void saveCategory(CategoryProduct categoryProduct, boolean isNew) throws RepositoryException {
    // TODO Auto-generated method stub
    
  }

  @Override
  public List<Product> getProductByFilter(ProductFilter filter) throws RepositoryException {
    // TODO Auto-generated method stub
    return null;
  }
  
  @Override
  public Product getProduct(String categoryId, String productId) throws RepositoryException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Product getProductSummary(String categoryId, String productId) throws RepositoryException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Product updateCategory(Product product) throws RepositoryException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void saveProduct(Product product, boolean isNew) throws RepositoryException {
    // TODO Auto-generated method stub
    
  }

  @Override
  public Partner getPartner(String partnerId) throws RepositoryException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Partner getPartnerSummary(String partnerId) throws RepositoryException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Partner updatePartner(Partner partner) throws RepositoryException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void savePartner(Partner partner, boolean isNew) throws RepositoryException {
    // TODO Auto-generated method stub
    
  }

  @Override
  public Manufacturer getManufacturer(String manufacturerId) throws RepositoryException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Manufacturer getManufacturerSummary(String manufacturerId) throws RepositoryException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Manufacturer updateManufacturer(Manufacturer manufacturer) throws RepositoryException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void saveManufacturer(Manufacturer manufacturer, boolean isNew) throws RepositoryException {
    // TODO Auto-generated method stub
    
  }

  @Override
  public CmsUser getCmsUser(String userId) throws RepositoryException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public CmsUser getCmsUserSummary(String userId) throws RepositoryException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public CmsUser updateCmsUser(CmsUser cmsUser) throws RepositoryException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void saveCmsUser(CmsUser cmsUser, boolean isNew) throws RepositoryException {
    // TODO Auto-generated method stub
    
  }


}

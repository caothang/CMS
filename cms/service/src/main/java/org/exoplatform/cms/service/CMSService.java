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
package org.exoplatform.cms.service;

import java.util.List;

import javax.jcr.RepositoryException;

/**
 * @author <a href="mailto:duytucntt@gmail.com">Vu Duy Tu</a>
 * @version $Revision$
 */
public interface CMSService {

  public String getContentTest();
  
  
  public CategoryProduct getCategory(String categoryId) throws RepositoryException;
  public CategoryProduct getCategorySummary(String categoryId) throws RepositoryException;
  public CategoryProduct updateCategory(CategoryProduct categoryProduct) throws RepositoryException;
  public List<CategoryProduct> getAllCategoryProduct() throws RepositoryException;
  public List<CategoryProduct> getCategoryProductByQuery(String query) throws RepositoryException;
  public void saveCategory(CategoryProduct categoryProduct, boolean isNew) throws RepositoryException;
  
  public Product getProduct(String categoryId, String productId) throws RepositoryException;
  public Product getProductSummary(String categoryId, String productId) throws RepositoryException;
  public Product updateCategory(Product product) throws RepositoryException;
  
  public void saveProduct(Product product, boolean isNew) throws RepositoryException;
  
  public Partner getPartner(String partnerId) throws RepositoryException;
  public Partner getPartnerSummary(String partnerId) throws RepositoryException;
  public Partner updatePartner(Partner partner) throws RepositoryException;
  public void savePartner(Partner partner, boolean isNew) throws RepositoryException;
  
  public Manufacturer getManufacturer(String manufacturerId) throws RepositoryException;
  public Manufacturer getManufacturerSummary(String manufacturerId) throws RepositoryException;
  public Manufacturer updateManufacturer(Manufacturer manufacturer) throws RepositoryException;
  public void saveManufacturer(Manufacturer manufacturer, boolean isNew) throws RepositoryException;

  public CmsUser getCmsUser(String userId) throws RepositoryException;
  public CmsUser getCmsUserSummary(String userId) throws RepositoryException;
  public CmsUser updateCmsUser(CmsUser cmsUser) throws RepositoryException;
  public void saveCmsUser(CmsUser cmsUser, boolean isNew) throws RepositoryException;
  
}

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
package org.exoplatform.cms.service;

import java.util.Date;

import org.exoplatform.services.jcr.util.IdGenerator;

/**
 * Created by The eXo BigB
 * Author : Vu Duy Tu
 *          duytucntt@gmail.com
 * Jul 26, 2012  
 */
public class CategoryProduct {
  public static final String CATEGORY = "Category";

  private String             id;

  private String             name;

  private String             description;

  private boolean            isSpecial;

  private int                order;

  private long               productCount;

  private Date               createdDate;

  private Date               modifiedDate;

  private boolean            isActive;

  public CategoryProduct() {
    id = CATEGORY.concat(IdGenerator.generate());
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isSpecial() {
    return isSpecial;
  }

  public void setSpecial(boolean isSpecial) {
    this.isSpecial = isSpecial;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }

  public long getProductCount() {
    return productCount;
  }

  public void setProductCount(long productCount) {
    this.productCount = productCount;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public Date getModifiedDate() {
    return modifiedDate;
  }

  public void setModifiedDate(Date modifiedDate) {
    this.modifiedDate = modifiedDate;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean isActive) {
    this.isActive = isActive;
  }

}

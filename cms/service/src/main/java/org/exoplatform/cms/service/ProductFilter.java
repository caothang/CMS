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
package org.exoplatform.cms.service;

/**
 * Created by The BigB
 * Author : Vu Duy Tu
 *          duytucntt@gmail.com
 * Oct 7, 2012  
 */
public class ProductFilter {
  String  categoryProduct;

  boolean isHot = false;

  String  isNewTechnology;

  String  orderBy;

  String  orderType;

  int     offset;
//max number items in one running filter 
  int     limit;

  public enum ODERBY{
    NAME("name"), PRICE("price"), CREATED_DATE("createDate"), 
    VIEW_COUNT("viewCount"), BUY_COUNT("buyCount");
    private final String name;

    ODERBY(String name) {
      this.name = name;
    }
    
    public String getName() {
      return name;
    }
  }
  
  public ProductFilter() {
    // TODO Auto-generated constructor stub
  }
  
  public String getCategoryProduct() {
    return categoryProduct;
  }

  public void setCategoryProduct(String categoryProduct) {
    this.categoryProduct = categoryProduct;
  }

  public boolean getIsHot() {
    return isHot;
  }

  public void setIsHot(boolean isHot) {
    this.isHot = isHot;
  }

  public String getIsNewTechnology() {
    return isNewTechnology;
  }

  public void setIsNewTechnology(String isNewTechnology) {
    this.isNewTechnology = isNewTechnology;
  }

  public String getOrderBy() {
    return orderBy;
  }

  public void setOrderBy(String orderBy) {
    this.orderBy = orderBy;
  }

  public String getFilter() {
    // TODO implement logic of filter
    if(isHot) {
      // buy = max
      // view = max
    }
    String s = "oderby @exo:"+orderBy + " " + orderType;
    return null;
  }
}

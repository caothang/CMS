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
package org.exoplatform.cms.webui;

import java.util.ArrayList;
import java.util.List;

import org.exoplatform.cms.service.CategoryProduct;
import org.exoplatform.webui.config.annotation.ComponentConfig;

/**
 * Created by The BigB
 * Author : Vu Duy Tu
 *          duytucntt@gmail.com
 * Oct 7, 2012  
 */

@ComponentConfig(
  template = "app:/templates/cms/webui/UICategoriesProduct.gtmpl"
)
public class UICategoriesProduct extends BaseCMSContainer{
  public UICategoriesProduct() {
   
  }
  
  private List<CategoryProduct> getCategoriesProduct() {
    
    List<CategoryProduct> categoryProducts = new ArrayList<CategoryProduct>();
    for (int i = 0; i < 10; i++) {
      CategoryProduct cateProduct = new CategoryProduct();
      cateProduct.setName("Cate .... " + (i+1));     
      categoryProducts.add(cateProduct);
    }
   //
    return categoryProducts; 
  }

  
  private List<CategoryProduct> getSubCategoriesProduct(String cateParentId) {
    List<CategoryProduct> categorySubProducts = new ArrayList<CategoryProduct>();
    for (int i = 0; i < 10; i++) {
      CategoryProduct cateProduct = new CategoryProduct();
      cateProduct.setName("Cate .... " + (i+1));
      categorySubProducts.add(cateProduct);
    }
    //
    return categorySubProducts;
  }


}

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
package org.exoplatform.cms.form;

import java.util.ArrayList;
import java.util.List;

import org.exoplatform.cms.service.CategoryProduct;
import org.exoplatform.webui.config.annotation.ComponentConfig;
import org.exoplatform.webui.config.annotation.EventConfig;
import org.exoplatform.webui.core.lifecycle.UIFormLifecycle;
import org.exoplatform.webui.core.model.SelectItemOption;
import org.exoplatform.webui.event.Event;
import org.exoplatform.webui.event.EventListener;
import org.exoplatform.webui.form.UIFormSelectBox;
import org.exoplatform.webui.form.UIFormStringInput;

/**
 * Created by The BigB
 * Author : Vu Duy Tu
 *          duytucntt@gmail.com
 * Oct 7, 2012  
 */

@ComponentConfig(
                 lifecycle = UIFormLifecycle.class,
                 template = "app:/templates/cms/webui/form/UIQuickSearchForm.gtmpl",
                 events = {
                   @EventConfig(listeners = UIQuickSearchForm.SearchActionListener.class),      
                   @EventConfig(listeners = UIQuickSearchForm.AdvancedSearchActionListener.class)      
                 }
             )
public class UIQuickSearchForm extends BaseCMSForm {
  public UIQuickSearchForm() {
    UIFormStringInput stringInput = new UIFormStringInput("SearchKey", "SearchKey", "Nhap noi dung tim kiem");
    stringInput.setHTMLAttribute("class", "input_txt unfocus");
    List<SelectItemOption<String>> options = new ArrayList<SelectItemOption<String>>();
    List<CategoryProduct> categoryProducts = new ArrayList<CategoryProduct>();
    
    for (CategoryProduct categoryProduct : categoryProducts) {
      SelectItemOption<String> option = new SelectItemOption<String>(categoryProduct.getName(), categoryProduct.getId());
      options.add(option);
    }
    
    UIFormSelectBox selectBox = new UIFormSelectBox("CategoryProducts", "CategoryProducts", options);
    selectBox.setHTMLAttribute("class", "select");
    
    addUIFormInput(stringInput);
    addUIFormInput(selectBox);
    // TODO Auto-generated constructor stub
  }
  
  protected List<CategoryProduct> getCategoryProducts() throws Exception {
    return getCMSService().getCategoryProductByFilter(null);
  }
  
  static public class SearchActionListener extends EventListener<UIQuickSearchForm> {
    public void execute(Event<UIQuickSearchForm> event) throws Exception {
      UIQuickSearchForm uiForm = event.getSource();
      String searchKey = uiForm.getUIStringInput("SearchKey").getValue();
      
    }
  }
  
  static public class AdvancedSearchActionListener extends EventListener<UIQuickSearchForm> {
    public void execute(Event<UIQuickSearchForm> event) throws Exception {
      UIQuickSearchForm uiForm = event.getSource();
      
    }
  }

}

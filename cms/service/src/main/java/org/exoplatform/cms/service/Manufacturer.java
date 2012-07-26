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

import java.util.Date;

import org.exoplatform.cms.service.Utils;
import org.exoplatform.services.jcr.util.IdGenerator;
/**
 * Created by The BigStore.
 * Author : Nguyen Cao Thang
 *          chuasonlam8484@gmail.com
 * Jul 26, 2012  
 */
public class Manufacturer {
private long id;

private String name;

private int order;

  /**
   * 
   */
public Manufacturer() {
    // TODO Auto-generated constructor stub
  }

  public Long Getid(){
  return id;
}

  public void SetId(Long id){
    this.id = id;
  }
  
  public String GetName(){
    return name;
  }
  
  public void SetName(String name){
    this.name = name;
  }
  
  public int GetOrder(){
    return order;
  }
  
  public void SetOrder(int order){
    this.order = order;
  }
  
 // public Manufacturer() {
 //   this(Utils.MANUFACTURER + IdGenerator.generate());
 // }
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}

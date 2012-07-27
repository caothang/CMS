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

import org.exoplatform.services.jcr.util.IdGenerator;

/**
 * Created by The eXo BigB
 * Author : Vu Duy Tu
 *          duytucntt@gmail.com
 * Jul 26, 2012  
 */
public class Partner {
  public static final String PARTNER = "Partner";

  private String             id;

  private String             name;

  private String             address;

  private String[]           contactsPhone;

  private String             website;

  private String             contactInfor;

  private int                type;

  private String             note;

  public Partner() {
    id = PARTNER.concat(IdGenerator.generate());
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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String[] getContactsPhone() {
    return contactsPhone;
  }

  public void setContactsPhone(String[] contactsPhone) {
    this.contactsPhone = contactsPhone;
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public String getContactInfor() {
    return contactInfor;
  }

  public void setContactInfor(String contactInfor) {
    this.contactInfor = contactInfor;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

}

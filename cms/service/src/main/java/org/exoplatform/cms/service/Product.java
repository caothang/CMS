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

import org.exoplatform.services.jcr.util.IdGenerator;

/**
 * Created by The eXo BigB
 * Author : Vu Duy Tu
 *          duytucntt@gmail.com
 * Jul 26, 2012  
 */
public class Product {
  public static final String PRODUCT = "product";

  private String             id;

  private String             code;

  private String             name;

  private String             manufactureID;

  private String             manufactureName;

  private String             shortDesciption;

  private String[]           techDesciption;

  private String             desciption;

  private long               inputPrice;

  private long               oldPrice;

  private long               price;

  private String             partnerID;

  private String             notePartner;

  private String             owner;

  private String             userIDUpdate;

  private String             userIDSupport;

  private Date               dateCreate;

  private Date               dateUpdate;

  private Date               dateDisplay;

  private Date               dateClose;

  private boolean            isBestBuy;

  private boolean            isNewTech;

  private boolean            isHotDeal;

  private long               sumView;

  private long               sumBuy;

  private long               order;

  private String             note;

  private boolean            isActive;

  public Product() {
    id = PRODUCT.concat(IdGenerator.generate());
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getManufactureID() {
    return manufactureID;
  }

  public void setManufactureID(String manufactureID) {
    this.manufactureID = manufactureID;
  }

  public String getManufactureName() {
    return manufactureName;
  }

  public void setManufactureName(String manufactureName) {
    this.manufactureName = manufactureName;
  }

  public String getShortDesciption() {
    return shortDesciption;
  }

  public void setShortDesciption(String shortDesciption) {
    this.shortDesciption = shortDesciption;
  }

  public String[] getTechDesciption() {
    return techDesciption;
  }

  public void setTechDesciption(String[] techDesciption) {
    this.techDesciption = techDesciption;
  }

  public String getDesciption() {
    return desciption;
  }

  public void setDesciption(String desciption) {
    this.desciption = desciption;
  }

  public long getInputPrice() {
    return inputPrice;
  }

  public void setInputPrice(long inputPrice) {
    this.inputPrice = inputPrice;
  }

  public long getOldPrice() {
    return oldPrice;
  }

  public void setOldPrice(long oldPrice) {
    this.oldPrice = oldPrice;
  }

  public long getPrice() {
    return price;
  }

  public void setPrice(long price) {
    this.price = price;
  }

  public String getPartnerID() {
    return partnerID;
  }

  public void setPartnerID(String partnerID) {
    this.partnerID = partnerID;
  }

  public String getNotePartner() {
    return notePartner;
  }

  public void setNotePartner(String notePartner) {
    this.notePartner = notePartner;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public String getUserIDUpdate() {
    return userIDUpdate;
  }

  public void setUserIDUpdate(String userIDUpdate) {
    this.userIDUpdate = userIDUpdate;
  }

  public String getUserIDSupport() {
    return userIDSupport;
  }

  public void setUserIDSupport(String userIDSupport) {
    this.userIDSupport = userIDSupport;
  }

  public Date getDateCreate() {
    return dateCreate;
  }

  public void setDateCreate(Date dateCreate) {
    this.dateCreate = dateCreate;
  }

  public Date getDateUpdate() {
    return dateUpdate;
  }

  public void setDateUpdate(Date dateUpdate) {
    this.dateUpdate = dateUpdate;
  }

  public Date getDateDisplay() {
    return dateDisplay;
  }

  public void setDateDisplay(Date dateDisplay) {
    this.dateDisplay = dateDisplay;
  }

  public Date getDateClose() {
    return dateClose;
  }

  public void setDateClose(Date dateClose) {
    this.dateClose = dateClose;
  }

  public boolean isBestBuy() {
    return isBestBuy;
  }

  public void setBestBuy(boolean isBestBuy) {
    this.isBestBuy = isBestBuy;
  }

  public boolean isNewTech() {
    return isNewTech;
  }

  public void setNewTech(boolean isNewTech) {
    this.isNewTech = isNewTech;
  }

  public boolean isHotDeal() {
    return isHotDeal;
  }

  public void setHotDeal(boolean isHotDeal) {
    this.isHotDeal = isHotDeal;
  }

  public long getSumView() {
    return sumView;
  }

  public void setSumView(long sumView) {
    this.sumView = sumView;
  }

  public long getSumBuy() {
    return sumBuy;
  }

  public void setSumBuy(long sumBuy) {
    this.sumBuy = sumBuy;
  }

  public long getOrder() {
    return order;
  }

  public void setOrder(long order) {
    this.order = order;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean isActive) {
    this.isActive = isActive;
  }

}

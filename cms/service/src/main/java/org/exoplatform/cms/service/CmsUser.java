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

/**
 * Created by The eXo BigB
 * Author : Vu Duy Tu
 *          duytucntt@gmail.com
 * Jul 26, 2012  
 */
public class CmsUser {

  private String   id;

  private String   activeKey;

  private String[] email;

  private String   fullName;

  private String   firstName;

  private String   lastName;

  private String   province;

  private String   address;

  private String[] contactsOnline;

  private String[] contactsPhone;

  private String   ip;

  private long     userRole;

  private String   viewNow;

  private String   signature;

  private long     totalProduct;

  private String   jobWattingForModerator;

  private String[] moderates;

  private long     totalBuy;

  private String[] productBought;

  private Date     lastLoginDate;

  private Date     joinedDate;

  private boolean  isBanned;

  private String   note;

  private boolean  isActive;

  public CmsUser() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getActiveKey() {
    return activeKey;
  }

  public void setActiveKey(String activeKey) {
    this.activeKey = activeKey;
  }

  public String[] getEmail() {
    return email;
  }

  public void setEmail(String[] email) {
    this.email = email;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String[] getContactsOnline() {
    return contactsOnline;
  }

  public void setContactsOnline(String[] contactsOnline) {
    this.contactsOnline = contactsOnline;
  }

  public String[] getContactsPhone() {
    return contactsPhone;
  }

  public void setContactsPhone(String[] contactsPhone) {
    this.contactsPhone = contactsPhone;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public long getUserRole() {
    return userRole;
  }

  public void setUserRole(long userRole) {
    this.userRole = userRole;
  }

  public String getViewNow() {
    return viewNow;
  }

  public void setViewNow(String viewNow) {
    this.viewNow = viewNow;
  }

  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }

  public long getTotalProduct() {
    return totalProduct;
  }

  public void setTotalProduct(long totalProduct) {
    this.totalProduct = totalProduct;
  }

  public String getJobWattingForModerator() {
    return jobWattingForModerator;
  }

  public void setJobWattingForModerator(String jobWattingForModerator) {
    this.jobWattingForModerator = jobWattingForModerator;
  }

  public String[] getModerates() {
    return moderates;
  }

  public void setModerates(String[] moderates) {
    this.moderates = moderates;
  }

  public long getTotalBuy() {
    return totalBuy;
  }

  public void setTotalBuy(long totalBuy) {
    this.totalBuy = totalBuy;
  }

  public String[] getProductBought() {
    return productBought;
  }

  public void setProductBought(String[] productBought) {
    this.productBought = productBought;
  }

  public Date getLastLoginDate() {
    return lastLoginDate;
  }

  public void setLastLoginDate(Date lastLoginDate) {
    this.lastLoginDate = lastLoginDate;
  }

  public Date getJoinedDate() {
    return joinedDate;
  }

  public void setJoinedDate(Date joinedDate) {
    this.joinedDate = joinedDate;
  }

  public boolean isBanned() {
    return isBanned;
  }

  public void setBanned(boolean isBanned) {
    this.isBanned = isBanned;
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

/*
 * Copyright (C) 2003-2008 BigB.
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
package org.exoplatform.cms.common.user;

import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.services.organization.OrganizationService;
import org.exoplatform.services.organization.UserProfile;

/**
 * ContactProvider implementation that uses portal user business profile to populate {@link CommonContact}. 
 * Preferable for corporate forums.<br><br>
 * Created by The BigB
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Aug 21, 2008  
 */
public class BusinessProfileContactProvider implements ContactProvider {

  private static Log log = ExoLogger.getLogger(BusinessProfileContactProvider.class);
  
  private OrganizationService orgService;
  
  
  public BusinessProfileContactProvider(OrganizationService orgService) {
    this.orgService = orgService;
  }
  
  /**
   * Retrieve the forum contact information from and user business profile.<br>
   * Email, city, country, mobile, phone and website are taken from {@link UserProfile#BUSINESE_INFO_KEYS}.
   */
  public CommonContact getCommonContact(String userId) {
    CommonContact contact = new CommonContact();
      try {
        UserProfile profile = orgService.getUserProfileHandler().findUserProfileByName(userId);
       
        contact.setAvatarUrl(profile.getAttribute("user.other-info.avatar.url"));
        contact.setBirthday(profile.getAttribute("user.bdate"));
        contact.setGender(profile.getAttribute("user.gender"));
        contact.setJob(profile.getAttribute("user.jobtitle"));
        
        contact.setEmailAddress(profile.getAttribute("user.business-info.online.email"));
        contact.setCity(profile.getAttribute("user.business-info.postal.city"));
        contact.setCountry(profile.getAttribute("user.business-info.postal.country"));        
        contact.setHomePhone(profile.getAttribute("user.business-info.telecom.mobile.number"));
        contact.setWorkPhone(profile.getAttribute("user.business-info.telecom.telephone.number"));
        contact.setWebSite(profile.getAttribute("user.business-info.online.uri"));
        
      } catch (Exception e) {
        log.error("Could not retrieve forum user profile for " + userId + ": " ,e);
      }
      return contact;
  }

}

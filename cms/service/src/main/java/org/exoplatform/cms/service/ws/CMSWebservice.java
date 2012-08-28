/**
 * 
 */
package org.exoplatform.cms.service.ws;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Path;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.RuntimeDelegate;

import org.apache.commons.lang.StringUtils;
import org.exoplatform.container.ExoContainerContext;
import org.exoplatform.portal.config.UserACL;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.services.organization.Group;
import org.exoplatform.services.organization.Membership;
import org.exoplatform.services.organization.OrganizationService;
import org.exoplatform.services.rest.impl.RuntimeDelegateImpl;
import org.exoplatform.services.rest.resource.ResourceContainer;

/**
 * @author Vu Duy Tu
 * 
 */
@Path("ks/cms")
public class CMSWebservice implements ResourceContainer {
  private static final Log    log                 = ExoLogger.getLogger(CMSWebservice.class);

  final public static String  APP_TYPE            = "poll".intern();

  private OrganizationService organizationService = null;

  public CMSWebservice() {
  }

  private static final CacheControl cc;
  static {
    RuntimeDelegate.setInstance(new RuntimeDelegateImpl());
    cc = new CacheControl();
    cc.setNoCache(true);
    cc.setNoStore(true);
  }

  private OrganizationService getOrganizationService() {
    if (organizationService == null) {
      organizationService = (OrganizationService) ExoContainerContext.getCurrentContainer().getComponentInstance(OrganizationService.class);
    }
    return organizationService;
  }

  private String getUserId(SecurityContext sc, UriInfo uriInfo) {
    if (sc != null && sc.getUserPrincipal() != null) {
      return sc.getUserPrincipal().getName();
    } else if (uriInfo != null) {
      return getViewerId(uriInfo);
    }
    return StringUtils.EMPTY;
  }

  private String getViewerId(UriInfo uriInfo) {
    URI uri = uriInfo.getRequestUri();
    String requestString = uri.getQuery();
    if (requestString == null)
      return null;
    String[] queryParts = requestString.split("&");
    for (String queryPart : queryParts) {
      if (queryPart.startsWith("opensocial_viewer_id")) {
        return queryPart.substring(queryPart.indexOf("=") + 1, queryPart.length());
      }
    }
    return null;
  }

  private boolean hasGroupAdminOfGatein(String username) {
    try {
      UserACL userACL = (UserACL) ExoContainerContext.getCurrentContainer().getComponentInstanceOfType(UserACL.class);
      List<String> list = new ArrayList<String>();
      list.add(username);
      list.addAll(getGroupsOfUser(username));
      for (String str : list) {
        if (str.equals(userACL.getSuperUser()) || str.equals(userACL.getAdminGroups()))
          return true;
      }
    } catch (Exception e) {
      log.debug("Failed to check has group admin of gatein." + e.getCause());
    }
    return false;
  }

  private List<String> getAllGroupAndMembershipOfUser(String username) {
    List<String> listOfUser = new ArrayList<String>();
    try {
      listOfUser.add(username);
      Set<String> list = new HashSet<String>();
      list.addAll(getGroupsOfUser(username));
      for (Object membership : getOrganizationService().getMembershipHandler().findMembershipsByUser(username)) {
        String value = ((Membership) membership).getGroupId();
        list.add(value); // its groups
        value = ((Membership) membership).getMembershipType() + ":" + value;
        list.add(value);
      }
      listOfUser.addAll(list);
    } catch (Exception e) {
      log.warn("Failed to get all info of user.");
    }
    return listOfUser;
  }

  private List<String> getGroupsOfUser(String username) {
    try {
      List<String> grIds = new ArrayList<String>();
      for (Object gr : getOrganizationService().getGroupHandler().findGroupsOfUser(username)) {
        grIds.add(((Group) gr).getId());
      }
      return grIds;
    } catch (Exception e) {
      log.warn("Failed to get groupId of user.");
      return new ArrayList<String>();
    }
  }
}

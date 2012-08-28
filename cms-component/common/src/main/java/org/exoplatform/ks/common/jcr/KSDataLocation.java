/*
 * Copyright (C) 2012 - BigB.
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
package org.exoplatform.ks.common.jcr;

import org.exoplatform.container.xml.InitParams;
import org.exoplatform.ks.common.conf.DataLocationPlugin;
import org.exoplatform.services.jcr.RepositoryService;
import org.exoplatform.services.jcr.ext.hierarchy.NodeHierarchyCreator;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;

/**
 * This class is meant to be the starting for any data storage access in KS.<br/>
 * Provides all JCR pathes usable in KS JCR data storage. <br/>
 * A {@link JCRSessionManager} accessible by {@link #getSessionManager()} is configured on the appropriate repository and workspace.<br/> 
 * Relies on {@link NodeHierarchyCreator} to initialize the structure and provide pathes aliases.
 * 
 * @author <a href="mailto:patrice.lamarque@exoplatform.com">Patrice Lamarque</a>
 * @version $Revision$
 */
public class KSDataLocation {

  private static final Log     log                     = ExoLogger.getLogger(KSDataLocation.class);

  /**
   * Parameter name use to designate the name of the repository where the data is stored. Should be passed in constructor's {@link InitParams}
   */
  // public static final String REPOSITORY_PARAM = "repository";

  /**
   * Parameter name use to designate the name of the workspace in the repository where the data is stored. Should be passed in constructor's {@link InitParams}
   */
  public static final String   WORKSPACE_PARAM         = "workspace";

  /**
   * Default repository name used if none is specified
   */
  public static final String   DEFAULT_REPOSITORY_NAME = "repository";

  /**
   * Default workspace name used if none is specified
   */
  public static final String   DEFAULT_WORKSPACE_NAME  = "portal-system";

  private String               avatarsLocation;

  private String               bbcodesLocation;

  private NodeHierarchyCreator creator;

  private String               workspace;

  private SessionManager       sessionManager;

  private RepositoryService    repositoryService;

  /**
   * Creates a new {@link KSDataLocation} and initializes pathes.
   * @param params {@link #REPOSITORY_PARAM} and {@link #WORKSPACE_PARAM} are expected as value-param 
   * @param creator used to resolve path names. It is also declared here to ensure that the data structure has been initalized before.
   */
  public KSDataLocation(InitParams params, NodeHierarchyCreator creator, RepositoryService repositoryService) {
    this.creator = creator;
    this.workspace = getParam(params, WORKSPACE_PARAM, DEFAULT_WORKSPACE_NAME);
    this.repositoryService = repositoryService;
    this.sessionManager = new JCRSessionManager(workspace, repositoryService);
    initPathes();
  }

  /**
   * Mainly used for tests
   * @param workspace
   */
  public KSDataLocation(String workspace, RepositoryService repositoryService) {
    this.workspace = workspace;
    this.repositoryService = repositoryService;
    this.sessionManager = new JCRSessionManager(workspace, repositoryService);
    initPathes();
  }

  public KSDataLocation(String workspace) {
    this.workspace = workspace;
    this.sessionManager = new JCRSessionManager(workspace, null);
    initPathes();
  }

  /**
   * Initializes all pathes with {@link #getPath(String)}
   */
  private void initPathes() {
    avatarsLocation = getPath(Locations.KS_USER_AVATAR);

    bbcodesLocation = getPath(Locations.BBCODE_HOME);
  }

  /**
   * Change the storage location. Note that pathes are not reset
   * @param plugin plugin defining repository and workspace location for the data storage
   */
  public void setLocation(DataLocationPlugin plugin) {
    this.workspace = plugin.getWorkspace();
    this.sessionManager = new JCRSessionManager(workspace, repositoryService);
  }

  /**
   * Get a jcr path by location name.
   * @param locationName name of the location such a defined in {@link Locations}
   * @return jcr path corresponding the alias name in {@link NodeHierarchyCreator}. 
   * If the creator was not set, returns the locationName. 
   * The path returned is relative to root (no leading '/')
   */
  protected String getPath(String locationName) {
    if (creator == null) {
      return locationName;
    }

    String path = creator.getJcrPath(locationName);
    if (path != null) {
      path = path.substring(1);
    }
    return path;
  }

  private String getParam(InitParams params, String name, String defaultValue) {
    String result = null;
    try {
      result = params.getValueParam(name).getValue();
    } catch (Exception e) {
      log.warn("No '" + name + "' value-param. Using default value: " + defaultValue);
    }

    if (result == null) {
      result = defaultValue;
    }
    return result;
  }

  public String getRepository() {
    try {
      return repositoryService.getCurrentRepository().getConfiguration().getName();
    } catch (Exception e) {
      return DEFAULT_REPOSITORY_NAME;
    }
  }
  
  public RepositoryService getRepositoryService() {
    return repositoryService;
  }

  public String getWorkspace() {
    return workspace;
  }

  public SessionManager getSessionManager() {
    return sessionManager;
  }

  public void setSessionManager(SessionManager manager) {
    this.sessionManager = manager;
  }

  /**
   * 
   * @return root path for all user avatars
   */
  public String getAvatarsLocation() {
    return avatarsLocation;
  }

  /**
   * 
   * @return root path for all BBCodes
   */
  public String getBBCodesLocation() {
    return bbcodesLocation;
  }


  public String toString() {
    return workspace;
  }

  /**
   * Location names for KS data storage
   * @author <a href="mailto:patrice.lamarque@exoplatform.com">Patrice Lamarque</a>
   * @version $Revision$
   */
  public interface Locations {

    public static final String KS_USER_AVATAR        = "UserAvatar";

    public static final String BBCODE_HOME           = "BBcodeService";

    public static final String DEFAULT_APPS_LOCATION = "exo:applications";

  }

}

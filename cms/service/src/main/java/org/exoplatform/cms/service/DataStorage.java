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

import org.exoplatform.container.component.ComponentPlugin;
import org.exoplatform.management.annotations.Managed;
import org.exoplatform.management.annotations.ManagedDescription;

/**
 * Created by The BigB.
 * Author : Nguyen Cao Thang
 *          chuasonlam8484@gmail.com
 * Jul 26, 2012  
 */
public interface DataStorage {

  public static final int CLOSE_FORUM = 1;

  public static final int LOCK_FORUM  = 2;

  @Managed
  @ManagedDescription("repository for cms storage")
  String getRepository() throws Exception;

  @Managed
  @ManagedDescription("workspace for the cms storage")
  String getWorkspace() throws Exception;

  @Managed
  @ManagedDescription("data path for cms storage")
  String getPath() throws Exception;

  void addPlugin(ComponentPlugin plugin) throws Exception;

  void addRolePlugin(ComponentPlugin plugin) throws Exception;

  void addInitialDataPlugin(ComponentPlugin plugin) throws Exception;

  void addInitialDefaultDataPlugin(ComponentPlugin plugin) throws Exception;

  void addCalculateModeratorEventListener() throws Exception;

  void addDeletedUserCalculateListener() throws Exception;

  void initCategoryListener();

  boolean isAdminRole(String userName) throws Exception;

  void setDefaultAvatar(String userName);

}

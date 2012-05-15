/*
 * Copyright (C) 2003-2009 eXo Platform SAS.
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
package org.exoplatform.cms.service.impl;

import javax.jcr.Node;
import javax.jcr.Session;

import org.exoplatform.cms.service.CMSNodeTypes;
import org.exoplatform.ks.common.jcr.KSDataLocation;
import org.exoplatform.ks.common.jcr.SessionManager;
import org.exoplatform.services.jcr.ext.common.SessionProvider;
import org.exoplatform.services.jcr.ext.hierarchy.NodeHierarchyCreator;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;

public class JCRDataStorage implements CMSNodeTypes {
  private static final Log               log                = ExoLogger.getLogger(JCRDataStorage.class);


  private NodeHierarchyCreator           nodeHierarchyCreator_;
  private SessionManager                 sessionManager;

  KSDataLocation                         dataLocator;

  public JCRDataStorage(NodeHierarchyCreator nodeHierarchyCreator, KSDataLocation dataLocator) {
    nodeHierarchyCreator_ = nodeHierarchyCreator;
    this.dataLocator = dataLocator;
    this.sessionManager = dataLocator.getSessionManager();
  }

  public Node getNodeByPath(String nodePath, SessionProvider sessionProvider) throws Exception {
    return (Node) getSession(sessionProvider).getItem(nodePath);
  }

  @SuppressWarnings("deprecation")
  public Session getSession(SessionProvider sprovider) throws Exception {
    return sessionManager.getSession(sprovider);
  }


}

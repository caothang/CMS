/*
 * Copyright (C) 2012 BigB.
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

import javax.jcr.Node;
import javax.jcr.Session;

import org.exoplatform.cms.service.impl.JCRDataStorage;
import org.exoplatform.ks.common.jcr.KSDataLocation;
import org.exoplatform.ks.common.jcr.SessionManager;
import org.exoplatform.services.jcr.ext.common.SessionProvider;
import org.exoplatform.services.jcr.ext.hierarchy.NodeHierarchyCreator;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;

/**
 * Created by The BigB
 * Author : Vu Duy Tu
 *          duytucntt@gmail.com
 * Aug 28, 2012  
 */
public class CMSImplementBase implements CMSNodeTypes {
  public static final Log     LOG = ExoLogger.getLogger(CMSImplementBase.class);

  public NodeHierarchyCreator nodeHierarchyCreator_;

  public SessionManager       sessionManager;

  public KSDataLocation       dataLocator;

  public JCRDataStorage       storage_;

  public CMSImplementBase(NodeHierarchyCreator nodeHierarchyCreator, KSDataLocation dataLocator) {
    this.nodeHierarchyCreator_ = nodeHierarchyCreator;
    this.dataLocator = dataLocator;
    this.sessionManager = dataLocator.getSessionManager();
    this.storage_ = new JCRDataStorage(nodeHierarchyCreator, dataLocator);
  }

  public Node getNodeByPath(String nodePath, SessionProvider sessionProvider) throws Exception {
    return (Node) getSession(sessionProvider).getItem(nodePath);
  }

  public Session getSession(SessionProvider sprovider) throws Exception {
    return sessionManager.getSession(sprovider);
  }

}

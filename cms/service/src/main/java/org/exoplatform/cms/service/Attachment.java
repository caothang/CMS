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

import java.io.InputStream;

import javax.jcr.Node;
import javax.jcr.Session;

import org.exoplatform.container.ExoContainerContext;
import org.exoplatform.services.jcr.RepositoryService;
import org.exoplatform.services.jcr.util.IdGenerator;

/**
 * Created by The eXo BigB
 * Author : Vu Duy Tu
 *          duytucntt@gmail.com
 * Jul 26, 2012  
 */
public class Attachment {
  public static final String ATTACHMENT = "Attachment";

  private String             id;

  private String             name;

  private String             mimeType;

  private String             pathNode;

  private String             path;

  private long               size;

  private String             workspace;

  private InputStream        input;

  public Attachment() {
    id = ATTACHMENT.concat(IdGenerator.generate());
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

  public String getMimeType() {
    return mimeType;
  }

  public void setMimeType(String mimeType) {
    this.mimeType = mimeType;
  }

  public String getPathNode() {
    return pathNode;
  }

  public void setPathNode(String pathNode) {
    this.pathNode = pathNode;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public long getSize() {
    return size;
  }

  public void setSize(long size) {
    this.size = size;
  }

  public String getWorkspace() {
    return workspace;
  }

  public void setWorkspace(String workspace) {
    this.workspace = workspace;
  }

  public InputStream getInputStream() throws Exception {
    if (input != null)
      return input;
    else {
      Node attachment;
      Session session = getSesison();
      try {
        attachment = (Node) session.getItem(getPath());
        return attachment.getNode(CMSNodeTypes.JCR_CONTENT).getProperty(CMSNodeTypes.JCR_DATA).getStream();
      } catch (Exception e) {
        return null;
      } finally {
        session.logout();
      }
    }
  }

  /**
   * Sets the input stream which is file's data.
   * 
   * @param in the new input stream
   * @throws Exception the exception
   */
  public void setInputStream(InputStream in) throws Exception {
    input = in;
  }

  private Session getSesison() throws Exception {
    RepositoryService repoService = (RepositoryService) ExoContainerContext.getCurrentContainer().getComponentInstanceOfType(RepositoryService.class);
    return repoService.getCurrentRepository().getSystemSession(getWorkspace());
  }

  public String toString() {
    return id + "[" + mimeType + "," + size + "]";
  }
}

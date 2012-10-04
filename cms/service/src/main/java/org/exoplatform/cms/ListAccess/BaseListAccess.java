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
package org.exoplatform.cms.ListAccess;

import javax.jcr.Session;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;

import org.exoplatform.ks.common.jcr.JCRListAccess;
import org.exoplatform.ks.common.jcr.SessionManager;
import org.exoplatform.services.jcr.impl.core.query.QueryImpl;

/**
 * Created by The BigB
 * Author : Vu Duy Tu
 *          duytucntt@gmail.com
 * Sep 9, 2012  
 */
public class BaseListAccess extends JCRListAccess<Object>{
  public String query;

  public BaseListAccess(SessionManager manager) {
    super(manager);
  }

  public BaseListAccess(SessionManager manager, String query) {
    super(manager);
    this.query = query;
  }

  @Override
  protected Object[] load(Session session, int index, int length) throws Exception, IllegalArgumentException {
    QueryManager qm = session.getWorkspace().getQueryManager();
    QueryImpl query = (QueryImpl) qm.createQuery(this.query, Query.XPATH);
    query.setOffset(index);
    query.setLimit(index + length);
    QueryResult result = query.execute();
    return null;
  }

  @Override
  protected int getSize(Session session) throws Exception {
    return 0;
  }

}

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
package org.exoplatform.cms.upgrade;

import org.exoplatform.commons.upgrade.UpgradeProductPlugin;
import org.exoplatform.container.xml.InitParams;
import org.exoplatform.services.jcr.ext.common.SessionProvider;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;

/**
 * Created by The BigB
 * Author : Vu Duy Tu
 *          tu.duy@exoplatform.com
 * Oct 4, 2011  
 */
public class UpgradeCMSPlugin extends UpgradeProductPlugin {

  private static final Log    log               = ExoLogger.getLogger(UpgradeCMSPlugin.class);

  public UpgradeCMSPlugin(InitParams initParams) {
    super(initParams);
  }

  public void processUpgrade(String oldVersion, String newVersion) {
    log.info(String.format("\n\n -----------> Migrating data from %s to %s for cms......\n\n", oldVersion, newVersion));
    SessionProvider sProvider = SessionProvider.createSystemProvider();
    try {
    } catch (Exception e) {
      log.warn("[UpgradeCMSPlugin] Exception when migrate data for cms.", e);
    } finally {
      sProvider.close();
    }
    log.info("\n\n -----------> The end cms Migration......\n\n");
  }

  public boolean shouldProceedToUpgrade(String previousVersion, String newVersion) {
    return false;
  }

}

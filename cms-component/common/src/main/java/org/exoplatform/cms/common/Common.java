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
package org.exoplatform.cms.common;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.exoplatform.container.ExoContainer;
import org.exoplatform.container.ExoContainerContext;
import org.exoplatform.container.PortalContainer;
import org.exoplatform.cms.common.notify.NotifyJob;
import org.exoplatform.services.mail.Message;
import org.exoplatform.services.scheduler.JobInfo;
import org.exoplatform.services.scheduler.JobSchedulerService;
import org.exoplatform.services.scheduler.PeriodInfo;
import org.quartz.JobExecutionContext;

/**
 * Created by The eXo Platform SARL
 * Author : Truong Nguyen
 *          truong.nguyen@exoplatform.com
 * Oct 22, 2008, 12:02:18 PM
 */
public class Common {
  
  public static Map<String, NotifyInfo> messagesInfoMap_ = new HashMap<String, NotifyInfo>() ;
  public static final String         COLON        = ":".intern();
  
  public Common (){}
  
  public void sendEmailNotification(List<String> addresses, Message message, String gruopName) throws Exception {
    Calendar cal = new GregorianCalendar();
    PeriodInfo periodInfo = new PeriodInfo(cal.getTime(), null, 1, 86400000);
    String name = String.valueOf(cal.getTime().getTime()) ;
    JobInfo info = new JobInfo(name, gruopName, NotifyJob.class);
    ExoContainer container = ExoContainerContext.getCurrentContainer();
    JobSchedulerService schedulerService = 
      (JobSchedulerService) container.getComponentInstanceOfType(JobSchedulerService.class);
    messagesInfoMap_.put(name, new NotifyInfo(addresses, message)) ;
    schedulerService.addPeriodJob(info, periodInfo);
  }
  
  public NotifyInfo getMessageInfo(String name) throws Exception {
    NotifyInfo messageInfo = messagesInfoMap_.get(name) ;
    messagesInfoMap_.remove(name) ;
    return  messageInfo ;
  }
  
  public static ExoContainer getExoContainer(JobExecutionContext context) {
	    if(context == null) return null;
	    String portalName = context.getJobDetail().getGroup();
	    if(portalName == null) {
	      portalName = PortalContainer.getCurrentPortalContainerName();
	    }
	    if(portalName.indexOf(COLON) > 0) portalName = portalName.substring(0, portalName.indexOf(":"));
	    return ExoContainerContext.getContainerByName(portalName);
	  }
  
}

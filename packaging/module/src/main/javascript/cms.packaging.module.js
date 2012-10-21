eXo.require("eXo.projects.Module");
eXo.require("eXo.projects.Product");

function getModule(params) {
  var ws = params.ws;
  var portal = params.portal;
  var module = new Module();
  
  module.version = "${project.version}";
  module.relativeMavenRepo = "org/hoahong/cms";
  module.relativeSRCRepo = "cms";
  module.name = "cms";
  
  var commonsVersion = "${org.exoplatform.commons.version}";

  module.commons = {};
  module.commons.extension = 
    new Project("org.exoplatform.commons", "exo.platform.commons.extension.webapp", "war", commonsVersion);
  module.commons.extension.deployName = "commons-extension";
  
  module.comet = {};
  module.comet.cometd =
    new Project("org.exoplatform.commons", "exo.platform.commons.comet.webapp", "war", commonsVersion).
    addDependency(new Project("org.mortbay.jetty", "cometd-bayeux", "jar", "${org.mortbay.jetty.cometd-bayeux.version}")).
    addDependency(new Project("org.mortbay.jetty", "jetty-util", "jar", "${org.mortbay.jetty.jetty-util.version}")).
    addDependency(new Project("org.mortbay.jetty", "cometd-api", "jar", "${org.mortbay.jetty.cometd-api.version}")).
    addDependency(new Project("org.exoplatform.commons", "exo.platform.commons.comet.service", "jar", commonsVersion));
  module.comet.cometd.deployName = "cometd";
  
  module.webuiExt = new Project("org.exoplatform.commons", "exo.platform.commons.webui.ext", "jar", commonsVersion);

  
  // CMS

  // CMS components
  module.component = {};
  module.component.common = new Project("org.hoahong.cms", "cms.component.common", "jar", module.version).
                            addDependency(new Project("org.exoplatform.commons", "exo.platform.commons.webui", "jar", commonsVersion));

  module.component.bbcode = new Project("org.hoahong.cms", "cms.component.bbcode", "jar", module.version).
              addDependency(new Project("org.hoahong.cms", "cms.component.rendering", "jar", module.version));

  
  // CMS application common
  module.application = {};
  module.application.common = new Project("org.hoahong.cms", "cms.application.common", "jar", module.version).
    addDependency(new Project("org.hoahong.cms", "cms.component.upgrade", "jar", module.version)).
    addDependency(new Project("org.exoplatform.commons", "exo.platform.commons.component.upgrade", "jar", commonsVersion)).
    addDependency(new Project("org.exoplatform.commons", "exo.platform.commons.component.product", "jar", commonsVersion));


  // CMS
  module.cms = 
    new Project("org.hoahong.cms", "cms.cms.webapp", "war", module.version) .
    addDependency(new Project("org.hoahong.cms", "cms.cms.service", "jar",  module.version));
  module.cms.deployName = "cms";
  module.cmsSkin = new Project("org.hoahong.cms", "cms.cms.skin", "war", module.version);
  module.cmsSkin.deployName = "cmsSkin";

  // KS we resources and services
  module.web = {}
  module.web.cmsResources = 
    new Project("org.hoahong.cms", "cms.web.cmsResources", "war", module.version) ;

  // KS extension for tomcat
  module.extension = {};
  module.extension.webapp = 
    new Project("org.hoahong.cms", "cms.extension.webapp", "war", module.version);
  module.extension.webapp.deployName = "cms-extension";
   
  module.server = {}
  module.server.tomcat = {}
  module.server.tomcat.patch =
    new Project("org.hoahong.cms", "cms.server.tomcat.patch", "jar", module.version);
	
  module.server.jboss = {}
  module.server.jboss.patchear =
    new Project("org.hoahong.cms", "cms.server.jboss.patch-ear", "jar", module.version);
   
  // CMS demo 
  module.demo = {};
  // demo portal
  module.demo.portal =
    new Project("org.hoahong.cms", "cms.demo.webapp", "war", module.version).
    addDependency(new Project("org.hoahong.cms", "cms.demo.config", "jar", module.version));
  module.demo.portal.deployName = "cmsdemo";  
	
  module.demo.cometd=
    new Project("org.hoahong.cms", "cms.demo.cometd-war", "war", module.version);
  module.demo.cometd.deployName = "cometd-cmsdemo";
	   
  // demo rest endpoint	   
  module.demo.rest =
    new Project("org.hoahong.cms", "cms.demo.rest-cmsdemo", "war", module.version).
    addDependency(ws.frameworks.servlet);
  module.extension.deployName = "rest-cmsdemo"; 
   
  return module;
}

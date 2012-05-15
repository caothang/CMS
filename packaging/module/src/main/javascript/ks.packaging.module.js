eXo.require("eXo.projects.Module");
eXo.require("eXo.projects.Product");

function getModule(params) {
  var ws = params.ws;
  var portal = params.portal;
  var module = new Module();

  module.version = "${project.version}";
  module.relativeMavenRepo = "org/exoplatform/ks";
  module.relativeSRCRepo = "ks";
  module.name = "ks";
  
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

  
  // KS

  // KS components
  module.component = {};
  module.component.common = new Project("org.hoahong.ks", "cms.component.common", "jar", module.version).
                            addDependency(new Project("org.exoplatform.commons", "exo.platform.commons.webui", "jar", commonsVersion));

  module.component.bbcode = new Project("org.hoahong.ks", "cms.component.bbcode", "jar", module.version);

  
  // KS application common
  module.application = {};
  module.application.common = new Project("org.hoahong.ks", "cms.application.common", "jar", module.version).
    addDependency(new Project("org.exoplatform.commons", "exo.platform.commons.component.upgrade", "jar", commonsVersion)).
    addDependency(new Project("org.exoplatform.commons", "exo.platform.commons.component.product", "jar", commonsVersion));


  // CMS
  module.cms = 
    new Project("org.hoahong.ks", "cms.webapp", "war", module.version) .
    addDependency(new Project("org.hoahong.ks", "cms.service", "jar",  module.version));
  module.cms.deployName = "cms";

  // KS we resources and services
  module.web = {}
  module.web.cmsResources = 
    new Project("org.hoahong.ks", "cms.web.cmsResources", "war", module.version) ;

  // KS extension for tomcat
  module.extension = {};
  module.extension.webapp = 
    new Project("org.hoahong.ks", "cms.extension.webapp", "war", module.version);
  module.extension.webapp.deployName = "cms-extension";
   
  module.server = {}
  module.server.tomcat = {}
  module.server.tomcat.patch =
    new Project("org.hoahong.ks", "cms.server.tomcat.patch", "jar", module.version);
	
  module.server.jboss = {}
  module.server.jboss.patchear =
    new Project("org.hoahong.ks", "cms.server.jboss.patch-ear", "jar", module.version);
   
  // KS demo 
  module.demo = {};
  // demo portal
  module.demo.portal =
    new Project("org.hoahong.ks", "cms.demo.webapp", "war", module.version).
    addDependency(new Project("org.hoahong.ks", "cms.demo.config", "jar", module.version));
  module.demo.portal.deployName = "cmsdemo";  
	
  module.demo.cometd=
    new Project("org.hoahong.ks", "cms.demo.cometd-war", "war", module.version);
  module.demo.cometd.deployName = "cometd-cmsdemo";
	   
  // demo rest endpoint	   
  module.demo.rest =
    new Project("org.hoahong.ks", "cms.demo.rest-cmsdemo", "war", module.version).
    addDependency(ws.frameworks.servlet);
  module.extension.deployName = "rest-cmsdemo"; 
   
  return module;
}

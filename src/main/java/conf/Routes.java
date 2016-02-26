/**
 * Copyright (C) 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package conf;


import ninja.AssetsController;
import ninja.Router;
import ninja.application.ApplicationRoutes;
import controllers.ApplicationController;

public class Routes implements ApplicationRoutes {

    @Override
    public void init(Router router) {

        router.GET().route("/").with(ApplicationController.class, "index");
        router.GET().route("/choose").with(ApplicationController.class, "choose");
//        router.GET().route("/hello_world.json").with(ApplicationController.class, "helloWorldJson");
        router.GET().route("/AcesUp").with(ApplicationController.class, "acesUp");
        router.GET().route("/AcesUp1").with(ApplicationController.class, "acesUp1");
        router.GET().route("/game1").with(ApplicationController.class, "gameGet1");
        router.GET().route("/game2").with(ApplicationController.class, "gameGet2");

        router.POST().route("/dealGame1").with(ApplicationController.class, "dealPost1");
        router.POST().route("/dealGame2").with(ApplicationController.class, "dealPost2");
        router.POST().route("/moveCard/{columnFrom}/{columnTo}").with(ApplicationController.class, "moveCard");
        router.POST().route("/moveCard1/{columnFrom}/{columnTo}").with(ApplicationController.class, "moveCard1");
        router.POST().route("/moveCard2/{columnFrom}/{columnTo}").with(ApplicationController.class, "moveCard2");
        router.POST().route("/removeCard1/{column}").with(ApplicationController.class, "removeCard1");
        router.POST().route("/removeCard2/{column}").with(ApplicationController.class, "removeCard2");
        ///////////////////////////////////////////////////////////////////////
        // Assets (pictures / javascript)
        ///////////////////////////////////////////////////////////////////////    
        router.GET().route("/assets/webjars/{fileName: .*}").with(AssetsController.class, "serveWebJars");
        router.GET().route("/assets/{fileName: .*}").with(AssetsController.class, "serveStatic");

        ///////////////////////////////////////////////////////////////////////
        // Index / Catchall shows index page
        ///////////////////////////////////////////////////////////////////////
//        router.GET().route("/.*").with(ApplicationController.class, "index");
    }

}

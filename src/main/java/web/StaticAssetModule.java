/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import io.jooby.Jooby;
import io.jooby.Route;
import java.nio.file.Paths;

/**
 *
 * @author benforde
 */
public class StaticAssetModule extends Jooby {

    public StaticAssetModule() {

        // handle favicons (silent 404)
        get("/favicon.ico", Route.FAVICON);

        // serve anything that matches a file in the static folder
        assets("/*", Paths.get("static"));
    }
}

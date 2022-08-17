package edu.escuelaing.arem.designprimer;

import static spark.Spark.*;

public class Tarea {
    public static void main(String[] args) {
        port(getPort());
        staticFiles.location("/public");
        get("/hello", (req, res) -> {
            String name = req.queryParams("name");
            return "Hello Heroku" + name;});
        get("/intraday", (req, res) -> {
            res.type("application/json");
            return HttpConnection.getAPI();
        });
    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}

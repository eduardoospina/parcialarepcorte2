package edu.escuelaing.arep;
import static spark.Spark.*;

public class RoundRobin {

    public static void main(String[] args) {

        APP_LB_RoundRobin roundrobin = new APP_LB_RoundRobin();

        port(getPort());

        get("/hello", (req, res) -> "Hello Heroku");


        get("/atan", (req, res) -> {
            res.type("application/json");
            Double input = Double.parseDouble(req.queryParams("value"));
            return roundrobin.enviaratan(input);
        });

        get("/sqrt", (req, res) -> {
            res.type("application/json");
            Double input = Double.parseDouble(req.queryParams("value"));
            return roundrobin.enviarsqrt(input);
        });

    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 34000; //returns default port if heroku-port isn't set(i.e. on localhost)
    }
}
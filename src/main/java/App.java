import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;


public class App {
    public static void main(String[] args) {


        get("/form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "/form.hbs");
        }, new HandlebarsTemplateEngine());


        get("/changeout.hbs", (request, response) -> {

            ChangeMachine changeMachine = new ChangeMachine();

            Map<String, Object> model = new HashMap<String, Object>();

            String newcash = request.queryParams("totalCash");


            String outcash = changeMachine.makeChange(Float.parseFloat(newcash));

            model.put("outCash", outcash);

            return new ModelAndView(model, "changeout.hbs");

        }, new HandlebarsTemplateEngine());







//
//        get("/form", (request, response) -> {
//            return new ModelAndView(new HashMap(), "/form.hbs");
//        }, new HandlebarsTemplateEngine());
//
//


        }
}
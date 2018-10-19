package com.karla.restapp.calculator;

import org.springframework.web.bind.annotation.*;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.text.DecimalFormat;

@RestController
public class HelloWorld {

    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");


    @RequestMapping(method=RequestMethod.POST, value="/api/hello")
    public String result(@RequestBody String expression) throws ScriptException {

        String str = expression.split("\"")[3];

        DecimalFormat df = new DecimalFormat("#.#####");
//        System.out.println(df.format(engine.eval(str)));
        return df.format(engine.eval(str));
    }
}


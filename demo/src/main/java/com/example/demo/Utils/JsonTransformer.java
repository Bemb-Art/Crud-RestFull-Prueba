package com.example.demo.Utils;

import com.google.gson.Gson;
import spark.ResponseTransformer;

public class JsonTransformer implements ResponseTransformer {
    @Override
    public String render(Object o) throws Exception {
        return new Gson().toJson(o);
    }
}

package io.swagger.server.api.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

import io.swagger.server.api.model.Carpets;

import java.util.List;
import java.util.Map;

public class DefaultApiVerticle extends AbstractVerticle {
    final static Logger LOGGER = LoggerFactory.getLogger(DefaultApiVerticle.class); 
    
    final static String GET_CARPETS_SERVICE_ID = "GET_carpets";
    final static String POST_CARPETS_SERVICE_ID = "POST_carpets";
    
    //TODO : create Implementation
    DefaultApi service = new DefaultApiImpl();

    @Override
    public void start() throws Exception {
        
        //Consumer for GET_carpets
        vertx.eventBus().<JsonObject> consumer(GET_CARPETS_SERVICE_ID).handler(message -> {
            try {
                
                Carpets result = service.carpetsGet();
                message.reply(new JsonObject(Json.encode(result)).encodePrettily());
            } catch (Exception e) {
                //TODO : replace magic number (101)
                message.fail(101, e.getLocalizedMessage());
            }
        });
        
        //Consumer for POST_carpets
        vertx.eventBus().<JsonObject> consumer(POST_CARPETS_SERVICE_ID).handler(message -> {
            try {
                Carpets body = Json.mapper.readValue(message.body().getJsonObject("body").encode(), Carpets.class);
                
                Carpets result = service.carpetsPost(body);
                message.reply(new JsonObject(Json.encode(result)).encodePrettily());
            } catch (Exception e) {
                //TODO : replace magic number (101)
                message.fail(101, e.getLocalizedMessage());
            }
        });
        
    }
}
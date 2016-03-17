package no.itera.websocket.message;

import javax.json.Json;
import javax.json.JsonObject;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Register implements Message {

  public static final String TYPE = "register";

  private final String name;

  public Register(String name) {
    this.name = name;
  }

  public String toJson() {
    return Json.createObjectBuilder()
        .add("type", TYPE)
        .add("name", name)
        .build()
        .toString();
  }

  public static Register fromJson(JsonObject object) {
    throw new NotImplementedException();
  }

}

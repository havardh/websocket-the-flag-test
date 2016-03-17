package no.itera.websocket.message;

import javax.json.Json;
import javax.json.JsonObject;

import no.itera.websocket.Color;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Update implements Message {

  public static final String type = "update";

  private final Color color;

  public Update(Color color) {
    this.color = color;
  }

  public String toJson() {
    return Json.createObjectBuilder()
        .add("type", type)
        .add("color", color.toString())
        .build()
        .toString();
  }

  public static Update fromJson(JsonObject object) {
    throw new NotImplementedException();
  }

}

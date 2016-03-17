package no.itera.websocket.message;


import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonValue;

import no.itera.websocket.Color;

public class Status implements Message {

  public static final String type = "status";

  public final List<Color> colors;

  public Status(List<Color> colors) {
    this.colors = colors;
  }

  public static Status fromJson(JsonObject object) {

    JsonArray jsonColorsArray = object.getJsonArray("status");

    List<Color> colors = new ArrayList<Color>();
    for (JsonValue jsonColor : jsonColorsArray) {
      colors.add(Color.valueOf(jsonColor.toString()));
    }

    return new Status(colors);
  }

  public String toJson() {
    JsonArrayBuilder builder = Json.createArrayBuilder();

    for (Color color : colors) {
      builder.add(color.toString());
    }

    return Json.createObjectBuilder()
        .add("type", type)
        .add("status", builder)
        .toString();
  }

}

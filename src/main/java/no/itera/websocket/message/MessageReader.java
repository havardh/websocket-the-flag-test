package no.itera.websocket.message;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class MessageReader {

  public static Message readJson(String json) {
    JsonReader reader = Json.createReader(new StringReader(json));
    JsonObject object = reader.readObject();

    String type = object.getString("type");

    if (type.equals(Register.TYPE)) {
      return Register.fromJson(object);
    } else if (type.equals(Register.TYPE)) {
      return Status.fromJson(object);
    } else if (type.equals(Register.TYPE)) {
      return Update.fromJson(object);
    } else {
      throw new NotImplementedException();
    }
  }
}

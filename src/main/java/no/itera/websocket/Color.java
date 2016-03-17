package no.itera.websocket;

public enum Color {

  RED,
  GREEN,
  BLUE,
  YELLOW;


  public static Color randomColor() {
    return values()[(int)Math.floor(Math.random() * values().length)];
  }
}

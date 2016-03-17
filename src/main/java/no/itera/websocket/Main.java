package no.itera.websocket;

import java.net.URI;

import no.itera.websocket.message.Message;
import no.itera.websocket.message.Register;
import no.itera.websocket.message.Update;

public class Main {



  public static void main(String[] args) throws Exception {
    final WebSocketTest clientEndPoint = new WebSocketTest(new URI("ws://localhost:3004"));
    clientEndPoint.addMessageHandler(new Handler());
    clientEndPoint.sendMessage(new Register("Test bot"));
    while (true) {

      Thread.sleep(3000);
      clientEndPoint.sendMessage(new Update(Color.randomColor()));

    }
  }

  private static class Handler implements WebSocketTest.MessageHandler {
    public void handleMessage(Message message) {
      System.out.println("Received: " + message.toJson());
    }
  }
}
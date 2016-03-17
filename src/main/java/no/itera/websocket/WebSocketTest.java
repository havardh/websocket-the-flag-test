package no.itera.websocket;

import java.net.URI;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.ContainerProvider;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import no.itera.websocket.message.Message;
import no.itera.websocket.message.MessageReader;

@ClientEndpoint(subprotocols = {"echo-protocol"})
public class WebSocketTest {
  Session userSession = null;
  private MessageHandler messageHandler;

  public WebSocketTest(URI endpointURI) {
    try {
      WebSocketContainer container = ContainerProvider.getWebSocketContainer();
      container.connectToServer(this, endpointURI);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @OnOpen
  public void onOpen(Session userSession) {
    System.out.println("Opening");
    this.userSession = userSession;
  }

  @OnClose
  public void onClose(Session userSession, CloseReason reason) {
    System.out.println("Closing");
    this.userSession = null;
  }

  @OnMessage
  public void onMessage(String msg) {
    System.out.println(msg);
    if (this.messageHandler != null) {
      Message message = MessageReader.readJson(msg);
      this.messageHandler.handleMessage(message);
    }
  }

  public void addMessageHandler(MessageHandler msgHandler) {
    this.messageHandler = msgHandler;
  }

  public void sendMessage(Message message) throws Exception {
    this.userSession.getBasicRemote().sendText(message.toJson());
  }

  public interface MessageHandler {
    void handleMessage(Message message);
  }
}
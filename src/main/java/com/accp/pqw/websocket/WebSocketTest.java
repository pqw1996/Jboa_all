package com.accp.pqw.websocket;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/WebSocket/{eid}")
public class WebSocketTest {
	// concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
	private static ConcurrentHashMap<Integer, WebSocketTest> webSocketSet = new ConcurrentHashMap<Integer, WebSocketTest>();
	// 与某个客户端的连接会话，需要通过它来给客户端发送数据
	private Session session;

	@OnOpen
	public void OnOpen(@PathParam(value = "eid") int eid, Session s) {
		System.err.println(eid);
		this.session = s;
		webSocketSet.put(eid, this);
		System.err.println("链接建立成功！");
	}

	@OnClose
	public void OnClose() {
		System.err.println("链接关闭！");
	}

	@OnMessage
	public void OnMessage(String message) {
		System.err.println("进入方法");
		if (webSocketSet.get(Integer.parseInt(message.split("[|]")[0])) != null) {
			System.err.println("不为空");
			try {
				webSocketSet.get(Integer.parseInt(message.split("[|]")[0])).sendMessage(message.split("[|]")[1]);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("此用户没有上线1！");
		}
	}

	@OnError
	public void OnError(Throwable error) {
		System.err.println("发生错误");
		error.printStackTrace();
	}

	public void sendMessage(String message) throws IOException {
		if (this.session.isOpen()) {
			System.err.println(message);
			this.session.getBasicRemote().sendText(message);
		} else {
			System.err.println("此用户没有上线2！");
		}
	}

}

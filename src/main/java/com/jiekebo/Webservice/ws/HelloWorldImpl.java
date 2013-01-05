package com.jiekebo.Webservice.ws;

import javax.jws.WebService;

@WebService(endpointInterface = "com.jiekebo.ws.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
	@Override
	public String getHelloWorldAsSring(String name) {
		return "Hello World JAX-WS " + name;
	}
}
package DI_09_Spring;

import java.util.Map;

public class ProtocolHandlerFactory {
	public ProtocolHandlerFactory() {
		System.out.println("ProtocolHandelrFactory 기본생성자");
	}
	
	
	//MAP (key, value)
	private Map<String, ProtocolHandler> handlers;
	
	public void setHandlers(Map<String, ProtocolHandler> handlers) {
		this.handlers = handlers;
		System.out.println("setter 주입 성공 : " + this.handlers);
	}
	
}

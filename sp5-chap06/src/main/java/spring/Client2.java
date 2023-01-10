package spring;

public class Client2 {
	private String host;

	public void setHost(String host) {
		this.host = host;
	}

	public void connect() {
		// TODO Auto-generated method stub
		System.out.println("Client.afterPropertiesSet() 실행");
	}

	public void send() {
		System.out.println("Client.send() to " + host);
	}

	public void close() {
		// TODO Auto-generated method stub
		System.out.println("Client.destory() 실행");

	}

}

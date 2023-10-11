package myspring.di.xml;

public class StringPrinter implements Printer {
	private StringBuffer buffer = new StringBuffer();
	// StringBuffer는  StringPrinter에 의존적
	// StringBuffer는 동기화해줌
	
	public StringPrinter() {
		System.out.println(this.getClass().getName()+" 생성자 호출");
	}

	public void print(String message) {
		this.buffer.append(message);
	}

	@Override
	public String toString() {
		return this.buffer.toString();
	}
}

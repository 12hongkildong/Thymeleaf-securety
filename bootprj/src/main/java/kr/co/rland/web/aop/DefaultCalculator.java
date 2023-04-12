package kr.co.rland.web.aop;

public class DefaultCalculator implements Calculator {

	private int x;
	private int y;

	public DefaultCalculator() {

	}

	public DefaultCalculator(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public int plus() {
		return x + y;
	}

	@Override
	public int sub() {
		return x - y;
	}

	@Override
	public int multi() {
		return x * y;
	}
}

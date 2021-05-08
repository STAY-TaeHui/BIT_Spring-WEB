package AOP_Basic_Spring07;

public class NewCalc implements Calc{

	@Override
	public int ADD(int x, int y) {
		System.out.println("This is ADD Method");
		// 보조업부(공통업무) cross-cutting-concern
		int sum=x+y;// 주업무(core-concern)
		// 보조업부(공통업무) cross-cutting-concern
		return sum;
	}

	@Override
	public int MUL(int x, int y) {
		System.out.println("This is MUL Method");
		// 보조업부(공통업무) cross-cutting-concern
			int mul=x*y;// 주업무(core-concern)
		// 보조업부(공통업무) cross-cutting-concern
		return mul;
	}

	@Override
	public int SUB(int x, int y) {
		System.out.println("This is SUB Method");
		// 보조업부(공통업무) cross-cutting-concern
			int sub=x-y;// 주업무(core-concern)
		// 보조업부(공통업무) cross-cutting-concern
		return sub;
	}

}

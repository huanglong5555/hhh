package designMode.decoratePattern;

public class SugerMocaCoffe implements Coffe {
	private Coffe coffe;

	public SugerMocaCoffe(Coffe coffe) {
		this.coffe = coffe;
	}

	@Override
	public double cost() {
		return coffe.cost() + 3;

	}

}

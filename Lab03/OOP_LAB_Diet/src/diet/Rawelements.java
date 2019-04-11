package diet;

class Rawelements implements NutritionalElement {
	private String nome;
	private double calorie;
	private double proteine;
	private double carboidrati;
	private double grassi;
	
	public Rawelements(String name, double calories, double proteins, double carbs, double fat) {
		this.nome=name;
		this.calorie=calories;
		this.proteine=proteins;
		this.carboidrati=carbs;
		this.grassi=fat;
	}

	@Override
	public String getName() {
		return this.nome;
	}

	@Override
	public double getCalories() {
		return this.calorie;
	}

	@Override
	public double getProteins() {
		return this.proteine;
	}

	@Override
	public double getCarbs() {
		return this.carboidrati;
	}

	@Override
	public double getFat() {
		return this.grassi;
	}

	@Override
	public boolean per100g() {	
		return true;
	}

}


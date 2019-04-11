package diet;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Represents a complete menu.
 * It consist of packaged products and servings of recipes.
 *
 */
public class Menu implements NutritionalElement {

	/**
	 * Menu constructor.
	 * The reference {@code food} of type {@link Food} must be used to
	 * retrieve the information about recipes and products 
	 * 
	 * @param nome unique name of the menu
	 * @param food object containing the information about products and recipes
	 */
	private Food food;
	private String nome;
	private double calorie;
	private double proteine;
	private double carboidrati;
	private double grassi;
	private Map<String,Number> mrecpmap=new HashMap<>();
	private List<String> prodlist=new LinkedList<>();
	
	public Menu(String name, Food food){
		this.nome=name;
		this.food=food;
		calorie=proteine=carboidrati=grassi=0;
		return;
	}
	
	/**
	 * Adds a given serving size of a recipe.
	 * The recipe is a name of a recipe defined in the {@code food}
	 * argument of the constructor.
	 * 
	 * @param recipe the name of the recipe to be used as ingredient
	 * @param quantity the amount in grams of the recipe to be used
	 */
	public void addRecipe(String recipe, double quantity) {
		NutritionalElement e=food.getRecipe(recipe);
		double q=quantity/100;
		mrecpmap.put(recipe, quantity);
		//Stesso motivo che per gli ingredienti in Recipe.java
		calorie=calorie+e.getCalories()*q;
		proteine=proteine+e.getProteins()*q;
		carboidrati=carboidrati+e.getCarbs()*q;
		grassi=grassi+e.getFat()*q;
		return;
	}

	/**
	 * Adds a unit of a packaged product.
	 * The product is a name of a product defined in the {@code food}
	 * argument of the constructor.
	 * 
	 * @param product the name of the product to be used as ingredient
	 */
	public void addProduct(String product) {
		NutritionalElement e=food.getProduct(product);
		prodlist.add(product);
		calorie=calorie+e.getCalories();
		proteine=proteine+e.getProteins();
		carboidrati=carboidrati+e.getCarbs();
		grassi=grassi+e.getFat();
		return;
	}

	public String getName() {
		return this.nome;
	}

	public double getCalories() {
		return this.calorie;
	}

	public double getProteins() {
		return this.proteine;
	}

	public double getCarbs() {
		return this.carboidrati;
	}

	public double getFat() {
		return this.grassi;
	}

	public boolean per100g() {
		// nutritional values are provided for the whole menu.
		return false;
	}
}

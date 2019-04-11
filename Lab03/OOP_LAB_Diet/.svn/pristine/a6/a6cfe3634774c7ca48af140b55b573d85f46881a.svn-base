package diet;

import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;

/**
 * Represent a recipe of the diet.
 * 
 * A recipe consists of a a set of ingredients that are given amounts of raw materials.
 * The overall nutritional values of a recipe can be computed
 * on the basis of the ingredients' values and are expressed per 100g
 * 
 *
 */
public class Recipe implements NutritionalElement {
    
	/**
	 * Recipe constructor.
	 * The reference {@code food} of type {@link Food} must be used to
	 * retrieve the information about ingredients. 
	 * 
	 * @param nome unique name of the recipe
	 * @param food object containing the information about ingredients
	 */
	private String nome;
	private Food food;
	private int flag;
	private Map<String,Number> ingrmap=new HashMap<>();
	private double calorie;
	private double proteine;
	private double carboidrati;
	private double grassi;
	
	public Recipe(String name, Food food){
		this.nome=name;
		this.food=food;
		this.flag=0;
		calorie=proteine=carboidrati=grassi=0;
		return;
	}
	
	/**
	 * Adds a given quantity of an ingredient to the recipe.
	 * The ingredient is a raw material defined with the {@code food}
	 * argument of the constructor.
	 * 
	 * @param material the name of the raw material to be used as ingredient
	 * @param quantity the amount in grams of the raw material to be used
	 */
	public void addIngredient(String material, double quantity) {
		NutritionalElement e=food.getRawMaterial(material);
		double q=quantity/100;
		if(flag==0){
			food.recpmap.put(this.nome,this); //o fare un metodo in food e mettere recmmap privata
			this.flag=1;
		}
		ingrmap.put(material, quantity);
		/*** Sembra inutile leggendo il testo memorizzare gli ingredienti
		 * ma a me sembra ancor più inutile avere una ricetta che non mi dice
		 * che ingredienti usare. Da questa mappa di ingredienti si ci può 
		 * ricavare tutto passando da food.
		 */
		this.calorie=this.calorie+e.getCalories()*q;
		this.proteine=this.proteine+e.getProteins()*q;
		this.carboidrati=this.carboidrati+e.getCarbs()*q;
		this.grassi=this.grassi+e.getFat()*q;
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
	  // a recipe expressed nutritional values per 100g
    return true;
  }

}

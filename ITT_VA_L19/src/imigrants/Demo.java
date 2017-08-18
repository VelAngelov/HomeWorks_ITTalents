package imigrants;

import imigrants.classes.Country;
import imigrants.classes.ImigrantPool;
import imigrants.classes.weapons.WeaponShop;

public class Demo {
	/*
	 * Въведени са леки промени в условието на задачата с цел да се постигне по
	 * голяма реалистичност. Приемания: 
	 * 1.Нелегалните емигранти има шанс в зависимост от своя тип да направят атентат.
	 * 2 Атентата е събитие при което ако се е стреляло с оръжие умират както в 
	 * задачата произволен брой цивилни след което имигранта,бива проверен 
	 * на границата -ако го заловят умира,ако не се крие извън града,докато не го 
	 * повикат роднини.Ако имаме взривяване на бомба броя на жертвите е по голям и 
	 * атентатора умира. Град изчезва само ако умрат всички цивилни и полицаи, 
	 * или ако остане без нито един полицай(При стрелбата има шанс и полицаи да 
	 * бъдат застреляни). 
	 * 3.Ако имигранта няма пари да си купи оръжие -и групировката иска да направи
	 * атентат,имигранта се самообива. 
	 * Условието с това дали емигранта е легален и ако има бомба да бъде
	 * пуснат от полицай е двусмислено, приел съм че на границата ще се прави само 
	 * проверка за легалност, ако въобще проверят имигранта 
	 * Относно 7.Тя може лесно да се реализира, но в случая не съм я направил.
	 */
	public static void main(String[] args) {

		WeaponShop shop = new WeaponShop(200, 50, 40, 10);
		ImigrantPool alQaeda = new ImigrantPool(100, 40, 35, 25, shop);
		Country germany = new Country("Germany");
		germany.generateTowns(15, 0.01);
		System.out.println(germany);
		alQaeda.startMigration(germany.towns());//голям брой редове с премествания!Добра идея е да се записват във файл!
		System.out.println(germany);
		alQaeda.makeAttacks(20);
		System.out.println(germany);
	}
}

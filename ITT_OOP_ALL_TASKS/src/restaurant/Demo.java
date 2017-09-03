package restaurant;

import java.util.Random;

import restaurant.lib.Client;
import restaurant.lib.Restaurant;

/*
 * 1. Създава ресторант с име „При Пешо Таланта“ и 5 сервитьора, работещи в
него. Началната сума, налична в ресторанта е 1000 лева. При създаването
си ресторантът съдържа 10 порции от всеки вид ястие и 20 броя от всеки
вид напитка.
2. Създава 15 клиента, като на произволен принцип трябва да бъдат
студенти, мутри или вегани. Вероятността да се създаде веган трябва да е
20%, студент – 30% , а мутра – 50%.
 */
/*
 * 3. Създава метод, който стартира работата на ресторанта. Работата на
ресторанта се състои в следното:
◦ влизане на всички клиенти в ресторанта;
◦ поръчка на всички клиенти към произволен сервитьор. Поръчките се
правят като на произволен принцип клиентът поръчва продукт, който
може да консумира. Всеки продукт има равен шанс да бъде поръчан.
◦ поискване на сметката от всеки клиент;
◦ плащане на сметката от всеки клиент.
4. Да се изпише текущия паричен баланс на ресторантът след като всички
клиенти са си отишли.
5. Да се изведе сервитьорът с най-голям бакшиш.
6. Да се изведат имената и бакшишите на всички сервитьори, подредени от
този с най-големия бакшиш за вечерта към този с най-малкия.
7. Да се изведе списък с останалите продукти, налични в ресторанта.
Продуктите да са сортирани по цена и разделени по вид. Да изглеждат по
следния начин:
Ястия:
Супа – 5 порции;
Десерт – 3 порции;
Основно – 1 порция;
Напитки:
Алкохол – 22 броя;
Безалкохолно – 14 броя.
 */
public class Demo {
	public static void main(String[] args) {
		Restaurant restaurant = new Restaurant("PRI PESHO TALANTA","MOL BULGARIA",1000);
		restaurant.findWaiters(5);
		restaurant.printMealsAndDrinks();
		
		Client[] clients = new Client[15];
		for (int i = 0; i < clients.length; i++) {
			int rnd = new Random().nextInt(101);
			if(rnd < 30) {
				clients[i]= Client.createNewStudent();
			}else if(rnd<30+50) {
				clients[i] = Client.createNewMutra();
			}else {
				clients[i] = Client.createNewVegan();
			}
		}
		
		restourantWork(restaurant, clients);
		
		System.out.println("Balance in restaurant:"+restaurant.getCash()+"lv");
		
		restaurant.printWaiterWithMaxTips();
		
		restaurant.printWaiterWithTipsSorted();
		
		restaurant.printMealsAndDrinks();
	}
	
	public static void restourantWork(Restaurant restaurant,Client[] clients) {
		//enter and order:
		for (int i = 0; i < clients.length; i++) {
			clients[i].goToRestaurant(restaurant);
			clients[i].orderMealsAndDrinks();
		}
		//bills and pays:
		for (int i = 0; i < clients.length; i++) {
			clients[i].makeMyBill();
			clients[i].payTheBill();
		}
		
	}
}

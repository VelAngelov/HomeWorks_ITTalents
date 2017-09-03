package imoti;

import java.time.LocalDate;
import java.util.Random;

import imoti.lib.Agencia;
import imoti.lib.Kupovach;
import imoti.lib.Prodavach;

/*
 * Да се реализира демо, в което:
1. Да се създаде агенция „Таланти Естейтс“ с пет агента с произволни имена.
2. Да се създадат 30 продавача на имоти. За всеки продавач да се създаде имот на
произволен принцип – 33% шанс да е апартамент, 33% шанс да е къща и 33% шанс за
парцел. Останалите характеристики също да са на произволен принцип. Цените на
имотите да варират – за къщите между 50 000 и 80 000 евро, за апартаментите – между
70 000 и 150 000 евро; за парцелите – между 30 000 и 85 000 евро.
3. Всички продавачи да регистрират имотите си за продажба в агенцията;
4. Да се създадат 10 купувача на произволен принцип с бюджети между 30 000 и 150 000
евро;
5. Всички купувачи да регистрират заявки за търсене на имот към агенцията;
6. Всеки купувач да заяви 3 огледа на произволни имоти от агенцията;
7. Всеки купувач да заявки покупка на някой от огледаните от него имоти на произволен
принцип;
8. Да се изпише на екрана паричния баланс на агенцията след продажбата на имотите;
9. Да се изпише на екрана паричния баланс на всеки агент от агенцията след продажбата
на имотите, като агентите са сортирани от най-богатия към този с най-малко печалби.
 */
public class Demo {
	public static void main(String[] args) {
		Agencia agencia = new Agencia("Talanti estates", "Ala bala", "0888888888");
		agencia.generateRandomAgents(5);
		
		Prodavach[] prodavachi = new Prodavach[30];
		for (int i = 0; i < prodavachi.length; i++) {
			prodavachi[i]= new Prodavach("Prodavach"+i, "083956546"+i, Prodavach.generateNewRandomImot());
			prodavachi[i].registerInAgencia(agencia);
		}
		
		Kupovach[] kupovachi = new Kupovach[10];
		for (int i = 0; i < kupovachi.length; i++) {
			kupovachi[i] = new Kupovach("Kupovach"+i, "0895554"+i,30_000+new Random().nextInt(150_001-30_000));
			kupovachi[i].registerInAgencia(agencia);
			kupovachi[i].zaqviOgled(LocalDate.of(2017, 9, 4));
			kupovachi[i].zaqviOgled(LocalDate.of(2017, 9, 4));
			kupovachi[i].zaqviOgled(LocalDate.of(2017, 9, 4));
			kupovachi[i].napraviPokupkaNaEdinImot();
		}
		
		System.out.println(agencia.getName()+" balance:"+agencia.getCash()+"lv");
		agencia.printSortedAgentsByIncome();
	}
}

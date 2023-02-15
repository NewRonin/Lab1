import java.io.PrintStream;
import java.util.*;


public class Calculus {
	public static Scanner in = new Scanner(System.in);
	public static PrintStream out = System.out;

	public static void main(String[] args){

		float a = in.nextFloat();
		float b = in.nextFloat();

		Complex number1;
		number1 = new Complex(a, b);

		a = in.nextFloat();
		b = in.nextFloat();

		Complex number2;
		number2 = new Complex(a, b);
		
		number1.getNumber();
		number2.getNumber();

		//СЛОЖЕНИЕ КОМПЛЕКСНЫХ ЧИСЕЛ

		number1.add(number2);

		//УМНОЖЕНИЕ КОМПЛЕКСНЫХ ЧИСЕЛ
		
		number1.mult(number2);
		
		//ТРИГ ФОРМА
		number1.getTriangle();	
		
		//Создание и заполнение матриц
		Matrix arr, arr2;
		arr = new Matrix(3, 2);
		arr2 = new Matrix(2, 2);
		arr.fill();
		arr2.fill();
		
		arr.getMatrix();
		arr2.getMatrix();
		
		//Умножение + сложение матриц 
		arr.add(arr2);
		arr.mult(arr2);
		System.out.println("");
		arr.getMatrix();
		
		//Транспонирование
		arr.getMatrix();
		arr.transpose();
		arr.getMatrix();

	}
}

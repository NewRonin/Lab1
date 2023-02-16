import java.util.*;


public class Calculus {
	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args){
		
		//Ниже приведён тест всего функционала
		
		
		//Инициализация комплексных чисел, ввод значений
		Complex number1;
		number1 = new Complex(1);

		Complex number2;
		number2 = new Complex(1, 1);

		System.out.println("Числа: \n");
		number1.getNumber();
		System.out.println("");
		number2.getNumber();
		System.out.println("");

		System.out.print('\n'+"Сложение комплексных чисел: ");

		//Сложение
		try {
			number1.add(number2);
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		number1.getNumber();
		System.out.println("");
		
		//Умножение
		System.out.print('\n'+"Умножение комплексных чисел: ");

		number1.mult(number2);

		number1.getNumber();
		System.out.println("");
		
		//Тригонометрическая форма
		System.out.print('\n'+"Тригонометрическая форма: ");
		number1.getTriangle();
		System.out.println("");

		//Создание и заполнение матриц
		Matrix arr, arr2;
		arr = new Matrix(2, 2);
		arr2 = new Matrix(2, 2);
		
		//Несколько доп. значений для матрицы
		Complex number3;
		number3 = new Complex(1, 1);

		Complex number4;
		number4 = new Complex(1);

		arr.setArr(new Complex [][] {{number1, number2}, {number3, number4}});
		arr2.setArr(new Complex [][] {{number1, number2}, {number3, number4}});

		System.out.println('\n' + "Матрицы:");
		arr.getMatrix();
		arr2.getMatrix();
		
		//Сложение
		System.out.println('\n' + "Сложение матриц:");
		try {
			arr.add(arr2);
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		arr.getMatrix();
		
		//Умножение
		System.out.println('\n' + "Умножение матриц:");
		try {
			arr.mult(arr2);
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		arr.getMatrix();
		
		//Транспонирование
		System.out.println('\n' + "Транспонирование:");
		arr.transpose();
		arr.getMatrix();

	}
}

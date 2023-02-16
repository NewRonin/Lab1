public class Matrix {

	private int m, n;
	// Область комплексных чисел включает действительные, удобнее все элементы хранить комплексными
	private Complex arr[][];

	//Конструкторы ввода
	public Matrix() {
		this(0,0);
	}
	public Matrix(int m, int n) {
		this.m = m;
		this.n = n;
		this.arr = new Complex[m][n];
	}

	// Процедура ручного заполнения
	public void fill() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				this.arr[i][j] = new Complex(Calculus.in.nextFloat(), Calculus.in.nextFloat());
				this.arr[i][j].getNumber();
				System.out.println("");

			}
		}
	}

	// Сложение матриц
	public void add(Matrix arr2) {
		//Выкидываем исключение, если размерности разные
		if ((this.m != arr2.m) || (this.n != arr2.n)) {
			throw new IllegalArgumentException("Невозможно сложить матрицы.");
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				this.arr[i][j].add(arr2.arr[i][j]);
			}
		}

	}
	
	

	//Умножение матриц
	public void mult(Matrix arr2) {
		// Выкидываем исключение, если смежные размерности не совпадают
		if (this.n != arr2.m) {
			throw new IllegalArgumentException("Невозможно перемножить матрицы");
		}

		Matrix result;
		result = new Matrix(this.m, arr2.n);

		for(int i = 0; i < this.m; i++) {
			for(int j = 0; j < arr2.n; j++) {
				result.arr[i][j] = new Complex();
				for(int k = 0; k < arr2.n; k++) {
					//Создаем локальную переменную, дабы не изменять изначальный объект
					Complex temp = new Complex();
					temp.add(this.arr[i][k]);
					temp.mult(arr2.arr[k][j]);
					result.arr[i][j].add(temp);
				}
			}
		}

		//Перезаписываем экземпляр класса
		this.arr = result.arr;
		this.m = result.m;
		this.n = result.n;
	}

	//Транспонирование матрицы
	public void transpose() {
		// Создадим локально ещё один экземпляр класса для удобства
		Matrix result;
		result = new Matrix(this.n, this.m);

		for(int i = 0; i < this.m; i++) {
			for(int j = 0; j < this.n; j++) {
				result.arr[j][i] = this.arr[i][j];
			}
		}

		//Скопируем получившийся результат
		this.m = result.m;
		this.n = result.n;
		this.arr = result.arr;
	}

	//Геттеры/Сеттеры класса
	
	//Быстрая процедура печати матрицы
	public void getMatrix() {
		
		for (int i = 0; i < m; i++) {
			System.out.println();
			for (int j = 0; j < n; j++) {
				try {
					arr[i][j].getNumber();
				}
				catch (NullPointerException e) {
					System.out.println("Матрица пуста \n");
				}
				System.out.print(" ");

			}
		}
		System.out.println("");
	}

	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public Complex[][] getArr() {
		return arr;
	}
	public void setArr(Complex[][] arr) {
		this.arr = arr;
	}


}
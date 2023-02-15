import java.util.*;

public class Matrix {

	private int m, n;
	private Complex arr[][];
	
	public Matrix() {
		this(0,0);
	}
	public Matrix(int m, int n) {
		this.m = m;
		this.n = n;
		this.arr = new Complex[m][n]; 
	}
	
	public void fill() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
		
				this.arr[i][j] = new Complex(Calculus.in.nextFloat(), Calculus.in.nextFloat());
				this.arr[i][j].getNumber();
				System.out.println("");
				
			}
		}
	}
	
	public void add(Matrix arr2) {
		if ((this.m != arr2.m) || (this.n != arr2.n)) {
			System.out.println("Невозможно сложить матрицы.");
		}
		else {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					this.arr[i][j].add(arr2.arr[i][j]); 
				}
			}			
		}
	}
	
	public void mult(Matrix arr2) {
		if (this.n == arr2.m) {
			Matrix result;
			result = new Matrix(this.m, arr2.n);
			
			for(int i = 0; i < this.m; i++) {
				for(int j = 0; j < arr2.n; j++) {
					result.arr[i][j] = new Complex();
					for(int k = 0; k < arr2.n; k++) {
						//Создаем локальную переменную, дабы не изменять изначальный объект
						Complex temp = new Complex();
						//Изначально она нулевая, можно попросту прибавить нужное значение, чтобы скопировать его
						temp.add(this.arr[i][k]);
						temp.mult(arr2.arr[k][j]);
						result.arr[i][j].add(temp);
					}
				}
			}
			
			this.arr = result.arr;
			this.m = result.m;
			this.n = result.n;
			
		}
		else {
			System.out.println("Невозможно перемножить матрицы");
		}
	}
	
	public void transpose() {
		Matrix result;
		result = new Matrix(this.n, this.m);
		
		for(int i = 0; i < this.m; i++) {
			for(int j = 0; j < this.n; j++) {
				result.arr[j][i] = this.arr[i][j];
			}
		}
		this.m = result.m;
		this.n = result.n;
		this.arr = result.arr;
	}
	
	//get/set
	
	public void getMatrix() {
		for (int i = 0; i < m; i++) {
			System.out.println();
			for (int j = 0; j < n; j++) {
				
				arr[i][j].getNumber();
				System.out.print(" ");
				
			}
		}
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
	

}

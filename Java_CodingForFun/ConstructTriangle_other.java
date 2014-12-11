package codingForFun;

// Given a array 
// {{ 4,7,3,6,7}} 
// construct a triangle like 
// {{81}} 
// {{40,41}} 
// {{21,19,22}} 
// {{11,10,9,13}} 
// {{ 4,7,3,6,7}}
public class ConstructTriangle_other {

	public void printTriangle(int[] array) {
		if (array != null && array.length > 0) {
			int length = array.length - 1;
			int[] newArray = new int[length];
			for (int i = 0; i < array.length - 1; i++) {
				newArray[i] = array[i] + array[i + 1];
			}
			printTriangle(newArray);
			printTriangleHelper(newArray);
		}
	}

	public void printTriangleHelper(int[] array) {
		if (array != null && array.length > 0) {
			int len = array.length;
			System.out.print("{{");
			for (int i = 0; i < len - 1; i++) {
				System.out.print(array[i] + ", ");
			}
			System.out.print(array[len - 1] + "}}");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		ConstructTriangle_other cto = new ConstructTriangle_other();
		int[] array = new int[] { 4, 7, 3, 6, 7 };
		cto.printTriangle(array);
		cto.printTriangleHelper(array);
	}
}

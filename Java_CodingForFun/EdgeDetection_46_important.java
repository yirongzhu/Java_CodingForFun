package codingForFun;

// Two-dimensional array representation of an image can also be represented by a one-dimensional array of W*H size,
// where W represent row and H represent column size and each cell represent pixel value of that image. You are also given a threshold X.
// For edge detection, you have to compute difference of a pixel value with each of it's adjacent pixel and find maximum of all differences.
// And finally compare if that maximum difference is greater than threshold X. if so, then that pixel is a edge pixel and have to display it.
public class EdgeDetection_46_important {

	public int[] detectEdge(int[] image, int width, int threshold) {
		if (image == null || width < 1 || image.length < width || image.length % width != 0) {
			return null;
		}
		int imageLength = image.length;
		int[] output = new int[imageLength];
		int height = imageLength / width;
		int colMin, colMax, rowMin, rowMax, index, position;
		
		for (int row = 0; row < height; row++) {
			int rowNum = row * width;
			for (int col = 0; col < width; col++) {
				index = rowNum + col;
				position = image[index];
				colMin = (col == 0) ? 0 : col - 1;
				colMax = (col == width - 1) ? (width - 1) : col + 1;
				rowMin = (row == 0) ? 0 : row - 1;
				rowMax = (row == height - 1) ? (height - 1) : row + 1;
				if (greaterThanThreshold(colMin, colMax, rowMin, rowMax, width, image, position, threshold)) {
					output[index] = position;
				}
			}
		}
		return output;
	}
	
	public boolean greaterThanThreshold(int colMin, int colMax, int rowMin, int rowMax, int width, int[] image, int position, int threshold) {
		int maxD = Integer.MIN_VALUE;
		for (int row = rowMin; row <= rowMax; row += width) {
			for (int col = colMin; col <= colMax; col++) {
				if (Math.abs(position - image[row + col]) > maxD){
					maxD = Math.abs(position - image[row + col]);
				}
			}
		}
		return maxD > threshold ? true : false;
	}
	
	public static void main(String[] args) {
		EdgeDetection_46_important ei = new EdgeDetection_46_important();
		int[] image = new int[] {1,3,4,5,2,4,6,3,5,6,7,3,8,2,12,52};
		int threshold = 3;
		int width = 4;
		int[] output = ei.detectEdge(image, width, threshold);
		for (int i : output) {
			System.out.print(i + " ");
		}
	}
}

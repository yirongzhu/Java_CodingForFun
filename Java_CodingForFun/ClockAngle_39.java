package codingForFun;

// We are given a specific time(like 02:23), we need to get the angle between hour and minute(less than 180)
public class ClockAngle_39 {

	public double getAngle(String time) {
		int h = Integer.parseInt(time.substring(0, time.indexOf(":")));
		int m = Integer.parseInt(time.substring(time.indexOf(":") + 1));
		double angleM = (double) (m * 6);
		double angleH = (double) (h * 30 + m * 0.5);
		double angle = Math.abs(angleM - angleH);
		return angle <= 180 ? angle : (360 - angle);
	}
	
	public static void main(String[] args) {
		ClockAngle_39 ca = new ClockAngle_39();
		System.out.println(ca.getAngle("02:23"));
		System.out.println(ca.getAngle("12:15"));
	}
}

package meal;

public class Meal {
	public int maxTime;
	public int accumulatedTime;
	public String mealTime;
	
	public Meal(String mealTime, int maxTime) {
		this.mealTime = mealTime;
		this.maxTime = maxTime;
	}
	
	public boolean roll() {
		++accumulatedTime;
		if(accumulatedTime<maxTime) {
			System.out.println(mealTime + "기다릴수있는 시간:" + (maxTime-accumulatedTime));
			return true;
		} else {
			System.out.println(mealTime + "배고픔");
			return false;
		}
	}
}

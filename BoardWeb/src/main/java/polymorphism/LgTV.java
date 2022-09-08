package polymorphism;

public class LgTV implements TV{
	@Override
	public void powerOn() {
		System.out.println("엘지티비가 켜졌습니다.");		
	}
	@Override
	public void powerOff() {
		System.out.println("엘지티비가 꺼졌습니다.");		
	}
	@Override
	public void volumeUp() {
		System.out.println("엘지티비 소리를 올립니다.");		
	}
	@Override
	public void volumeDown() {
		System.out.println("엘지티비 소리를 줄입니다.");		
	}
}

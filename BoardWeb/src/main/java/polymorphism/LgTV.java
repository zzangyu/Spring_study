package polymorphism;

public class LgTV implements TV{
	@Override
	public void powerOn() {
		System.out.println("����Ƽ�� �������ϴ�.");		
	}
	@Override
	public void powerOff() {
		System.out.println("����Ƽ�� �������ϴ�.");		
	}
	@Override
	public void volumeUp() {
		System.out.println("����Ƽ�� �Ҹ��� �ø��ϴ�.");		
	}
	@Override
	public void volumeDown() {
		System.out.println("����Ƽ�� �Ҹ��� ���Դϴ�.");		
	}
}
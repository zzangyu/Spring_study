package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// <bean id="tv" class="polymorphism.LgTV"/> 이 bean을 만드는거임

@Component("tv")
public class LgTV implements TV{
	
	@Autowired
	// @Qualifier("sony") : 아이디로 지정
	// @Resource(name = "apple")
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("====>엘지티비 객체 생성");
	}
	
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
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
}

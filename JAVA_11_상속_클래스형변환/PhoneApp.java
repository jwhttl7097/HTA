package day1;

public class PhoneApp {

	public static void main(String[] args) {

		// Phone객체 생성하기
		Phone phone = new Phone();
		phone.setTel("010-1234-5678");
		phone.call();
		
		// FeaturePhone객체 생성하기
		FeaturePhone featurePhone = new FeaturePhone();
		featurePhone.setTel("010-3333-3333");				// Phone객체로부터 물려받은 속성값 변경
		featurePhone.setPixel(7000000);						// FeaturePhone의 고유한 속성값 변경
		featurePhone.call();								// Phone객체로부터 물려받은 기능
		featurePhone.takePicture();							// FeaturePhone의 고유한 속성
		
		// SmartPhone객체 생성하기
		SmartPhone smartPhone = new SmartPhone();
		smartPhone.setTel("010-4444-4444");					// Phone객체로부터 물려받은 속성값 변경
		smartPhone.call();									// Phone객체로부터 물려받은 기능
		smartPhone.setIp("000.000.000.00");					// SmartPhone객체의 고유한 속성값 변경
		smartPhone.setEmailAddress("zxcv1234@naver.com");	// SmartPhone객체의 고유한 속성값 변경
		smartPhone.web();									// SmartPhone객체의 고유한 기능
		smartPhone.mail();									// SmartPhone객체의 고유한 기능
	}

}

이클립스-톰캣 연동 방법

이클립스 Window > Preferences 클릭

![톰캣연동1](https://user-images.githubusercontent.com/62005139/118573898-5c96fb80-b7be-11eb-9bf4-5d128556ef47.PNG)

 Server > Runtime Environments 클릭
 
 ![톰캣연동2](https://user-images.githubusercontent.com/62005139/118574043-9f58d380-b7be-11eb-8d74-14a1ae03092b.PNG)
 
 Add > Apache Tomcat v10.0 클릭 > Next>

![톰캣연동3](https://user-images.githubusercontent.com/62005139/118574153-d333f900-b7be-11eb-9377-5caf5ff02a78.PNG)

Browse.. > C:\Program Files\Apache Software Foundation\Tomcat 10.0 폴더선택 > Finish

![톰캣연동4](https://user-images.githubusercontent.com/62005139/118574258-024a6a80-b7bf-11eb-9f38-32053ba9a054.PNG)

Name하단부 Apache Tomcat v10.0 설정확인 > Apply and Close

![톰캣연동5](https://user-images.githubusercontent.com/62005139/118574395-489fc980-b7bf-11eb-8244-6aa2ee43bc94.PNG)

하단부 Servers탭에서 No servers are... 더블클릭

![톰캣연동6](https://user-images.githubusercontent.com/62005139/118574600-ba781300-b7bf-11eb-9e8f-9f6998939a69.PNG)

Server Locations탭 > Use Tomcat installation (...) 선택 > Ports에서 Tomcate admin port 89변경 > 저장

![톰캣연동7](https://user-images.githubusercontent.com/62005139/118574771-16429c00-b7c0-11eb-931c-e190dca84151.PNG)

다시 하단부 Servers탭에서 No servers are... 우클릭 > Start

![톰캣연동8](https://user-images.githubusercontent.com/62005139/118574848-44c07700-b7c0-11eb-9f0a-cbe209aaffb5.PNG)

Console탭에서 서버실행 확인

![톰캣연동9](https://user-images.githubusercontent.com/62005139/118574882-59047400-b7c0-11eb-820c-40ad46331a93.PNG)

인터넷 주소창에 http://localhost/ 접속후 톰캣 화면 확인 되면 연동 완료.
![image](https://user-images.githubusercontent.com/62005139/118575163-ca442700-b7c0-11eb-861a-7288219ddfb0.png)

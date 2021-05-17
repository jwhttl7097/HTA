아파치 톰캣 설치 과정
 URL : https://tomcat.apache.org/ 접속
![톰캣홈페이지1](https://user-images.githubusercontent.com/62005139/118459926-2e220d80-b737-11eb-835e-8f7f6c666d30.PNG)


Tomcat10 다운로드
![톰캣홈페이지2](https://user-images.githubusercontent.com/62005139/118460099-5a3d8e80-b737-11eb-89a6-8749d10e9702.PNG)


운영체재에 맞는 설치 파일 다운로드
![톰캣홈페이지3](https://user-images.githubusercontent.com/62005139/118460223-72ada900-b737-11eb-87a1-f50fad038b0d.PNG)


다운받은 톰캣 설치파일 실행
![톰캣설치4](https://user-images.githubusercontent.com/62005139/118460351-9375fe80-b737-11eb-87cd-b496a25bfcb2.PNG)


설치 진행중 Host Manager 및 Examples 추가 선택후 Next>
![image](https://user-images.githubusercontent.com/62005139/118460454-b1436380-b737-11eb-833b-bbe9c4da0217.png)

HTTP/1.1 Connector Port 80으로 수정
Tomcat Administrator Login 에서 User Name, Password 설정 후 Next>
![image](https://user-images.githubusercontent.com/62005139/118460864-0e3f1980-b738-11eb-8517-cecb995f1318.png)

경로를 JDK로 설정후 설치 진행
![image](https://user-images.githubusercontent.com/62005139/118462227-69254080-b739-11eb-810d-c57eb6d7fe11.png)
![image](https://user-images.githubusercontent.com/62005139/118462327-84904b80-b739-11eb-9bfd-6f79cc8c39e7.png)


설치를 끝내고 http://localhost/  접속하여 톰캣 홈페이지 화면이 나오는지 확인(정상 서버구동중)
접속이 안될 경우 http://localhost:Port번호 입력으로 접속하기 (설치때 설정한 포트번호 ex)80 )
![image](https://user-images.githubusercontent.com/62005139/118462690-ed77c380-b739-11eb-92b6-abf0b31af286.png)

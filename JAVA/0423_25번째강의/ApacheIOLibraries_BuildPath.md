**Apache commons io 라이브러리 다운받기**
![image](https://user-images.githubusercontent.com/62005139/115981053-0920fb80-a5cc-11eb-81e2-03aab3a806ec.png)
http://commons.apache.org/proper/commons-io/  <- 접속

![image](https://user-images.githubusercontent.com/62005139/115981086-3c638a80-a5cc-11eb-936b-78754b6751b5.png)

릴리즈 된 상위 최신 버전 Download now! 클릭

![image](https://user-images.githubusercontent.com/62005139/115981113-7b91db80-a5cc-11eb-9a58-b600cc97b4cf.png)
commons-io-2.8.0-bin.zip 파일 다운로드


**Apache commons io 라이브러리 Build Path하기**
![image](https://user-images.githubusercontent.com/62005139/115980627-2607ff80-a5c9-11eb-8c39-19600ec9a22c.png)
해당 프로젝트 우측클릭 -> Build Path -> Configure Build Path클릭

![image](https://user-images.githubusercontent.com/62005139/115980659-62d3f680-a5c9-11eb-9aaf-d6a2435cc9b6.png)
Libraries탭 -> Classpath 클릭 -> Add External JARs 클릭

![image](https://user-images.githubusercontent.com/62005139/115980702-b1819080-a5c9-11eb-9ca6-35546fc081e7.png)
해당 라이브러리 commons-io-2.8.0.jar 파일 선택 후 열기 -> Apply -> Apply and Close


**Apache commons io 라이브러리 사용하기 (FileUtils, IOUtils)**
  - 파일복사하기 2가지 방법
  방법1. FileUtils.copyFile(new File("복사할 파일 위치/파일명.확장자"), new File("복사한 파일저장 위치/복사한 새로운 파일명.확장자"));
  방법2.     
    File 변수명1 = new File("복사할 파일 위치/파일명.확장자");
    File 변수명2 = new File("복사한 파일저장 위치/복사한 새로운 파일명.확장자");
    FileUtils.copyFile(변수명1, 변수명2);
   
  - 인터넷의 자원(텍스트, 사진, 영상) 가져오기
    URL 변수명1 = new URL("인터넷의 자원 주소");
    InputStream 변수명2 = 변수명1.openStream();
    FileOutputStream 변수명3 = new FileOutputStream("인터넷에서 가져온 파일저장 위치/복사한 새로운 파일명.확장자");
    IOUtils.copy(변수명2, 변수명3);



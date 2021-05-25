마이바티스 설치 및 셋팅 순서

1. 마이바티스 깃허브에서 최신 릴리즈된 마이바티스 버전을 다운로드

https://github.com/mybatis/mybatis-3/releases

![image](https://user-images.githubusercontent.com/62005139/119472471-3d333c00-bd85-11eb-8013-01ca6801d874.png)

2. 압축해제 후 mybatis-3.5.7.jar파일
 
![image](https://user-images.githubusercontent.com/62005139/119473097-ccd8ea80-bd85-11eb-8503-08c7cad1aa42.png)

3. lib폴더 내 .jar파일 전부

![image](https://user-images.githubusercontent.com/62005139/119473027-b92d8400-bd85-11eb-9fb9-e519a04d7c3c.png)

4.C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib -> ojdbc6.jar 파일 

![image](https://user-images.githubusercontent.com/62005139/119473490-2c36fa80-bd86-11eb-9d5f-f5a99619c309.png)

5. (2, 3, 4 파일 전부)를 -> 생성한 Dynamic web Project -> src -> webapp -> WEB-INF -> lib폴더에 넣기

![image](https://user-images.githubusercontent.com/62005139/119473973-a9fb0600-bd86-11eb-9d76-abfcbc543d04.png)

6. 생성한 Dynamic web Project에 src/main/resources 폴더를 생성

![image](https://user-images.githubusercontent.com/62005139/119474418-14ac4180-bd87-11eb-84ad-cb1f3b9c0650.png)

7. src/main/resources -> new -> Source Folder -> 폴더명 mybatis 생성

![image](https://user-images.githubusercontent.com/62005139/119474584-458c7680-bd87-11eb-9bc2-f775c593892c.png)

 7-1 생성된 mybatis 리소스 폴더에 mybatis-config.xml 파일을 넣어준다
 
 ![image](https://user-images.githubusercontent.com/62005139/119474916-9b611e80-bd87-11eb-824d-8860eb0b50a8.png)

8. src/main/resources -> new -> Source Folder -> 폴더명 mybatis.mappers 생성

![image](https://user-images.githubusercontent.com/62005139/119475258-f2ff8a00-bd87-11eb-913b-71462564fcf9.png)

 8-1 생성된 mybatis.mappers 리소스 폴더에 log4j.properties 파일을 넣어준다
 
 ![image](https://user-images.githubusercontent.com/62005139/119475364-0dd1fe80-bd88-11eb-8bb1-e0113572401c.png)

9. src -> main폴더에 resources폴더 생성 -> resources폴더에 log4j.properties 파일을 넣고 mybatis라는 폴더를 하나 더 생성한다.

![image](https://user-images.githubusercontent.com/62005139/119475617-440f7e00-bd88-11eb-8e02-780199827371.png)

10. src -> main -> resources -> mybatis폴더에 mybatis-config.xml 파일을 넣어준다.

![image](https://user-images.githubusercontent.com/62005139/119476154-c435e380-bd88-11eb-809b-03976c65b31b.png)

11. src/main/java -> util을 관리하는 패키지를 만들고 패키지안에 MybatisUtils.java 파일을 넣는다.

![image](https://user-images.githubusercontent.com/62005139/119476853-681f8f00-bd89-11eb-8207-1ecf07beb9ea.png)


- 셋팅완료 

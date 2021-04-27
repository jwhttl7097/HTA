oracle 설치하기
  
	- 다운로드 URL : https://www.oracle.com/database/technologies/oracle-database-software-downloads.html
  ![오라클설치하기1](https://user-images.githubusercontent.com/62005139/116211576-ed118b80-a77e-11eb-8bda-016389ac228c.PNG)
  
  
	- Oracle Database 11gR2 Express Edition for Windows x64 클릭후 다운로드 진행
  ![오라클설치하기2](https://user-images.githubusercontent.com/62005139/116211498-d703cb00-a77e-11eb-9ab5-222e2382e723.PNG)
  ![오라클설치하기3](https://user-images.githubusercontent.com/62005139/116211756-1df1c080-a77f-11eb-85e7-ce621dfae4ac.PNG)
  
  
	- 다운로드 폴더의 OracleXE112_Win64.zip파일 압축풀기
  ![image](https://user-images.githubusercontent.com/62005139/116211952-55606d00-a77f-11eb-82a6-13b634d0ec0b.png)
  
  
	- 다운로드 폴더의 OracleXE112_Win64/DISK1 폴더의 setup.exe 실행후 순차적 설치 진행
  ![오라클설치하기4](https://user-images.githubusercontent.com/62005139/116212062-6a3d0080-a77f-11eb-8d4c-cf2eab61c94c.PNG)
  
  
	- 설치과정에서 묻는 비밀번호는 시스템계정의 비밀번호로 본인이 사용할 비밀번호 입력하고 설치 진행
	- * 오라클의 관리자계정(system 계정) 비밀번호로 설정된다.
  ![image](https://user-images.githubusercontent.com/62005139/116212263-9d7f8f80-a77f-11eb-838a-dec84aa857a1.png)
	 
	 
   
   
	- 오라클이 제공하는 샘플계정(hr) 활성화 하기
		- 윈도우 시작탭에서 Run SQL Command Line 실행
    ![image](https://user-images.githubusercontent.com/62005139/116212848-39110000-a780-11eb-861f-8a210ccfe463.png)
    
		 SQL> conn system/설치때 설정했던 시스템계정의 비밀번호 입력			-- 관리자 계정 접속
		 Connected.
		 SQL> alter user hr account unlock;		-- hr계정 활성화
		 User altered.
	 	 SQL> alter user hr identified by zxcv1234;	-- hr계정 사용하고자 하는 비밀번호 입력
		 User altered.
     
   - hr계정 접속 테스트
		SQL> conn hr/zxcv1234				-- hr계정 접속
		Connected.					-- 접속완료.
     ![관리자계정_hr계정활성화](https://user-images.githubusercontent.com/62005139/116213146-7c6b6e80-a780-11eb-94d3-d2ab53efb17a.PNG)
     		

		- hr계정의 테이블들 조회하기
    ![테이블조회](https://user-images.githubusercontent.com/62005139/116213452-c5232780-a780-11eb-859a-306a642c472e.PNG)
		SQL> select * from tabs;
		- 테이블 조회결과 7개의 테이블 발견
    ![테이블조회결과](https://user-images.githubusercontent.com/62005139/116213469-c7858180-a780-11eb-87fe-7cfd48b978cc.PNG)

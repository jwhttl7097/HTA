package com.sample.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sample.vo.Score;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/core")
public class CoreTagSampleServlet extends HttpServlet{

   @Override
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
	   // <c:out /> 태그연습
      String text1 = "택배 배송이 너무 지연됩니다. 확인부탁드려요";
      String text2 = "<script>function a() { alert('해피해킹');}</script><button onclick='a()'>클릭</button>";      
      request.setAttribute("text1", text1);
      request.setAttribute("text2", text2);
      
      // <c:if test="${조건식}">컨텐츠</if> 태그 연습
      // <c:choose />, <c:when test="${조건식}"/>, <c:otherwise /> 태그 연습
      request.setAttribute("score", 85);
      
      ArrayList<String> names = new ArrayList<String>();
      names.add("홍길동");
      names.add("김유신");
      request.setAttribute("names", names);
      
      Map<String, Integer> condition = new HashMap<String, Integer>();
      condition.put("year", 3);					// 자동차 사용기간 3년
      condition.put("distance", 100000);			// 운행거리 10만km
      request.setAttribute("car", condition);
      
      // <c:forEach var="변수명" items="${}">HTML 컨텐트</c:forEach> 태그연습
      List<String> members = new ArrayList<String>();
      members.add("홍길동");
      members.add("김유신");
      members.add("이봉창");
      members.add("윤봉길");
      members.add("유관순");
      request.setAttribute("members", members);
      
      List<Score> scoreList = new ArrayList<>();
      scoreList.add(new Score("길동", "홍", 100, 90, 80));
      scoreList.add(new Score("유신", "김", 50, 70, 60));
      scoreList.add(new Score("봉창", "이", 30, 40, 90));
      scoreList.add(new Score("봉길", "윤", 65, 90, 80));
      scoreList.add(new Score("관순", "유", 60, 75, 45));
      request.setAttribute("scores", scoreList);
      
      // <c:set /> 태그 연습
      request.setAttribute("king", new Score("세종", "대왕", 100, 100, 100));
      
      //core.jsp 내부이동 시키기
      request.getRequestDispatcher("jstl/core.jsp").forward(request, response);
   }
}
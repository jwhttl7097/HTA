
package com.sample.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.dao.TodoDao;
import com.sample.vo.Todo;

@Controller
@RequestMapping("/todo")
public class TodoAjaxController {

	@Autowired TodoDao todoDao;
	
	@RequestMapping({"/list"})
	public String home(Model model) {
		List<Todo> savedTodos = todoDao.getAllTodos();
		model.addAttribute("todos", savedTodos);
		
		return "todo/ajax";
	}
	
	@RequestMapping("/add")
	public @ResponseBody ResponseEntity<Todo> add(Todo todo) {
		todoDao.insertTodo(todo);
		Todo savedTodo = todoDao.getTodoByNo(todo.getNo());
		return new ResponseEntity<Todo>(savedTodo, HttpStatus.OK);
	}
	
	@RequestMapping("/detail")
	public @ResponseBody ResponseEntity<Todo> detail(@RequestParam("no") int todoNo) {
		Todo savedTodo = todoDao.getTodoByNo(todoNo);
		return new ResponseEntity<Todo>(savedTodo, HttpStatus.OK);
	}
	
	@RequestMapping("/delete")
	public @ResponseBody ResponseEntity<Void> delete(@RequestParam("no") int todoNo) {
		Todo savedTodo = todoDao.getTodoByNo(todoNo);
		savedTodo.setStatus("삭제");
		savedTodo.setUpdatedDate(new Date());
		savedTodo.setDeletedDate(new Date());
		todoDao.updateTodo(savedTodo);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping("/modify")
	public @ResponseBody ResponseEntity<Todo> modify(Todo todo) {
		Todo savedTodo = todoDao.getTodoByNo(todo.getNo());
		savedTodo.setCategory(todo.getCategory());
		savedTodo.setTitle(todo.getTitle());
		savedTodo.setWriter(todo.getWriter());
		savedTodo.setDueDate(todo.getDueDate());
		savedTodo.setContent(todo.getContent());
		savedTodo.setUpdatedDate(new Date());
		
		todoDao.updateTodo(savedTodo);
		
		return new ResponseEntity<Todo>(savedTodo, HttpStatus.OK);
	}
	
	@RequestMapping("/complete")
	public @ResponseBody ResponseEntity<Void> completed(@RequestParam("no") int todoNo) {
		Todo savedTodo = todoDao.getTodoByNo(todoNo);
		savedTodo.setStatus("완료");
		savedTodo.setCompletedDate(new Date());
		savedTodo.setUpdatedDate(new Date());
		
		todoDao.updateTodo(savedTodo);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}

/*
 * @ResponseBody
 * 		- 요청핸들러 메소드가 반환하는 값이 응답메세지의 body부에 HTML 대신 포함되어 내려간다.
 * 		- pom.xml에 jackson-databind 라이브러리를 추가하면 요청핸들러 메소드가 반환하는 값이 json형식의 텍스트로
 * 		    자동 변환되어서 응답으로 전달된다.
 * 		작성예)
 * 			@ResponseBody
 * 			public List<Todo> list() {
 * 				List<Todo> todos = todoService.getAllTodos();
 * 				return todos;
 * 			}
 * 
 * 			@ResponseBody
 * 			public ResponseEntity<<Todo>> list() {
 * 				List<Todo> todos = todoService.getAllTodos();
 * 				return new ResponseEntity<>(todos, HttpStatus.OK);
 * 			}
 */

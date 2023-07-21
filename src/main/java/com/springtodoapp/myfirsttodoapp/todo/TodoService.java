package com.springtodoapp.myfirsttodoapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	private static int todosCount = 0;
	//intialization of static var todos
	static {
		todos.add(new Todo(++todosCount, "Abhijeet","Learn Python", 
				LocalDate.now().plusYears(1), false));
		
		todos.add(new Todo(++todosCount, "Arwaz","Learn Java", 
				LocalDate.now().plusYears(1), false));
		
		todos.add(new Todo(++todosCount, "Akash","Learn C++", 
				LocalDate.now().plusYears(1), false));
	}
	
	public List<Todo> findByUserName(String username){
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String userName, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todosCount, userName, description, targetDate, done);
		todos.add(todo);
	}
	
	public void deleteTodo(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId()==id;
		todos.removeIf(predicate );
	}

	public Todo findById(int id) {
		// TODO Auto-generated method stub
		Predicate<? super Todo> predicate = todo -> todo.getId()==id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		// TODO Auto-generated method stub
		deleteTodo(todo.getId());
		todos.add(todo);
	}
}

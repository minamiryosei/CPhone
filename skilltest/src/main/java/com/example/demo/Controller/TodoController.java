package com.example.demo.Controller;



import java.sql.Timestamp;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.Todo;
import com.example.demo.Service.TodoService;


@Controller
public class TodoController {

  @Autowired
  TodoService todoService;

  @GetMapping("/")
  public String home(Model model) {
    List<Todo> allTodo = todoService.searchAll();
    model.addAttribute("allTodo", allTodo);
    model.addAttribute("todo", new Todo());
    return "home";
  }

  // 新規登録用
  @PostMapping("/")
  public String createTodo(@Valid Todo todo, BindingResult bindingResult,Model model) {
    // 入力値にエラーがあった時
    if(bindingResult.hasErrors()) {
      List<Todo> allTodo = todoService.searchAll();
      model.addAttribute("allTodo", allTodo);
      model.addAttribute("todo", todo);
      return "home";
    }

    // エラーがなかった時は、Todoを新規登録する
    todoService.addTodo(todo);
    return "redirect:/";
  }

  // 未完了タスク横のボタンが押されたら、doneフラグをtrueに変更する
  @PostMapping("/done")
  public String doneTodo(@RequestParam(name = "id") Integer todoId) {
    Todo updateTodo = todoService.findById(todoId);
    updateTodo.setDone(true);
    todoService.addTodo(updateTodo);
    return "redirect:/";
  }

  // 追加(削除ボタンが押されたら、処理される)
  @PostMapping("/deleteAll")
  public String deleteAll() {
    todoService.deleteAllTodo();
    return "redirect:/";
  }
  public class Tod {
		public static void main(String[] args) {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			  System.out.println(timestamp);
		}
		}
  
}


package com.behzad.async.controller;

import com.behzad.async.component.AsyncComponentInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.concurrent.CompletableFuture;

@Controller
public class HelloController {

	@Autowired
	private AsyncComponentInf asyncComponent;

	@GetMapping("/hello")
	public String hello(Model model) {
		CompletableFuture<String> result = new CompletableFuture<>();
		asyncComponent.callMe(result);
		result.whenComplete((r,t) -> {
			System.out.println("result is :"+r);
		});
		System.out.println(" hello Controller ---- threadName:"+Thread.currentThread().getName());
		model.addAttribute("name", "John Doe :");

		return "welcome";
	}
}

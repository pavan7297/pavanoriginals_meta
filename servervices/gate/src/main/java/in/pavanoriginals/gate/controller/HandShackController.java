package in.pavanoriginals.gate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HandShackController {

	@GetMapping("/hello")
	public String wish() {
		return new String("<h1>hello server up</h1>");
	}
}

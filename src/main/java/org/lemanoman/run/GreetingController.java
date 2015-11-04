package org.lemanoman.run;

import java.util.concurrent.atomic.AtomicLong;

import org.lemanoman.model.GreetingModel;
import org.lemanoman.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    private EnderecoService enderecoService;

    @RequestMapping("/greeting")
    public GreetingModel greeting(@RequestParam(value="name", defaultValue="World") String name) {
	System.out.println(enderecoService.searchByCEP("07025120"));
	return new GreetingModel(counter.incrementAndGet(),
		String.format(template, name));
    }
}


package br.com.desafio.endPoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexEndPoint {

	private static final String BASE = "base";

	@RequestMapping(method = RequestMethod.GET)
	public String getIndex() {
		return BASE;
	}

}

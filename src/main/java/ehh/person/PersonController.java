package ehh.person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RefreshScope
public class PersonController {

	private Logger logger = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private PersonRepository pessoaRepository;

	@PostMapping(value = "/person/", produces = "application/json; charset=UTF-8")
	public void create(@RequestBody Person person) {
		logger.info(String.format("create(id: %s, name: %s)", person.getId(), person.getName()));
		pessoaRepository.save(person);
	}

	@GetMapping(value = "/person/{id}")
	public Person getPerson(@PathVariable("id") String id) {
		return pessoaRepository.findOne(id);
	}
}

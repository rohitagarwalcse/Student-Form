package com.Spring.Main.Student;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class StudentController {
		@Autowired
		private StudentRepository str;
		
		@GetMapping("/students")
		public List<Student> allStudent(){
			return str.findAll();
		}
		@GetMapping("/students/{id}")
		public Student specificStudent(@PathVariable long id) throws StudentNotFoundException {
			Optional<Student> os= str.findById(id);
			if(!os.isPresent()) {
				throw new  StudentNotFoundException(id);
			}
			return os.get();
		}
		@DeleteMapping("students/{id}")
		public void deleteStudent(@PathVariable long id) {
				str.deleteById(id);
		}
		@PostMapping("/students")
		public ResponseEntity<Student> createStudent(@RequestBody Student student){
			Student saveStudent= str.save(student);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveStudent.getId()).toUri();
			return ResponseEntity.created(location).build();
		}
}














package com.project.controller;

import com.project.model.Coder;
import com.project.repository.CoderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class CoderController {

    @Autowired
    CoderRepository repository;

    @GetMapping("/")
    public String home() {

        return "main.jsp";

    }

    // This endpoint is mainly called by the form in main.jsp.
    @GetMapping("/addCoder")
    public String addProgrammer(Coder coder) {

        repository.save(coder);
        return "main.jsp";

    }

    // This endpoint is mainly called by the form in main.jsp.
    @GetMapping("/getCoder")
    public ModelAndView getCoder(@RequestParam int id) {

        ModelAndView mv = new ModelAndView("getCoder.jsp");
        Coder coder = repository.findById(id).orElse(new Coder());
        mv.addObject(coder);

        return mv;

    }

    // @ResponseBody annotation causes the String to be printed directly as text.
    // (Rather than be treated as a file name)
    @GetMapping("/getCoders")
    @ResponseBody
    public List<Coder> getCoders() {

        return repository.findAll();

    }

    // @ResponseBody annotation causes the String to be printed directly as text.
    // (Rather than be treated as a file name)
    // produces = "application/xml" ensures that this endpoint can only return xml format.
    @GetMapping(path = "/getCodersXML", produces = "application/xml")
    @ResponseBody
    public List<Coder> getCodersXML() {

        return repository.findAll();

    }

    // @ResponseBody annotation causes the String to be printed directly as text.
    // (Rather than be treated as a file name)
    @GetMapping("/coder/{id}")
    @ResponseBody
    public Optional<Coder> coderById(@PathVariable("id") int id) {

        return repository.findById(id);

    }

}

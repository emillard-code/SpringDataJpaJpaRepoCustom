package com.project.controller;

import com.project.model.Coder;
import com.project.repository.CoderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class CoderController {

    @Autowired
    CoderRepository repository;

    @RequestMapping("/")
    public String home() {

        return "main.jsp";

    }

    // This endpoint is mainly called by the form in main.jsp.
    @RequestMapping("/addCoder")
    public String addProgrammer(Coder coder) {

        repository.save(coder);
        return "main.jsp";

    }

    // This endpoint is mainly called by the form in main.jsp.
    @RequestMapping("/getCoder")
    public ModelAndView getCoder(@RequestParam int id) {

        ModelAndView mv = new ModelAndView("getCoder.jsp");
        Coder coder = repository.findById(id).orElse(new Coder());
        mv.addObject(coder);

        return mv;

    }

    // @ResponseBody annotation causes the String to be printed directly as text.
    // (Rather than be treated as a file name)
    @RequestMapping("/getCoders")
    @ResponseBody
    public List<Coder> getCoders() {

        return repository.findAll();

    }

    // @ResponseBody annotation causes the String to be printed directly as text.
    // (Rather than be treated as a file name)
    // produces = "application/xml" ensures that this endpoint can only return xml format.
    @RequestMapping(path = "/getCodersXML", produces = "application/xml")
    @ResponseBody
    public List<Coder> getCodersXML() {

        return repository.findAll();

    }

    // @ResponseBody annotation causes the String to be printed directly as text.
    // (Rather than be treated as a file name)
    @RequestMapping("/coder/{id}")
    @ResponseBody
    public Optional<Coder> coderById(@PathVariable("id") int id) {

        return repository.findById(id);

    }

}

package eu.ensup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/formationList")
public class FormationController {
    private FormationRepository FormationRepository;

    @Autowired
    public FormationController(FormationRepository FormationRepository) {
        this.FormationRepository = FormationRepository;
    }

   /* @RequestMapping(value="/{theme}", method=RequestMethod.GET)
    public String listerLesFormations(@Path)*/
}

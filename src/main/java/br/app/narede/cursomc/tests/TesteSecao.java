package br.app.narede.cursomc.tests;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteSecao {
    @Autowired
    private HttpSession session;

    @RequestMapping(value = "/current-section", method = RequestMethod.GET)
    public Map<String, Object> currentSection(@RequestParam("requestedSectionId") String requestedSectionId) {
        Map<String, Object> result = new HashMap<>();
        String currentSectionId = (String) session.getAttribute("currentSectionId");
        if (currentSectionId != null && currentSectionId.equals(requestedSectionId)) {
            result.put("sameSection", true);
        } else {
            session.setAttribute("currentSectionId", requestedSectionId);
            result.put("sameSection", false);
        }
        return result;
    }
}


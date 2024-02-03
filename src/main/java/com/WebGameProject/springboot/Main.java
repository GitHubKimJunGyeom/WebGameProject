package com.WebGameProject.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Main {
   @RequestMapping("/")
   public @ResponseBody String root() throws Exception{
      
      return "test page";
   }
   
   @RequestMapping("/Main")
   public String testPage() {
      
      return "Main";
   }

}
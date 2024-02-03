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
   
   @RequestMapping("/guest/welcome")
   public String welcome1() {
      return "guest/welcome1";
   }
   
   @RequestMapping("/member/welcome")
   public String welcome2() {
      return "member/welcome2";
   }
   
   @RequestMapping("/admin/welcome")
   public String welcome3() {
      return "admin/welcome3";
   }

}
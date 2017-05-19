package com.boris.controller.test;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/requestMappingAndParamDemo")
@Controller
public class RequestMappingAndParamDemoController {
	private static Logger LOGGER = LoggerFactory.getLogger(RequestMappingAndParamDemoController.class);

	@RequestMapping("/home")
	public String home() {
		return "requestMappingAndParamHome";
	}

	// test 1 Testing @RequestParam without explicit attributes
	@RequestMapping("/test1")
	public String requestMappingAndParamTest1(@RequestParam("orgName") String orgName, Model model) {
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test1");
		return "requestMappingAndParamResults";
	}

	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String requestMappingAndParamTest2(@RequestParam("orgName") String orgName, Model model) {
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test2");
		return "requestMappingAndParamResults";
	}

	@RequestMapping(value = "*", method = RequestMethod.GET)
	public String requestMappingAndParamTest3() {
		return "fallback";
	}

	@RequestMapping(value = "/test4")
	public String requestMappingAndParamTest4(
			@RequestParam(value = "orgName", defaultValue = "Anonymous Organization") String orgName, Model model) {
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test4");
		return "requestMappingAndParamResults";
	}

	@RequestMapping(value = "/test5", method = RequestMethod.GET)
	public String requestMappingAndParamTest5(@RequestParam String orgname, Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("testserial", "test5");
		return "requestMappingAndParamResults";
	}

	// // Subtest 1
	// @RequestMapping(value = "/test6", method = RequestMethod.GET)
	// public String requestMappingAndParamTest6Subtest1(@RequestParam String
	// orgname, Model model) {
	// model.addAttribute("orgname", orgname);
	// model.addAttribute("testserial", "test6-subtest1");
	// return "requestMappingAndParamResults2";
	// }

	// Subtest 1
	@RequestMapping(value = "/test6", params = "orgname")
	public String requestMappingAndParamTest6Subtest1(@RequestParam String orgname, Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("testserial", "test6-subtest1");
		return "requestMappingAndParamResults2";
	}

	// // Subtest2
	// @RequestMapping(value = "/test6")
	// public String requestMappingAndParamTest6Subtest2(@RequestParam String
	// empcount, Model model) {
	// model.addAttribute("orgname", empcount);
	// model.addAttribute("testserial", "test6-subtest2");
	// return "requestMappingAndParamResults2";
	// }

	// Subtest2
	@RequestMapping(value = "/test6", params = "empcount")
	public String requestMappingAndParamTest6Subtest2(@RequestParam String empcount, Model model) {
		model.addAttribute("orgname", empcount);
		model.addAttribute("testserial", "test6-subtest2");
		return "requestMappingAndParamResults2";
	}

	// Subtest3 Multiple params
	@RequestMapping(value = "/test6/subtest4", method = RequestMethod.GET, params = { "orgname", "empcount" })
	public String requestMappingAndParamTest6Subtest4(@RequestParam String orgname, Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("testserial", "test6-subtest3");
		return "requestMappingAndParamResults2";
	}

	// Subtest3 Multiple params
	@RequestMapping(value = {"/test6","/test7"}, method = RequestMethod.GET)
	public String requestMappingAndParamTest7And8(@RequestParam String orgname, Model model, HttpServletRequest request)  {
		
		model.addAttribute("orgname", orgname);
		LOGGER.info(request.getRequestURI().toString());
		
		if(request.getRequestURI().contains("test7")) {
			model.addAttribute("testserial", "test7");
		} else {
			model.addAttribute("testserial", "test7");
		}
		
		model.addAttribute("testserial", "test6-subtest3");
		return "requestMappingAndParamResults2";
	}

}

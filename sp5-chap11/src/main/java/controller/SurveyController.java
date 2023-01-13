package controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import survey.AnswerData;
import survey.Question;

@Controller
@RequestMapping("/survey")
public class SurveyController {

	@GetMapping
	public ModelAndView form() {
		ModelAndView mav = new ModelAndView();
		List<Question> questions = createQuestions();
		mav.addObject("questions", questions);
		mav.setViewName("survey/surveyForm");
		return mav;
	}

	@PostMapping
	public String submit(@ModelAttribute("ansData") AnswerData data) {
		return "survey/submitted";
	}

	private List<Question> createQuestions() {
		Question q1 = new Question("당신의 역할은 무엇입니까?", Arrays.asList("서버", "백엔드", "풀스택"));
		Question q2 = new Question("많이 사용하는 개발도구는 무엇입니까?", Arrays.asList("이클립스", "인텔리제이", "서브라임"));
		Question q3 = new Question("하고 싶은 말을 적어주세요");

		return Arrays.asList(q1, q2, q3);
	}

}

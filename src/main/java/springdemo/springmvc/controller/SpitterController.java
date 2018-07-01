package springdemo.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springdemo.springmvc.Spitter;
import springdemo.springmvc.data.SpitterRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

    // 和数据存储相关
    private SpitterRepository repository;

    public SpitterController() {
    }

    @Autowired
    public SpitterController(SpitterRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Spitter());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistrationForm(@Valid Spitter spitter, Errors errors) {
         //使用Java校验API
        System.out.println(errors.hasErrors());
        if (errors.hasErrors()) {
            System.out.println("has errors");
            return "/register";
        }


        //保存到数据库
        repository.save(spitter);

        //防止重复提交表单，最好是要重定向，发送新请求
        return "redirect:/spitter/" + spitter.getUserName();
    }

    // 处理重定向的请求
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
        //从数据库中取出对象，放进model，发给视图渲染
        Spitter spitter = repository.findByUsername(username);
        model.addAttribute(spitter);
        return "profile";
    }


}

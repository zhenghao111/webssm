package springdemo.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import springdemo.springmvc.domain.Spitter;
import springdemo.springmvc.exception.SpittleNotFoundException;
import springdemo.springmvc.repository.SpitterRepository;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller // 包含@Component
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
    public String processRegistrationForm(
//            @RequestPart("photo") byte[] photo,
            @RequestPart("photo") MultipartFile photo,
            @Valid Spitter spitter, // 校验对象
            Errors errors,
//            Model model
            RedirectAttributes model
    ) {
         //使用Java校验API
        System.out.println(errors.hasErrors());
        if (errors.hasErrors()) {
            System.out.println("has errors");
            return "/register";
        }

        //保存到数据库
        repository.addSpitter(spitter);

//        repository.save(spitter);
        //测试异常处理
//        if (true) {
//            throw new DuplicateSpittleException();
//        }

        //保持图片
        try {
            photo.transferTo(new File("/Users/zhenghao/Documents/Workspace/IDEA/webssm/uploads/" + photo.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }


        //防止重复提交表单，最好是要重定向，发送新请求
//        return "redirect:/spitter/" + spitter.getUserName();
        //使用URL模板,防止SQL注入
        model.addAttribute("username", spitter.getUserName());
        //flash属性添加到会话中
        model.addFlashAttribute("spitter", spitter);
        return "redirect:/spitter/{username}";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String processLoginForm() {
        return "home";
    }


    // 处理重定向的请求
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(
            @PathVariable String username,
            Model model) {


        // 重定向的flash属性添加到会话中，从会话中取出到模型中
        if (!model.containsAttribute("spitter")) {
            //从数据库中取出对象，放进model，发给视图渲染
            Spitter spitter = repository.findByUsername(username);

            if (spitter == null) {
                throw new SpittleNotFoundException();
            }

            model.addAttribute(spitter);
        }
        return "profile";
    }


}

package springdemo.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springdemo.springmvc.Spittle;
import springdemo.springmvc.repository.SpittleRepository;

import java.util.List;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
//        System.out.println(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public String spittles(Model model) {
//        model.addAttribute("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 20));
//        return "spittles"; // 返回逻辑视图名
//    }

    // 会自动将返回值加入到Model，逻辑视图名自动推测出来
//    @RequestMapping(method = RequestMethod.GET)
//    public List<Spittle> spittles() {
//        return spittleRepository.findSpittles(Long.MAX_VALUE, 20);
//    }

    // 会自动将返回值加入到Model，逻辑视图名自动推测出来
    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(@RequestParam(value = "max", defaultValue = "400000") long max,
                                  @RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max, count);
    }

    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    //@PathVariable相同变量名可以省略
    public String spittle(@PathVariable("spittleId") long spittleId, Model model) {
        model.addAttribute(spittleRepository.findOne(spittleId));
//        System.out.println(spittleId);
//        System.out.println(spittleRepository.findOne(spittleId));
//        System.out.println(model.containsAttribute("spittle"));
        return "spittle";
    }


}

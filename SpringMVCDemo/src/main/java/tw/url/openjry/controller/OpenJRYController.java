package tw.url.openjry.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
 
// @Controller 標示擔任控制器的類別
@Controller
public class OpenJRYController {
 
    // @RequestMapping 指定 URL 對應
    // @RequestParam 標註哪個請求參數指定給哪個方法參數
    // Model 參數用來攜帶回應頁面要用到的資料
    @RequestMapping("/openjry")
    public String printHello(@RequestParam("user") String user, Model model) {
        model.addAttribute("message", "Hello " + user + "!");
        return "openjry";
    }
}
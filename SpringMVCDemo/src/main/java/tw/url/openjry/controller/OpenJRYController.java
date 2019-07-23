package tw.url.openjry.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
 
// @Controller �Хܾ����������O
@Controller
public class OpenJRYController {
 
    // @RequestMapping ���w URL ����
    // @RequestParam �е����ӽШD�Ѽƫ��w�����Ӥ�k�Ѽ�
    // Model �ѼƥΨ���a�^�������n�Ψ쪺���
    @RequestMapping("/openjry")
    public String printHello(@RequestParam("user") String user, Model model) {
        model.addAttribute("message", "Hello " + user + "!");
        return "openjry";
    }
}
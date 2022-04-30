package gbro.todolist.itemservice.web.mylist.basic;


import gbro.todolist.domain.mylist.MyList;
import gbro.todolist.domain.mylist.MyListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/basic/lists")
@RequiredArgsConstructor
public class BasicMyListController {

    private final MyListRepository myListRepository;

    @GetMapping
    public String lists(Model model){
        List<MyList> lists = myListRepository.findAll();
        model.addAttribute("lists", lists);
        return "basic/lists";
    }

    @GetMapping("/{id}")
    public String list(@PathVariable Long id, Model model){
        MyList list = myListRepository.findById(id);
        model.addAttribute("list",list);
        return "basic/list";
    }

    /*
    테스트용 데이터
     */

    @PostConstruct
    public void init(){
        myListRepository.save(new MyList("TODOLIST1","집사기"));
        myListRepository.save(new MyList("TODOLIST2","차사기"));

    }
}

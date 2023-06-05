package com.study.springboot.controller;

import com.study.springboot.entity.Notice;
import com.study.springboot.repository.NoticeRepository;
import com.study.springboot.service.DetailService;
import com.study.springboot.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor //Autowired은 자원을 많이 차지. 생성자만들어주고 final로 처리.
public class MyController {

    private final NoticeRepository noticeRepository; //서비스 만들고 얘를 없애기.
    private final DetailService detailService;
    private final NoticeService noticeService;

    //@PostConstruct //insert는 여기서 안되기도 한다함. 테스트에서 자료넣는게 안전.
    public void init(){
        Notice notice = Notice.builder().seq(20000L).title("제목2").content("내용2").build();
        noticeRepository.insertNotice(notice);
    }

    @GetMapping("/")
    public String root(){

        return "view/index";
    }

    @GetMapping("/page2")
    public String listAction(Model model, @PageableDefault(page = 0, size = 10)Pageable pageable){
        //List<Notice> list = noticeRepository.findAll();
        List<Notice> list = noticeRepository.findAllByOrderBySeqDesc();

        final int start = (int) pageable.getOffset();
        final int end = Math.min((start + pageable.getPageSize()), list.size());
        final Page<Notice> page = new PageImpl<>(list.subList(start, end), pageable, list.size());

        model.addAttribute("list", page);
        return "view/list";
    }

    @GetMapping("/insert1")
    public String insert1(){
        Notice notice1 = Notice.builder().seq(1L).title("제목1").content("내용1").parent(0L).build();
        noticeRepository.insertNotice(notice1);
        return "redirect:/page2";
    }

    @GetMapping("/insert2")
    public String insert2(){
        Long seq = noticeRepository.selectMaxSeq();
        Notice notice2 = Notice.builder().seq(seq+2L).title("제목2").content("내용2").parent(0L).build();
        noticeRepository.insertNotice(notice2);
        return "redirect:/page2";
    }

    //service쓰는 방식 보기.
    @GetMapping("/detail")
    public String detail(Long seq, Model model){ //model은 컨트롤러 주요기능이기 때문에 service에 보내지 못함. 페이징도.
        Notice notice = detailService.detail(seq);
        model.addAttribute("notice", notice);
        return "view/detail";
    }
    //service쓰는 방식 보기.
    @PostMapping("/addNotice")
    @ResponseBody
    public Notice addNotice(Notice notice){

        return noticeService.saveReply(notice);
    }
}

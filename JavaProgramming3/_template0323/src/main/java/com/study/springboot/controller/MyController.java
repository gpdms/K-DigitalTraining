package com.study.springboot.controller;

import com.study.springboot.dao.EmpMapper;
import com.study.springboot.dto.Emp;
import com.study.springboot.entity.*;
import com.study.springboot.jdbc.EmpDeptMapper;
import com.study.springboot.repository.CartRepository;
import com.study.springboot.repository.GenreRepository;
import com.study.springboot.repository.MyEntityManager;
import com.study.springboot.repository.NoticeRepository;
import com.study.springboot.service.DetailService;
import com.study.springboot.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MyController {

    private final NoticeRepository noticeRepository;
    private final DetailService detailService;
    private final NoticeService noticeService;
    private final EmpMapper empMapper;
    private final TestEntityManager testEntityManager;
    private final EmpDeptMapper empDeptMapper;
    private final GenreRepository genreRepository;
    private final MyEntityManager em;
    private final CartRepository cartRepository;
    private final EntityManager em2;

    @GetMapping("/empList")
    public String hello(Model model) {
        System.out.println(empMapper.findAll());
        model.addAttribute("list", empMapper.findAll());
        return "empList";
    }

    @GetMapping("/testEm")
    @ResponseBody
    public String testEm() {
        testEntityManager.personCreate();
        testEntityManager.personSelect();
        return "OK";
    }

    @GetMapping("/")
    public String root() {
        return "view/index";
    }

    @GetMapping("/list")
    public String listEmp(Model model) {
        // List<Emp> list = empRepository.findAll();
        List<Emp> list = empDeptMapper.findAllEmp("%", "A");
        model.addAttribute("list", list);
        return "view/list";
    }

    @GetMapping("/search")
    public String search(Model model, String search, String type) {
        log.info("---search:" + search + ", type:" + type);
        List<Emp> list = empDeptMapper.findAllEmp(search, type);
        model.addAttribute("list", list);
        return "view/list";
    }

    //@PostConstruct
    public void init() {
        Notice notice = Notice.builder().seq(30000L)
                .title("제목3").content("내용3").build();
        //noticeRepository.saveAndFlush(notice);
        noticeRepository.insertNotice(notice);
    }

    //페이징
    @GetMapping("/page2")
    public String listAction(Model model, @PageableDefault(page = 0, size = 10) Pageable pageable) {
        //List<Notice> list = noticeRepository.findAll();
        List<Notice> list = noticeRepository.findAllByOrderBySeqDesc();
        final int start = (int) pageable.getOffset();
        final int end = Math.min((start + pageable.getPageSize()), list.size());
        final Page<Notice> page = new PageImpl<>(list.subList(start, end), pageable, list.size());
        model.addAttribute("list", page);
        return "view/noticelist";
    }

    @GetMapping("/insert1")
    public String insert1() {
        Notice notice1 = Notice.builder().seq(1L)
                .title("제목1").content("내용1").parent(0L).build();
        noticeRepository.insertNotice(notice1);
        return "redirect:/page2";
    }
    @GetMapping("/insert2")
    public String insert2() {
        Long seq = noticeRepository.selectMaxSeq();
        Notice notice2 = Notice.builder().seq(seq+2L)
                .title("제목2").content("내용2").parent(0L).build();
        noticeRepository.insertNotice(notice2);
        return "redirect:/page2";
    }

    @GetMapping("/detail")
    public String detail(Long seq, Model model) {
        Notice notice = detailService.detail(seq);
        log.info("arg1: {}, arg2: {}", notice.getSeq(), notice.getTitle());
        model.addAttribute("notice", notice);
        return "view/detail";
    }

    @PostMapping("/addNotice")
    @ResponseBody
    public Notice addNotice(Notice notice) {
        return noticeService.saveReply(notice);
    }

    @GetMapping("/page3")
    public String listAction3(Model model, @PageableDefault(page = 0, size = 10) Pageable pageable) {
        //List<Notice> list = noticeRepository.findAll();
        List<Cart> list = cartRepository.findAllByOrderByIdDesc();
        final int start = (int) pageable.getOffset();
        final int end = Math.min((start + pageable.getPageSize()), list.size());
        final Page<Cart> page = new PageImpl<>(list.subList(start, end), pageable, list.size());
        model.addAttribute("list", page);
        return "view/cartlist";
    }

    @GetMapping("/createPerson")
    @ResponseBody
    public String createPerson() {
        String str = em.create();
        return str;
    }

    @GetMapping("/updatePerson")
    @ResponseBody
    public String updateCart() {
        String str = em.update();
        return str;
    }

    @GetMapping("/listPerson")
    @ResponseBody
    public List<Person> listPerson() {
        List<Person> list = em.selectAll();
        return list;
    }

    @GetMapping("/deletePerson")
    @ResponseBody
    public String deleteCart() {
        String str = em.delete();
        return str;
    }

    @GetMapping("/cart")
    @ResponseBody
    public String cart() {
        String str = em.putInCart();
        return str;
    }

    @GetMapping("/getCart")
    @ResponseBody
    public Cart getCart() {
        Cart cart = em.getCart();
        return cart;
    }

    @GetMapping("/cartDetail")
    public String cartDetail(Long id, Model model) {
        Cart cart = em.getCart2(id);
        System.out.println("===>"+cart.getProducts());
        model.addAttribute("list", cart.getProducts());
        return "view/cartdetail";
    }

    @GetMapping("/insertCart")
    public String insertCart() {
        String str = em.putInCart();
        System.out.println("===>"+str);
        return "redirect:/page3";
    }

    @GetMapping("/makeCart")
    @ResponseBody
    public Cart makeCart(HttpSession session) {
        Cart cart = new Cart();

        Product product = Product.builder().cart(cart)
                .name("가방").price(70000).build();
        cart.addProduct(product);
        System.out.println(cart);
        System.out.println(cart.getProducts());
        session.setAttribute("sesCart", cart);
        return cart;
    }

    @GetMapping("/saveCart")
    @ResponseBody
    @Transactional
    public Cart saveCart(HttpSession session) {
        Cart cart = (Cart) session.getAttribute("sesCart");
        System.out.println(cart.getProducts());
        em2.merge(cart);
        return cart;
    }

    @GetMapping("/delProduct")
    @ResponseBody
    @Transactional
    public Cart delProduct() {
        Cart cart = em2.find(Cart.class, 4L);
        System.out.println(cart.getProducts());
        em2.remove(cart.getProducts().get(0));
//        Product product = em2.find(Product.class, 8L);
//        System.out.println(product);
//        em2.remove(product);
//        Cart cart = em2.find(Cart.class, 2L);
        return cart;
    }
}

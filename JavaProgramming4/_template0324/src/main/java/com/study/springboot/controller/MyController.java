package com.study.springboot.controller;

import com.study.springboot.dao.EmpMapper;
import com.study.springboot.dto.Emp;
import com.study.springboot.dto.UploadResultDTO;
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
import net.coobird.thumbnailator.Thumbnailator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    //설정 파일 등의 외부 자원에서 값을 읽어와 필드에 주입
    @Value("${com.study.path}")
    private String uploadPath;

    @PersistenceContext
    EntityManager em3;

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
        //Cart cart = em.getCart2(id);
        Cart cart = em3.find(Cart.class, id);
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
        Cart cart = em2.find(Cart.class, 14L);
        System.out.println(cart.getProducts());
        em2.remove(cart.getProducts().get(0));
//        Product product = em2.find(Product.class, 8L);
//        System.out.println(product);
//        em2.remove(product);
//        Cart cart = em2.find(Cart.class, 2L);
        return cart;
    }

    @GetMapping("/uploadEx")
    public void uploadEx() {
        log.info("처음");
    }
    @PostMapping("/uploadAjax")
    public ResponseEntity<List<UploadResultDTO>> uploadFile(MultipartFile[] uploadFiles) throws IOException {
        //log.info("=========", uploadPath);
        List<UploadResultDTO> resultDTOList = new ArrayList<>();

        for (MultipartFile uploadFile : uploadFiles) {
            // 파일의 MIME 타입을 체크하여, 이미지 파일인지 여부를 확인하는 코드
            if (uploadFile.getContentType().startsWith("image") == false) {
                log.warn("this file is not image type");
                //클라이언트가 서버에게 요청한 작업을 수행할 권한이 없음을 나타내는 상태코드
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
            String originalName = uploadFile.getOriginalFilename();
            log.info("originalName: " + originalName);
            String fileName = originalName.substring(originalName.lastIndexOf("\\")+1);
            log.info("fileName: " + fileName);
            //UUID(Universally Unique Identifier)를 생성하기 위한 메서드
            //UUID는 128비트 숫자로 이루어진 고유한 식별자
            String uuid = UUID.randomUUID().toString();
            String saveName = uuid+"_"+fileName;
            Path savePath = Paths.get(uploadPath+ File.separator+saveName);
            //원본 저장
            uploadFile.transferTo(savePath);
            //섬네일 생성
            String thumbnailName = uploadPath+File.separator+"s_"+uuid+"_"+fileName;
            File thumbnailFile = new File(thumbnailName);
            //썸네일 생성 라이브러리인 "Thumbnailator"를 사용하여 이미지 파일의 썸네일을 생성하는 메서드
            Thumbnailator.createThumbnail(savePath.toFile(), thumbnailFile, 100, 100);
            resultDTOList.add(new UploadResultDTO(fileName, uuid));
            log.info(resultDTOList.toString());
        }
        return new ResponseEntity<>(resultDTOList, HttpStatus.OK);
    }

    @GetMapping("/display")
    public ResponseEntity<byte[]> getFile(String fileName) {
        log.info("****fileName: " + fileName);
        //HTTP 응답을 생성할 때 사용되는 객체 중 하나인 ResponseEntity를 사용하여,
        //byte 배열 형태의 데이터를 응답 본문으로 전송
        ResponseEntity<byte[]> result = null;
        try {
            //URL에서 인코딩된 문자열을 디코딩하여 원래의 문자열을 복원하는 것
            String srcFileName = URLDecoder.decode(fileName, "UTF-8");
            log.info("----fileName: " + srcFileName);
            //new File() : 파일이나 디렉토리를 추상화한 클래스로,
            //File.separator: 파일 또는 디렉토리의 경로, 크기, 수정 일자 등의 속성 정보를 제공
            //파일 시스템 경로를 구분하는 문자열 사용
            //운영 체제에 따라 파일 경로를 구분하는 구분자가 다르기 때문에
            File file = new File(uploadPath+File.separator+srcFileName);
            log.info("----file: " + fileName);

            //HttpHeaders 객체를 생성하여 HTTP 요청 또는 응답의 헤더 정보를 설정하거나 읽어들일 수 있음
            HttpHeaders header = new HttpHeaders();
            // MIME타입 처리
            //파일의 MIME 타입을 추론
            //MIME(Multipurpose Internet Mail Extensions) 타입: 인터넷 상에서 파일의 형식을 지정하는 미디어 타입
            //"text/plain"은 일반 텍스트 파일, "image/jpeg"는 JPEG 이미지 파일
            header.add("Content-Type", Files.probeContentType(file.toPath()));

            //HTTP 요청 또는 응답에 대한 응답 본문과 HTTP 상태 코드, 헤더 등을 포함하는 클래스
            // 파일 데이터 처리: 파일의 내용을 바이트 배열로 읽어오는 메서드
            result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
        } catch (Exception e) {
            log.info(e.getMessage());
            //서버에서 내부적으로 오류가 발생했음을 나타내는 상태 코드
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return result;
    }

    @PostMapping("/removeFile")
    public ResponseEntity<Boolean> removeFile(String fileName){
        String srcFileName = null;
        try {
            srcFileName = URLDecoder.decode(fileName,"UTF-8");
            File file = new File(uploadPath +File.separator+ srcFileName);
            //delete() 메소드는 java.io.File 클래스의 메소드
            //이 메소드는 파일이 정상적으로 삭제되었을 경우 true를 반환하며,
            // 삭제되지 않았을 경우 false를 반환
            boolean result = file.delete();
            //file.getParent() 메서드는 파일의 부모 디렉토리를 나타내는 문자열을 반환
            File thumbnail = new File(file.getParent(), "s_" + file.getName());
            result = thumbnail.delete();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/vue")
    public String vue() {
        return "vue/index";
    }

}

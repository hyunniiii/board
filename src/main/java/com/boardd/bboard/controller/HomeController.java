package com.boardd.bboard.controller;

import com.boardd.bboard.domain.Book;
import com.boardd.bboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/board")
public class HomeController{

    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("board_list",boardService.boardListFindAll());
        return "/board/list";
    }

    @PostMapping("/create")
    public String create(Book book){

        boardService.boardCreate(book);
        return "redirect:/board/list";
    }

    @GetMapping("/write")
    public String write(Model model){
        return "/board/write";
    }

    @GetMapping("/detail")
    public String detail(Model model, @RequestParam(value = "bid", defaultValue = "0") Long idx){
        model.addAttribute("book",boardService.boardFindById(idx));
        return "/board/detail";
    }

    @GetMapping("/modify")
    public String update(Model model, @RequestParam(value = "bid", defaultValue = "0") Long idx){
        model.addAttribute("book",boardService.boardFindById(idx));
        return "/board/modify";
    }

    @PutMapping("/update")
    public String update(Book book){
        boardService.boardUpdate(book);
        return "redirect:/board/detail?bid="+book.getBid();
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam(value = "bid" , defaultValue="0") Long idx){
        boardService.boardDelete(idx);
        return "redirect:/board/list";
    }


}
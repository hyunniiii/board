package com.boardd.bboard.controller;

import com.boardd.bboard.domain.Book;
import com.boardd.bboard.service.BoardService;
import com.sun.org.apache.xpath.internal.operations.Bool;
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
    public String list(Model model, @RequestParam(value = "pageNo", defaultValue = "1") int pageNo){
        model.addAttribute("board_list",boardService.findBoardList(pageNo-1));
        model.addAttribute("boardPage_list",boardService.paging());

        return "/board/list";
    }

    @PostMapping("/create")
    @ResponseBody
    public boolean create(@RequestBody Book book){

        boardService.boardCreate(book);
        return true;
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
    @ResponseBody
    public boolean update(@RequestBody Book book){
        boardService.boardUpdate(book);
        return true;
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public boolean delete(@RequestBody @RequestParam(value = "bid" , defaultValue="0") Long idx){
        boardService.boardDelete(idx);
        return true;
    }


}
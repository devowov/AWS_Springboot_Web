package com.hej.book.springboot.web;

import com.hej.book.springboot.config.auth.LoginUser;
import com.hej.book.springboot.config.auth.dto.SessionUser;
import com.hej.book.springboot.service.posts.PostsService;
import com.hej.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user)
    {
        model.addAttribute("posts", postsService.findAllDesc());

        //SessionUser user = (SessionUser)httpSession.getAttribute("user");

        if(user !=null)
        {
            model.addAttribute("userName",user.getName());
        }
        return "index"; // 머스테치 스타터로 인하여 뒤에 확장자를 붙이지 않아도 자동으로 template파일에서 찾아서 들어가게됨.
    }

    @GetMapping("/posts/save")
    public String postsSave()
    {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model)
    {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);

        return "posts-update";
    }
}

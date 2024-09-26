package Blog.API.blog.controllers;

import org.springframework.web.bind.annotation.RestController;

import Blog.API.blog.entities.Blog;
import Blog.API.blog.services.BlogService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;




@RestController
@RequestMapping("/blog")
public class BlogController {

    BlogService blogService;
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/")
    public Blog addBlog(@RequestBody Blog blog) {
    
        return blogService.createBlog(blog);
    }
    
    @GetMapping("/")
    public List<Blog>getAllBlogs () {
        return blogService.getAllBlogs();
    }
    
    @GetMapping("/{id}")
    public Blog getBlog(@PathVariable int id) {
        return blogService.getBlogById(id);
    }

     // Update Blog
     @PutMapping("/{id}")
     public Blog editBlog(@RequestBody Blog blog , @PathVariable int id) {
        return blogService.editBlog(blog,id);
    }

    
     // Delete Blog
     @DeleteMapping("/{id}")
     public void deleteBlog(@PathVariable int id) {
        blogService.deleteBlog(id);
    }


}

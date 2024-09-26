package Blog.API.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import Blog.API.blog.entities.Blog;
import Blog.API.blog.repositories.BlogRepo1;

@Service
public class BlogService {

    BlogRepo1 blogRepo1;

    public BlogService(BlogRepo1 blogRepo1) {
        this.blogRepo1 = blogRepo1;
    }
    
    public Blog createBlog(Blog blog) {
        return blogRepo1.save(blog);

    }

    public List<Blog> getAllBlogs() {
        return blogRepo1.findAll();
    }

    public Blog getBlogById(int id) {
        return blogRepo1.findById(id).orElseThrow(()->new RuntimeException("Blog doesn't exist"));
    }

    // Update Blog
    public Blog editBlog(Blog blog,int id) {
        blog.setId(id);
        return blogRepo1.save(blog);
    }

     // Delete Blog
     public void deleteBlog(int id) {
        blogRepo1.deleteById(id);;
    }

}

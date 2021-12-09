package luyen_tap.controller;

import luyen_tap.model.Blog;
import luyen_tap.model.Category;
import luyen_tap.service.impl.BlogServiceImpl;
import luyen_tap.service.impl.CategoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BlogServlet", value = "/blogs")
public class BlogServlet extends HttpServlet {
    BlogServiceImpl blogService = new BlogServiceImpl();
    CategoryServiceImpl categoryService = new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteBlog(request, response);
                break;
            case "create":
                showCreateForm(request, response);
                break;
            default:
                showList(request, response);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("blog/create.jsp");
        List<Category> categories = categoryService.findAll();
        request.setAttribute("categories", categories);
        dispatcher.forward(request, response);
    }

    private void deleteBlog(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        blogService.delete(id);
        response.sendRedirect("/blogs");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("blog/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Blog blog = blogService.findById(id);
        request.setAttribute("blog", blog);
        List<Category> categories = categoryService.findAll();
        request.setAttribute("categories", categories);
        dispatcher.forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("blog/list.jsp");
        List<Blog> blogs = blogService.findAll();
        request.setAttribute("blogs", blogs);
        List<Category> categories = findAllCategory(blogs);
        request.setAttribute("categories", categories);
        dispatcher.forward(request, response);
    }

    List<Category> findAllCategory(List<Blog> blogs) {
        List<Category> categories = new ArrayList<>();
        for (Blog blog : blogs) {
            categories.add(categoryService.findById(blog.getCategoryId()));
        }
        return categories;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "edit":
                editBlog(request, response);
                break;
            case "create":
                createBlog(request, response);
                break;
        }
    }

    private void createBlog(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String content = request.getParameter("content");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        Blog blog = new Blog(name, content, categoryId);
        blogService.add(blog);
        response.sendRedirect("/blogs");
    }

    private void editBlog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String content = request.getParameter("content");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        Blog blog = new Blog(id, name, content, categoryId);
        blogService.edit(blog);
        response.sendRedirect("/blogs");
    }
}

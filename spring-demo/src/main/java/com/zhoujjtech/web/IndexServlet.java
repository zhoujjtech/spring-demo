package com.zhoujjtech.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // /index.html
        String fileName = req.getRequestURI();
        // classpath目录
        String basePath = IndexServlet.class.getResource("/").getPath();

        String path = basePath + fileName;

        FileUtils.writeFile(new File(path), resp.getOutputStream());
    }
}

package com.crossyf.practice.nativetomcat.servlet;

import com.crossyf.practice.nativetomcat.http.DefaultRequest;
import com.crossyf.practice.nativetomcat.http.DefaultResponse;

/**
 * @author Created by crossyf.
 * @date 2020/3/21
 * 功能:
 */
public class SecondAbstractServlet extends AbstractServlet {
    @Override
    public void doGet(DefaultRequest request, DefaultResponse response) {
        response.write("你好啊Servlet");
    }
}

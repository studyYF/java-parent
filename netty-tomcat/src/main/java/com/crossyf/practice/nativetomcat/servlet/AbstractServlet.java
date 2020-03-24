package com.crossyf.practice.nativetomcat.servlet;

import com.crossyf.practice.nativetomcat.http.DefaultRequest;
import com.crossyf.practice.nativetomcat.http.DefaultResponse;

/**
 * @author Created by crossyf.
 * @date 2020/3/21
 * 功能:
 */
public abstract class AbstractServlet {



    public void service(DefaultRequest request, DefaultResponse response) {
        if ("GET".equalsIgnoreCase(request.getMethod())) {
            doGet(request,response);
        }
    }

    public abstract void doGet(DefaultRequest request, DefaultResponse response);

}
